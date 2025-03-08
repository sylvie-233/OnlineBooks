package cn.ylcto.book.dao;

import java.util.List;


/**
 * 持久层通用接口
 */
public interface IDao<T> {
    T getById(Integer id);
    List<T> getAll();
    boolean removeById(Integer id);
    T update(T vo);
    T insertOne(T vo);
}
