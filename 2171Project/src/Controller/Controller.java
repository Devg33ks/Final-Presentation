package Controller;
import Database.*;
import EmployeeManagement.*;
import Report.Report;
import UI.*;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private String name;
    private String balance;
    private Double bal;
    private String id;
    private boolean check;

    public Controller(){
    }

    public void addEmployee(String name, String balance, String id, String roomType,boolean check,boolean check2){
        try{
            bal = Double.parseDouble(balance);
        }catch(NumberFormatException  e){
            ErrorHandling er = new ErrorHandling("Enter an amount as balance","Invalid Entry");
            er.setVisible(true);
            e.printStackTrace();
        }


        if (name.split(" ").length != 2){
            ErrorHandling er = new ErrorHandling("Enter an a valid name: 'firstnam lastname'","Invalid Entry");
            er.setVisible(true);
        }else{
            //}
            if (((check == true)) || (check2 == true)){
                //now creating emplyee and calculation length of stay
                //instead of creating an object we wouldve created GuI class obj and called on function
                Employee employee = new Employee(id,name,roomType,bal);
                employee.makePayment();
                /*try{
                    employee.setRoomNum(Room.TrackAvaliableRooms("Rooms.txt", roomType));
                }catch(IOException e){
                    e.printStackTrace();
                }*/

                if (employee.getRoomNum()!=null){
                    employee.save();}
                else{
                    ErrorHandling er = new ErrorHandling("Room of this type is not available","Invalid Entry");
                    er.setVisible(true);
                }

                //creating conformation screen , with record to be saved to file
                //instead of creating an object we wouldve created GuI class obj and called on function
                //AddEmployeeScreen.setVisible(false);
            }else{
                ErrorHandling er = new ErrorHandling("Please select an Room Type","Invalid Entry");
                er.setVisible(true);}
        }
    }

    public void editEmployee(String newname,String balance,String roomtype,String roomnum,String id,String employeeRecord,boolean keep){
        String oldbalance= employeeRecord.split(" ")[3];
        String lastpayment= employeeRecord.split(" ")[6];
        String duedate= employeeRecord.split(" ")[7];
        if (newname.split(" ").length == 2){
            DatabaseManager database = new DatabaseManager();
            database.deleteRecord(employeeRecord);
            try{

                //Double newBalance = Double.parseDouble(jTextField1.getText());
                if ((roomtype.equals("D")) || (roomtype.equals("K"))){
                    Employee employee =new Employee();
                    //employeeRecord.split(" ")[0],jTextField4.getText(), jTextField2.getText(),newBalance
                    employee.setId(id);
                    employee.setName(newname);
                    employee.setRoomType(roomtype);
                    System.out.println(employee.getBalance());
                    employee.setBalance(Double.parseDouble(balance));
                    employee.setStartDate(lastpayment);
                    employee.setEndDate(duedate);
                    if (!balance.equals(oldbalance)){
                        employee.makePayment();
                    }
                    if (keep == true){
                        employee.setRoomNum(roomnum);
                    }else{
                        try{
                            employee.setRoomNum(Room.AssignRooms("Rooms.txt",roomtype));
                        }catch(IOException e){
                            e.printStackTrace();
                        }
                    }
                    employee.save();

                }else{
                    ErrorHandling er = new ErrorHandling("Room type Invalid. Enter either 'D' or'K'","Invalid Entry");
                    er.setVisible(true);
                }
            }catch(NumberFormatException  e){
                ErrorHandling er = new ErrorHandling("Enter an amount as balance","Invalid Entry");
                er.setVisible(true);
                e.printStackTrace();
            }
            //this.setVisible(false);
        }else{
            ErrorHandling er = new ErrorHandling("Enter an a valid name: 'firstnam lastname'","Invalid Entry");
            er.setVisible(true);
        }

    }
    public void deleteEmployee(String employeeRecord){
        DatabaseManager database = new DatabaseManager();
        database.deleteRecord(employeeRecord);
    }

    public void overrideRoom(){

    }
    public ArrayList<String> mainDisplay(){
        DatabaseManager database = new DatabaseManager();
        return database.getEmployeeList();

    }
    public String searchEmployee(String id){

        Report report = new Report();
        return report.searchEmployee(id);
    }
    public ArrayList<String>  roomDisplay(){
        DatabaseManager database = new DatabaseManager();
        return database.getRoomListing();

    }
}


