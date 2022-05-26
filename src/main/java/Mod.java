import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Mod {

    public static File inventoryFile = new File("src/main/inventory.txt");
    public static void main(String[] args) {
//        String multiple = "catcatcat";
//        String single = "cat";
//        System.out.println(mult(single, multiple));
//        multiple = "catdatcat";
//        System.out.println(mult(single, multiple));
//        multiple = "catcatCat";
//        System.out.println(mult(single, multiple));
        try
        {
            System.out.println(getinventory());
        }
        catch(IOException e)
        {
            System.out.println("bark");
        }
        List<item> list = new ArrayList<>();
        list.add(new item("new name", 2.2,6,1));
        writeInventoryToFile(list);
    }
    public static boolean mult(String single, String multiple)
    {
        int times = multiple.length()/single.length(); //find amnt of times the single fits in the multiple
        return multiple.equals(single.repeat(times)); //compare the multiple to the multiplied single

    }
    public static List<item> getinventory() throws IOException
    {
        List<item> temp = new ArrayList<>();
        String[] curr_line;
        try
        {
            Scanner sc = new Scanner(inventoryFile);
            while(sc.hasNextLine())
            {
                curr_line = sc.nextLine().split(",");
                curr_line[0] = curr_line[0].replace('\'',' ');
                curr_line[0] = curr_line[0].trim();
                temp.add(new item(curr_line[0],Double.parseDouble(curr_line[1]),Integer.parseInt(curr_line[2]), Integer.parseInt(curr_line[3])));
            }
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return temp;
    }

    public static void writeInventoryToFile(List<item> items)
    {
        FileWriter fw = null;
        for (item item : items) {
            try {
                fw = new FileWriter(inventoryFile, true);
                fw.append("\r\n"+item.toString());
                fw.flush();
                System.out.println("written");
                fw.close();
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                try {
                    fw.close();
                } catch (Exception ex) {/*ignore*/}
            }

        }
    }


}
