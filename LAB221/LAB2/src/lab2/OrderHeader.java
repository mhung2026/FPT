/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author NGOMI
 */
public class OrderHeader {

    public String id;
    public String orderDate;
    public String customerName;
    public int flowerCount;
    public int total;
    public ArrayList<List<String>> listDetails;

    public OrderHeader() {

    }

    public OrderHeader(String id, String orderDate, String customerName, int flowerCount, int total, ArrayList<List<String>> listDetails) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.flowerCount = flowerCount;
        this.total = total;
        this.listDetails = listDetails;
    }

    public int getFlowerCount() {
        return flowerCount;
    }

    public void setFlowerCount(int flowerCount) {
        this.flowerCount = flowerCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<List<String>> getListDetails() {
        return listDetails;
    }

    public void setListDetails(ArrayList<List<String>> listDetails) {
        this.listDetails = listDetails;
    }

    @Override
    public String toString() {
        return "Id: " + id + "| orderDate: " + orderDate + "| customerName: " + customerName + listDetails;//To change body of generated methods, choose Tools | Templates.
    }

    public String inputOrderHeaderId(HashMap hashmap) {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (OHxxx): ");
                String orderHeaderId = sc.nextLine();
                if (!orderHeaderId.matches("^OH\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }
                Set<String> keyset = hashmap.keySet();
                for (String key : keyset) {
                    if (key.matches(orderHeaderId)) {
                        throw new Exception("The ID you entered already exists");
                    }
                }
                return orderHeaderId;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String orderDate() {
        DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        while (true) {
            try {
                String a;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter order Date: ");
                a = sc.nextLine();

                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyy-MM-dd");
                    String orderDate = outputFormat.format(date);
                    return orderDate;
                    
                } else {
                    throw new Exception("Order Date can not is empty!");
                }
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public String customerName() {
        while (true) {
            System.out.print("Customer's name name: ");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            if (!name.isEmpty()) {
                return name;
            }

            System.out.println("Customer's name can not is empty!");
        }
    }

}
