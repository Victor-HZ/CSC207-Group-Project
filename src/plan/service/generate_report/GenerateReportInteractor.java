package plan.service.generate_report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;
import plan.entity.weather.Weather;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class GenerateReportInteractor implements GenerateReportInputBoundary {
    private GenerateReportOutputBoundary generateReportPresenter;

    public GenerateReportInteractor(GenerateReportOutputBoundary outputBoundary) {
        this.generateReportPresenter = outputBoundary;
    }

    @Override
    public void execute(GenerateReportInputData inputData) {
        Plan plan = inputData.getPlan();
        ArrayList<Activity> activities = plan.getActivities();
        DayInfo dayInfo = plan.getDayInfo();
        Weather weather = dayInfo.getWeather();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("PlanReport.pdf"));

            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 26, BaseColor.BLACK);
            Font weatherFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 15, BaseColor.BLACK);
            Font activityFont = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 18, BaseColor.PINK);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

            String titleFormat = String.format("Plan for %s", dayInfo.getPlanDate());

            Paragraph title = new Paragraph(titleFormat, titleFont);
            document.add(title);

            String weatherBody1;
            String weatherBody2;
            try {
                weather.setWeather(dayInfo, plan.getAddress());
                weatherBody1 = weather.getTemp();
                weatherBody2 = weather.getRain();
            } catch (IOException e) {
                weatherBody1 = "[Weather not available for this date]";
                weatherBody2 = "[Weather not available for this date]";
            }

            String weatherFormat = String.format("Average Temperature: %1$s\nRain: %2$s", weatherBody1, weatherBody2);
            Paragraph weatherText = new Paragraph(weatherFormat, weatherFont);
            document.add(weatherText);

            System.out.println(activities);
            for (Activity activity : activities) {
                Paragraph activityTitle = new Paragraph(activity.getName(), activityFont);
                document.add(activityTitle);

                String description;
                if (activity.getDescription() == null) {
                    description = "No description available.";
                } else {
                    description = activity.getDescription();
                }

                String body = String.format("%1$s\nCost: $%2$s",
                        description,
                        activity.getCost().toString());
                Paragraph activityText = new Paragraph(body, textFont);
                document.add(activityText);
            }

            document.close();
            generateReportPresenter.prepareSuccessView();
        } catch (FileNotFoundException e) {
            generateReportPresenter.prepareFailView("Unable to create PDF.");
        } catch (DocumentException f) {
            generateReportPresenter.prepareFailView("Error while generating PDF.");
        }
    }
}

