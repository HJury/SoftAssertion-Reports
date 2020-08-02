package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;


public class ExtentSetup {
    private static ExtentReports extent;

    public static ExtentReports setupExtentReport() {
        String directory = System.getProperty("user.dir") + "/report/";
        new File(directory).mkdirs();
        ExtentHtmlReporter sparkReporter = new ExtentHtmlReporter(directory + "report.htlm");


        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle("Title");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("First Report");

        return extent;
    }
}
