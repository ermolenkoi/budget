package dao;

import model.ReceiptsExpenditure;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ReceiptsExpenditureDAO {
    List<ReceiptsExpenditure> getAllReceiptsExpenditure();

    List<ReceiptsExpenditure> getAllReceipts();

    List<ReceiptsExpenditure> getAllExpenditure();

    List<ReceiptsExpenditure> getReceiptsExpenditure(Data startData, Date endData);

    void deleteReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure);

    void addReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure);

    void updateReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure);
}
