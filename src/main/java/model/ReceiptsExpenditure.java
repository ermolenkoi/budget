package model;

import com.sun.javafx.binding.StringFormatter;

import java.sql.Date;

// receipts and expenditure (поступления и расходы)
public class ReceiptsExpenditure {

    private Integer id;

    private Boolean receipt;

    private Double sum;

    private Date data;

    ReceiptsExpenditure (Integer id, Boolean receipt, Double sum, Date data){
        this.id = id;
        this.receipt = receipt;
        this.sum = sum;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getReceipt() {
        return receipt;
    }

    public void setReceipt(Boolean receipt) {
        this.receipt = receipt;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString() {
        if (receipt) {
            return "Receipts {" +
                    "id=" + id +
                    ", sum='" + sum + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        } else {
            return "Expenditure {" +
                    "id=" + id +
                    ", sum='" + sum + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        }


    }



}
