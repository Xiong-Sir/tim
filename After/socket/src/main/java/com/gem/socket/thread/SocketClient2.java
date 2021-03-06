package com.gem.socket.thread;

import com.gem.socket.thread.ClientThread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author jingmeng4
 * @date 2020/10/23 9:08
 */
public class SocketClient2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9999);
            //开启一个线程接收信息，并解析
            ClientThread thread=new ClientThread(socket);
            thread.start();
            //主线程用来发送信息
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            while(true)
            {
                String s=br.readLine();
                out.println(s);
                out.flush();
            }
        }catch(Exception e){
            System.out.println("服务器异常");
        }
    }
}
