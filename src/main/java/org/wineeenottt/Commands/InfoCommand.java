package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

/**
 * Команда, выводящая информацию о коллекции.
 */
public class InfoCommand implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager.
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса.
     *
     * @param collectionManager объект класса CollectionManager, используемый для получения информации о коллекции.
     */
    public InfoCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    /**
     * Метод, исполняющий команду. Выводит описание коллекции HashSet экземпляров Route.
     */
    @Override
    public void execute() {
        collectionManager.infoAboutCollection();
    }

    /**
     * Возвращает описание команды.
     *
     * @return строку с описанием команды.
     */
    @Override
    public String getDescription() {
        return " получает информацию о коллекции(тип, дата инициализации, кол-во элементов, тип элементов коллекции)";
    }
}