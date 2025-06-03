package org.example.Command;

import org.example.Filler;
import org.example.Option.Dragon;
import org.example.Other.Request;
import org.example.Other.Response;

public class AddIfMaxCommand implements Command {
    private final CollectionManager collectionManager;

    public AddIfMaxCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        Filler filler = new Filler();
        Dragon dragon = filler.fill();

        if (collectionManager.isMax(dragon)) {
            collectionManager.add(dragon);
            return new Response("Элемент успешно добавлен!");
        } else {
            return new Response("Элемент не добавлен, так как значение поля age не является максимальным");
        }
    }

    public String descr() {
        return "add_if_max - добавляет новый элемент в коллекцию, если его значение поля age превышает значение наибольшего элемента этой коллекции";
    }
}
