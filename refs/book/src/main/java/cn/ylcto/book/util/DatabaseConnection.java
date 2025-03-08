package cn.ylcto.book.util;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static String DATABASE_URL = "book.db"; 
    private static String DATABASE_PATH; 
    static {
        URL resource = DatabaseConnection.class.getClassLoader().getResource(DATABASE_URL);
        String dbPath = new File(resource.getFile()).getAbsolutePath();
        DATABASE_PATH = "jdbc:sqlite:" + dbPath;
    }
    
    public static Connection getConnection()  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_PATH);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
