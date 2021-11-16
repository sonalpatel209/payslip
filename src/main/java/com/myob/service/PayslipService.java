package com.myob.service;

import org.springframework.stereotype.Service;

@Service
public class PayslipService {

    public void generateMonthlyPayslip(String name, double yearlyIncome) {
        double grossMonthlyIncome = yearlyIncome / 12;
        double monthlyIncomeTax = this.calculateIncomeTax(yearlyIncome);
        double netMonthlyIncome = grossMonthlyIncome - monthlyIncomeTax;

        System.out.println("Monthly Payslip for " + name);
        System.out.println("Gross Monthly Income:" + grossMonthlyIncome);
        System.out.println("Monthly Income Tax:" + monthlyIncomeTax);
        System.out.println("Net Monthly Income:" + netMonthlyIncome);
    }

    private double calculateIncomeTax(double yearlyIncome) {
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
