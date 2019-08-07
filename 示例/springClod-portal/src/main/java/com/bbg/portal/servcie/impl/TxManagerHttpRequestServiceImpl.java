package com.bbg.portal.servcie.impl;

import com.bbg.tx.netty.service.TxManagerHttpRequestService;
import com.lorne.core.framework.utils.http.HttpUtils;

/**
 * create by lorne on 2017/11/18
 */

// @Service
public class TxManagerHttpRequestServiceImpl implements TxManagerHttpRequestService{

    @Override
    public String httpGet(String url) {
        System.out.println("httpGet-start");
        String res = HttpUtils.get(url);
        System.out.println("httpGet-end");
        return res;
    }

    @Override
    public String httpPost(String url, String params) {
        System.out.println("httpPost-start");
        String res = HttpUtils.post(url,params);
        System.out.println("httpPost-end");
        return res;
    }
}
