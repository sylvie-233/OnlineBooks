package cn.ylcto.book.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface OfBuilder<T> {
    public T of(ResultSet resultSet) throws SQLException;
    public List<Pair> ofValue();
}
