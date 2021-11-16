package com.myob;

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
        app.run(args);
    }

    @Override
    public void run(String... args) {
        this.validateInput(args);
        double yearlyIncome = NumberUtils.toDouble(args[1]);
        payslipService.generateMonthlyPayslip(args[0], yearlyIncome);
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
