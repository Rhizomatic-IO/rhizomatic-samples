# Rhizomatic Samples

## Run the sample

### *nix
```
./gradlew clean jar rhizomaticAssembly
(cd runtime/build/image/ && exec java -p libraries:system:../../../bootstrap-message-gradle/build/classes/java/main/ -m io.rhizomatic.kernel/io.rhizomatic.kernel.Rhizomatic)
```

### Windows
```
gradlew clean jar rhizomaticAssembly
cd runtime/build/image/
java  -p libraries:system:../../../bootstrap-message-gradle/build/classes/java/main/ -m io.rhizomatic.kernel/io.rhizomatic.kernel.Rhizomatic
```

## Run the Development System

Configure your IDE (currently IntelliJ is supported) to enable incremental compile and build the project.
IntelliJ will then create the `out/production/classes` folder when building.

### *nix
```
./gradlew clean jar rhizomaticAssembly
(cd runtime/build/image/ && exec java -p libraries:system:../../../bootstrap-message-dev/out/production/classes/ -m io.rhizomatic.kernel/io.rhizomatic.kernel.Rhizomatic)
```

### Windows
```
gradlew clean jar rhizomaticAssembly
cd runtime/build/image/
java  -p libraries:system:../../../bootstrap-message-dev/out/production/classes/ -m io.rhizomatic.kernel/io.rhizomatic.kernel.Rhizomatic
```

## Invoke the Service

1. Open API: http://localhost:8080/api/tests/test
2. Open WebApp: http://localhost:8080/ui


## Debugging

To debug tests, launch Gradle with the debug option and set your IDE to listen on port 5005:

```./gradlew clean test --debug-jvm``` 




