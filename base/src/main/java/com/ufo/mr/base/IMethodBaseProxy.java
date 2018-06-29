package com.ufo.mr.base;

public interface IMethodBaseProxy {
    /**
     * @param modelTag   模块别名
     * @param methodName 方法名
     * @param params     方法参数数组
     * @return true 当前代理类方法支持该方法并且执行 ；false 当前代理类里不支持该方法名和参数
     */
    boolean envoke(String modelTag, String methodName, Object[] params);


    /**
     * @return 返回代理模块名
     */
    String getTag();
}
