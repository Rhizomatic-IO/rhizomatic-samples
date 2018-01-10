package io.rhizomatic.bootstrap.production;

import io.rhizomatic.api.SystemDefinition;
import io.rhizomatic.api.layer.RzLayer;
import io.rhizomatic.api.web.WebApp;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static java.nio.file.Files.isDirectory;
import static java.nio.file.Files.newDirectoryStream;

/**
 *
 */
public class ProductionSystemDefinition implements SystemDefinition {
    private List<RzLayer> layers;
    private List<WebApp> webApps = new ArrayList<>();

    public ProductionSystemDefinition() {
        try {
            Path anchor = Paths.get(getClass().getResource("").toURI());
            RzLayer.Builder layerBuilder = RzLayer.Builder.newInstance("main");
            newDirectoryStream(anchor, p -> isDirectory(p)).forEach(path -> {
                if (path.getFileName().toString().equals("webapp")) {
                    webApps.add(new WebApp("/ui", path));
                } else if (!path.getFileName().toString().startsWith("bootstrap")) {
                    layerBuilder.module(path);
                }
            });
            layers = List.of(layerBuilder.build());

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException("Unable to bootstrap system", e);
        }
    }

    public List<RzLayer> getLayers() {
        return layers;
    }

    public List<WebApp> getWebApps() {
        return webApps;
    }
}
