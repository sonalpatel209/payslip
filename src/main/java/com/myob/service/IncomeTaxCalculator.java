package com.myob.service;

import org.springframework.stereotype.Component;

@Component
public class IncomeTaxCalculator {

    public double calculateIncomeTax(double yearlyIncome) {
        double tax;
        if (yearlyIncome <= 20000)
            tax = 0;
        else if (yearlyIncome <= 40000)
            tax = 0.1 * (yearlyIncome - 20000);
        else if (yearlyIncome <= 80000)
            tax = (0.2 * (yearlyIncome - 40000)) + 2000;
        else if (yearlyIncome <= 180000)
            tax = (0.3 * (yearlyIncome - 80000)) + 10000;
        else
            tax = (0.4 * (yearlyIncome - 180000)) + 40000;
        return tax / 12;
    }
}
