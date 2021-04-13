package tests;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static helpers.fileHelper.readFile;
import static helpers.fileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;

public class SomeTest {

   @Test
    public void some(){
      // readFile("/Users/tatianakurylenko/IdeaProjects/G48AutomationTanya2/src/test/resources/test").forEach(System.out::println);

      List<String> data = new ArrayList<>();
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");
      data.add("Я буду хорошим автоматизатором на Selenium");


    readFile(writeFileAndGet(data, "our_test.txt")).forEach(System.out::println);

   }






}
