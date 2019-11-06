package com.calculator;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ThreadClient extends Thread {
    @Override
    public void run() {
        super.run();
        VisitServer();
    }
    private String host="";
    private int port=0;
    public ThreadClient(String host,int port){
        this.host=host;
        this.port=port;
    }
    public MyLogger myLogger=new MyLogger();
    public void VisitServer(){
        try {
            Socket client;
            try {
                client = new Socket(host, port);
                myLogger.addLog("IP是：127.0.0.1,端口号是：9091");
                /**由于80端口被占用了*/
            } catch (Exception ex) {
                System.out.println(ex);
                myLogger.addLog(ex.toString());
                return;
            }
            try {
                PrintWriter output =
                        new PrintWriter(client.getOutputStream(), true);
                Scanner cin = new Scanner(System.in);

                String words;

                while (cin.hasNext()) {
                    words = cin.nextLine();

                    myLogger.addLog("客户端发送了"+words);

                    output.println(words);

                    System.out.println("写出了数据:" + words);
                    InputStream s = client.getInputStream();
                    byte[] buf = new byte[1024];
                    int len = 0;
                    System.out.print("服务器回复了:");
                    len=s.read(buf);
                    //while ((len = s.read(buf)) >0) {
                        System.out.println(new String(buf, 0, len));
                    //}
                    //System.out.println("接受成功");
                }
                System.out.println("客户端关闭");
                System.out.println("客户端在这段时间产生的日志是\n"+myLogger.getLogger());
                cin.close();
            } finally {
                client.close();

            }
        }catch (Exception ex){
            System.out.println("访问出错");
            myLogger.addLog(ex.toString());
        }
    }
}
