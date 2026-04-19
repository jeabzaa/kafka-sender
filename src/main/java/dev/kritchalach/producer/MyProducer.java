package dev.kritchalach.producer;

import dev.kritchalach.producer.service.ProjectService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

	@Autowired
	ProjectService projectService;

	private static final Logger log = LogManager.getLogger(SpringBootApplication.class);
	private final KafkaTemplate<String, String> kafkaTemplate;

	public MyProducer(KafkaTemplate<String, String> kafkaTemplate) throws Exception{
		this.kafkaTemplate = kafkaTemplate;
		try{
			String project = projectService.getProject("000","DEFAULT","DEFAULT", 0 , 0 , "0000-000-00");
			this.kafkaTemplate.send("project.release.create-topic", project);
		}catch (Exception ex){
			log.info(ex.getMessage());
		}
	}
}














