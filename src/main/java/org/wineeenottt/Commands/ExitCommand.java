package org.wineeenottt.Commands;

public class ExitCommand implements Command{
    /**
     * Конструктор класса
     */
    public ExitCommand() {
    }

    /**
     * Метод, завершающий работу программы. При завершении выводит соответствующее сообщение
     */
    @Override
    public void execute() {
        System.out.println("Завершение работы программы");
        System.exit(0);
    }

    /**
     * Метод, возвращающий строку описания программы
     */
    @Override
    public String getDescription() {
        return " завершает работу программы";
    }
}

