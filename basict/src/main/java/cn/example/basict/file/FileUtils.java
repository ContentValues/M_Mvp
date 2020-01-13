package cn.example.basict.file;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Author：created by SugarT
 * Time：2019/11/29 10
 */
public class FileUtils {

    public static void main(String args[]) {
        writeToFile("你好啊");
        writeToFile("你好啊1");
        writeToFile("你好啊2");
    }


    public static void writeToFile(String content) {
        StringBuilder sb = new StringBuilder(getCurrentDate());
        sb.append(":").append(content);
        writeToFile(absolutePath, sb.toString(), true);
    }


    static String absolutePath = "/Users/zhangmin/Documents/AndroidStudio/组件化/M_Mvp/basict" + "/Kept/Cepa/log.txt";

    /**
     * 文件数据写入（如果文件夹和文件不存在，则先创建，再写入）
     *
     * @param filePath
     * @param content
     * @param flag     true:如果文件存在且存在内容，则内容换行追加；false:如果文件存在且存在内容，则内容替换
     */
    public static void writeToFile(String filePath, String content, boolean flag) {
        FileWriter fw = null;
        try {
            File file = new File(filePath);
            //如果文件夹不存在，则创建文件夹
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {//如果文件不存在，则创建文件,写入第一行内容
                file.createNewFile();
                fw = new FileWriter(file);
            } else {//如果文件存在,则追加或替换内容
                fw = new FileWriter(file, flag);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 得到当前时间
     *
     * @return
     */
    public static synchronized String getCurrentDate() {
        Date currentDate = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(currentDate);
    }
}
