package cn.ylcto.book.vo;

import java.sql.Timestamp;

/**
 * 借书记录
 */
public class Lenbook {
    /**
     * 借书记录id
     */
    private Integer leid;

    /**
     * 借用的图书
     */
    private Books books;

    /**
     * 借书的用户
     */
    private Member member;

    /**
     * 借书时间
     */
    private Timestamp credate;

    public Lenbook() {
    }

    public Lenbook(Integer leid, Books books, Member member, Timestamp credate) {
        this.leid = leid;
        this.books = books;
        this.member = member;
        this.credate = credate;
    }

    public Integer getLeid() {
        return leid;
    }

    public void setLeid(Integer leid) {
        this.leid = leid;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Timestamp getCredate() {
        return credate;
    }

    public void setCredate(Timestamp credate) {
        this.credate = credate;
    }

    @Override
    public String toString() {
        return "Lenbook [leid=" + leid + ", books=" + books + ", member=" + member + ", credate=" + credate + "]";
    }

}
