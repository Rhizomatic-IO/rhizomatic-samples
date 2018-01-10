import io.rhizomatic.bootstrap.production.ProductionSystemDefinition;
import io.rhizomatic.api.SystemDefinition;

/**
 * Bootstraps a development system from the current project layout.
 */
module bootstrap.production {
    requires io.rhizomatic.api;

    provides SystemDefinition with ProductionSystemDefinition;
}