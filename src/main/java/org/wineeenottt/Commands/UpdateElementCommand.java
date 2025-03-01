package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.IO.UserIO;
import org.wineeenottt.Utility.RouteFieldsReader;

public class UpdateElementCommand implements CommandWithArguments {

    private final CollectionManager collectionManager;
    private final UserIO userIO;
    private final RouteFieldsReader routeFieldsReader;
    private String[] commandArguments;

    public UpdateElementCommand(CollectionManager collectionManager, UserIO userIO, RouteFieldsReader routeFieldsReader) {
        this.collectionManager = collectionManager;
        this.userIO = userIO;
        this.routeFieldsReader = routeFieldsReader;
    }

    @Override
    public void execute() {
        try {
            if (commandArguments == null || commandArguments.length < 1) {
                throw new IllegalArgumentException("Не указан ID элемента");
            }

            int id = Integer.parseInt(commandArguments[0]);

            if (!collectionManager.containsIdRoute(id)) {
                System.err.println("Элемента с данным ID не существует");
                return;
            }

            userIO.printCommandText(collectionManager.getFieldNames());
            userIO.printCommandText("Напишите stop, если хотите прервать изменение элемента коллекции\n");


            String fieldName = "";
            String fieldValue;

            do {
                try {
                    fieldName = routeFieldsReader.readUpdateFieldName();
                    if (fieldName.equalsIgnoreCase("stop")) break;

                    fieldValue = routeFieldsReader.readUpdateFieldValue();
                    collectionManager.update(id, fieldName, fieldValue);

                } catch (IndexOutOfBoundsException ex) {
                    System.err.println("Ошибка: Не указано поле/значение");
                } catch (Exception ex) {
                    System.err.println("Ошибка при чтении значения поля: " + ex.getMessage());
                }
            } while (!fieldName.equalsIgnoreCase("stop"));

        } catch (NumberFormatException ex) {
            System.err.println("Ошибка: ID должен быть целым числом");
        } catch (IllegalArgumentException ex) {
            System.err.println("Ошибка: " + ex.getMessage());
        }
    }

    @Override
    public void getCommandArguments(String[] commandArguments) {
        this.commandArguments = commandArguments;
    }

    @Override
    public String getDescription() {
        return "изменяет указанное поле выбранного по ID элемента коллекции";
    }
}
