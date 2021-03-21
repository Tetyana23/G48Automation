package hm2;

public class User {
    String mood = "normal";
    String winCombination = "231-245-554";

    void sayMood() {
        System.out.println(mood);
    }

    void play(String combination) {
        switch (mood) {
            case "normal":
                if (combination.equals(winCombination))
                    mood = "happy";
                else mood = "bad";
                break;
            case "happy":
                if (combination.equals(winCombination))
                    mood = "happy";
                else mood = "normal";
                break;
            case "bad":
                if (combination.equals(winCombination))
                    mood = "normal";
                else mood = "bad";
                break;
        }


    }

    public static void main(String[] args) {
        User user = new User();
       user.sayMood();
        user.play("123-432-345");
user.sayMood();
        user.play("231-245-554");
        user.sayMood();
        user.play("231-245-554");
        user.sayMood();
    }
}


