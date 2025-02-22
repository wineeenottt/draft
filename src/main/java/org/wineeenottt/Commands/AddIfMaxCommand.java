package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.Collection.Route;
import org.wineeenottt.Utility.RouteFieldsReader;
import org.wineeenottt.IO.UserIO;

import java.time.ZonedDateTime;

public class AddIfMaxCommand implements Command {
    private final CollectionManager collectionManager;
    private final RouteFieldsReader routeFieldsReader;
    private final UserIO userIO;

    public AddIfMaxCommand(CollectionManager collectionManager, RouteFieldsReader routeFieldsReader, UserIO userIO) {
        this.collectionManager = collectionManager;
        this.routeFieldsReader = routeFieldsReader;
        this.userIO = userIO;
    }

    @Override
    public void execute() {
        userIO.printCommandText("ID (Integer > 0): ");
        int id = routeFieldsReader.readInt("");

        if (collectionManager.containsIdRoute(id)) {
            userIO.printCommandError("Маршрут с таким ID уже существует");
            return;
        }

        if (id <= collectionManager.getMaxId()) {
            userIO.printCommandError("ID должен быть больше максимального существующего ID");
            return;
        }

        Route newRoute = new Route(
                id,
                routeFieldsReader.readName(),
                routeFieldsReader.readCoordinates(),
                ZonedDateTime.now(),
                routeFieldsReader.readLocation(),
                routeFieldsReader.readLocation(),
                routeFieldsReader.readDistance()
        );

        collectionManager.addIfMaxIdRoute(id, newRoute.getName(), newRoute.getCoordinates(), newRoute.getCreationDate(), newRoute.getFrom(), newRoute.getTo(), newRoute.getDistance());
        System.out.println("Маршрут успешно добавлен!\n");
    }
}
