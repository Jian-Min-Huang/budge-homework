package com.example.budge.homework;

import java.time.LocalDate;

public class BudgetVo {

    private LocalDate yearMonth;

    private Integer amount;

    public BudgetVo(LocalDate yearMonth, Integer amount) {
        this.yearMonth = yearMonth;
        this.amount = amount;
    }

    public LocalDate getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(LocalDate yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
