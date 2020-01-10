import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

public class foodtest {

    @Test
    public void loginAndPrint() {
        Configuration.startMaximized = true;
        open("https://imperialfood.com.ua/iEmployee/#!menu");
        $(By.xpath("(//input[@type=\"text\"])[2]")).setValue("3880034001");
        $(By.xpath("//input[@type='password']")).setValue("3880034001");
        $(By.xpath("(//div[@role='button'])[2]")).click();

        System.out.println("was entered");
        Date date1 = new Date();
        SimpleDateFormat form1 = new SimpleDateFormat("EEEE");
        String day = form1.format(date1);
        String Capital =  day.substring(0,1).toUpperCase() + day.substring(1).toLowerCase();
        WebElement dayTab =  $(By.xpath("//*[contains(text(), '" + Capital + "')]"));
        $(dayTab).waitUntil(visible, 60*1000).click();
        $(By.xpath("//div[@class=\"v-loading-indicator second v-loading-indicator-delay\"]")).waitUntil(disabled, 10*1000);
        WebElement otchet =  $(By.xpath("//span[contains(text(), 'Отчёты')]/../../../../.."));
        otchet.click();
        $(By.xpath("//div[@class=\"v-loading-indicator second v-loading-indicator-delay\"]")).waitUntil(disabled, 10*1000);

        $(By.xpath("(//span[@class=\"v-button-caption\"])[2]/../..")).waitUntil(visible, 3*60*1000).click();
        $(By.xpath("//div[@class=\"v-loading-indicator second v-loading-indicator-delay\"]")).waitUntil(disabled, 10*1000);
//        try {
//            Thread.sleep(5*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("End");

    }


}
