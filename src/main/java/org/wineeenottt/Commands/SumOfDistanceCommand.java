package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

public class SumOfDistanceCommand implements Command{
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса. Хранит ссылку на созданный в объекте Application объект CollectionManager
     */
    public SumOfDistanceCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команду sumOfDistance
     */
    @Override
    public void execute() {
        Long sum = collectionManager.sumOfDistance();
        System.out.println("Сумма всех расстояний: " + sum);
    }

    /**
     * Описание команды
     */
    @Override
    public String getDescription() {
        return " выводит сумму значений поля distance для всех элементов коллекции";
    }
}


