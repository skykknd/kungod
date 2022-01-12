package com.sky.kungod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.sky.kungod_github.entry.KunGod;

public class MainActivity extends Activity {
    private KunGod kunGod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        KunGod.init(getApplicationContext());
        kunGod = KunGod.get();

        kunGod.scan(1001);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return kunGod.exitConfirm(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                kunGod.sToast(data.toString());
            }
        }
    }
}