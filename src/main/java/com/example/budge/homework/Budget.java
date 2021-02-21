package com.example.budge.homework;

public class Budget {

    private String yearMonth;

    private Integer amount;

    public Budget(String yearMonth, Integer amount) {
        this.yearMonth = yearMonth;
        this.amount = amount;
    }

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
