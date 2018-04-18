package com.intuit.slackapps.kudos.resources

import com.intuit.slackapps.kudos.dataclasses.Activity
import com.intuit.slackapps.kudos.services.ActivityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.net.URI
import java.util.*
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("/kudos")
class KudosResource {

    @Autowired
    lateinit var activityService : ActivityService

    @POST
    @Consumes("application/json")
    fun createActivity(activity: Activity) : Response {
        var id: UUID = this.activityService.persistActivity(activity)
        activity.id = id
        return Response.created(URI("kudos/$id")).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getActivityById(@PathParam("id") id: UUID): Response {
        if (id == null) return Response.status(Response.Status.NOT_FOUND).build()

        this.activityService = ActivityService()
        val activity = this.activityService.getActivityById(id)

        return if (activity == null) Response.status(Response.Status.NOT_FOUND).build()
        else Response.ok(activity).build()
    }

    @GET
    @Path("/activities/{f}") // kudos for ...
    @Produces(MediaType.APPLICATION_JSON)
    fun getLeaders(@PathParam("f") f: String): Response {
        when (f.toLowerCase()) {
            "givers" -> { return Response.ok(activityService.getActivities("givers")).build() }
            "receivers" -> { return Response.ok(activityService.getActivities("receivers")).build() }
            "me" -> {return Response.ok(activityService.getActivities("me")).build()}
        }
        return Response.noContent().build()
    }
}