package cn.love.demo.demo.design.simpleFactory;


/**
 * Author：created by SugarT
 * Time：2019/12/13 10
 */
public interface IOHandler {

    void save(String key, String value);

    String get(String key, String defaultValue);

}
