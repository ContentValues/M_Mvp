package cn.love;

import cn.love.imageloader.ILoader;
import cn.love.kit.Kits;
import cn.love.router.Router;

/**
 * Created by wanglei on 2016/12/4.
 */

public class XDroidConf {
    // #log
    public static boolean LOG = true;
    public static String LOG_TAG = "XDroid";

    // #cache
    public static String CACHE_SP_NAME = "config";
    public static String CACHE_DISK_DIR = "cache";

    // #router
    public static int ROUTER_ANIM_ENTER = Router.RES_NONE;
    public static int ROUTER_ANIM_EXIT = Router.RES_NONE;

    // #imageloader
    public static int IL_LOADING_RES = ILoader.Options.RES_NONE;
    public static int IL_ERROR_RES = ILoader.Options.RES_NONE;

    // #dev model
    public static boolean DEV = true;


    /*网络配置*/
    public static int HTTP_READ_TIME_OUT = 3000;
    public static int HTTP_CONNECT_TIME_OUT = 3000;
//    public static String BASE_URL = "http://api.douban.com/v2/movie/top250/";
    public static String BASE_URL = "http://gank.io/api/";


    public static String SHARE_PREFERENCE_FILE_NAME = "diantudaikuan";

    /**
     * config log
     *
     * @param log
     * @param logTag
     */
    public static void configLog(boolean log, String logTag) {
        LOG = log;
        if (!Kits.Empty.check(logTag)) {
            LOG_TAG = logTag;
        }
    }

    /**
     * conf cache
     *
     * @param spName
     * @param diskDir
     */
    public static void configCache(String spName, String diskDir) {
        if (!Kits.Empty.check(spName)) {
            CACHE_SP_NAME = spName;
        }
        if (!Kits.Empty.check(diskDir)) {
            CACHE_DISK_DIR = diskDir;
        }
    }

    /**
     * config dev
     *
     * @param isDev
     */
    public static void devMode(boolean isDev) {
        DEV = isDev;
    }

}
