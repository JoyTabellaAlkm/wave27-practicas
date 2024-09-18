package org.example;

import java.util.List;

public interface BillController {
        void createBill(Bill factura);
        Bill findBillById(int id);
        void updateBill(Bill factura);
        void removeBill(int id);
        List<Bill> listBills();
}
