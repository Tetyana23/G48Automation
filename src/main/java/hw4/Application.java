package hw4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Application {
    private final static Logger LOG = LogManager.getLogger("Main");
    public static void main(String[] args) {
        Homework3 homework3 = new Homework3();
        Homework3_1 homework3_1 = new Homework3_1();
        LOG.info("полный массив:  ");
        for (int i = 0; i < homework3.stringArray.length; i++)
            LOG.info(homework3.stringArray[i]);
        LOG.info("--------------------");
        LOG.info("обрезанный массив:  ");
        homework3_1.print(homework3.copyElements(1));

        LOG.info("--------------------");
       Parent parent = new Parent("Katya");
       parent.print();
       homework3.printList(null);
        List<String> list = Arrays.asList(homework3.stringArray);
       homework3_1.printList(list);
       homework3_1.printList(new ArrayList<String>());

    }
}
