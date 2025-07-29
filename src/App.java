import entity.Customer;
import service.BillingService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        BillingService service = new BillingService();

        while (true) {
            System.out.println("1. Add Customer\n2. Generate Invoice\n3. Show Invoice\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                System.out.print("Customer name: ");
                String name = sc.next();
                System.out.print("Phone: ");
                String phone = sc.next();
                service.customerService.addCustomer(new Customer(0,name,phone));
            break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    int cid = sc.nextInt();
                    System.out.print("Enter vehicle ID: ");
                    int vid = sc.nextInt();
                    System.out.println("Enter number of services:");
                    int n = sc.nextInt();
                    List<Integer> sids=new ArrayList<>();
                    for (int i=0;i<n;i++){
                        System.out.println("enter the service id: ");
                        sids.add(sc.nextInt());
                    }
                    service.createInvoice(cid,vid,sids);
                    break;
                case 3:
                    service.showAllInvoices();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("No Option");
                    break;
            }}}}