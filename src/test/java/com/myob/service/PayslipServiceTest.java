package com.myob.service;

import com.myob.PayslipApplication;
import com.myob.dto.Payslip;
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
public class PayslipServiceTest {

    @Autowired
    private PayslipService payslipService;

    @Test
    void generateMonthlyPayslip_negativeamount() {
        double yearlyIncome = -55;
        String name = "sonal";
        Payslip payslip = payslipService.generateMonthlyPayslip(name, yearlyIncome);
        assertThat(payslip).isNotNull();
        assertThat(payslip.getMonthlyIncomeTax()).isEqualTo(0);
    }
}
