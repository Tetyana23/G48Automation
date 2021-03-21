import models.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static models.Car.count;

public class Application {

    private final static Logger LOG = LogManager.getLogger("Тест");
    private static String count;

    public static void main(String[] args) {
        LOG.info("=========Start========");

        String[] colors = new String[]{
                "red",
                "blue",
                "green",
                "yellow"};

        List<Car> cars = new ArrayList<>();

        for (String color : colors) {
            LOG.debug(format("Пуредаем цвет %s в конструктор Car", color));
            switch (color) {
                case "red":
                    cars.add(new Car("Ferrari", color));
                    break;
                case "blue":
                    cars.add(new Car("Nissan", color));
                    break;
                case "yellow":
                    cars.add(new Car("Grandmother car", color));
                    break;
                default:
                    cars.add(new Car("polo", color));
                    break;
            }
            new Car("Test", "violet");


        }
        LOG.info("Текущее количество машин: " + count);
        try {
            throw new IllegalArgumentException("" +
                    "Неправильно введено значение какой " + "то переменной");
        } catch (IllegalArgumentException i) {
            LOG.error(i);
        }
        LOG.info(cars);


        LOG.info("=========Finish========");
    }

}
