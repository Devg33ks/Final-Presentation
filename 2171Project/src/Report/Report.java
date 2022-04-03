package Report;

import Database.DatabaseManager;

import java.io.*;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;


public class Report{
    private String employeeFile;
    private String roomFile;


    public Report(){

    };




    //this returns an arry list of records in the database file
    //takes a sting of the form "firstName lastName Balance roomType roomNumber StartOfRentPeriod  EndOFRentPeriod"
    //called on in GUI to display list of records or intandem with with other methods in class



    //called in Employee to add emplyee record to database

    //used by Gui to find a record given a name
    //if not found it asks gui to create error window
    public static String searchEmployee(String id){
        String idOnRecord;
        for (String record : DatabaseManager.getEmployeeList()){
            // System.out.println(record);
            idOnRecord = record.split(" ")[0];
            if(id.equals(idOnRecord)){
                return(record);
            }
        }
        //gui call or return message is used in GUI
        return("Employee does not exists") ;
    }

    //Used to edit a single field of a single record
    //accepts, (as strings) :   1. old record to be changed
    //                          2. new info to be inserted
    //                          3. the type of info to be change "name" , "balnce" , "type" ,"num" , "startdate" ,"enddate"
 /*   public static void editEmployeeRecord(String oldrecord, String newinfo, String infoType){

        String newRecord;
        System.out.println(oldrecord);
        String oldname = oldrecord.split(" ")[0] + " " + oldrecord.split(" ")[1] ;
        System.out.println(oldname);
        String oldBalance = oldrecord.split(" ")[2];
        System.out.println(oldBalance);
        String oldRoomType = oldrecord.split(" ")[3];
        String oldRoomNum = oldrecord.split(" ")[4];
        String oldstartdate = oldrecord.split(" ")[5];
        String oldEndDate = oldrecord.split(" ")[6];
        ArrayList<String> employeelist;
        switch(infoType){
            case "name":
                newRecord = newinfo + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "balance":
                newRecord = oldname + " " + newinfo + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "type":
                newRecord = oldname + " " + oldBalance + " " + newinfo + " " + oldRoomNum + " " + oldstartdate + " " + oldEndDate;
                break;
            case "num":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + newinfo + " " + oldstartdate + " " + oldEndDate;
                break;
            case "startdate":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + newinfo + " " + oldEndDate ;
                break;
            case "enddate":
                newRecord = oldname + " " + oldBalance + " " + oldRoomType + " " + oldRoomNum + " " + oldstartdate + " " + newinfo ;
                break;
            default:
                newRecord ="error with edit";
        }

        employeelist = getEmployeeList();


        employeelist.remove(oldrecord);


        employeelist.add(newRecord);


        updateDatabase(employeelist);
        System.out.println(employeelist);

    }*/





}
