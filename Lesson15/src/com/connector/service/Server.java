package com.connector.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Server {
    public void serverConnector() {
        int port = 8081;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            Server server = new Server();
            System.out.println("Сервер запущено. Очікуємо клієнта...");
            Socket socket = serverSocket.accept();
            System.out.println("Клієнт підключився!");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            String line;
            while ((line = input.readLine()) != null) {
                if(server.isClientNotRussion(line, input, output)){
                    break;
                }
                output.println(line);
                System.out.println("Повідомлення від клієнта: " + line);
            }
            input.close();
            output.close();
            socket.close();
            System.out.println("Клієнт відключився!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isClientNotRussion(String line, BufferedReader input, PrintWriter output) throws IOException {
        ServerManager serverManager = new ServerManager();
        if (serverManager.perevirkaNaKozaka(line) != true) {
            output.println("Що таке паляниця?");
            line = input.readLine();
            if (line.toLowerCase().equals("хлеб")) {
                LocalDate now = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String formattedDate = now.format(formatter);
                output.println("Дякую, до побачення!  " + formattedDate);
                return true;
            } else {
                System.out.println(line);
                return true;
            }
        }
        return false;
    }
}
