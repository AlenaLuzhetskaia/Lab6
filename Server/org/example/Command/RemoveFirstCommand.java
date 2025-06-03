package org.example.Command;

import org.example.Option.Dragon;
import org.example.Other.Request;
import org.example.Other.Response;

public class RemoveFirstCommand implements  Command {
    CollectionManager collectionManager;
    public RemoveFirstCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        if (collectionManager.getDragonPriorityQueue().isEmpty()) {
            return new Response("Коллекция пуста, удаление невозможно");
        }

        Dragon removedDragon = collectionManager.getDragonPriorityQueue().poll();
        return new Response("Первый элемент коллекции успешно удалён!");
    }

    public String descr() {
        return "remove_first - удаляет первый элемент коллекции";
    }
}
