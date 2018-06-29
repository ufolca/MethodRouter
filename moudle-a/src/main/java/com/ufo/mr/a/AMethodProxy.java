package com.ufo.mr.a;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.ufo.mr.base.IMethodBaseProxy;
import com.ufo.mr.base.MethoProxyCallBack;

public class AMethodProxy implements IMethodBaseProxy {
    @Override
    public boolean envoke(String modelTag, String methodName, Object[] params) {
        if ("test".equals(methodName)) {
            test();
            return true;
        } else if ("testContext".equals(methodName)) {
            if (params != null && params.length == 1) {
                try {
                    testContext((Context) params[0]);
                    return true;
                } catch (Exception e) {

                }
            }
        } else if ("testCallback".equals(methodName)) {
            if (params != null && params.length == 3) {
                try {
                    testCallback((Context) params[0], params[1].toString(), (MethoProxyCallBack) params[2]);
                    return true;
                } catch (Exception e) {

                }
            }
        }
        return false;

    }

    private void testCallback(Context ctx, String s, MethoProxyCallBack callBack) {
        if (callBack != null) {
            callBack.callBack("{\"" + s + "\":\"success\"}");
        }
    }

    private void testContext(Context ctx) {
        Toast.makeText(ctx, "moudle-a.testContext()", Toast.LENGTH_SHORT).show();
    }

    private void test() {
        Log.d("moudle-a.test()", "success");
    }

    @Override
    public String getTag() {
        return "a";
    }
}
