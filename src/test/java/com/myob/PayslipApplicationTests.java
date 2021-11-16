package com.myob;

import com.myob.service.PayslipService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PayslipApplication.class},
        initializers = ConfigDataApplicationContextInitializer.class)
class PayslipApplicationTests {

    @Autowired
    private PayslipService payslipService;

    @Test
    void contextLoads() {
        assertThat(payslipService).isNotNull();
        payslipService.generateMonthlyPayslip("sonal", 10000);
    }

}
