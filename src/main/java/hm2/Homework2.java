package hm2;

public class Homework2 {
    int result;
    void minus (int first, int second){
        result = first - second;
    }

    public static void main(String[] args) {
       Homework2 homework2 = new Homework2();
       homework2.minus(10, 4);
        System.out.println(homework2.result);
        System.out.println("Произвольный текст");
        System.out.println(homework2.result > 0);
    }
}

