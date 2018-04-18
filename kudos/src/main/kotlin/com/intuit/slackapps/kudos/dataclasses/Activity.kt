package com.intuit.slackapps.kudos.dataclasses

import java.util.*

data class Activity(var id: UUID,
                    val from: String,
                    val to: String,
                    val msg: String,
                    val channelName: String,
                    val at: Long = Calendar.getInstance().timeInMillis)