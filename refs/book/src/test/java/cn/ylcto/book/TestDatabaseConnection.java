package cn.ylcto.book;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import cn.ylcto.book.util.DatabaseConnection;

public class TestDatabaseConnection {
    @Test
    public void testGetConnection() {
        Connection connection = DatabaseConnection.getConnection();
        System.out.println(connection);
        assertTrue(connection != null);
    }
}
