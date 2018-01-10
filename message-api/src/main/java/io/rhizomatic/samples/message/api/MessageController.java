package io.rhizomatic.samples.message.api;

import io.rhizomatic.api.Monitor;
import io.rhizomatic.api.annotations.Service;
import io.rhizomatic.samples.message.service.api.MessageService;
import io.rhizomatic.api.annotations.Eager;
import io.rhizomatic.api.annotations.Init;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * A controller that is scanned and provisioned by Rhizomatic.
 *
 * Access at: http://localhost:8080/api/tests/test. The {@code /api/} path part is defined in the module using {@code @io.rhizomatic.api.annotations.EndpointPath}.
 */
@Path("tests")
@Consumes("text/html")
@Produces("text/html")
@Eager
@Singleton
@Service
public class MessageController {

    @Inject
    protected MessageService messageService; // provided by the message.service module

    @Inject
    protected Monitor monitor;  // provided by Rhizomatic

    @Init
    public void init() {
        monitor.info(() -> "Started TestResource");
    }

    @Path("test")
    @GET
    public String greeting() {
        return messageService.message();
    }
}
