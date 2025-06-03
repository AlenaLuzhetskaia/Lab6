package org.example.Command;

import org.example.Other.Request;
import org.example.Other.Response;

import static org.example.Other.ClassReader.consoleReadLine;

public class RemoveAllByAgeCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveAllByAgeCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        System.out.print("Введите возраст дракона: ");
        int age = Integer.parseInt(consoleReadLine());
        try {
            collectionManager.removeAllByAge(age);
            return new Response("Удалены все элементы с возрастом: " + age);
        } catch (NumberFormatException e) {
            return new Response(("Введите числовое значение: "));
        }
    }

    public String descr() {
        return "remove_all_by_age - удаляет все элементы, где значение поля age эквивалентно заданному";
    }
}
