package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.Utility.RouteFieldsReader;

/**
 * Команда, удаляющая элементы коллекции, превыщающие заданный id
 */
public class RemoveGreaterCommand implements CommandWithArguments {
    private final CollectionManager collectionManager;
    private final RouteFieldsReader routeFieldsReader;
    String[] commandArguments;

    public RemoveGreaterCommand(CollectionManager collectionManager, RouteFieldsReader routeFieldsReader) {
        this.collectionManager = collectionManager;
        this.routeFieldsReader = routeFieldsReader;
    }

    /**
     * Метод, исполняющий команду
     */
//    @Override
//    public void execute() {
//        Integer id = routeFieldsReader.readId();
//        collectionManager.removeGreater(id);
//        System.out.println("Соответствующие элементы коллекции были удалены");
//    }
    @Override
    public void execute() {
        try {
            int id = Integer.parseInt(commandArguments[0]);
            if (id == 0) {
                System.err.println("Идентификатор не может быть равен нулю.");
                return;
            }
            if (collectionManager.containsIdRoute(id)) {
                collectionManager.removeGreater(id);
                System.out.println("Элемент коллекции был удален.");
            } else {
                System.out.println("Данного элемента коллекции не существует.");
            }
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Не указаны аргументы команды.");
        } catch (NumberFormatException ex) {
            System.err.println("Формат аргумента не соответствует целочисленному: " + ex.getMessage());
        }
    }

    /**
     * Метод - возвращает описание команды
     */
    @Override
    public String getDescription() {
        return " удаляет из коллекции все элементы, ключ которых превышает заданный";
    }

    @Override
    public void getCommandArguments(String[] commandArguments) {

    }
}


