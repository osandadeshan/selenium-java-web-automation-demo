package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static util.PropertyFileReader.getProperty;
import static util.driver.DriverHolder.getDriver;

public class ExtentReportListener implements ITestListener {

    private static final String fileSeparator = File.separator;
    private ExtentReports extent;
    private ExtentTest test;
    private static final String extentReportDirectory = System.getProperty("user.dir") + fileSeparator + "reports" +
            fileSeparator + "html-report";
    private static final String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());

    @Override
    public void onStart(ITestContext iTestContext) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(extentReportDirectory + fileSeparator +
                "Execution Results - " + timestamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        if (getProperty("extent_reporter_theme").toLowerCase().equals("dark"))
            htmlReporter.config().setTheme(Theme.DARK);
        else
            htmlReporter.config().setTheme(Theme.STANDARD);

        htmlReporter.config().setDocumentTitle(getProperty("extent_document_title"));
        htmlReporter.config().setReportName(getProperty("extent_reporter_name"));

        extent.setSystemInfo("Application Name", getProperty("application_name"));
        extent.setSystemInfo("Environment", getProperty("environment"));
        extent.setSystemInfo("Browser", getProperty("browser"));
        extent.setSystemInfo("Operating System", getProperty("operating_system"));
        extent.setSystemInfo("Test Developer", getProperty("test_developer"));
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        test = extent.createTest(iTestResult.getName(), iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        test.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.RED));
        test.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getThrowable().getMessage(), ExtentColor.RED));
        test.log(Status.FAIL, MarkupHelper.createLabel(Arrays.toString(iTestResult.getThrowable().getStackTrace()), ExtentColor.RED));
        try {
            test.fail("Screenshot at the failed moment is below.");
            test.addScreenCaptureFromPath(takeScreenshot(iTestResult.getName()), iTestResult.getMethod().getMethodName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        test.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName(), ExtentColor.GREY));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        extent.flush();
    }

    private static String takeScreenshot(String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String destination = extentReportDirectory + fileSeparator + "screenshots" + fileSeparator +
                screenshotName + " - " + timestamp + ".png";
        String relativePath = "screenshots" + fileSeparator + screenshotName + " - " + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativePath;
    }
}
