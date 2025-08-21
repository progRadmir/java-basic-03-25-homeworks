package ru.otus.java.basic.homeworks.homework20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ClientsTools implements AutoCloseable{
    private Socket client;
    private final DataInputStream input;
    private DataOutputStream output;
    private Scanner scanner;

    public ClientsTools(Socket client) throws IOException {
        this.client = client;
        input = new DataInputStream(this.client.getInputStream());
        output = new DataOutputStream(this.client.getOutputStream());
        scanner = new Scanner(System.in);
    }

    public boolean writeAndRead() {
        System.out.println("Введите выражение без скобок:");
        String s = scanner.nextLine();
        try {
            if (s.equalsIgnoreCase("exit")) {
                output.writeUTF(s);
                client.close();
                return false;
            }
            output.writeUTF(s);
            System.out.println(input.readUTF());

        } catch (ConnectException e) {
            System.out.println("Соединение не установлено / разорвано");
            throw new RuntimeException(e);
        } catch (SocketException | EOFException e) {
            System.out.println("Сервер закрыл соединение");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        IOException ex = null;

        try {
            if (input != null) {input.close();}
        } catch (IOException e) {
            ex = e;
        }
        try {
            if (output != null) {output.close();}
        } catch (IOException e) {
            if (ex == null) {ex = e;} else {ex.addSuppressed(e);}
        }

        if (ex != null) {throw ex;}

    }
}
