package hm3;

import java.util.Collections;
import java.util.List;

public class Homework3_1 {
    /** метод, который выводит в консоль все отсортированные елементы списка.
     * @param list список строк, который нужно вывести
     */
    public void print(List<String> list) {
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

}
