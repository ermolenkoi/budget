package dao.impl;

import dao.BasicDAO;
import dao.ReceiptsExpenditureDAO;
import model.ReceiptsExpenditure;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class ReceiptsExpenditureDAOImpl extends BasicDAO implements ReceiptsExpenditureDAO {

    @Override
    public List<ReceiptsExpenditure> getAllReceiptsExpenditure() {
        return null;
    }

    @Override
    public List<ReceiptsExpenditure> getAllReceipts() {
        return null;
    }

    @Override
    public List<ReceiptsExpenditure> getAllExpenditure() {
        return null;
    }

    @Override
    public List<ReceiptsExpenditure> getReceiptsExpenditure(Data startData, Date endData) {
        return null;
    }

    @Override
    public void deleteReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure) {

    }

    @Override
    public void addReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure) {

    }

    @Override
    public void updateReceiptsExpenditure(ReceiptsExpenditure receiptsExpenditure) {

    }
}
