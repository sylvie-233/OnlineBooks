package cn.ylcto.book.dao.impl;

import java.sql.Connection;
import java.util.List;

import cn.ylcto.book.vo.Admin;

public class AdminDaoImpl extends AbstractDaoImpl<Admin> {
    private static String SQL_SELECT_BY_ID = "SELECT aid, username, password, lastdate, flag, status FROM admin WHERE  aid=?";
    private static String SQL_SELECT_ALL = "SELECT aid, username, password, lastdate, flag, status FROM admin";
    private static String SQL_INSERT_ONE = "INSERT INTO admin(username, password, lastdate, flag, status) values(?, ?, ?, ?, ?)";

    public AdminDaoImpl(Connection conn) {
        super(conn, Admin.class);
    }

    /**
     * 根据id获取Admin
     */
    @Override
    public Admin getById(Integer id) {
        return super.getById(SQL_SELECT_BY_ID, id);
    }

    @Override
    public List<Admin> getAll() {
        return super.getAll(SQL_SELECT_ALL);
    }

    @Override
    public Admin insertOne(Admin vo) {
        return super.insert(SQL_INSERT_ONE, vo);
    }
    
    
}
