import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class CaptchaReader {

    public static String readCaptcha(WebDriver driver, WebElement captchaElement) {
        try {

            File screenshot = captchaElement.getScreenshotAs(OutputType.FILE);

            String screenshotPath = "captcha_screenshot.png";
            FileHandler.copy(screenshot, new File(screenshotPath));

            Tesseract tesseract = new Tesseract();

            tesseract.setDatapath("lib/tessdata");
            tesseract.setLanguage("eng");

            String result = tesseract.doOCR(new File(screenshotPath));

            return cleanCaptchaText(result);

        } catch (TesseractException | IOException e) {
            System.out.println("CAPTCHA read error: " + e.getMessage());
            return "";
        }
    }

    private static String cleanCaptchaText(String text) {

        return text.replaceAll("\\s+", "")
                .replaceAll("[^a-zA-Z0-9]", "")
                .trim();
    }
}