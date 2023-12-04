package plan.service.save_plan;

import plan.entity.activity.Activity;
import user.entity.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SavePlanInteractor implements SavePlanInputBoundary{
    final SavePlanOutputBoundary savePlanPresenter;
    public SavePlanInteractor(SavePlanOutputBoundary savePlanPresenter) {
        this.savePlanPresenter = savePlanPresenter;
    }
    @Override
    public void execute(SavePlanInputData savePlanInputData) {
        // First adding the plan to the user
        User user = savePlanInputData.getCommonUser();
        user.updatePlan(savePlanInputData.getPlan());

        // Calling csv file editor method

    }

    public void writeCSV(SavePlanInputData savePlanInputData) {
        String name = savePlanInputData.getCommonUser().getName();
        String password = savePlanInputData.getCommonUser().getPassword();
        String user = String.format("%s, %s", name, password);

        String path = savePlanInputData.getFilePath();

        String cost = String.format("%f", savePlanInputData.getPlan().getCost());
        String dayInfo = savePlanInputData.getPlan().getDayInfo().stringInfo();

        ArrayList<Activity> activities = savePlanInputData.getPlan().getActivities();

        /*
        CSV file format will be:
        username, password
        plan cost
        plan day info
        however many activities until no more lines
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(user);
            writer.newLine();
            writer.write(cost);
            writer.newLine();
            writer.write(dayInfo);
            for (Activity i: activities) {
                writer.write(i.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
