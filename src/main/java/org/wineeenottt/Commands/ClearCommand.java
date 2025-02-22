package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

/**
 * Команда, очищающая коллекцию
 */
public class ClearCommand implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;

    /**
     * Конструктор класса. Хранит ссылку на созданный в объекте Application объект CollectionManager
     */
    public ClearCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команду. Выводит сообщение, когда коллекция очищена
     */
    @Override
    public void execute() {
        collectionManager.clearAllCollection();
        System.out.println("Коллекция была очищена");
    }

    /**
     * Описание команды
     */
    @Override
    public String getDescription() {
        return " очищает все элементы коллекции";
    }
}



