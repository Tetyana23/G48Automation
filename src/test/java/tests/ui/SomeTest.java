package tests.ui;

import io.qameta.allure.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static helpers.ExcelHelper.*;
import static helpers.FileHelper.readFile;
import static helpers.FileHelper.writeFileAndGet;
import static org.junit.Assert.assertTrue;


@Feature("Working with files")
@Owner("Tetyana23")
@Severity(SeverityLevel.CRITICAL)
public class SomeTest {

    @Description("Тест нужен, чтобы проверить запись чтения в файл")
    @Test
    public void some() {
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

    @Description("Тест нужен, чтобы переписать данные из одного файла в Excel файл")
    @Test
    public void someExcel() {
        readDataFromExcelFile(
                writeToExcelFileAndGet(
                "/Users/tatianakurylenko/IdeaProjects/G48AutomationTanya2/target/outputFiles/outputExcel.xls",
                readDataFromExcelFile(
                        "/Users/tatianakurylenko/IdeaProjects/G48AutomationTanya2/src/test/resources/testData/Book1.xls",
                        "Sheet1", false)).getPath(),
                "Automated Sheet", true)
                .forEach(System.out::println);
    }

    @Description("Тест нужен, чтобы вычитать данные из файла и записать в консоль")
    @Test
    public void checkExcelProvider() {
        readDataProviderFromExcel("/Users/tatianakurylenko/IdeaProjects/G48AutomationTanya2/src/test/resources/testData/Book1.xls",
                "Sheet1").forEach(
                objectArray -> System.out.println(Arrays.asList(objectArray)));
    }

}
