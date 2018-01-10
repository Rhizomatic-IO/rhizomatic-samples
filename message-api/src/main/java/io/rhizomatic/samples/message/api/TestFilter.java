package io.rhizomatic.samples.message.api;

import io.rhizomatic.samples.message.service.api.MessageService;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * A simple JAX-RS filter. This class will be scanned by Rhizomatic.
 *
 * Writers can be injected with services using {@code @Inject}.
 */
@Provider
public class TestFilter implements ContainerRequestFilter {

    @Inject
    protected MessageService messageService;

    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Intercepting:" + messageService.message());
    }
}

