package com.intuit.slackapps.kudos.dataclasses

import java.util.*

data class Kudos (var from: String, var to: Array<String>) {
    var channelName: String = ""
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Kudos

        if (from != other.from) return false
        if (!Arrays.equals(to, other.to)) return false
        if (channelName != other.channelName) return false

        return true
    }

    override fun hashCode(): Int {
        var result = from.hashCode()
        result = 31 * result + Arrays.hashCode(to)
        result = 31 * result + channelName.hashCode()
        return result
    }
}