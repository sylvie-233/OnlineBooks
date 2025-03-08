package cn.ylcto.book.dao.impl;

import java.sql.Connection;
import java.util.List;

import cn.ylcto.book.vo.Item;

public class ItemDaoImpl extends AbstractDaoImpl<Item> {
    private static String SQL_SELECT_BY_ID = "SELECT iid, name, note FROM item WHERE iid=?";
    private static String SQL_SELECT_ALL = "SELECT iid, name, note FROM item";

    public ItemDaoImpl(Connection conn) {
        super(conn, Item.class);
    }

    /**
     * 根据id获取Admin
     */
    @Override
    public Item getById(Integer id) {
       return super.getById(SQL_SELECT_BY_ID, id);
    }

    @Override
    public List<Item> getAll() {
        return super.getAll(SQL_SELECT_ALL);
    }
    
}
