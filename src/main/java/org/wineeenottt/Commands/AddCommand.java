package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.Utility.RouteFieldsReader;

public class AddCommand implements Command{
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;
    /**
     * Поле, хранящее ссылку на объект, осуществляющий чтение полей из указанного в userIO потока ввода
     */
    private RouteFieldsReader routeFieldsReader;

    /**
     * Конструктор класса
     */
    public AddCommand(CollectionManager collectionManager, RouteFieldsReader routeFieldsReader) {
        this.collectionManager = collectionManager;
        this.routeFieldsReader = routeFieldsReader;
    }

    /**
     * Метод, исполняющий команду
     */
    @Override
    public void execute() {
        collectionManager.addRoute(
                routeFieldsReader.readName(),
                routeFieldsReader.readCoordinates(),
                java.time.ZonedDateTime.now(),
                routeFieldsReader.readLocation(),
                routeFieldsReader.readLocation(),
                routeFieldsReader.readDistance()
        );
        System.out.println("Маршрут успешно добавлен");
    }

    /**
     * Описание команды
     */
    @Override
    public String getDescription() {
        return "добавляет элемент в коллекцию";
    }
}

