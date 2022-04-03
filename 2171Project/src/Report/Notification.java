package Report;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Notification {
    private LocalDateTime today;

    public Notification() {

    }

    public ArrayList<String> UpdateManager(String rfile) throws IOException {
        File f1 = new File(rfile); //Creation of File Descriptor for input file
        String[] words = null;  //Intialize the word Array
        FileReader fr = new FileReader(f1);  //Creation of File Reader object
        BufferedReader br = new BufferedReader(fr); //Creation of BufferedReader object
        FileWriter writer = null;
        String s;
        String name = "";
        ArrayList<String> employees = new ArrayList<String>();
        String duedate = "";
        int count = 0;
        LocalDateTime now = LocalDateTime.now();
        String currdate = LocalDateTime.now().toString();
        LocalDateTime tommorrow = LocalDateTime.now().plusDays(1);
        Double bal= Double.parseDouble("123");


        try {
            while ((s = br.readLine()) != null) {
                String line[] = s.split(" ");
                if (line[6] == currdate) {
                    count++;
                    name = line[0].concat(" ").concat(line[1]);
                    duedate = "Rent for" + name + "is due today" + currdate;
                    employees.add(duedate);

                } else if (LocalDateTime.parse(line[6]).isAfter(now) && LocalDateTime.parse(line[6]).isBefore(tommorrow)) {
                    count++;
                    name = line[0].concat(" ").concat(line[1]);
                    String date = LocalDateTime.parse(line[6]).toString();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd   HH:mm");
                    String empdate = LocalDateTime.parse(line[6]).format(formatter);
                    duedate = "Rent for " + name + " is due " + empdate;
                    employees.add(duedate);
                }

            }
            if (count == 0) {
                System.out.println("no rent due");
            }

        } catch (IOException ex) {
            System.out.println("File not found");
        }
        return employees;
    }
}

