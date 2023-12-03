package plan.service.save_plan;

import java.io.File;

public class SavePlanOutputData {
    private final File csvFile;
    private final boolean useCaseFailed;
    private String creationTime;

    public SavePlanOutputData(File csvFile, boolean useCaseFailed, String creationTime){
        this.csvFile = csvFile;
        this.useCaseFailed = useCaseFailed;
        this.creationTime = creationTime;
    }

    public File getCsvFile(){
        return this.csvFile;
    }

    public void setCreationTime(String creationTime){
        this.creationTime = creationTime;
    }

    public String getCreationTime(){
        return this.creationTime;
    }
}
