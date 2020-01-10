import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
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
        SimpleDateFormat form1 = new SimpleDateFormat("dd.MM.yyyy");
        String day = form1.format(date1);
//        String Capital =  day.substring(0,1).toUpperCase() + day.substring(1).toLowerCase();

        WebElement dayTab =  $(By.xpath("//*[text()='" + day + "']"));
        $(dayTab).waitUntil(visible, 60*1000).click();
        System.out.println("was selected" + day + " day");
        waitProgress();
        WebElement otchet =  $(By.xpath("//span[contains(text(), 'Отчёты')]/../../../../.."));
        otchet.click();
        waitProgress();
        $(By.xpath("(//span[@class=\"v-button-caption\"])[2]/../..")).waitUntil(visible, 3*60*1000).click();
        waitProgress();
        $(By.xpath("//div[@class=\"v-loading-indicator second v-loading-indicator-delay\"]")).waitUntil(disabled, 10*1000);





        System.out.println("End");

    }

    public foodtest waitProgress(){
        WebElement progressbar1 = $(By.xpath("//div[@class=\"v-loading-indicator second v-loading-indicator-delay\"]"));
        WebElement progressbar2 = $(By.xpath("//div[@class=\"v-loading-indicator first\"]"));
        if (progressbar1.isDisplayed())
        {
            ((SelenideElement) progressbar1).waitUntil(disabled, 10*1000);
        }
        if (progressbar2.isDisplayed())
        {
            ((SelenideElement) progressbar2).waitUntil(disabled, 10*1000);
        }
        return this;
    }

    //        try {
//            Thread.sleep(5*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

}
