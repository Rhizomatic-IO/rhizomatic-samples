import io.rhizomatic.bootstrap.gradle.GradleSystemDefinition;
import io.rhizomatic.api.SystemDefinition;

/**
 * Bootstraps a development system from the current project layout.
 */
module bootstrap.gradle {
    requires io.rhizomatic.api;

    provides SystemDefinition with GradleSystemDefinition;
}