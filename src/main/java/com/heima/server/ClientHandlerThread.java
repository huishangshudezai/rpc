package com.heima.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientHandlerThread extends Thread {

    private Socket clientSocket;

    public ClientHandlerThread(Socket socket) {

        this.clientSocket=socket;

    }

    @Override
    public void run() {

        try {
            handle();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void handle() throws IOException {

        String readline="";
        String inTemp=null;
        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader clientSocketIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter clientSocketOut = new PrintWriter(clientSocket.getOutputStream());


        while(!readline.equals("bye")){

            inTemp = clientSocketIn.readLine();
            System.out.println("read from client:"+inTemp);
            System.out.println("请输入：");
            readline = systemIn.readLine();
            clientSocketOut.println(readline);
            clientSocketOut.flush();    //赶快刷新使Client收到，也可以换成socketOut.println(readline, ture)

        }

        systemIn.close();
        clientSocketIn.close();
        clientSocketOut.close();
        clientSocket.close();


    }
}
