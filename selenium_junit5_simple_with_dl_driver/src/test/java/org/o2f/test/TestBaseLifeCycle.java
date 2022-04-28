package org.o2f.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.o2f.configuration.BaseConfigModel;
import org.o2f.configuration.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.util.Locale;

@Slf4j
public class TestBaseLifeCycle {

    public static ExtentReports reports;

    public static BaseConfigModel config;

    public static WebDriver driver;

    @BeforeAll
    public static void baseSetup(){

        //Unwrap config from the BaseTestConfig
        config = BaseTestConfig.getTestConfig();

        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(config.getReportConfigModel().getReportPath());
        reports.attachReporter(spark);

        log.info(String.format("Using the Base URL: %s",config.getBaseUrl()));
        log.info(String.format("Using the Browser URL: %s",config.getBrowser().toUpperCase(Locale.ROOT)));

        driver = new DriverFactory(config.getBrowser()).getDriver();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }

    protected void reporter(@NonNull TestInfo testInfo){

        reports.createTest(testInfo.getDisplayName()).log(Status.PASS,"PASSED");
        reports.flush();
    }

    protected void reporter(@NonNull TestInfo testInfo, Status status, @NonNull String error){
        reports.createTest(testInfo.getDisplayName()).log(status,error.replace("\n"," "));
        reports.flush();
    }
}
