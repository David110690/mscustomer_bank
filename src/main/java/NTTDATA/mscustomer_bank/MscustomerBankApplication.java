package NTTDATA.mscustomer_bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MscustomerBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscustomerBankApplication.class, args);
	}

}
