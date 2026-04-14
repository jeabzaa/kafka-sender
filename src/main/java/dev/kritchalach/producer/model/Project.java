package dev.kritchalach.producer.model;


import org.apache.kafka.common.protocol.types.Field;

public class Project {
    private String projectCode;
    private String action;
    private String saleTeamLead;
    private Integer startingPriceUnit;
    private Integer marketingCost;

    public Project(String projectCode, String action, String saleTeamLead, Integer startingPriceUnit, Integer marketingCost){
        this.projectCode = projectCode;
        this.action = action;
        this.saleTeamLead = saleTeamLead;
        this.startingPriceUnit = startingPriceUnit;
        this.marketingCost = marketingCost;
    }

    public void setProjectCode(String projectCode) { this.projectCode = projectCode; }
    public String getProjectCode() { return this.projectCode; }
    public String getActon() { return this.action; }
    public void setAction(String action) { this.action = action; }
    public String getSaleTeamLead() { return this.saleTeamLead; }
    public void setSaleTeamLead( String saleTeamLead) { this.saleTeamLead = saleTeamLead; }
    public Integer getStartingPriceUnit(){ return this.startingPriceUnit; }
    public void setStartingPriceUnit(Integer startingPriceUnit) { this.startingPriceUnit = startingPriceUnit;}
    public Integer getMarketingCost(){ return this.marketingCost; }
    public void setMarketingCost(Integer marketingCost) { this.marketingCost = marketingCost; }
    @Override
    public String toString(){
        return "Project[name="+this.projectCode+",action="+this.action+",saleTeam="+this.saleTeamLead+",startingPriceUnit="+this.startingPriceUnit+",marketingCost="+this.marketingCost+"]";
    }
}
