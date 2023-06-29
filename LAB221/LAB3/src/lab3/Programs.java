package lab3;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Programs {

    private String ID;
    private String name;
    private String time;
    private String fromDate;
    private String endDate;
    private int days;
    private String location;
    private int cost;
    private String content;

    public Programs() {

    }

    public Programs(String ID, String name, String time, String fromDate, String endDate, int days, String location, int cost, String content) {
        this.ID = ID;
        this.name = name;
        this.time = time;
        this.fromDate = fromDate;
        this.endDate = endDate;
        this.days = days;
        this.location = location;
        this.cost = cost;
        this.content = content;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getLocation() {
        return location;
    }

    public void setLocotion(String location) {
        this.location = location;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String inputId(HashMap hashmap) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Pxxx): ");
                String id = sc.nextLine();
                if (!id.matches("^P\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(id)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return id;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputName() {
        while (true) {
            System.out.print("Enter name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Name can not is empty!");
        }
    }

    public String inputTime() {
        while (true) {
            System.out.print("Enter time: ");
            Scanner sc = new Scanner(System.in);
            String time = sc.nextLine();
            if (!time.isEmpty()) {
                if (time.matches("January") || time.matches("March") || time.matches("May") || time.matches("July") || time.matches("September") || time.matches("November")) {
                    return time;
                } else {
                    System.out.println("Only accept as: January, March, May, July, September, November");
                }

            } else {
                System.out.println("Time can not is empty!");
            }
        }
    }

    public String inputFromDate() {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter from Date: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String fromDate = outputFormat.format(date);
                    return fromDate;
                } else {
                    throw new Exception("From Date can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String inputEndDate(String std) {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter end Date: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    String endDate = outputFormat.format(date);

                    LocalDate st = LocalDate.parse(std);
                    LocalDate en = LocalDate.parse(endDate);
                    if (st.isBefore(en)) {
                        return endDate;
                    } else {
                        System.out.println("End date is after From date!");
                    }
                } else {
                    throw new Exception("End Date can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public int inputDays() {

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter days: ");
                int days = sc.nextInt();
                if (days < 30 || days > 40) {
                    throw new Exception("From 30 to 40 days");
                }
                return days;
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String inputLocation() {
        while (true) {
            System.out.print("Enter location: ");
            Scanner sc = new Scanner(System.in);
            String location = sc.nextLine();
            if (!location.isEmpty()) {
                return location;
            }
            System.out.println("Location can not is empty!");
        }
    }

    public int inputCost() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter cost: ");
                int cost = sc.nextInt();
                if (cost <= 0) {
                    throw new Exception("The cost must be a positive number!");
                }
                return cost;
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String inputContent() {
        while (true) {
            System.out.print("Enter content: ");
            Scanner sc = new Scanner(System.in);
            String content = sc.nextLine();
            if (!content.isEmpty()) {
                if (content.contains(".doc") || content.contains(".pdf")) {
                    File file = new File(content);
                    if (file.isFile()) {
                        return content;
                    } else {
                        System.out.println("Haven't file!");
                    }
                } else {
                    System.out.println("The path of the file( .doc or .pdf)");
                }
            } else if (content.isEmpty()) {
                System.out.println("Content can not is empty!");
            } else {
                System.out.println("Invalid!");
            }
        }
    }

    public Programs input(HashMap hashmap) {
        String ID = inputId(hashmap);
        String name = inputName();
        String time = inputTime();
        String fromDate = inputFromDate();
        String endDate = inputEndDate(fromDate);
        int days = inputDays();
        String location = inputLocation();
        int cost = inputCost();
        String content = inputContent();
        Programs p = new Programs(ID, name, time, fromDate, endDate, days, location, cost, content);
        return p;
    }

}
