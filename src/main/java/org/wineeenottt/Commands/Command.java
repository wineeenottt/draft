package org.wineeenottt.Commands;
/**
 * Uнтерфейс, реализация которого приведена в командах
 */
public interface Command {

    /**
     * Метод, исполняющий команду
     */
    void execute();

    /**
     * Метод, возвращающий описание команды
     */
    default String getDescription() {
        return "Описание команды";
    }
}
