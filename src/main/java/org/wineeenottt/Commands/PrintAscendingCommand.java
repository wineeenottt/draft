package org.wineeenottt.Commands;

import org.wineeenottt.Collection.CollectionManager;

public class PrintAscendingCommand implements Command{
        /**
         * Поле, хранящее ссылку на объект класса CollectionManager
         */
        private CollectionManager collectionManager;

        /**
         * Хранит ссылку на созданный в объекте Application объект CollectionManager
         */
    public PrintAscendingCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

        /**
         * Метод, исполняющий команду
         */
        @Override
        public void execute() {
        collectionManager.showIdSortedCollection();
    }

        /**
         * Метод, возвращающий описание команды
         */
        @Override
        public String getDescription() {
        return " выводит элементы коллекции в порядке возрастания";
    }

}
