package plan.service.generate_report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import plan.entity.activity.Activity;
import plan.entity.day_info.DayInfo;
import plan.entity.plan.Plan;
import plan.entity.weather.Weather;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;


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
        Weather weather = dayInfo.getWeather();;

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("PlanReport.pdf"));

            document.open();
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 26, BaseColor.BLUE);
            Font weatherFont = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 20, BaseColor.BLACK);
            Font activityFont = FontFactory.getFont(FontFactory.HELVETICA, 20, BaseColor.GREEN);
            Font textFont = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);

            String titleFormat = String.format("Plan for %s", dayInfo.getPlanDate());

            Paragraph title = new Paragraph(titleFormat);
            title.setFont(titleFont);
            document.add(title);

            String weatherFormat = String.format("Weather: %s", weather.toString());

            Paragraph weatherText = new Paragraph(weatherFormat);
            weatherText.setFont(weatherFont);
            document.add(weatherText);

            for (Activity activity : activities) {
                Paragraph activityTitle = new Paragraph(activity.getName());
                activityTitle.setFont(activityFont);
                document.add(activityTitle);

                String body = String.format("Address: %1$s\n%2$s\nCost: %3$s",
                        activity.getAddress().getAddressText(),
                        activity.getDescription(),
                        activity.getCost().toString());
                Paragraph activityText = new Paragraph(body);
                activityText.setFont(textFont);
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

