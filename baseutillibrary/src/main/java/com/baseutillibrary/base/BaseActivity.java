package com.baseutillibrary.base;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by 李健健 on 2016/12/21.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManagerUtil.getInstance().addToStack(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityManagerUtil.getInstance().removeFromStack(this);
    }
}
