package cn.ylcto.book.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.ylcto.book.util.OfBuilder;

/**
 * 图书类别
 */
public class Item implements Serializable, OfBuilder<Item> {
    /**
     * 图书类别id
     */
    private Integer iid;

    /**
     * 图书类别名称
     */
    private String name;

    /**
     * 图书类别描述
     */
    private String note;

    /**
     * 类别下图书
     */
    private List<Books> Book;//表示一个类别下有多本书

    public Item() {
    }

    public Item(Integer iid, String name, String note, List<Books> book) {
        this.iid = iid;
        this.name = name;
        this.note = note;
        Book = book;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Books> getBook() {
        return Book;
    }

    public void setBook(List<Books> book) {
        Book = book;
    }

    @Override
    public String toString() {
        return "Item [iid=" + iid + ", name=" + name + ", note=" + note + ", Book=" + Book + "]";
    }

    public Item of(ResultSet resultSet) throws SQLException {
        this.setIid(resultSet.getInt("iid"));
        this.setName(resultSet.getString("name"));
        this.setNote(resultSet.getString("note"));
        return this;
    }

}
