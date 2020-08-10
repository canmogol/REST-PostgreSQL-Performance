package fatjar.implementations.db;


import fatjar.DB;
import org.postgresql.Driver;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class JDBC implements DB {

    public static final int NUMBER_OF_CONNECTIONS = 100;

    private final List<Connection> connections = new ArrayList<>();

    private int cursor = 0;

    public JDBC(String jdbcConnectionURL) throws SQLException {
        final Driver driver = new Driver();
        final int majorVersion = driver.getMajorVersion();
        log("postgresql driver version " + majorVersion);
        for (int i = 0; i < NUMBER_OF_CONNECTIONS; i++) {
            connections.add(DriverManager.getConnection(jdbcConnectionURL));
        }
        log(connections.size() + " connections created.");
    }

    @Override
    public <T> long count(Class<T> tClass) {
        return 0;
    }

    @Override
    public <T> long count(Class<T> tClass, Query query) {
        return 0;
    }

    @Override
    public <T> Optional<T> insert(T t) {
        return Optional.empty();
    }

    @Override
    public <T> T update(T t) {
        return t;
    }

    @Override
    public <T> void delete(T t) {
    }

    @Override
    public <T> List<T> findAll(Class<T> typeClass) {
        List<T> objects = new ArrayList<>();
        Statement statement = null;
        try {
            statement = getNextConnection().createStatement();
            final String tableName = getTableName(typeClass);
            final String query = String.format("select * from %s", tableName);
            final ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                final Constructor<T> constructor = typeClass.getConstructor();
                final T entity = constructor.newInstance();
                ((JdbcEntity) entity).read(resultSet);
                objects.add(entity);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException |
                SQLException | NoSuchMethodException e) {
            throw new RuntimeException("Exception occurred at database operation.", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    log("could not close the statement.");
                }
            }
        }
        return objects;
    }

    private Connection getNextConnection() {
        return connections.get((cursor++) % NUMBER_OF_CONNECTIONS);
    }

    private <T> String getTableName(Class<T> typeClass)
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        final Constructor<T> jdbcEntityConstructor = typeClass.getConstructor();
        final JdbcEntity jdbcEntity = (JdbcEntity) jdbcEntityConstructor.newInstance();
        return jdbcEntity.getTableName();
    }

    @Override
    public <T> T find(Class<T> typeClass, Object primary) {
        return null;
    }

    @Override
    public <T> List<T> find(Class<T> typeClass, Query query) {
        return Collections.emptyList();
    }

    private void log(String log) {
        System.out.println(log);
    }

}
