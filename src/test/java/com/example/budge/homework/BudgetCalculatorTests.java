package com.example.budge.homework;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BudgetCalculatorTests {

    private BudgetRepo budgetRepo = mock(BudgetRepo.class);

    @Test
    void testSingleDayInSingleMonth() {
        List<Budget> budges = Arrays.asList(
                new Budget("202101", 31)
        );
        when(budgetRepo.getAll()).thenReturn(budges);

        BudgetCalculator budgetCalculator = new BudgetCalculator(budgetRepo);
        LocalDate start = LocalDate.of(2021, 1, 1);
        LocalDate end = LocalDate.of(2021, 1, 1);

        Assertions.assertThat(budgetCalculator.query(start, end)).isEqualTo(1);
    }

    @Test
    void testMultiDayInSingleMonth() {
        List<Budget> budges = Arrays.asList(
                new Budget("202102", 56)
        );
        when(budgetRepo.getAll()).thenReturn(budges);

        BudgetCalculator budgetCalculator = new BudgetCalculator(budgetRepo);
        LocalDate start = LocalDate.of(2021, 2, 1);
        LocalDate end = LocalDate.of(2021, 2, 20);

        Assertions.assertThat(budgetCalculator.query(start, end)).isEqualTo(40);
    }

    @Test
    void testMultiDayInMultiMonth() {
        List<Budget> budges = Arrays.asList(
                new Budget("202102", 28),
                new Budget("202103", 31 * 2),
                new Budget("202104", 30 * 3)
        );
        when(budgetRepo.getAll()).thenReturn(budges);

        BudgetCalculator budgetCalculator = new BudgetCalculator(budgetRepo);
        LocalDate start = LocalDate.of(2021, 2, 28);
        LocalDate end = LocalDate.of(2021, 4, 1);

        Assertions.assertThat(budgetCalculator.query(start, end)).isEqualTo(66);
    }


    @Test
    void testMultiDayInMultiMonth2() {
        List<Budget> budges = Arrays.asList(
                new Budget("202102", 28),
                new Budget("202103", 31 * 2),
                new Budget("202104", 30 * 3),
                new Budget("202105", 31 * 4),
                new Budget("202106", 30 * 5)
        );
        when(budgetRepo.getAll()).thenReturn(budges);

        BudgetCalculator budgetCalculator = new BudgetCalculator(budgetRepo);
        LocalDate start = LocalDate.of(2021, 2, 28);
        LocalDate end = LocalDate.of(2021, 4, 2);

        Assertions.assertThat(budgetCalculator.query(start, end)).isEqualTo((1 * 1) + (31 * 2) + (2 * 3));
    }
}
