package cn.ylcto.book;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cn.ylcto.book.dao.impl.ItemDaoImpl;
import cn.ylcto.book.util.DatabaseConnection;
import cn.ylcto.book.vo.Item;


public class TestItemDaoImpl {
    private static Connection connection;
    private static ItemDaoImpl impl;

    @BeforeEach
    public void initConnection() {
        connection = DatabaseConnection.getConnection();
        impl = new ItemDaoImpl(connection);
    }


    @Test
    public void testGetById() {
        Item result = impl.getById(1);
        System.out.println(result);
        assertEquals(result.getIid(), 1);
    }

    @Test
    public void testGetAll() {
        List<Item> results = impl.getAll();
        System.out.println(results);
        assertEquals(results.size(), 2);
    }
}
