package com.myob.service;

import com.myob.PayslipApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PayslipApplication.class},
        initializers = ConfigDataApplicationContextInitializer.class)
public class IncomeTaxCalculatorTest {

    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;

    @Test
    void calculateTax_negativeamount() {
        double yearlyIncome = -55;
        double expectedTax = 0;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }

    @Test
    void calculateTax_lessthan20000() {
        double yearlyIncome = 1000;
        double expectedTax = 0;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }

    @Test
    void calculateTax_lessthan40000() {
        double yearlyIncome = 36000;
        double expectedTax = (0.1 * (yearlyIncome - 20000)) / 12;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }


    @Test
    void calculateTax_lessthan80000() {
        double yearlyIncome = 75000;
        double expectedTax = ((0.2 * (yearlyIncome - 40000)) + 2000) / 12;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }

    @Test
    void calculateTax_lessthan180000() {
        double yearlyIncome = 145000;
        double expectedTax = ((0.3 * (yearlyIncome - 80000)) + 10000) / 12;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }

    @Test
    void calculateTax_morethan180000() {
        double yearlyIncome = 225000;
        double expectedTax = ((0.4 * (yearlyIncome - 180000)) + 40000) / 12;
        assertThat(incomeTaxCalculator.calculateIncomeTax(yearlyIncome)).isEqualTo(expectedTax);
    }
}
