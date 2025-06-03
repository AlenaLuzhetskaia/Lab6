package org.example.Command;

import org.example.Other.Request;
import org.example.Other.Response;

public class ClearCommand implements Command {
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        collectionManager.clear();
        return new Response("Коллекция успешно очищена!");
    }

    public String descr() {
        return "clear - очистить коллекцию";
    }
}
