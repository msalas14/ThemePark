import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Something {
    public static void main(String[] args) {
        //System.out.println(problem2());
//        try
//        {
//            addPatient("anneli Salas ", "03/17/2004","patients.txt");
//            //addPatient("anothr Salas ", "03/17/2004","patients.txt");
//            //addPatient("oly Salas ", "03/17/2004","patients.txt");
//
//        }
//        catch (IOException e) {
//            e.getStackTrace();
//        }
        try {
            deletePatient("anneli", "patients.txt");
            deletePatient("danna", "patients.txt");
        }
        catch (IOException e)
        {

        }

    }
    public static String isBirthVaild (int day, int month, int year) {
        if (day <= 31 && day > 0 && month > 0 && month <= 12 && year > 0)
        {
            String tempDay = Integer.toString(day), tempMonth = Integer.toString(month);
            if(day<10)
            {
                tempDay = "0"+ day;
            }
            if(month<10)
            {
                tempMonth = "0" + month;
            }
            return tempMonth + "/" + tempDay + "/" + year;
        }
        else
        {
            return "Given day is not valid";
        }
//"Is not valid";
//check if the given birth is valid.
    }
    public static void addPatient (String name, String Birth, String fileName) throws IOException {
        Birth = isBirthVaild(Integer.parseInt(Birth.substring(3,5)), Integer.parseInt(Birth.substring(0, 2)), Integer.parseInt(Birth.substring(6)));
        if(Birth.length()==10){
            FileWriter fw = null;
        try
            {
                fw = new FileWriter(fileName, true);
                fw.append("\r\n"+ name + " "+ Birth + " sick");
                fw.flush();
                System.out.println("written");
                fw.close();
            }
            catch (Exception e)
            {
                e.getStackTrace();
            }
            finally {
                try {fw.close();} catch (Exception ex) {/*ignore*/}
            }

        }

    }
    public static void deletePatient (String name, String fileName) throws IOException {
        File patFile = new File(fileName);
        File temp = new File("temp.txt");
        temp.createNewFile();
        BufferedReader br = new BufferedReader(new FileReader(patFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
        String curr = br.readLine();
        int count = 0;
        while(curr  != null) {

            String trimmedLine = curr.trim();

            if((!trimmedLine.contains(name)&&!trimmedLine.contains("sick"))) {
                bw.write(curr + System.getProperty("line.separator"));

            }
            curr = br.readLine();
        }
        bw.close();
        br.close();
        if (patFile.delete()) {
            System.out.println("og deleted");
        }
        if (temp.renameTo(patFile)) {
            System.out.println("renamed");
        }




    } // Delete an existing patient record from the file
//// can't delete if the patient still sick. // if there are two patients occur with the same name, and they are both not sick, only delete the first one. Otherwise, delete the first patient who is not sick.
//
//    public static int countPatients (String status, String fileName) throws FileNotFoundException { // return numbers of sick patients or recovery patients in the file. // if client given" (empty string), then return the total number of patients.
//    }
//    public static void averageAge(String fileName) throws FileNotFoundException { // find the average age for all patients in the file. 5.
//    }
//    public static void sortPatientsByAge(String fileName) throws FileNotFoundException {
//// modify file by sorting patients by age for all patients from young to old
//    }
//    public static void sortPatientsByName(String firstorLast, String fileName) throws FileNotFoundException {
//
//// modify file by sorting patients by first name or last name for all patients from a-z
//    }
//    public static void shufflePatients (String fileName) throws FileNotFoundException
//    {
//
//    }// modify file by shuffle all patients, so they are not in any order
//// Using random in this method is req
//    static ArrayList<Integer> problem2()
//    {
//        ArrayList<Integer> myArrayList = null;
//        for(int i = 0; i<10; i++)
//        {
//            try{
//                myArrayList.add(i);
//                myArrayList.set(i, i/ myArrayList.get(i-1));
//            }
//            catch(NullPointerException ne)
//            {
//                System.out.println("Exception encountered: " + ne.getMessage());
//                myArrayList = new ArrayList<>();
//                myArrayList.add(i);
//            }
//            catch(ArithmeticException ae)
//            {
//                System.out.println("Exception encountered: " + ae.getMessage() + " at index " + i);
//
//            }
//        }
//        return myArrayList;
//    }
}
