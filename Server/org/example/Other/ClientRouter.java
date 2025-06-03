package org.example.Other;

import java.io.*;
import java.net.*;
import java.text.ParseException;

public class ClientRouter {
    public static void connectionStart() throws IOException {
        ServerSocket socket = new ServerSocket(1337);
        ClientHandler clientHandler = new ClientHandler();
        clientHandler.start();
        try {
            clientHandler.fill();
        } catch (ParseException | NullPointerException e) {
            System.out.println("Не удалось считать файл");
        }
        // создается новый поток и он консоль параллельно считывает
        new Thread(() -> {
            while (true) {
                String line = ServerReader.readLine();
                System.out.println(1);
                if (line.equals("save")) {
                    try {
                        ClientHandler.save();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        while (true) {
            Socket client = socket.accept();
            System.out.println(client.getInetAddress());
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            while (true) {
                try {
                    Request request = (Request) in.readObject();
                    System.out.println("Получен запрос: " + request);
                    Response response = clientHandler.executionCommand(request);
                    System.out.println("Отправляем ответ: " + response);
                    out.writeObject(response);
                    out.flush();
                } catch (ClassNotFoundException e) {
                    System.err.println("Неверный формат ответа от сервера");
                } catch (EOFException e) {
                    break;
                } catch (SocketException e) {
                    System.out.println(e);
                    break;
                }

            }
        }

    }
}