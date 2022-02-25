import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pyramid {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6};
        MyArrayList array = new MyArrayList(arr);
//        array.add(0);
//        array.add(1);
//        array.add(2);
//        array.add(3);
//        array.add(4);
        array.remov(2);
        System.out.println(array.toString());
    }
}
