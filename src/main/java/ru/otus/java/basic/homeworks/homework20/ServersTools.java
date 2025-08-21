package ru.otus.java.basic.homeworks.homework20;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class ServersTools implements Closeable {
    private Socket client;
    private DataInputStream input;
    private DataOutputStream output;

    public ServersTools(Socket client) throws IOException {
        this.client = client;
        input = new DataInputStream(this.client.getInputStream());
        output = new DataOutputStream(this.client.getOutputStream());
    }

    public void readAndWrite() {
        try {
            String s = input.readUTF();
            if (s.equalsIgnoreCase("exit")) {
                output.writeUTF(s);
                client.close();
                return;
            }
            int result;
            try {
                result = Calculator.calculate(s);
                output.writeUTF(Integer.toString(result));
            } catch (Exception e) {
                System.out.println("Ошибка в процессе расчёта, возможно, введено некорректное выражение");
                output.writeUTF("Ошибка в процессе расчёта, возможно, вы ввели некорректное выражение");
            }

        } catch (SocketException | EOFException e) {
            System.out.println("Клиент закрыл соединение");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
