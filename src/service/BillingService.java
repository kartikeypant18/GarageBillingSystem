package service;

import entity.Invoice;
import java.sql.SQLException;
import java.util.List;

public class BillingService {

    public CustomerService customerService = new CustomerService();
    public InvoiceService invoiceService = new InvoiceService();

    public void createInvoice(int customerId, int vehicleId, List<Integer> serviceIds) throws SQLException {
        Invoice invoice = new Invoice(0, customerId, vehicleId, serviceIds);
        int invoiceId = invoiceService.addInvoice(invoice);
        System.out.println("Invoice #" + invoiceId + " generated successfully with " + serviceIds.size() + " services.");
    }
    public void showAllInvoices() throws SQLException {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        for (Invoice invoice : invoices) {
            System.out.println(invoice);
        }
    }
}
