import java.util.ArrayList;

public class BalanceParentheses {
    public static void main(String[] args) {
//        System.out.println("String:   ((())),  "+balance("((()))"));
//        System.out.println("String:   (Hello (Hi) world,  "+balance("(Hello (Hi) world"));
//        System.out.println("String:   (I (like to (code) in Java))" + balance(" (I (like to (code) in Java))"));
        String str = "(Hello (Hi) world";
        System.out.println("String:     " + str + ",  "+ recursBalance(str));
    }
    public static boolean balance(String str)
    {
        int openct = 0, closedct = 0;
        for(int i = 0; i<str.length(); i++)
        {
            if(str.charAt(i)=='(')
            {
                openct++;
                //System.out.println("open foundat: " + i);
            }
            else if (str.charAt(i)==')')
            {
                closedct++;
                //System.out.println("closed found at: " + i);
            }
        }
        return openct==closedct;
    }
    public static boolean recursBalance(String str) {
        if(str.contains("(") && str.contains(")"))
        {
            //System.out.println("Recurse: " + str.substring(str.indexOf('(') + 1, str.lastIndexOf(')')));
            return recursBalance(str.substring(str.indexOf('(') + 1, str.lastIndexOf(')')));
        }
        //System.out.println("String: " + str + ", empty: " + str.isEmpty());
        return str.isEmpty() || !(str.contains("(") || str.contains(")"));
    }
}
