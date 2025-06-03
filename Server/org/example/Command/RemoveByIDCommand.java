package org.example.Command;

import org.example.Other.Request;
import org.example.Other.Response;

import java.util.Scanner;

public class RemoveByIDCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveByIDCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите id элемента для удаления: ");
        long id = scanner.nextLong();
        scanner.nextLine(); // очистка буфера после nextLong()

        boolean isRemoved = collectionManager.removeByID(id);
        if (isRemoved) {
            return new Response("Элемент с id " + id + " успешно удалён!");
        } else {
            return new Response("Элемент с id " + id + " не найден");
        }
    }

    public String descr() {
        return "remove_by_id - удалить элемент по его id";
    }
}
