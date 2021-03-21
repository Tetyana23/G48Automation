package hm3;

public class Application {
    public static void main(String[] args) {
        Homework3 homework3 = new Homework3();
        Homework3_1 homework3_1 = new Homework3_1();
        System.out.println("полный массив:  ");
        for (int i = 0; i < homework3.stringArray.length; i++)
            System.out.println(homework3.stringArray[i]);
        System.out.println("--------------------");
        System.out.println("обрезанный массив:  ");
        homework3_1.print(homework3.copyElements(1));
    }
}
