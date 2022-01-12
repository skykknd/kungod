package com.sky.kungod_github.engine;

import android.app.Activity;
import android.content.Context;

import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

//华为扫码
public class Scan {
    private Context mContext;

    public Scan(Context context) {
        mContext = context;
    }

    /**
     * 扫码
     *
     * @param REQUEST_CODE_SCAN startActiviyForResult()的请求码
     */
    public void scan(int REQUEST_CODE_SCAN) {
        HmsScanAnalyzerOptions options = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(HmsScan.QRCODE_SCAN_TYPE).create();
        ScanUtil.startScan((Activity) mContext, REQUEST_CODE_SCAN, options);
    }
}
