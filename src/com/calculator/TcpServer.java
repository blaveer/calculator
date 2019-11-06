package com.calculator;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static MyLogger myLogger=new MyLogger();
    /**
     * 打开之后一直接收来自客户端的数据，直到其发送exit结束
     * */
    public static void main(String[] args)  {
        File file = new File("SendFile/server.txt");
        /**将文件内容读成String发送
         * */
        if (!file.exists() && !file.mkdirs()) {
            System.out.println("打开文件出错");
        }
        String file_info="";
        try{
            System.out.println("读取文件");
            BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
            String linetxt="";
            StringBuilder result = new StringBuilder();
            while ((linetxt = bufferedReader.readLine()) != null) {
                file_info=file_info+linetxt;
            }
        }catch (Exception ex){
            System.out.println("读取文件错处");
        }
        finally {
            System.out.println("读取的文件的内容是"+file_info);
        }
        try {
            ServerSocket server = new ServerSocket(9091);
            myLogger.addLog("服务器端口号：9091");
            try {
                Socket client = server.accept();
                myLogger.addLog("服务器开始接收消息");
                try {
                    BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    boolean flag = true;
                    int count = 1;
                    while (flag) {
                        System.out.println("客户端可以开始访问，这是第" + count + "次！");
                        count++;

                        String line = input.readLine();

                        System.out.println("客户端说： " + line);

                        if (line.equals("exit")) {
                            flag = false;
                            myLogger.addLog("客户端输入了exit，结束访问");
                            System.out.println("客户端结束访问");
                        } else {
                            myLogger.addLog("客户端发送了：" + line);
                            System.out.println("客户端发送了：" + line);
                            OutputStream out=client.getOutputStream();
                            out.write((file_info).getBytes());
                            myLogger.addLog("向客户端回复了送了：");
                        }
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                    myLogger.addLog(ex.toString());
                } finally {
                    client.close();
                    System.out.println("服务器在这段时间产生的日志是\n"+myLogger.getLogger());
                }

            } finally {
                server.close();
            }
        }catch (Exception ex){
            System.out.println(ex);
            myLogger.addLog(ex.toString());
        }
    }
}
