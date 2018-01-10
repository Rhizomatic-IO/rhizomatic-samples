package io.rhizomatic.bootstrap.dev;

import io.rhizomatic.api.SystemDefinition;
import io.rhizomatic.api.layer.LayerPathBuilder;
import io.rhizomatic.api.layer.RzLayer;
import io.rhizomatic.api.web.WebApp;
import io.rhizomatic.api.web.WebAppPathBuilder;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Defines the development system using the Gradle project layout.
 *
 * A single layer is produced with modules corresponding to Gradle subprojects except for the bootstrap and webapp subprojects.
 */
public class DevSystemDefinition implements SystemDefinition {
    private static final int BOOTSTRAP_MODULE_DEPTH = 4;
    private Path anchor;

    public DevSystemDefinition() {
        // calculates the top of the project directory hierarchgy by walking up from the current location of this compiled class
        try {
            anchor = Paths.get(getClass().getResource("").toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException("Unable top determine bootstrap location", e);
        }

        int count = getClass().getPackageName().split("\\.").length;

        if (anchor.getNameCount() < count + BOOTSTRAP_MODULE_DEPTH) {
            throw new RuntimeException("Boostrap module in an unknown location");
        }

        for (int i = 0; i < count; i++) {
            anchor = anchor.getParent();
        }
        if ("classes".equals(anchor.getFileName().toString())) {
            for (int i = 0; i < BOOTSTRAP_MODULE_DEPTH; i++) {
                anchor = anchor.getParent();
            }
        } else {
            throw new RuntimeException("Bootstrap module in an unknown location");
        }
    }

    public List<RzLayer> getLayers() {
        LayerPathBuilder firstBuilder = LayerPathBuilder.newInstance("main");
        return List.of(firstBuilder.root(anchor).javaPath("out/production/classes").excludes("bootstrap-message-dev", "bootstrap-message-production", "webapp").build());
    }

    public List<WebApp> getWebApps() {
        // configures the webapp to be accessible from http://localhost:8080/ui/index.html.
        WebApp webApp = WebAppPathBuilder.newInstance().root(anchor).contextPath("/ui").contentRootPath("src/main/resources").includes("webapp").build();
        return List.of(webApp);
    }
}
