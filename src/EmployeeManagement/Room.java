package EmployeeManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Room{
    private String roomNumber;
    private String roomType;

    public Room(){}

    public Room(String roomType){
        this.roomType = roomType;
        try{
            this.roomNumber = AssignRooms("Rooms.txt",this.roomType);
        } catch (IOException ex){
            System.out.println("File not found");
        }

    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public void setRoomNumber(int roomNumumber){
        this.roomNumber = roomNumber;
    }

    public String getRoomType(){
        return roomType;
    }

    public void setRoomType(){
        this.roomType = roomType;
    }




    public static String AssignRooms(String rfile,String roomType) throws IOException{

        File f1=new File(rfile);
        FileReader fr = new FileReader(f1);
        BufferedReader br = new BufferedReader(fr);
        FileWriter writer = null;
        String s;
        String id = "";
        String oldLine = "";
        int count=0;   //Intialize the count to zero
        if(roomType != ""){
            try{
                while((s=br.readLine()) !=null) //Reading Content from the file
                {
                    // System.out.println(s);
                    String line [] =s.split(" ");

                    if((s.contains("Available")) & (s.contains(roomType)) & (count == 0)){
                        count++; // to ensure more than one room isnt assigned
                        id = line[0];
                        //System.out.println(id);
                        String newLine = s.replace("Available", "N/A");
                        oldLine = oldLine + newLine + System.lineSeparator();
                    }
                    else{
                        oldLine = oldLine + s + System.lineSeparator();
                        //System.out.println(s);
                        writer = new FileWriter(f1);
                        writer.write(oldLine);
                    }

                }
                System.out.println(oldLine);
                roomType = "";

                if(count == 0){
                    //ErrorHandling er = new ErrorHandling("Room of this type is not available","");
                    //er.setVisible(true);
                }

            } catch (IOException ex){
                //ErrorHandling er = new ErrorHandling("Save File not found","");
                //er.setVisible(true); ;

            }
            finally{
                fr.close();
                if (writer!= null) {
                    writer.close();
                }
            }
        }

        else{
            try{
                while((s=br.readLine()) !=null) //Reading Content from the file
                {
                    if((s.contains("Available"))){

                        count++;
                        System.out.println(s);

                    }
                }
                if(count == 0){
                    //ErrorHandling er = new ErrorHandling("Room of this type is not available ","");
                    //er.setVisible(true);
                }

            } catch (IOException ex){
                //ErrorHandling er = new ErrorHandling("Save File not found","");
                //er.setVisible(true);
            }
            finally{
                fr.close();
            }
        }
        return id;

    }




    public static void main(String[] args) throws IOException{
        AssignRooms("Rooms.txt","K");
    }


}
