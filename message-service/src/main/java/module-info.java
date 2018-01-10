/**
 * Provides the backend services for the system.
 */
open module io.rhizomatic.samples.message.service {
    requires javax.inject;
    requires java.ws.rs;
    requires io.rhizomatic.api;

    exports io.rhizomatic.samples.message.service.api;
}