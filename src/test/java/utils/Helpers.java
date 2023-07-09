package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Helpers {
    public static Properties properties = new Properties();
    public static Properties getConfigData() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/ConfigData.properties");
        properties.load(fileInputStream);
        return properties;
    }

    // Method to take screenshot after every method
//    public static void captureScreenshot(WebDriver driver , String screenshotname)
//    {
//        Path dest = Paths.get("./ScreenShots",screenshotname+".png");
//        try {
//            Files.createDirectories(dest.getParent());
//            FileOutputStream out = new FileOutputStream(dest.toString());
//            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
//            out.close();
//        } catch (IOException e) {
//            System.out.println("Excpetion while taking screenshot"+ e.getMessage());
//        }
//    }
}
