package com.calculator;

import java.util.logging.Logger;

public class MyLogger {
    /**
     * 该类只是在客户端和服务端声明，
     * 如果需要查看日志，只需获取getLogger函数就好
     * */
    public MyLogger(){}
    private String log="";
    public void addLog(String logTemp){
        log=log+logTemp+"\n";
    }
    public String getLogger() {
        return log;
    }
}
