package com.myob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayslipService {

    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;

    public void generateMonthlyPayslip(String name, double yearlyIncome) {
        double grossMonthlyIncome = 0;
        double monthlyIncomeTax = 0;
        double netMonthlyIncome = 0;
        if (yearlyIncome > 0) {
            grossMonthlyIncome = yearlyIncome / 12;
            monthlyIncomeTax = incomeTaxCalculator.calculateIncomeTax(yearlyIncome);
            netMonthlyIncome = grossMonthlyIncome - monthlyIncomeTax;
        }
        System.out.println("Monthly Payslip for " + name);
        System.out.println("Gross Monthly Income:" + grossMonthlyIncome);
        System.out.println("Monthly Income Tax:" + monthlyIncomeTax);
        System.out.println("Net Monthly Income:" + netMonthlyIncome);
    }
}
