package org.example.Command;

import org.example.Other.Request;
import org.example.Other.Response;

public class AddCommand implements Command {
    private final CollectionManager collectionManager;

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        request.dragon().setId(IDGenerator.generateID());
        collectionManager.add(request.dragon());
        return new Response("Элемент успешно добавлен!");
    }

    public String descr() {
        return "add - добавление нового элемента";
    }
}
