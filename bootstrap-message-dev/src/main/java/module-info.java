import io.rhizomatic.bootstrap.dev.DevSystemDefinition;
import io.rhizomatic.api.SystemDefinition;

/**
 * Bootstraps a development system from the current project layout.
 */
module bootstrap.dev {
    requires io.rhizomatic.api;

    provides SystemDefinition with DevSystemDefinition;
}