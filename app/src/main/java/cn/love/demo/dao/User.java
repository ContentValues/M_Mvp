package cn.love.demo.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Author：created by SugarT
 * Time：2019/11/25 14
 */
@Entity //@Entity 将我们的java普通类变为一个能够被greenDAO识别的数据库类型的实体类
public class User {

    //@Id：主键，通过这个注解标记的字段必须是Long类型的，这个字段在数据库中表示它就是主键，并且它默认就是自增的
    @Id(autoincrement = true)
    private Long id;

    @NotNull    // @NotNull 设置数据库表当前列不能为空
    @Unique  //唯一
    private String name;

    //@Property：设置一个非默认关系映射所对应的列名，默认是使用字段名，例如：@Property(nameInDb = "name")
    @Property(nameInDb = "userage")
    private int age;


    private String love;

    private String fsUpdateTime;


    //@Transient：表明这个字段不会被写入数据库，只是作为一个普通的java类字段，用来临时存储数据的，不会被持久化
    @Transient
    private String like;


    @Generated(hash = 803956419)
    public User(Long id, @NotNull String name, int age, String love,
            String fsUpdateTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.love = love;
        this.fsUpdateTime = fsUpdateTime;
    }


    @Generated(hash = 586692638)
    public User() {
    }


    public Long getId() {
        return this.id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return this.age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getLove() {
        return this.love;
    }


    public void setLove(String love) {
        this.love = love;
    }


    public String getFsUpdateTime() {
        return this.fsUpdateTime;
    }


    public void setFsUpdateTime(String fsUpdateTime) {
        this.fsUpdateTime = fsUpdateTime;
    }




}
