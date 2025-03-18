package com.connector;

import com.connector.service.Server;

public class Start {
    public static void main(String[] args) {
        Start start = new Start();
        start.start();
    }
    public void start(){
        Server server = new Server();
        server.serverConnector();

    }
}
