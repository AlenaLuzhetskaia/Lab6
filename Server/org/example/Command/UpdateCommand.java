package org.example.Command;

import org.example.Option.Dragon;
import org.example.Other.ClassReader;
import org.example.Other.Request;
import org.example.Other.Response;

public class UpdateCommand implements Command {
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        try {
            System.out.print("Введите id элемента для обновления: ");
            long id = Long.parseLong(ClassReader.consoleReadLine());

            Dragon dragonToUpdate = collectionManager.getById(id);
            if (dragonToUpdate == null) {
                return new Response("Элемент с id " + id + " не найден");
            }

            String message = "Текущие данные элемента:\n"
                    + dragonToUpdate
                    + "\n\nВведите новые данные:";

            return new Response(message);
        } catch (NumberFormatException e) {
            return new Response("Ошибка: введите корректный числовой id");
        }
    }

    public String descr() {
        return "update - обновить информацию об элементе";
    }
}
