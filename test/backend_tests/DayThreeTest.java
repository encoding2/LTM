package com.edutech.progressive;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.edutech.progressive.config.DatabaseConnectionManager;

public class DayThreeTest {

    @Test
    void testDatabaseConnectionManagerHasGetConnectionMethod() {
        Method method = null;

        try {
            method = DatabaseConnectionManager.class.getMethod("getConnection");
        } catch (NoSuchMethodException e) {
            throw new AssertionError("getConnection method is not implemented");
        }

        assertNotNull(method);
        assertTrue(Connection.class.isAssignableFrom(method.getReturnType()));
    }

    @Test
    void testGetConnection() throws Exception {
        Connection connection = DatabaseConnectionManager.getConnection();

        assertNotNull(connection);

        connection.close();
    }
}