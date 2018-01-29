package io.rhizomatic.bootstrap.gradle;

import io.rhizomatic.api.SystemDefinition;
import io.rhizomatic.api.layer.LayerPathBuilder;
import io.rhizomatic.api.layer.RzLayer;
import io.rhizomatic.api.web.WebApp;
import io.rhizomatic.api.web.WebAppPathBuilder;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * Defines the development system using the Gradle project layout.
 *
 * A single layer is produced with modules corresponding to Gradle subprojects except for the bootstrap and webapp subprojects.
 */
public class GradleSystemDefinition implements SystemDefinition {
    private static final Predicate<Path> GRADLE = (p) -> Files.exists(p.resolve("gradlew.bat")) && !Files.isDirectory(p.resolve("gradlew.bat"));

    public List<RzLayer> getLayers() {
        LayerPathBuilder firstBuilder = LayerPathBuilder.newInstance("main");
        return List.of(firstBuilder.findRoot(GRADLE).javaPath("build/classes/java").excludes("bootstrap-message-dev", "bootstrap-message-production", "bootstrap-message-gradle", "webapp").build());
    }

    public List<WebApp> getWebApps() {
        // configures the webapp to be accessible from http://localhost:8080/ui/index.html.
        WebApp webApp = WebAppPathBuilder.newInstance().findRoot(GRADLE).contextPath("/ui").contentRootPath("src/main/resources").includes("webapp").build();
        return List.of(webApp);
    }
}
