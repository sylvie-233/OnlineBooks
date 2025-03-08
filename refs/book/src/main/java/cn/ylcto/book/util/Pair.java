package cn.ylcto.book.util;

/*
 * 键值对工具类
 */
public class Pair {
    private String key;
    private Object value;
    
    public Pair(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair [key=" + key + ", value=" + value + "]";
    }

    /**
     * 静态工具构造
     * @param key int/text
     * @param value 
     * @return
     */
    public static Pair of(String key, Object value) {
        return new Pair(key, value);
    }
}
