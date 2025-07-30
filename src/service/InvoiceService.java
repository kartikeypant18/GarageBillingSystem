package service;

import config.DbConfig;
import entity.Customer;
import entity.Invoice;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvoiceService {

    public int addInvoice(Invoice invoice) throws SQLException {
        Connection conn = DbConfig.getConnection();

        // Insert into invoices and get generated invoice_id
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO invoices (customer_id, vehicle_id) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        ps.setInt(1, invoice.getCustomerId());
        ps.setInt(2, invoice.getVechicleId());
        ps.executeUpdate();

        // Get generated invoice ID
        ResultSet rs = ps.getGeneratedKeys();
        int invoiceId = -1;
        if (rs.next()) {
            invoiceId = rs.getInt(1);
        }

        ps.close();

        // Now insert all services into invoice_services table
        for (Integer serviceId : invoice.getServiceIds()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "INSERT INTO invoice_services (invoice_id, service_id) VALUES (?, ?)"
            );
            ps2.setInt(1, invoiceId);
            ps2.setInt(2, serviceId);
            ps2.executeUpdate();
            ps2.close();
        }

        conn.close();
        return invoiceId;
    }

    public List<Invoice> getAllInvoices() throws SQLException {
        List<Invoice> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM invoices");

        while (rs.next()) {
            int invoiceId = rs.getInt("id");
            int customerId = rs.getInt("customer_id");
            int vehicleId = rs.getInt("vehicle_id");

            // Fetch service IDs for this invoice
            PreparedStatement ps = conn.prepareStatement("SELECT service_id FROM invoice_services WHERE invoice_id = ?");
            ps.setInt(1, invoiceId);
            ResultSet rs2 = ps.executeQuery();

            List<Integer> serviceIds = new ArrayList<>();
            while (rs2.next()) {
                serviceIds.add(rs2.getInt("service_id"));
            }
            rs2.close();
            ps.close();

            list.add(new Invoice(invoiceId, customerId, vehicleId, serviceIds));
        }

        conn.close();
        return list;
    }
}
