package ru.otus.java.basic.homeworks.homework20;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {

            while (true) {
                try (Socket client = new Socket("localhost", 8080);
                     ClientsTools clientTools = new ClientsTools(client)) {

                    if (!clientTools.writeAndRead()) {
                        break;
                    }
                }
            }
    }
}
