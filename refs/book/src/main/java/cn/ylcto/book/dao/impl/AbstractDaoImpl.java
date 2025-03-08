package cn.ylcto.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.ylcto.book.dao.IDao;
import cn.ylcto.book.util.OfBuilder;
import cn.ylcto.book.util.Pair;

/**
 * 持久层接口 抽象基类
 */
public abstract class AbstractDaoImpl<T extends OfBuilder<T>> implements IDao<T> {

    private Connection conn;
    private Class<T> clazz;

    public AbstractDaoImpl(Connection conn, Class<T> clazz) {
        this.conn = conn;
        this.clazz = clazz;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    /**
     * 根据id获取实体类
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T getById(String sql, Integer id) {
        ArrayList<Pair> arrayList = new ArrayList<>();
        arrayList.add(Pair.of("int", id));
        T item = null;
        try {
            ResultSet resultSet = executeQuery(sql, arrayList);
            if (resultSet.next()) {
                item = (T)((OfBuilder)(clazz.getDeclaredConstructor().newInstance())).of(resultSet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * 获取所有实体类
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> getAll(String sql) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            ResultSet executeQuery = executeQuery(sql, null);
            while (executeQuery.next()) {
                T item = (T)((OfBuilder)(clazz.getDeclaredConstructor().newInstance())).of(executeQuery);
                arrayList.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public T insert(String sql, T data) {
        List<Pair> ofPairs = data.ofValue();
        T item = null;
        try {
            item = (T)((OfBuilder)(clazz.getDeclaredConstructor().newInstance()));
            PreparedStatement preparedStatement = executeUpdate(sql, ofPairs);
            int executeUpdateResult = preparedStatement.executeUpdate();
            if (executeUpdateResult > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    item = getById(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }



    @Override
    public T insertOne(T vo) {
        return null;
    }

    @Override
    public boolean removeById(Integer id) {
        return false;
    }

    @Override
    public T update(T vo) {
        return null;
    }

    /**
     * 执行查询SQL语句
     * @param sql
     * @param data
     * @return
     * @throws SQLException
     */
    public ResultSet executeQuery(String sql, List<Pair> data) throws SQLException  {
        ResultSet resultSet = null;
        PreparedStatement statement = executeUpdate(sql, data);
        resultSet = statement.executeQuery();
        return resultSet;
    }

    /**
     * 执行更新SQL语句
     * @param sql
     * @param data
     * @return
     * @throws SQLException
     */
    public PreparedStatement executeUpdate(String sql, List<Pair> data) throws SQLException {
        PreparedStatement statement = conn.prepareStatement(sql);
        if (data != null) {
            for (int i = 1; i <= data.size(); i++) {
                Pair pair = data.get(i - 1);
                if ("int".equals(pair.getKey())) {
                    statement.setInt(i, (Integer)(pair.getValue()));
                } else if ("text".equals(pair.getKey())) {
                    statement.setString(i, (String)(pair.getValue()));
                }
            }
        }
        return statement;
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

}
