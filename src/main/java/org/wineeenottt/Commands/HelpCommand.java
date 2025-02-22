package org.wineeenottt.Commands;

import java.util.Map;

public class HelpCommand implements Command {
    /**
     * Коллекция, содержащая объекты всех доступных в программе команд
     */
    private final Map<String, Command> commandMap;

    /**
     * Конструктор класса
     */
    public HelpCommand(Map<String, Command> commandMap) {
        this.commandMap = commandMap;
    }

    /**
     * Метод, исполняющий команду. Выводит описание всех доступных в программе команд
     */
    @Override
    public void execute() {
        for (Map.Entry<String, Command> entry : commandMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        }
    }

    /**
     * Описание данной команды
     */
    @Override
    public String getDescription() {
        return "выводит справку по всем командам";
    }
}


