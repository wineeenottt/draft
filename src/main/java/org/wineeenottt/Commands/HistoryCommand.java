package org.wineeenottt.Commands;

import java.util.ArrayList;

/**
 * Команда, выводящая список исполненных команд (последних 11)
 */
public class HistoryCommand implements Command {
    /**
     * Cписок, хранящий исполненные команды
     */
    ArrayList<String> commandsHistoryList = new ArrayList<>();

    /**
     * Хранит список исполненных команд
     */
    public HistoryCommand(ArrayList<String> commandsHistoryList) {
        this.commandsHistoryList = commandsHistoryList;
    }

    /**
     * Метод, исполняющий команду.
     * При вызове изменяется указанной элемент коллекции до тех пор, пока в качестве аргумента не будет передан stop. В случае некорректного ввода высветится ошибка
     */
    @Override
    public void execute() {
        System.out.println("History: ");
        for (String str : commandsHistoryList)
            System.out.println(str);
    }

    /**
     * Метод, возвращающий описание команды
     */
    @Override
    public String getDescription() {
        return "вывести последние 11 команд (без их аргументов)";
    }
}

