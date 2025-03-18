package com.connector.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.PrintWriter;
import java.util.Scanner;

import static com.connector.service.Server1.REASON_TO_STOP;
import static com.connector.service.Server1.STOP_WORD;

public class Client1 {
    static int PORT = 8081;
    static String HOSTNAME = "localhost";

    public static void main(String[] args) {
        Client1 client = new Client1();
        client.startClient();
    }

    void startClient() {
        try (Socket socket = new Socket(HOSTNAME, PORT)) {
            System.out.println("Connected to the server at " + HOSTNAME + ";" + PORT);
            System.out.println("To interrupt communication send message \"" + STOP_WORD + "\"");

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner console = new Scanner(System.in);

            boolean isContinue;
            do {
                isContinue = chatWithServer(reader, writer, console);
            } while (isContinue);

            reader.close();
            writer.close();
            console.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean chatWithServer(BufferedReader reader, PrintWriter writer, Scanner console) throws IOException {
        String messageToServer = console.nextLine();
        System.out.println("Sending to server: " + messageToServer);
        writer.println(messageToServer);
        String serverResponse = reader.readLine();
        System.out.println("Server says: " + serverResponse);
        return !(STOP_WORD.equalsIgnoreCase(serverResponse) || REASON_TO_STOP.equalsIgnoreCase(serverResponse));
    }
}

