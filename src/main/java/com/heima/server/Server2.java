package com.heima.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Xuejun Yang
 * @version V1.0
 * @description: TODO
 * @date 2019/7/1 14:40
 */
public class Server2 {


    public static void main(String[] args) throws Exception {

        String readline = "";
        String inTemp = null;


        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 4001;



        ServerSocket serverSocket = new ServerSocket(port);  //创建serversocket

        //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket

        while (true){
            Socket clientSocket = serverSocket.accept();
            ClientHandlerThread clientHandlerThread=new ClientHandlerThread(clientSocket);
            clientHandlerThread.start();
        }


        //serverSocket.close();

    }







}
