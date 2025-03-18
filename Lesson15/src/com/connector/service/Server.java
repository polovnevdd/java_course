package com.connector.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server {
    public void serverConnector(){
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущено. Очікуємо клієнта...");
            Socket socket = serverSocket.accept();
            System.out.println("Клієнт підключився!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
            ServerManager serverManager = new ServerManager();
            String line;
            while ((line = input.readLine()) != null){
                if(serverManager.PerevirkaNaKozaka(line) != true) {
                    output.println("Що таке паляниця?");
                    line = input.readLine();
                    if(line.toLowerCase().equals("хлеб")){
                        LocalDateTime now = LocalDateTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                        String formattedDateTime = now.format(formatter);
                        output.println("Дякую, до побачення!  " + formattedDateTime);
                        break;
                    }else{
                        System.out.println(line);
                        break;
                    }
                }
                output.println(line);
                System.out.println("Повідомлення від клієнта: " + line);
            }
            input.close();
            output.close();
            socket.close();
            System.out.println("Клієнт відключився!");

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void isClientNotRussion(){

    }
}
