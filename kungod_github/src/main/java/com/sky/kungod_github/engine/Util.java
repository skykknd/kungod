package com.sky.kungod_github.engine;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.Toast;

//基础工具
public class Util {
    private Context mContext;

    public Util(Context context) {
        mContext = context;
    }

    /**
     * 保存到剪贴板
     *
     * @param s 要保存到剪贴板的数据
     */
    public void clip(String s) {
        if (TextUtils.isEmpty(s)) {
            return;
        }
        try {
            ClipboardManager cm = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData mClipData = ClipData.newPlainText("KunGod", s);
            cm.setPrimaryClip(mClipData);
            sToast("复制成功: " + s);
        } catch (Exception e) {
            sToast("复制数据异常");
        }
    }

    /**
     * ShortToast
     *
     * @param content toast内容
     */
    public void sToast(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        Toast.makeText(mContext, content, Toast.LENGTH_SHORT).show();
    }

    /**
     * longToast
     *
     * @param content toast内容
     */
    public void lToast(String content) {
        if (TextUtils.isEmpty(content)) {
            return;
        }
        Toast.makeText(mContext, content, Toast.LENGTH_LONG).show();
    }

    /**
     * 16进制字符串转为byte数组
     *
     * @param hex 16进制的字符串
     * @return byte数组
     */
    public byte[] h2b(String hex) throws IllegalArgumentException {
        if (hex.length() % 2 != 0) {
            throw new IllegalArgumentException();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    /**
     * 16进制字符串转为2进制字符串
     *
     * @param hexString 16进制的字符串
     * @return 2进制字符串
     */
    public String hs2bs(String hexString) {
        if (hexString == null || hexString.length() % 2 != 0) {
            return null;
        }
        String bString = "", tmp;
        for (int i = 0; i < hexString.length(); i++) {
            tmp = "0000" + Integer.toBinaryString(Integer.parseInt(hexString.substring(i, i + 1), 16));
            bString += tmp.substring(tmp.length() - 4);
        }
        return bString;
    }

    /**
     * ASCII的16进制字符串转为普通的16进制字符串
     *
     * @param asc ASCII的16进制字符串
     * @return 普通的16进制字符串
     */
    public String convertAscHexToStr(String asc) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < asc.length() - 1; i += 2) {
            String h = asc.substring(i, i + 2);
            int decimal = Integer.parseInt(h, 16);
            stringBuilder.append((char) decimal);
        }
        return stringBuilder.toString();
    }

    /**
     * 退出时需连点
     *
     * @param keyCode 取onKeyDown()的方法参数
     * @param event   取onKeyDown()的方法参数
     * @return 事件消费
     */
    public boolean exitConfirm(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                sToast("再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                ((Activity) mContext).finish();
            }
            return true;
        }
        return false;
    }

    private long exitTime = 0;
}
