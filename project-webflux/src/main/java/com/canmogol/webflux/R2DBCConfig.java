package com.canmogol.webflux;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import java.time.Duration;

@Configuration
@EnableR2dbcRepositories
public class R2DBCConfig extends AbstractR2dbcConfiguration {

    @Value("${r2dbc.postgresql.host:localhost}")
    private String host;

    @Value("${r2dbc.postgresql.port:5432}")
    private Integer port;

    @Value("${r2dbc.postgresql.database:postgres}")
    private String database;

    @Value("${r2dbc.postgresql.schema:public}")
    private String schema;

    @Value("${r2dbc.postgresql.username:postgres}")
    private String username;

    @Value("${r2dbc.postgresql.password:postgres}")
    private String password;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
        return new PostgresqlConnectionFactory(PostgresqlConnectionConfiguration.builder()
                .host(host)
                .port(port)
                .database(database)
                .username(username)
                .password(password)
                .schema(schema)
                .connectTimeout(Duration.ofMinutes(2))
                .build());
    }

}