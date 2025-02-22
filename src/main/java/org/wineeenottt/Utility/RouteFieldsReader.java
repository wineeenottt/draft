package org.wineeenottt.Utility;

import org.wineeenottt.Collection.CollectionManager;
import org.wineeenottt.Collection.Coordinates;
import org.wineeenottt.Collection.Location;
import org.wineeenottt.Collection.Route;
import org.wineeenottt.Exceptions.ValidValuesRangeException;
import org.wineeenottt.IO.UserIO;

import java.time.Instant;
import java.time.ZonedDateTime;

public class          RouteFieldsReader {

    private final UserIO userIO;
    CollectionManager collectionManager;

    /**
     * Конструктор класса
     */
    public RouteFieldsReader(UserIO userIO, CollectionManager collectionManager) {
        this.userIO = userIO;
    }

    public Route read(Integer id) {

        String i = Instant.now().toString();
        Location fromLocation = readLocation();
        Location toLocation = readLocation();
        return new Route(id, readName(), readCoordinates(), ZonedDateTime.parse(i).plusHours(3), fromLocation, toLocation, readDistance());
    }

    public String readName() {
        String str;
        while (true) {
            userIO.printCommandText("Name (not null): ");
            str = userIO.readLine().trim();
            if (str.isEmpty()) {
                userIO.printCommandError("\nЗначение поля не может быть null или пустой строкой\n");
            } else return str;
        }
    }

    public Coordinates readCoordinates() {
        return new Coordinates(readCoordinateX(), readCoordinateY());
    }

    public Double readCoordinateX() {
        double x;
        while (true) {
            try {
                userIO.printCommandText("CoordinateX (Double & x <= 750): ");
                String str = userIO.readLine().trim();
                if (str.isEmpty()) continue;
                else {
                    x = Double.parseDouble(str);
                    if (x > 750) throw new ValidValuesRangeException();
                    else return x;
                }
            } catch (ValidValuesRangeException ex) {
                System.out.println("Координата x имеет максимальное значение - 750");
            } catch (NumberFormatException ex) {
                System.err.println("Число должно быть типа Double");
            }
        }
    }

    public float readCoordinateY() {
        return readFloat("CoordinateY (Float): ");
    }

    public Location readLocation() {
        return new Location(readLocationCoordinateX(), readLocationCoordinateY(), readLocationCoordinateZ(), readLocationName());
    }

    public float readLocationCoordinateX() {
        return readFloat("Location coordinateX (Float): ");
    }

    public int readLocationCoordinateY() {
        return readInt("Location coordinateY (Int): ");
    }

    public double readLocationCoordinateZ() {
        return readDouble("Location coordinateZ (Double): ");
    }

    public String readLocationName() {
        String str;
        while (true) {
            userIO.printCommandText("LocationName (not null): ");
            str = userIO.readLine().trim();
            if (str.isEmpty()) {
                userIO.printCommandError("\nЗначение поля не может быть null или пустой строкой\n");
            } else return str;
        }
    }

    public long readDistance() {
        long distance;
        while (true) {
            try {
                userIO.printCommandText("Distance (Long > 1): ");
                String str = userIO.readLine().trim();
                if (str.isEmpty()) continue;
                else {
                    distance = Long.parseLong(str);
                    if (distance <= 1) throw new ValidValuesRangeException();
                    return distance;
                }
            } catch (ValidValuesRangeException ex) {
                System.out.println("Distance должно быть больше 1");
            } catch (NumberFormatException ex) {
                System.err.println("Число должно быть типа Long");
            }
        }
    }

    private float readFloat(String prompt) {
        float value;
        while (true) {
            try {
                userIO.printCommandText(prompt);
                String str = userIO.readLine().trim();
                if (str.isEmpty()) continue;
                value = Float.parseFloat(str);
                return value;
            } catch (NumberFormatException ex) {
                System.err.println("Ввод должен быть типа Float");
            }
        }
    }

    public int readInt(String prompt) {
        int value;
        while (true) {
            try {
                userIO.printCommandText(prompt);
                String str = userIO.readLine().trim();
                if (str.isEmpty()) continue;
                value = Integer.parseInt(str);
                return value;
            } catch (NumberFormatException ex) {
                System.err.println("Ввод должен быть типа Integer");
            }
        }
    }

    private double readDouble(String prompt) {
        double value;
        while (true) {
            try {
                userIO.printCommandText(prompt);
                String str = userIO.readLine().trim();
                if (str.isEmpty()) continue;
                value = Double.parseDouble(str);
                return value;
            } catch (NumberFormatException ex) {
                System.err.println("Ввод должен быть типа Double");
            }
        }
    }
}
