package org.wineeenottt.Run;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.Collection.Route;
import org.wineeenottt.Commands.CommandInvoker;
import org.wineeenottt.IO.UserIO;
import org.wineeenottt.Utility.RouteFieldsReader;
import org.wineeenottt.WorkWithFile.FileManager;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Set;

public class Application {
    /**
     * Менеджер коллекций
     */
    private CollectionManager collectionManager;
    /**
     * Менеджер файлов
     */
    //private FileManager fileManager;
    /**
     * CSV парсер
     */
    private FileManager csvParser;
    /**
     * Объект для ввода/вывода команд
     */
    private UserIO userIO;
    /**
     * Объект для исполнения команд
     */
    private CommandInvoker commandInvoker;
    /**
     * Объект для чтения полей класса Route
     */
    private RouteFieldsReader routeFieldsReader;

    /**
     * Метод, выполняющий запуск программы. Через него происходит работа всей программы.
     */
    public void start(String inputFile) {
        csvParser = new FileManager();
        userIO = new UserIO();

        Set<Route> routes;
        try {
            File ioFile = new File(inputFile);
            if (!ioFile.exists() || ioFile.isDirectory() || !ioFile.canRead()) {
                throw new IOException("Error with file");
            }

            // Чтение маршрутов из CSV
            routes = csvParser.parseCsvFile(inputFile);

            // Создаём CollectionManager после загрузки маршрутов
            collectionManager = new CollectionManager(routes);

            userIO.printCommandText("Элементы коллекции из указанного файла были загружены\n");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Теперь создаём RouteFieldsReader и CommandInvoker, передавая уже созданный collectionManager
        routeFieldsReader = new RouteFieldsReader(userIO, collectionManager);
        commandInvoker = new CommandInvoker(collectionManager, userIO, inputFile, routeFieldsReader);

        try {
            cycle();
        } catch (NoSuchElementException ex) {
            System.err.println("Ошибка ввода: " + ex.getMessage());
        }
    }

    /**
     * Метод, выполняющий циклическое чтение команд из строки ввода
     */
    public void cycle() {
        userIO.printCommandText("Программа была запущена.\n");
        while (true) {
            userIO.printCommandText("\nВведите название команды:\n");
            userIO.printPreamble();
            String line = userIO.readLine();
            commandInvoker.execute(line);
        }
    }
}
