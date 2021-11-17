package com.myob.dto;

public class Payslip {

    private String name;
    private double grossMonthlyIncome = 0;
    private double monthlyIncomeTax = 0;
    private double netMonthlyIncome = 0;

    public Payslip() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrossMonthlyIncome() {
        return grossMonthlyIncome;
    }

    public void setGrossMonthlyIncome(double grossMonthlyIncome) {
        this.grossMonthlyIncome = grossMonthlyIncome;
    }

    public double getMonthlyIncomeTax() {
        return monthlyIncomeTax;
    }

    public void setMonthlyIncomeTax(double monthlyIncomeTax) {
        this.monthlyIncomeTax = monthlyIncomeTax;
    }

    public double getNetMonthlyIncome() {
        return netMonthlyIncome;
    }

    public void setNetMonthlyIncome(double netMonthlyIncome) {
        this.netMonthlyIncome = netMonthlyIncome;
    }
}
