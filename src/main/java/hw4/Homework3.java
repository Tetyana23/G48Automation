package hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Homework3 extends Parent {
    private final Logger LOG;


    public String name = "Default";
    public int number = 10;

    public Homework3() {
        super("Default");
        LOG = LogManager.getLogger("Default");
        LOG.info("Новый пустой экземпляр класса " + Homework3.class.getSimpleName());
    }

    public Homework3(String name, int number) {
        super(name);
        LOG = LogManager.getLogger(name);
        this.name = name;
        this.number = number;

    }

    public String[] stringArray = new String[]{"white", "blue", "black", "yellow", "pink"};

    /**
     * метод возвращает все елементы из массива до индекса включительно.
     *
     * @param number это индекс елемента массива
     * @return список елементов из массива в ввиде ArrayList
     */


    public List<String> copyElements(int number) {
        List<String> resultList = new ArrayList<>();
        int i = 0;
        while (i <= number) {
            LOG.debug("copyElements итерация номер " + i);
            resultList.add(stringArray[i]);
            i++;
        }
        return resultList;
    }


}

