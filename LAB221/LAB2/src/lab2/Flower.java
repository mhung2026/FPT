/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Flower {

    public String id;
    public String name;
    public String description;
    public String importDate;
    public int unitPrice;
    public String category;

    public Flower() {
    }

    public Flower(String id, String name, String description, String importDate, int unitPrice, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.importDate = importDate;
        this.unitPrice = unitPrice;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Id: " + id + "| Name: " + name + "| Description: " + description + "| Import Date: " + importDate + "| Unit Price: " + unitPrice + "| Category: " + category;

    }

    public String inputFlowerId(HashMap hashmap) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Fxxx): ");
                String flowerId = sc.nextLine();
                if (!flowerId.matches("^F\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(flowerId)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return flowerId;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputName() {
        while (true) {
            System.out.print("Enter name: ");
            Scanner sc = new Scanner(System.in);
            description = sc.nextLine();
            if (!description.isEmpty()) {
                return description;
            }

            System.out.println("Name can not is empty!");
        }
    }

    public String description() {
        while (true) {
            System.out.print("Enter diagnosis: ");
            Scanner sc = new Scanner(System.in);
            description = sc.nextLine();
            if (description.isEmpty()) {
                System.out.println("Description can not is empty!");
            } else if (description.length() < 3 || description.length() > 50) {
                System.out.println("Length >3 and <50");
            } else {
                return description;
            }

        }

    }

    public String importDate() {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter import Date: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    importDate = outputFormat.format(date);
                    return importDate;
                } else {
                    throw new Exception("Import Date can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public int unitPrice() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter unit price: ");
                unitPrice = sc.nextInt();
                if (unitPrice <=0) throw new Exception("The price must be a positive number!");
                return unitPrice;
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String category() {
        while (true) {
            System.out.print("Enter category: ");
            Scanner sc = new Scanner(System.in);
            category = sc.nextLine();
            if (!category.isEmpty()) {
                return category;
            }

            System.out.println("Category can not is empty!");
        }
    }

    public void searchFlower(HashMap hashmap) {

        String idname, s;
        System.out.println("Do you want to find by ID/Name?");
        while (true) {
            Scanner sc = new Scanner(System.in);
            idname = sc.nextLine();
            if (!idname.isEmpty()) {
                if (idname.matches("ID") || idname.matches("Name")) {
                    break;
                }
            }
            System.out.println("Invalid");
        }
        if (idname.matches("ID")) {
            System.out.println("Enter ID of Flower: ");
            while (true) {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine();
                if (!s.isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid");
                }
            }
            if (hashmap.get(s) == null) {
                System.out.println("The flower does not exist");
            } else {
                System.out.println(hashmap.get(s));
            }
        } else {
            System.out.println("Enter Name of Flower: ");
            while (true) {
                Scanner sc = new Scanner(System.in);
                s = sc.nextLine();
                if (!s.isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid");
                }
            }

//            Set<String> keyset = hashmap.keySet();
//            for (String key : keyset) {
//                if (hashmap.get(key).equals(s)) {
//                    System.out.println(hashmap.get(key));
//                }
//            }
        }
    }

    public String deleteFlower(HashMap hashmap) {
        String s;
        System.out.println("Enter ID of Flower: ");
        while (true) {
            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (!s.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid");
            }
        }
        return s;
    }

}
