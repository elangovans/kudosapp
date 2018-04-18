package com.intuit.slackapps.kudos.dataaccess

import java.util.*

interface DataAccess {
    fun <T> read(id: UUID)
}
