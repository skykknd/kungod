package com.sky.kungod;

import android.app.Activity;
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
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return kunGod.exitConfirm(keyCode, event);
    }
}