package com.myob.service;

import com.myob.dto.Payslip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayslipService {

    @Autowired
    private IncomeTaxCalculator incomeTaxCalculator;

    public Payslip generateMonthlyPayslip(String name, double yearlyIncome) {
        double grossMonthlyIncome = 0;
        double monthlyIncomeTax = 0;
        double netMonthlyIncome = 0;
        if (yearlyIncome > 0) {
            grossMonthlyIncome = yearlyIncome / 12;
            monthlyIncomeTax = incomeTaxCalculator.calculateIncomeTax(yearlyIncome);
            netMonthlyIncome = grossMonthlyIncome - monthlyIncomeTax;
        }
        Payslip payslip = new Payslip();
        payslip.setName(name);
        payslip.setGrossMonthlyIncome(grossMonthlyIncome);
        payslip.setMonthlyIncomeTax(monthlyIncomeTax);
        payslip.setNetMonthlyIncome(netMonthlyIncome);

        return payslip;
    }
}
