package com.calculator;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    /**
     * 通过一个线程来执行一个客户端，若要执行多个客户端，只需要声明多个线程就好，
     * 关于向服务器发送消息和接受消息的代码都已经封装到那个线程类中
     *
     * 这里将消息写到函数里面手动输入了，输入exit结束访问
     *
     *
     * */
    public static void main(String[] args){
       ThreadClient t=new ThreadClient("127.0.0.1",9091);
       t.start();
//       ThreadClient t1=new ThreadClient();
//       t1.start();
    }

}
