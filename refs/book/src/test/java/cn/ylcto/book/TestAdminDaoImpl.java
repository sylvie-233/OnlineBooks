package cn.ylcto.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.ylcto.book.dao.impl.AdminDaoImpl;
import cn.ylcto.book.util.DatabaseConnection;
import cn.ylcto.book.vo.Admin;


public class TestAdminDaoImpl {
    private static Connection connection;
    private static AdminDaoImpl impl;

    @BeforeEach
    public void initConnection() {
        connection = DatabaseConnection.getConnection();
        impl = new AdminDaoImpl(connection);
    }

    @Test
    public void testGetById() {
        Admin result = impl.getById(1);
        System.out.println(result);
        assertEquals(result.getAid(), 1);
    }

    @Test
    public void testGetAll() {
        List<Admin> results = impl.getAll();
        System.out.println(results);
        assertEquals(results.size(), 2);
    }
}
