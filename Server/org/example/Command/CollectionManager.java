package org.example.Command;

import org.example.Option.Dragon;

import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.PriorityQueue;
import org.example.Option.Color;
import org.example.Option.DragonCharacter;

public class CollectionManager {
    private PriorityQueue<Dragon> dragonPriorityQueue = new PriorityQueue<>(Comparator.comparing(Dragon::getID));
    private final Date creationDate = new Date();

    public void add(Dragon dragon) {
        dragonPriorityQueue.offer(dragon);
    }


    public int size() {
        return dragonPriorityQueue.size();
    }

    public Date creationDate() {
        return creationDate;
    }


    public PriorityQueue<Dragon> getDragonPriorityQueue() {
        return dragonPriorityQueue;
    }

    public Dragon getById(long id) {
        for (Dragon dragon : dragonPriorityQueue) {
            if (dragon.getID() == id) {
                return dragon;
            }
        }
        return null;
    }

    public void clear() {
        dragonPriorityQueue.clear();
    }

    // удаление элемента по id
    public boolean removeByID(long id) {
        Iterator<Dragon> iterator = dragonPriorityQueue.iterator();
        while (iterator.hasNext()) {
            Dragon dragon = iterator.next();
            if (dragon.getID() == id) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public boolean isMax(Dragon dragon) {
        if (dragonPriorityQueue.isEmpty()) {
            return true; // Если коллекция пуста, новый элемент автоматически считается максимальным
        }

        for (Dragon d : dragonPriorityQueue) {
            if (d.getAge() > dragon.getAge()) {
                return false;
            }
        }
        return true;
    }

    public void removeGreater(int age) {
        Iterator<Dragon> iterator = dragonPriorityQueue.iterator(); //
        while (iterator.hasNext()) {
            if (iterator.next().getAge() > age) {
                iterator.remove(); //поэтапно перебирает элемпенты коллекции и безопасно удаляет их во время итерации
            }
        }
    }

    public void removeAllByAge(int age) {
        Iterator<Dragon> iterator = dragonPriorityQueue.iterator();
        while (iterator.hasNext()) {
            Dragon dragon = iterator.next();
            if (dragon.getAge() == age) {
                iterator.remove();
            }
        }
    }

    public boolean removeAnyByColor(Color color) {
        Iterator<Dragon> iterator = dragonPriorityQueue.iterator();
        while (iterator.hasNext()) {
            Dragon dragon = iterator.next();
            if (dragon.getColor() == color) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public int countByCharacter(DragonCharacter character) {
        int count = 0;
        for (Dragon dragon : dragonPriorityQueue) {
            if (dragon.getCharacter() == character) {
                count++;
            }
        }
        return count;
    }

    public PriorityQueue<Dragon> getAll() {
        return dragonPriorityQueue;
    }
}

