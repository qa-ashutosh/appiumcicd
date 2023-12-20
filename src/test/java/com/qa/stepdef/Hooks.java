package com.qa.stepdef;

import com.qa.pages.BasePage;
import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import com.qa.utils.VideoManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
//        BasePage basePage = new BasePage();
//        basePage.closeApp();
//        basePage.launchApp();

//        GlobalParams globalParams = new GlobalParams();
//        globalParams.initializeGlobalParams();
//        ThreadContext.put("ROUTINGKEY", globalParams.getPlatformName() + "_" + globalParams.getDeviceName());
//        new ServerManager().startServer();
//        new DriverManager().initializeDriver();
        new VideoManager().startRecording();
    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        new VideoManager().stopRecording(scenario.getId());

//        DriverManager driverManager = new DriverManager();
//        if(driverManager.getDriver() != null) {
//            driverManager.getDriver().quit();
//            driverManager.setDriver(null);
//        }
//
//        ServerManager serverManager = new ServerManager();
//        if(serverManager.getServer() != null) serverManager.getServer().stop();
    }
}

