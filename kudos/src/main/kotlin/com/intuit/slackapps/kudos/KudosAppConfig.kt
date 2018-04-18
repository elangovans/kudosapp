package com.intuit.slackapps.kudos

import com.intuit.slackapps.kudos.resources.KudosResource
import com.intuit.slackapps.kudos.resources.PingResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

@Configuration
class KudosAppConfig : ResourceConfig() {
    init {
        registerEndpoints()
    }

    private fun registerEndpoints() {
        register(PingResource())
        register(KudosResource())
    }
}