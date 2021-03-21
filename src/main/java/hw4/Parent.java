package hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Parent {
    private final Logger LOG;

    protected String name;

    public Parent(String name) {
        LOG = LogManager.getLogger(name);
        this.name = name;
    }

    /**
     * метод который выводит текст с именем
     */
    public void print() {
        LOG.info(name + ": Выведен текст");
    }

    /**
     * метод который выводит елементы массива по буквам, в случае исключений выводит текст
     * @param list список строк, который нужно вывести
     */
    public void printList(List<String> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                LOG.debug("printList номер итерации " + i);
                String[] letters = list.get(i).split("");
                for (int a = 0; a < letters.length; a++) {
                    LOG.debug("перебор буков номер итерации " + a);
                    LOG.info(letters[a]);
                }
            }
        } catch (NullPointerException exception){
            LOG.error("Массив не определён. Пожалуйста проверьте корректность вводимых значений");
        } catch (Exception exception){
            LOG.error("Произошла неизвестная ошибка. Подробнее: " + exception.getMessage());
        }
    }
}
