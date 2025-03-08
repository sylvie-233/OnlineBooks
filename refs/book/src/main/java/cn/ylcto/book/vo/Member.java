package cn.ylcto.book.vo;

import java.util.List;

/**
 * 借书用户
 */
public class Member {
    /**
     * 用户id
     */
    private String mid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 用户年龄
     */
    private Integer age;

    /**
     * 用户性别
     */
    private Integer sex;

    /**
     * 用户电话
     */
    private String phone;

    /**
     * 借书记录
     */
    private List<Lenbook> Lenbooks;

    public Member() {
    }

    public Member(String mid, String name, Integer age, Integer sex, String phone, List<Lenbook> lenbooks) {
        this.mid = mid;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        Lenbooks = lenbooks;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Lenbook> getLenbooks() {
        return Lenbooks;
    }

    public void setLenbooks(List<Lenbook> lenbooks) {
        Lenbooks = lenbooks;
    }

    @Override
    public String toString() {
        return "Member [mid=" + mid + ", name=" + name + ", age=" + age + ", sex=" + sex + ", phone=" + phone
                + ", Lenbooks=" + Lenbooks + "]";
    }

}
