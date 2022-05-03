package pers.rasskazov.railroads.testsupport.helpers;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public final class ResourcesHelper {
    private ResourcesHelper() {
        // No OP
    }

    public static Path getResourcePath(Class<?> classValue, String resourceName) {
        URL resourceURL = classValue.getClassLoader().getResource(resourceName);
        try {
            return Paths.get(Objects.requireNonNull(resourceURL).toURI());
        } catch (URISyntaxException e) {
            return Paths.get(Objects.requireNonNull(resourceURL).getPath());
        }
    }

    public static Path getClassResourcePath(Class<?> classValue, String classResourceName) {
        String resourceName = classValue.getSimpleName() + "/" + classResourceName;
        return getResourcePath(classValue, resourceName);
    }
}
