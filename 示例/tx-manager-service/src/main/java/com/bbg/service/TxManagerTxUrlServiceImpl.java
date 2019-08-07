package com.bbg.service;

import com.bbg.tx.config.service.TxManagerTxUrlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TxManagerTxUrlServiceImpl implements TxManagerTxUrlService{
    
    @Value("${txmanger.url}")
    private String url;
    
    public String getTxUrl() {
        // TODO Auto-generated method stub
        return url;
    }

}
