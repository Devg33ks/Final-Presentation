package Database;

import java.io.*;
import java.util.ArrayList;

public class DatabaseManager {
    private String roomFile="Rooms.txt";
    private String employeeFile= "Databasefile.txt";

    public DatabaseManager(){
    }

    public  static ArrayList<String> getEmployeeList(){
        String readerline ;
        ArrayList<String> employeelist= new ArrayList<String>();

        try{
            FileReader fr = new FileReader("Databasefile.txt");
            BufferedReader br = new BufferedReader(fr);

            while( (readerline=br.readLine()) != null ){

                if(readerline != null){
                    employeelist.add(readerline);
                }
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return(employeelist);
    }
    public static void addToDatabase(String employeerecord){
        try{
            ArrayList<String> emplist = new ArrayList<String>();
            emplist =getEmployeeList();
            System.out.println(emplist);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Databasefile.txt"));
            for (String record :emplist){
                // System.out.println(record);
                bw.write(record + "\n");
            }
            bw.write(employeerecord);
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    //Used only in report class to assist in file editting
    public static void updateDatabase(ArrayList<String> employeelist){
        try{
            ArrayList<String> emplist = new ArrayList<String>();
            System.out.println(emplist);
            BufferedWriter bw = new BufferedWriter(new FileWriter("Databasefile.txt"));
            for (String record :employeelist){
                // System.out.println(record);
                bw.write(record + "\n");
            }
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //Deletes a record and rewrites file
    public static void deleteRecord(String record){
        ArrayList<String> employeeList = new ArrayList<String>();
        employeeList = getEmployeeList();
        employeeList.remove(record);
        updateDatabase(employeeList);
    }
    public static ArrayList<String> getRoomListing(){
        String readerline ;
        ArrayList<String> roomlist= new ArrayList<String>();

        try{
            FileReader fr = new FileReader("Rooms.txt");
            BufferedReader br = new BufferedReader(fr);

            while( (readerline=br.readLine()) != null ){

                if(readerline != null){
                    roomlist.add(readerline);
                }
            }
            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        return(roomlist);
    }



}
