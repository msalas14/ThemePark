import java.util.ArrayList;

public class Digits {

    public static void main(String[] args) {
        int number = 123456;
         ArrayList<Integer> sequence = new ArrayList<>();
        while(number>10)
        {
            sequence.add(0, number%10);
            number /= 10;

        }
        sequence.add(0,number);
        System.out.println(sequence);
    }
}
