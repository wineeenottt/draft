package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

/**
 * Команда, удаляющая элемент по ключу
 */
public class RemoveByIdCommand implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды
     */
    private String[] commandArguments;

    /**
     * Конструктор класса
     */

    public RemoveByIdCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команд
     */
    @Override
    public void execute() {
        try {
            int id = Integer.parseInt(commandArguments[0]);
            if (id == 0) {
                System.err.println("Идентификатор не может быть равен нулю.");
                return;
            }
            if (collectionManager.containsIdRoute(id)) {
                collectionManager.removeById(id);
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
        return "удаляет элемент с указанным id ";
    }

    /**
     * Аргуметы команды
     */
    @Override
    public void getCommandArguments(String[] commandArguments) {
        this.commandArguments = commandArguments;
    }
}





