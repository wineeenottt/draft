package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

/**
 * Команда, сохраняющая коллекцию
 */
public class SaveCommand implements Command{
    /**
     * Поле, хранящее адрес файла, куда следует сохранить коллекцию
     */
    private String inputFile;
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager
     */
    private CollectionManager collectionManager;
    /**
     * Конструктор класса
     */
    public SaveCommand(CollectionManager collectionManager, String inputFile){
        this.collectionManager=collectionManager;
        this.inputFile=inputFile;
    }
    /**
     * Метод, сохраняющий коллекцию в указанном файле в формате. В случае некорректной работы высветится ошибка
     */

    @Override
    public void execute() {
        collectionManager.save(inputFile);
        System.out.println("Коллекция была сохранена");
    }
    /**
     * Метод, возвращающий описание команды
     */
    @Override
    public String getDescription() {
        return "сохраняет коллекцию в указанный файл";
    }
}

