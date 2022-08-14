package ali.com.transactionlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TransactionLogApplication {
    public static void main(String[] args) {
		SpringApplication.run(TransactionLogApplication.class, args);
	}
}
