package cn.love.demo.dao;

import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;

/**
 * Author：created by SugarT
 * Time：2019/11/25 14
 */
public class PersonInfor {

    @Id(autoincrement = true)//设置自增长
    private Long id;

    @Index(unique = true)//设置唯一性
    private String perNo;//人员编号

    private String name;//人员姓名

    private String sex;//人员姓名
}
