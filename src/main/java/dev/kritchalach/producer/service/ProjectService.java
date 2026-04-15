package dev.kritchalach.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kritchalach.producer.model.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ProjectService {
    private static final Logger log = LogManager.getLogger(SpringBootApplication.class);
    public String getProject(String projectCode, String action,String saleTeamLead, Integer startingPriceUnit, Integer marketingCost) throws Exception {
        Project project = new Project(projectCode, action, saleTeamLead, startingPriceUnit, marketingCost, LocalDate.now().toString(), "CMO");
        return this.objectToJson(project);
    }

    private String objectToJson(Project project) throws Exception{
        String jsonStr = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            jsonStr = mapper.writeValueAsString(project);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
}

