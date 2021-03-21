package hm3;

import java.util.ArrayList;
import java.util.List;

public class Homework3 {


    public String[] stringArray = new String[]{"white", "blue", "black", "yellow", "pink"};

    /**
     * метод возвращает все елементы из массива до индекса включительно.
     * @param number это индекс елемента массива
     * @return список елементов из массива в ввиде ArrayList
     */

    public List<String> copyElements(int number) {
        List<String> resultList = new ArrayList<>();
        int i = 0;
        while (i <= number) {
            resultList.add(stringArray[i]);
            i++;
        }
        return resultList;
    }



}

