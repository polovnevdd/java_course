package com.connector.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8081)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);
            Client client = new Client();
            client.giveMessageToServer(scanner, input, output);
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean getMessageFromServer(BufferedReader reader) {
        String message;
        try {
            if((message = reader.readLine()) != null) {
                System.out.println("Сообщение от сервера: " + message);
            }
        } catch (IOException e) {
            return true;
        }
        return true;
    }

    private void giveMessageToServer(Scanner scanner, BufferedReader input, PrintWriter output) {
        Client client = new Client();
        while (true) {
            System.out.print("Введите сообщение для сервера (или 'exit' для выхода): ");
            String messageToSend = scanner.nextLine();
            if (isExit(messageToSend) ) {
                break;
            }
            output.println(messageToSend);
            client.getMessageFromServer(input);
        }
    }

    private boolean isExit(String messageToSend) {
        return messageToSend.equals("exit");
    }
}
