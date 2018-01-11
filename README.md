# Rhizomatic Samples

## Launch the Development System

Configure your IDE (currently IntelliJ is supported) to enable incremental compile and build the project.

From the ```rhizomatic-samples/runtime/build/image/``` directory, execute:

```java  -p libraries:system:<rhizomatic-samples>/bootstrap-message-dev/out/production/classes/ -m io.rhizomatic.kernel/io.rhizomatic.kernel.Rhizomatic```

## Debugging

To debug tests, launch Gradle with the debug option and set your IDE to listen on port 5005:

```./gradlew clean test --debug-jvm``` 


