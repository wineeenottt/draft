package org.wineeenottt.Commands;

/**
 * Uнтерфейс, реализуемый командами с аргументами, записываемыми с новой строки
 */
public interface CommandWithArguments extends Command {
    /**
     * Метод, получающий аргументы команды
     */
    void getCommandArguments(String[] commandArguments);
}

