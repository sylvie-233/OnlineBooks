package cn.ylcto.book.vo;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.ylcto.book.util.DateFormater;
import cn.ylcto.book.util.OfBuilder;
import cn.ylcto.book.util.Pair;

/**
 * 后台管理员
 */
public class Admin implements Serializable, OfBuilder<Admin> {
    /**
     *  用户id
     */
    private Integer aid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 最后一次登录
     */
    private Timestamp lastdate;

    /**
     * 
     */
    private int flag;

    /**
     * 
     */
    private int status;

    
    
    public Admin() {
    }


    public Admin(Integer aid, String username, String password, Timestamp lastdate, int flag, int status) {
        this.aid = aid;
        this.username = username;
        this.password = password;
        this.lastdate = lastdate;
        this.flag = flag;
        this.status = status;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastdate() {
        return lastdate;
    }

    public void setLastdate(Timestamp lastdate) {
        this.lastdate = lastdate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin [aid=" + aid + ", password=" + password + ", lastdate=" + lastdate + ", flag=" + flag
                + ", status=" + status + "]";
    }

    public Admin of(ResultSet resultSet) throws SQLException {
        this.setAid(resultSet.getInt("aid"));
        this.setUsername(resultSet.getString("username"));
        this.setPassword(resultSet.getString("password"));
        if (resultSet.getString("lastdate") != null) {
            this.setLastdate(DateFormater.parse(resultSet.getString("lastdate")));
        }
        this.setFlag(resultSet.getInt("flag"));
        this.setStatus(resultSet.getInt("status"));
        return this;
    }


    @Override
    public List<Pair> ofValue() {
        List<Pair> list = new ArrayList<>();
        list.add(Pair.of("text", getUsername()));
        list.add(Pair.of("text", getPassword()));
        list.add(Pair.of("text", getLastdate()));
        list.add(Pair.of("int", getFlag()));
        list.add(Pair.of("int", getStatus()));
        return list;
    }
    
}
