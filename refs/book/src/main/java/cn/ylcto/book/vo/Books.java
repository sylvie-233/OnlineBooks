package cn.ylcto.book.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import cn.ylcto.book.util.DateFormater;
import cn.ylcto.book.util.OfBuilder;

/**
 * 书籍
 */
public class Books implements Serializable, OfBuilder<Books> {
    /**
     * 书籍id
     */
    private Integer Bid;

    /**
     * 书籍分类id
     */
    private Integer iid;

    /**
     * 管理员id
     */
    private Integer aid;
    
    /**
     * 书籍名称
     */
    private String name;
    
    /**
     * 创建时间
     */
    private Timestamp credate;
    
    /**
     * 描述
     */
    private String note;
    
    /**
     * 书籍状态
     */
    private Integer status;
    
    /**
     * 书籍分类
     */
    private Item item;
    
    /**
     * 创建书籍的管理员
     */
    private Admin admin;
    
    /**
     * 借书记录
     */
    private List<Lenbook> Lenbook;
    
    public Books() {
    }
    
    public Books(Integer bid, Integer iid, Integer aid, String name, Timestamp credate, String note, Integer status,
            Item item, Admin admin, List<cn.ylcto.book.vo.Lenbook> lenbook) {
        Bid = bid;
        this.iid = iid;
        this.aid = aid;
        this.name = name;
        this.credate = credate;
        this.note = note;
        this.status = status;
        this.item = item;
        this.admin = admin;
        Lenbook = lenbook;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getBid() {
        return Bid;
    }

    public void setBid(Integer bid) {
        Bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCredate() {
        return credate;
    }

    public void setCredate(Timestamp credate) {
        this.credate = credate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<Lenbook> getLenbook() {
        return Lenbook;
    }

    public void setLenbook(List<Lenbook> lenbook) {
        Lenbook = lenbook;
    }
    
    @Override
    public String toString() {
        return "Books [Bid=" + Bid + ", iid=" + iid + ", aid=" + aid + ", name=" + name + ", credate=" + credate
                + ", note=" + note + ", status=" + status + ", item=" + item + ", admin=" + admin + ", Lenbook="
                + Lenbook + "]";
    }

    public Books of(ResultSet resultSet) throws SQLException {
        this.setBid(resultSet.getInt("bid"));
        this.setIid(resultSet.getInt("iid"));
        this.setAid(resultSet.getInt("aid"));
        this.setName(resultSet.getString("name"));
        if (resultSet.getString("credate") != null) {
            this.setCredate(DateFormater.parse(resultSet.getString("credate")));
        }
        this.setBid(resultSet.getInt("bid"));
        this.setStatus(resultSet.getInt("status"));
        this.setNote(resultSet.getString("note"));
        return this;
    }

    @Override
    public List ofValue() {
        // TODO Auto-generated method stub
        return null;
    }
    
}

