package com.intuit.slackapps.kudos.services

import com.intuit.slackapps.kudos.dataclasses.Activity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.HashMap

@Service
class ActivityService {
    companion object {
        var activityCache : MutableMap<UUID, Activity>? = null
    }

    fun getActivityById(id: UUID): Activity? {
        // search of an activity in the db, if it is not found then respond null
        if (activityCache!!.containsKey(id)) {
            val activity : Activity = activityCache!!.get(id)!!
            return activity
        }

        return null
    }

    fun getActivities(key: String) : List<Activity>? {
        return null
    }

    fun persistActivity(activity: Activity) : UUID {
        // 1. store the activity object as is.
        // 2. asynchronously parse the activity for how many people the activity needs to be delivered/counted to.
        // 3. asynchronously update the leader-board
        if (null == activity) throw Exception("Invalid activity object")
        if (null == activity.id) activity.id = UUID.randomUUID()
        if (null == activityCache) activityCache = HashMap<UUID, Activity>()

        activityCache!!.put(activity.id, activity)

        return activity.id
    }
}
