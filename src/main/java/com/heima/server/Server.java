package com.heima.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {


    public static void main(String[] args) throws Exception {

        String readline = "";
        String inTemp = null;


        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";

        int port = 4001;



        ServerSocket serverSocket = new ServerSocket(port);  //创建serversocket

        //调用服务器的accept（）进行阻塞（程序会在这等待），当有申请连接时会打开阻塞并返回一个socket
        Socket clientSocket = serverSocket.accept();

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader clientSocketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter clientSocketOut = new PrintWriter(clientSocket.getOutputStream());

        while(!readline.equals("bye")){

            inTemp = clientSocketIn.readLine();
            System.out.println(client + turnLine + inTemp);
            System.out.println(server);

            readline = systemIn.readLine();

            clientSocketOut.println(readline);
            clientSocketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)

        }

        systemIn.close();
        clientSocketIn.close();
        clientSocketOut.close();
        clientSocket.close();
        serverSocket.close();

    }







}
