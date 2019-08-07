package com.bbg.web.controller;

import com.bbg.portal.servcie.PortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PortalController {
    String strErr="";
    @Autowired
    private PortalService portalService;
    
    @RequestMapping("/testRandomErr")
    public Map<String,String> addOrder(){
        this.portalService.testRandomErr();
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg", "ok");
        return map;
    }
    
    @RequestMapping("/testServerRepeatCall")
    public Map<String,String> testRepeatCall(){
        
        this.portalService.testRepeatCall();
        
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg", "ok");
        return map;
    }
    @RequestMapping("/testLoopCall")
    public Map<String,String> testLoopCall(@RequestParam(value = "count", required = false, defaultValue="200") int count){
        String str="";
        for(int i=0;i<count;i++){
            try {
                this.portalService.testLoopCall(i); 
            } catch (Exception e) {
                str+=i+",";
               continue;
            }
            
        }
        System.out.println(str.substring(0, str.length()-1));
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg", "ok");
        return map;
    }
    @RequestMapping("/testHystrix")
    public Map<String,String> testHystrix(){
        this.portalService.testHystrix(); 
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg", "ok");
        return map;
    }
    @RequestMapping("/pressureTest")
    public Map<String,String> pressureTest(){

        for(int i=0;i<300;i++){
            Integer begin = begin=i*200;
            Integer end=(i+1)*200;
            MyTestThred t = new MyTestThred(begin,end);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(strErr);
        Map<String,String> map = new HashMap<String,String>();
        map.put("msg", "ok");
        return map;
    }
    class TestThred implements Runnable
    {
        private Integer begin;
        private Integer end;
        public void run()
        {
            try {
                for(;begin<end;begin++){
                    portalService.testLoopCall(begin);
                }
            }catch (Exception e) {
                //strErr+=begin+",";
            }
        }

    }
    class MyTestThred extends Thread
    {
        private Integer begin;
        private Integer end;

        public MyTestThred(){}

        public MyTestThred(Integer begin,Integer end){
            this.begin=begin;
            this.end=end;
        }

        public void run()
        {
            for(;begin<end;begin++){
                try {
                    portalService.testLoopCall(begin);
                }catch (Exception e) {
                    strErr+=begin+",";
                }
            }
        }

    }
}
