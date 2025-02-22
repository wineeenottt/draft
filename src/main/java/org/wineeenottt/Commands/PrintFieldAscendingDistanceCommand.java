package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;


public class PrintFieldAscendingDistanceCommand implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;

    /**
     * Конструктор класса
     */
    public PrintFieldAscendingDistanceCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команду
     */
    @Override
    public void execute() {
        collectionManager.showRouteSortedDistance();
    }

    /**
     * Метод, возвращающий описание команды
     */
    @Override
    public String getDescription() {
        return " выводит значения поля distance всех элементов в порядке возрастания";
    }
}


