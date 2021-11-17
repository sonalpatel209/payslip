package com.myob;

import com.myob.dto.Payslip;
import com.myob.service.PayslipService;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PayslipApplication implements CommandLineRunner {

    @Autowired
    private PayslipService payslipService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PayslipApplication.class);
        app.setBannerMode(Mode.OFF);
        app.setLogStartupInfo(false);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        this.validateInput(args);
        double yearlyIncome = NumberUtils.toDouble(args[1]);
        Payslip payslip = payslipService.generateMonthlyPayslip(args[0], yearlyIncome);
        System.out.println("Monthly Payslip for " + payslip.getName());
        System.out.println("Gross Monthly Income:" + payslip.getGrossMonthlyIncome());
        System.out.println("Monthly Income Tax:" + payslip.getMonthlyIncomeTax());
        System.out.println("Net Monthly Income:" + payslip.getNetMonthlyIncome());
    }

    private void validateInput(String... args) {
        if (args == null || args.length != 2) {
            System.out.println("Please provide Name and yearly income to generate monthly payslip.");
            System.exit(0);
        }
        if (!(NumberUtils.isParsable(args[1]) && NumberUtils.toDouble(args[1]) > 0)) {
            System.out.println("Please provide valid number for yearly income");
            System.exit(0);
        }
    }

}
