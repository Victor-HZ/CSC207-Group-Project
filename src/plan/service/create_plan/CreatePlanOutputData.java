package plan.service.create_plan;

public class CreatePlanOutputData {
    private String creationTime;
    private boolean useCaseFailed;
    public CreatePlanOutputData(String creationTime, boolean useCaseFailed){
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }
}
