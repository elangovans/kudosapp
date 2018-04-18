package com.intuit.slackapps.kudos.resources

import com.intuit.slackapps.kudos.dataclasses.Ping
import mu.KLogging
import org.springframework.stereotype.Component
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Component
@Path("/ping")
class PingResource {
    companion object : KLogging()

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun ping(@QueryParam("name") @DefaultValue("") name: String?): Response {
        logger.debug("name = $name")
        if (name.isNullOrBlank()) return Response.status(Response.Status.BAD_REQUEST).build()

        return Response.ok(Ping("Hello, $name").message).build()
    }
}