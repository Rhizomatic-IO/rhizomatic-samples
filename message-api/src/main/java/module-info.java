import io.rhizomatic.api.annotations.EndpointPath;

/**
 * Provides the REST API controllers for the system.
 */
@EndpointPath("api")
open module io.rhizomatic.samples.message.api {
    requires javax.inject;
    requires java.ws.rs;
    requires io.rhizomatic.api;

    requires io.rhizomatic.samples.message.service;
}