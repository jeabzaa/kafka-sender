package dev.kritchalach.producer.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kritchalach.producer.model.Project;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    public String getProject(String projectCode, String action,String saleTeamLead, Integer startingPriceUnit, Integer marketingCost) throws Exception {
        Project project = new Project(projectCode, action, saleTeamLead, startingPriceUnit, marketingCost);
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

