package com.ufo.mr.b;

import android.content.Context;

import com.ufo.mr.base.MethoProxyCallBack;
import com.ufo.mr.base.ModelProxyManager;

public class BTest {

    public void test() {
        ModelProxyManager.getInstance().envoke("a", "test", null);
    }

    public void testContext(Context context) {
        ModelProxyManager.getInstance().envoke("a", "testContext", new Object[]{context});
    }

    public void testCallback(Context context, String s, MethoProxyCallBack callBack) {
        ModelProxyManager.getInstance().envoke("a", "testCallback", new Object[]{context, s, callBack});
    }
}
