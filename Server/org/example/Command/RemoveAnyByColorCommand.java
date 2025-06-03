package org.example.Command;

import org.example.Option.Color;
import org.example.Other.ClassReader;
import org.example.Other.Request;
import org.example.Other.Response;

public class RemoveAnyByColorCommand implements Command {
    private final CollectionManager collectionManager;

    public RemoveAnyByColorCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public Response execute(Request request) {
        while (true) {
            try {
                System.out.println("Выберите цвет из предложенных:");
                for (Color c : Color.values()) {
                    System.out.print(c + " ");
                }
                System.out.print("Введите цвет: ");

                String input = ClassReader.consoleReadLine().trim().toUpperCase();
                Color color = Color.valueOf(input);

                boolean isRemoved = collectionManager.removeAnyByColor(color);
                if (isRemoved) {
                    return new Response("Элемент с цветом " + color + " успешно удалён!");
                } else {
                    return new Response("Элементов с цветом " + color + " не найдено");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Выберите цвет из предложенного списка");
            }
        }
    }

    public String descr() {
        return "remove_any_by_color - удаляет один элемент, значение поля color которого эквивалентно заданному";
    }
}
