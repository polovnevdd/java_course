package com.connector.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Set;

public class Server1 {
    static int PORT = 8081;
    static final Set<String > RUSSIAN_CHARACTERS = Set.of("ы", "ё", "э", "ъ");
    static String STOP_WORD = "bye";
    static String REASON_TO_STOP = "Ти - москаль";

    public static void main(String[] args) {
        Server1 server = new Server1();
        server.startServer();
    }

    void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Starting the server on port" + PORT);
            System.out.println("Server is running and waiting for connections...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket.getInetAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            boolean isContinue;
            do {
                isContinue = chatWithClient(reader, writer);
            } while (isContinue);

            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean chatWithClient(BufferedReader reader, PrintWriter writer) throws IOException {
        String clientMessage = reader.readLine();
        if (RUSSIAN_CHARACTERS.stream().anyMatch(clientMessage::contains)) {
            return isClientNotRussian(reader, writer);
        } else {
            writer.println(clientMessage);
            return !STOP_WORD.equalsIgnoreCase(clientMessage);
        }
    }

    private boolean isClientNotRussian(BufferedReader reader, PrintWriter writer) throws IOException {
        writer.println("що таке паляниця?");
        String clientMessage = reader.readLine();
        if ("це традиційний український хліб".equals(clientMessage)){
            LocalDateTime currentDateTime = LocalDateTime.now();
            writer.println("Вірно, поточна дата і час: " + currentDateTime);
            writer.println("До побачення");
            return true;
        } else {
            writer.println(REASON_TO_STOP);
            return false;
        }
    }
}

