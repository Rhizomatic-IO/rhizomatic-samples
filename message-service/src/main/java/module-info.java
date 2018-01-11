/**
 * Provides the backend services for the system.
 */
open module io.rhizomatic.samples.message.service {
    requires javax.inject;
    requires java.ws.rs;
    requires io.rhizomatic.api;
    requires static io.rhizomatic.inject;
    requires static io.rhizomatic.kernel;

    exports io.rhizomatic.samples.message.service.api;
}