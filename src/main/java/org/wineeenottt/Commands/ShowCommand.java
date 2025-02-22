package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

/**
 * Команда, показывыющая содержимое всех элементов коллекции
 */
public class ShowCommand implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;

    /**
     * Конструктор класса
     */
    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команду. Показывает подробное содержание содержимого коллекции
     */
    @Override
    public void execute() {
        collectionManager.showElementsCollection();
    }

    /**
     * Метод, возвращающий описание команды
     */
    @Override
    public String getDescription() {
        return " показывает подробное содержимое всех элементов коллекции";
    }
}


