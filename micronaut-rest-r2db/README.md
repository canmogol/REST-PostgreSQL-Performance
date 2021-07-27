## Micronaut 2.5.11 Documentation

- [User Guide](https://docs.micronaut.io/2.5.11/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.11/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.11/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature data-r2dbc documentation

- [Micronaut Data R2DBC documentation](https://micronaut-projects.github.io/micronaut-r2dbc/latest/guide/)

- [https://r2dbc.io](https://r2dbc.io)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature testcontainers documentation

- [https://www.testcontainers.org/](https://www.testcontainers.org/)

## Feature r2dbc documentation

- [Micronaut R2DBC documentation](https://micronaut-projects.github.io/micronaut-r2dbc/latest/guide/)

- [https://r2dbc.io](https://r2dbc.io)

## How to Compile

You can compile the project only by running the `mvnw` command line script.

On *nix environment you may run the `mvnw` shell script,
```bash
./mvnw clean install
```

On Windows environment you may run the `mvnw.cmd` command.
```bash
mvnw.cmd clean install
```

## How to Native Compile**

You can compile this Micronaut Reactive application to a native executable.

In order compile to native executable, you need to install the Graalvm and `native-image` command.

You can use SdkMan to install and configure JDKs.

```
# install sdkman
curl -s "https://get.sdkman.io" | bash

# initialize sdkman on the current shell session
source "$HOME/.sdkman/bin/sdkman-init.sh"

# install Graalvm Java 11
sdk install java 21.1.0.r11-grl

# install native image tool
gu install native-image
```

This command will create a docker image with a native executable in the container. The executable file is on `/app/application` path in the docker image.
```
mvn package -Dpackaging=docker-native
```

You can either copy the `application` executable to the host machine from the docker image, or you can directly run the docker image.

```
docker run -d --name micronaut-rest-r2db --network="host" micronaut-rest-r2db:latest

# or if you copy the application executable, you can run the app from command line
docker cp micronaut-rest-r2db:/app/application /tmp/
/tmp/application
```

## Test Results

Please see the `project-webflux` Readme for the results.



