package ru.otus.java.basic.homeworks.homework20;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Сервер активирован");
            while (true) {
                try (Socket client = server.accept();
                     ServersTools serversTools = new ServersTools(client)) {

                    serversTools.readAndWrite();
                }
            }
        }
    }
}

