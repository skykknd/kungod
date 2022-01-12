package com.sky.kungod_github.entry;

import android.content.Context;
import android.view.KeyEvent;

import com.sky.kungod_github.engine.Scan;
import com.sky.kungod_github.engine.Util;

public class KunGod {
    /**
     * 坤神工具初始化
     *
     * @param context 应传ApplicationContext, 跟随app生命周期
     */
    public static void init(Context context) {
        mContext = context;
        util = new Util(context);
        scan = new Scan(context);
    }

    private static Context mContext;
    private static Util util;
    private static Scan scan;

    /**
     * 获取工具的单例对象
     */
    public static KunGod get() {
        return instance;
    }

    private final static KunGod instance = new KunGod();

    private KunGod() {
    }


    // ************ 对外API ************//

    // ====== 1.基础工具 ====== //

    /**
     * 保存到剪贴板
     *
     * @param s 要保存到剪贴板的数据
     */
    public void clip(String s) {
        util.clip(s);
    }

    /**
     * ShortToast
     *
     * @param content toast内容
     */
    public void sToast(String content) {
        util.sToast(content);
    }

    /**
     * longToast
     *
     * @param content toast内容
     */
    public void lToast(String content) {
        util.lToast(content);
    }

    /**
     * 16进制字符串转为byte数组
     *
     * @param hex 16进制的字符串
     * @return byte数组
     */
    public byte[] h2b(String hex) throws IllegalArgumentException {
        return util.h2b(hex);
    }

    /**
     * 16进制字符串转为2进制字符串
     *
     * @param hexString 16进制的字符串
     * @return 2进制字符串
     */
    public String hs2bs(String hexString) {
        return util.hs2bs(hexString);
    }

    /**
     * ASCII的16进制字符串转为普通的16进制字符串
     *
     * @param asc ASCII的16进制字符串
     * @return 普通的16进制字符串
     */
    public String convertAscHexToStr(String asc) {
        return util.convertAscHexToStr(asc);
    }

    /**
     * 退出时需连点
     *
     * @param keyCode 取onKeyDown()的方法参数
     * @param event   取onKeyDown()的方法参数
     * @return 事件消费
     */
    public boolean exitConfirm(int keyCode, KeyEvent event) {
        return util.exitConfirm(keyCode, event);
    }


    // ====== 2.华为扫码 ====== //

    /**
     * 扫码
     *
     * @param REQUEST_CODE_SCAN startActiviyForResult()的请求码
     */
    public void scan(int REQUEST_CODE_SCAN) {
        scan.scan(REQUEST_CODE_SCAN);
    }
}
