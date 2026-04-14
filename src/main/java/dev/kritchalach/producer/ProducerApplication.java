package dev.kritchalach.producer;

import dev.kritchalach.producer.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Scanner;

@SpringBootApplication
public class ProducerApplication {

    private static final Logger log = LoggerFactory.getLogger(ProducerApplication.class);

    public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

    @Autowired
    ProjectService projectService;

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> template) throws Exception{
        log.info("Let us know about any of your Project Release the form below.");
        Scanner sc = new Scanner(System.in);

        log.info("Enter your projectCode: ");
        String projectCode = sc.nextLine();

        log.info("Enter your sale Team Lead: ");
        String saleTeamLead = sc.nextLine();

        log.info("Enter your starting price unit(square metre): ");
        String startingPriceUnit = sc.nextLine();

        log.info("Enter your marketing cost: ");
        String marketingCost = sc.nextLine();

        String project = projectService.getProject(projectCode,"RELEASE",saleTeamLead, Integer.parseInt(startingPriceUnit) , Integer.parseInt(marketingCost) );
        return args -> {
            template.send("project.release.create-topic", project);
        };
    }
}
