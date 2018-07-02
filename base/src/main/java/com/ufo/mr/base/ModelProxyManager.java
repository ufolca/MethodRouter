package com.ufo.mr.base;

import java.util.HashMap;

public class ModelProxyManager   {
    private HashMap<String, IMethodBaseProxy> methodProxyMap = new HashMap<>();

    public static class ModelProxyManagerHolder {
        public static ModelProxyManager instance = new ModelProxyManager();
    }

    public static ModelProxyManager getInstance() {
        return ModelProxyManagerHolder.instance;
    }

    private ModelProxyManager() {

    }

    public void addMethodProxy(IMethodBaseProxy proxy) {
        if (methodProxyMap != null) {
            methodProxyMap.put(proxy.getTag(), proxy);
        }
    }


    /**
     * 遍历寻找对应的方法所在的代理类并且进行调用
     *
     * @param modelTag   模块别名
     * @param methodName 方法名
     * @param paras      方法参数
     * @return
     */
    public boolean envoke(String modelTag, String methodName, Object[] paras) {
        if (methodProxyMap != null && methodProxyMap.containsKey(modelTag)) {
            IMethodBaseProxy methodProxy = methodProxyMap.get(modelTag);
            if (methodProxy.envoke(modelTag, methodName, paras)) {
                return true;
            }
        }
        return false;
    }


}