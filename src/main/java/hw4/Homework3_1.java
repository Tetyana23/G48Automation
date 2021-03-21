package hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.List;

public class Homework3_1 extends Parent {
    private final Logger LOG;

    public String name = "Test";
    public int number = 5;

    public Homework3_1() {
        super("Test");
        LOG = LogManager.getLogger("Test");
        LOG.info("Новый пустой экземпляр класса " + Homework3_1.class.getSimpleName());
    }

    public Homework3_1(String name, int number) {
        super(name);
        LOG = LogManager.getLogger(name);
        this.name = name;
        this.number = number;
    }

    /**
     * метод, который выводит в консоль все отсортированные елементы списка.
     *
     * @param list список строк, который нужно вывести
     */
    public void print(List<String> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            LOG.debug("print номер итерации " + i);
            LOG.info(list.get(i));

        }

    }

}
