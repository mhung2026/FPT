/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Store {

    Flower p = new Flower();
    OrderHeader odh = new OrderHeader();
    public HashMap<String, Flower> hashmapFl = new HashMap<>();
    public HashMap<String, OrderHeader> hashmapOd = new HashMap<>();

    List<String> idOd = new ArrayList<String>();

    public void inputFlower() {
        while (true) {
            p.id = p.inputFlowerId(hashmapFl);
            p.name = p.inputName();
            p.description = p.description();
            p.importDate = p.importDate();
            p.unitPrice = p.unitPrice();
            p.category = p.category();
            this.hashmapFl.put(p.id, p);
            System.out.println("Do you want continue (Y/N)?");
            String bool;
            while (true) {
                Scanner sc = new Scanner(System.in);
                bool = sc.nextLine();
                if (bool.matches("Y") || bool.matches("N")) {
                    break;
                }
            }
            if (bool.equals("N")) {
                System.out.println("");
                System.out.println("Successful!");
                System.out.println("");
                return;
            }
        }

    }

    public void findFlower() {
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
            if (hashmapFl.get(s) == null) {
                System.out.println("The flower does not exist");
            } else {
                System.out.println(hashmapFl.get(s));
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

            Set<String> keyset = hashmapFl.keySet();
            for (String key : keyset) {
                if (hashmapFl.get(key).name.equals(s)) {
                    System.out.println(hashmapFl.get(key));
                }
            }

        }
    }

    public void updateFlower() {
        String s;
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
        Set<String> keyset = hashmapFl.keySet();
        for (String key : keyset) {
            if (hashmapFl.get(key).name.equals(s)) {
                System.out.println("Do you want update " + key + "/" + s + " (Y/N)?");
                String bool;
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    bool = sc.nextLine();
                    if (bool.matches("Y") || bool.matches("N")) {
                        break;
                    }
                }
                if (bool.matches("Y")) {
                    this.hashmapFl.get(key).description = p.description();
                    this.hashmapFl.get(key).importDate = p.importDate();
                    this.hashmapFl.get(key).unitPrice = p.unitPrice();
                    this.hashmapFl.get(key).category = p.category();
                }
                for (String key2 : idOd) {
                    ArrayList<List<String>> Arrlist = hashmapOd.get(key2).listDetails;
                    int tmp = 0, total = 0;
                    for (List key3 : Arrlist) {
                        List<String> tmpList = Arrlist.get(tmp);
                        OrderHeader p = hashmapOd.get(key2);
                        if (tmpList.get(1).matches(key)) {
                            int x = hashmapFl.get(key).unitPrice * Integer.parseInt(tmpList.get(2));
                            tmpList.set(3, "" + x);
                            Arrlist.set(tmp, tmpList);
                            p.setListDetails(Arrlist);
                        }
                        total += Integer.parseInt(tmpList.get(3));
                        p.setTotal(total);
                        hashmapOd.replace(key2, p);
                        tmp++;
                    }
                }
            }
        }
    }

    public void deleteFlower() {
        String s = p.deleteFlower(hashmapFl);
        if (hashmapFl.get(s) != null) {
            hashmapFl.remove(s);
            System.out.println("");
            System.out.println("Successful!");
        } else {
            System.out.println("The flower does not exist");
        }
    }

    public void printFlower() {
        if (this.hashmapFl != null) {
            System.out.println("");
            System.out.println("_________LIST Flower_________:");
            System.out.println("");
            Set<String> keyset = this.hashmapFl.keySet();
            for (String key : keyset) {
                System.out.println(this.hashmapFl.get(key));
            }
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("List Flower is empty!");
            System.out.println("");
        }
    }

    public String inputOrderDetailId() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (ODxxx): ");
                String orderDetailId = sc.nextLine();
                if (!orderDetailId.matches("^OD\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }

                Set<String> keyset = hashmapOd.keySet();

                for (String key : keyset) {
                    ArrayList<List<String>> ListD = hashmapOd.get(key).listDetails;
                    int i = 0;
                    for (List j : ListD) {
                        if (ListD.get(i).get(0).equals(orderDetailId)) {
                            throw new Exception("The ID you entered already exists");
                        }
                        i++;
                    }
                }
                return orderDetailId;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String inputOrderFlowerId() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Id (Fxxx): ");
                String orderDetailFlowerId = sc.nextLine();
                if (!orderDetailFlowerId.matches("^F\\d{3}$")) {
                    throw new Exception("Id is incorrect");
                }

                Set<String> keyset = hashmapFl.keySet();

                for (String key : keyset) {
                    if (key.matches(orderDetailFlowerId)) {
                        return orderDetailFlowerId;
                    }

                }

            } catch (Exception ex) {
                System.out.println("Invalid " + ex.getMessage());
            }
        }
    }

    public int inputQuantity() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter Quannaty: ");
                int quantity = sc.nextInt();
                return quantity;
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
    }

    public List<String> inputOrderDetail() {
        List<String> list = new ArrayList<>();
        list.add(0, inputOrderDetailId());
        list.add(1, inputOrderFlowerId());
        list.add(2, "" + inputQuantity());
        int x = hashmapFl.get(list.get(1)).unitPrice * Integer.parseInt(list.get(2));
        list.add(3, "" + x);
        return list;
    }

    public void addOder() {
        while (true) {
            OrderHeader o = new OrderHeader();
            ArrayList<List<String>> list = new ArrayList<List<String>>();
            int flowerCount = 0, total = 0;
            o.id = odh.inputOrderHeaderId(hashmapOd);
            o.orderDate = odh.orderDate();
            o.customerName = odh.customerName();
            while (true) {
                List<String> tmp = new ArrayList<String>();
                tmp = inputOrderDetail();
                flowerCount += Integer.parseInt(tmp.get(2));
                total += Integer.parseInt(tmp.get(3));
                list.add(tmp);
                System.out.println("Do you want continue add new OrderDetail (Y/N)?");
                String bool;
                while (true) {
                    Scanner sc = new Scanner(System.in);
                    bool = sc.nextLine();
                    if (bool.matches("Y") || bool.matches("N")) {
                        break;
                    }
                }
                if (bool.matches("N")) {
                    break;
                }
            }
            o.flowerCount = flowerCount;
            o.total = total;
            o.listDetails = list;
            this.hashmapOd.put(o.id, o);
            
            idOd.add(o.id);

            System.out.println("Do you want continue (Y/N)?");
            String bool;
            while (true) {
                Scanner sc = new Scanner(System.in);
                bool = sc.nextLine();
                if (bool.matches("Y") || bool.matches("N")) {
                    break;
                }
            }
            if (bool.matches("N")) {
                System.out.println("Successful!");
                return;
            }
        }
    }

    public void displayOrder() {
        String std, ed;
        Scanner sc = new Scanner(System.in);
        while (true) {
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String a;
                System.out.println("Enter start admissionDate: ");
                a = sc.nextLine();
                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.DATE, -1);
                    date = c.getTime();
                    std = outputFormat.format(date);
                    break;
                }
                throw new Exception("Invalid");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Invalid format!");
                System.out.println("");
            }
        }
        while (true) {
            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                String a;
                System.out.println("Enter end admissionDate: ");
                a = sc.nextLine();
                if (!a.isEmpty()) {
                    Date date = inputFormat.parse(a);
                    DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Calendar c = Calendar.getInstance();
                    c.setTime(date);
                    c.add(Calendar.DATE, 1);
                    date = c.getTime();
                    ed = outputFormat.format(date);
                    break;
                }
                throw new Exception("Invalid");
            } catch (Exception e) {
                System.out.println("");
                System.out.println("Invalid format!");
                System.out.println("");
            }
        }
        
        int x;
        while (true) {
            try {
                Scanner sc2 = new Scanner(System.in);
                System.out.print("Enter unit price: ");
                x = sc2.nextInt();
                break;
            } catch (Exception ex) {
                System.out.println("Invalid");
            }
        }
        
        LocalDate startDate = LocalDate.parse(std);
        LocalDate endDate = LocalDate.parse(ed);
        List<OrderHeader> filteredPatients = new ArrayList<>();
        Set<String> keyset = hashmapOd.keySet();
        for (String key : keyset) {
            LocalDate admissionDate = LocalDate.parse(hashmapOd.get(key).orderDate);
            if (admissionDate.isAfter(startDate) && admissionDate.isBefore(endDate)) {
                filteredPatients.add(hashmapOd.get(key));
            }
        }
        System.out.println("");
        System.out.println("-----------LIST OF ORDER HEADER-----------");
        System.out.println("Start date:" + std);
        System.out.println("End date:" + ed);
        System.out.println("");
        for (OrderHeader p : filteredPatients) {
            List<String> tmp = new ArrayList<String>();
            System.out.print("Order ID: " + p.id + "| Order Date: " + p.orderDate + "| Customer: " + p.customerName + "| Flower Count: " + p.flowerCount + "| Order Total: " + p.total);
            if (p.total == x) {
                System.out.println("| Status: Nomal");
            }
            if (p.total < x) {
                System.out.println("| Status: Low");
            }
            if (p.total > x) {
                System.out.println("| Status: Hight");
            }

            System.out.println("");
        }
        System.out.println("");
    }

    public void sortOrderWithId(String bool) {
        for (int i = 0; i < idOd.size(); i++) {
            for (int j = i + 1; j < idOd.size(); j++) {
                if (bool.matches("ASC")) {
                    if (idOd.get(i).compareTo(idOd.get(j)) > 0) {
                        Collections.swap(idOd, i, j);

//                    String tmp = idOd.get(i);
//                    idOd.set(i, idOd.get(j));
//                    idOd.set(j, tmp);
                    }
                } else {
                    if (idOd.get(j).compareTo(idOd.get(i)) > 0) {
                        Collections.swap(idOd, i, j);
                    }
                }
            }
        }
    }

    public void sortOrderWithName(String bool) {
        for (int i = 0; i < idOd.size(); i++) {
            for (int j = i + 1; j < idOd.size(); j++) {
                String a = hashmapOd.get(idOd.get(i)).customerName;
                String b = hashmapOd.get(idOd.get(j)).customerName;
                if (bool.matches("ASC")) {
                    if (a.compareTo(b) > 0) {
                        Collections.swap(idOd, i, j);
                    }
                } else {
                    if (a.compareTo(b) < 0) {
                        Collections.swap(idOd, i, j);
                    }
                }

            }
        }
    }

    public void sortOrderWithDate(String bool) {
        for (int i = 0; i < idOd.size(); i++) {
            for (int j = i + 1; j < idOd.size(); j++) {
                LocalDate a = LocalDate.parse(hashmapOd.get(idOd.get(i)).orderDate);
                LocalDate b = LocalDate.parse(hashmapOd.get(idOd.get(j)).orderDate);
                if (bool.matches("ASC")) {

                    if (a.isAfter(b)) {
                        Collections.swap(idOd, i, j);
                    }
                } else {
                    if (b.isAfter(a)) {
                        Collections.swap(idOd, i, j);
                    }
                }

            }
        }
    }

    public void sortOrderWithTotal(String bool) {
        for (int i = 0; i < idOd.size(); i++) {
            for (int j = i + 1; j < idOd.size(); j++) {
                int a = hashmapOd.get(idOd.get(i)).total;
                int b = hashmapOd.get(idOd.get(j)).total;
                if (bool.matches("ASC")) {
                    if (a > b) {
                        Collections.swap(idOd, i, j);
                    }

                } else {
                    if (a < b) {
                        Collections.swap(idOd, i, j);
                    }
                }

            }
        }

    }

    public void sortOrder() {
        String s, bool;
        while (true) {
            System.out.println("Sort with id/date/name/total ?");

            Scanner sc = new Scanner(System.in);
            s = sc.nextLine();
            if (s.isEmpty()) {
                System.out.println("Can not is empty!");
            } else if ((s.matches("id") || s.matches("date")) || (s.matches("name") || s.matches("total"))) {
                break;
            } else {
                System.out.println("Invalid!");
            }
        }
        while (true) {
            System.out.println("Sort with ASC/DESC ?");

            Scanner sc = new Scanner(System.in);
            bool = sc.nextLine();
            if (bool.isEmpty()) {
                System.out.println("Can not is empty!");
            } else if ((bool.matches("ASC") || bool.matches("DESC"))) {
                break;
            } else {
                System.out.println("Invalid!");
            }
        }

        if (s.matches("id")) {
            sortOrderWithId(bool);
        }
        if (s.matches("date")) {
            sortOrderWithDate(bool);
        }
        if (s.matches("name")) {
            sortOrderWithName(bool);
        }
        if (s.matches("total")) {
            sortOrderWithTotal(bool);
        }
        System.out.println("Sort by: Order " + s);
        System.out.println("Sort order: " + bool);
        System.out.println("");
        for (String key : idOd) {
            System.out.println("ID Order Header: " + key + "| Order Date: " + hashmapOd.get(key).getOrderDate() + "| Customer: " + hashmapOd.get(key).getCustomerName() + "| Flower Count: " + hashmapOd.get(key).getFlowerCount() + "| Order Total: " + hashmapOd.get(key).getTotal());
        }
//        printOrder();
        System.out.println("Successful!");
    }

    public void printOrder() {

        for (String key : idOd) {
            System.out.println("ID Order Header: " + key + "| Order Date: " + hashmapOd.get(key).getOrderDate() + "| Customer: " + hashmapOd.get(key).getCustomerName());
            ArrayList<List<String>> list = hashmapOd.get(key).listDetails;
            int tmp = 0;
            System.out.println("Detail:  ");
            for (List key2 : list) {
                System.out.println("ID order detail: " + list.get(tmp).get(0).toString() + "| ID Flower: " + list.get(tmp).get(1).toString() + "| Quantity:" + list.get(tmp).get(2).toString() + "| Cost:" + list.get(tmp).get(3).toString());
                tmp++;
            }
            System.out.println("-----------------------------------------------");;
        }
    }

    public void loadData() throws FileNotFoundException {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB2\\src\\lab2\\File\\Flower");
        if (!f.exists()) {
            System.out.println("Load Data unsuccessful!");
            return;
        } else {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                while ((line = br.readLine()) != null) {
                    StringTokenizer stk = new StringTokenizer(line, "|");
                    String id = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    String description = stk.nextToken().trim();
                    String importDate = stk.nextToken().trim();
                    int unitPrice = Integer.parseInt(stk.nextToken().trim());
                    String category = stk.nextToken().trim();
                    Flower p = new Flower(id, name, description, importDate, unitPrice, category);
                    this.hashmapFl.put(p.id, p);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        File foh = new File("E:\\PRO192\\Session01-Hello\\LAB2\\src\\lab2\\File\\Order");
        if (!foh.exists()) {
            System.out.println("Load Data Order unsuccessful!");
            return;
        } else {
            FileReader fr = new FileReader(foh);
            BufferedReader br = new BufferedReader(fr);
            try {
                String line = null;
                OrderHeader odh = new OrderHeader();
                while ((line = br.readLine()) != null) {
                    ArrayList<List<String>> listF = new ArrayList<>();
                    StringTokenizer stk = new StringTokenizer(line, "|");

                    String id = stk.nextToken().trim();
                    String date = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    int total = 0, flowerCount = 0;

                    while (stk.hasMoreTokens()) {
                        List<String> tmp2 = new ArrayList<String>();
                        String tmp = stk.nextToken().trim();
                        int j = 0;
                        String ss = "";
                        for (int i = 0; i < tmp.length(); i++) {
                            String x = Character.toString(tmp.charAt(i));
                            if (x.equals(":")) {

                                if (j == 2) {
                                    flowerCount += Integer.parseInt(ss);
                                }

                                tmp2.add(j, ss);

                                ss = "";
                                j++;
                            } else {
                                ss = ss + x;
                            }
                            if (i == tmp.length() - 1) {
                                tmp2.add(j, ss);
                                if (j == 3) {
                                    total += Integer.parseInt(ss);
                                }
                                ss = "";
                                j++;
                            }
                        }
                        listF.add(tmp2);
                    }
                    OrderHeader p = new OrderHeader(id, date, name, flowerCount, total, listF);
                    hashmapOd.put(p.id, p);
                    idOd.add(p.id);

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Successful!");
    }

    public void saveFile() throws Exception {
        File f = new File("E:\\PRO192\\Session01-Hello\\LAB2\\src\\lab2\\File\\Flower");
        if (hashmapFl.isEmpty()) {
            System.out.println("ListFlower is empty! Save list Flower to file unsuccessful!");
            return;
        }
        PrintWriter pw = new PrintWriter(f);
        Set<String> keyset = hashmapFl.keySet();
        for (String key : keyset) {
            pw.println(key + "|" + hashmapFl.get(key).getName() + "|" + hashmapFl.get(key).getDescription() + "|" + hashmapFl.get(key).getImportDate() + "|" + hashmapFl.get(key).getUnitPrice() + "|" + hashmapFl.get(key).getCategory());
        }
        if (pw != null) {
            pw.close();
        }

        File fod = new File("E:\\PRO192\\Session01-Hello\\LAB2\\src\\lab2\\File\\Order");
        if (hashmapOd.isEmpty()) {
            System.out.println("List Order is empty! Save list Order to file unsuccessful!");
            return;
        }

        PrintWriter pwod = new PrintWriter(fod);

        for (String key : idOd) {
            pwod.print(key + "|" + hashmapOd.get(key).getOrderDate() + "|" + hashmapOd.get(key).getCustomerName());

            ArrayList<List<String>> list = hashmapOd.get(key).listDetails;
            int tmp = 0;
            for (List key2 : list) {
                pwod.print("|" + list.get(tmp).get(0).toString() + ":" + list.get(tmp).get(1).toString() + ":" + list.get(tmp).get(2).toString() + ":" + list.get(tmp).get(3).toString());
                tmp++;
            }
            pwod.println();
        }

        if (pwod != null) {
            pwod.close();
        }
        System.out.println("Save Data successful!");
        return;
    }

    public static void main(String[] args) throws Exception {
        Store st = new Store();
        while (true) {
            Menu.display();
            String choice = Menu.choose();
            switch (choice) {
                case "1":
                    st.inputFlower();
                    break;
                case "2":
                    st.findFlower();
                    break;
                case "3":
                    st.updateFlower();
                    break;
                case "4":
                    st.deleteFlower();
                    break;
                case "5":
                    st.printFlower();
                    break;
                case "6":
                    st.addOder();
                    break;
                case "7":
                    st.displayOrder();
                    break;
                case "8":
                    st.sortOrder();
                    break;
                case "9":
                    st.printOrder();
                    break;
                case "10":
                    st.saveFile();
                    break;
                case "11":
                    st.loadData();
                    break;
                default:
                    System.out.println("Do you want exit (Y/N)?");
                    String bool;
                    while (true) {
                        Scanner sc = new Scanner(System.in);
                        bool = sc.nextLine();
                        if (bool.matches("Y") || bool.matches("N")) {
                            break;
                        }
                    }
                    if (bool.matches("Y")) {
                        st.saveFile();
                        System.exit(0);
                    }
            }

        }
    }
}
