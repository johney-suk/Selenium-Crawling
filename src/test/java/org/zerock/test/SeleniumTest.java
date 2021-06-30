package org.zerock.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTest {

    @Test
    public void testOpen()throws Exception {

        WebDriver driver = new ChromeDriver();

        driver.get("http://gs25.gsretail.com/gscvs/ko/products/event-goods#");

        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,1000)");


        WebElement ele = driver.findElement(By.cssSelector("#TWO_TO_ONE"));

        ele.click();

        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.cssSelector(".prod_list li"));

        list.forEach(webElement -> {
            //System.out.println(webElement);
            WebElement imgEle = webElement.findElement(By.cssSelector("img"));
            System.out.println(imgEle.getAttribute("alt"));
            System.out.println(imgEle.getAttribute("src"));
        });
    }

    @Test
    public void testOpen1() throws Exception{

        WebDriver driver = new ChromeDriver();

        driver.get("https://login.coupang.com/login/login.pang?rtnUrl=https%3A%2F%2Fwww.coupang.com%2Fnp%2Fpost%2Flogin%3Fr%3Dhttps%253A%252F%252Fwww.coupang.com%252F");
        Thread.sleep(3000);

        WebElement eleID = driver.findElement(By.cssSelector("#login-email-input"));

        String userID="아이디";

        eleID.sendKeys(userID);

        String passWord="비밀번호";
        WebElement elePW = driver.findElement(By.cssSelector("#login-password-input"));

        elePW.sendKeys(passWord);

        // 진행중..
//        WebElement elebtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[5]/button"));
        WebElement elebtn1 = driver.findElement(By.xpath("/html/body/div[1]/div/div/form/div[4]/a\n"));


        elebtn1.click();


    }
    @Test
    public void testOpen2() throws Exception{

        WebDriver driver = new ChromeDriver();

        driver.get("https://login.11st.co.kr/auth/front/login.tmall?returnURL=https%3A%2F%2Fwww.11st.co.kr%2F%3Fgclid%3DCj0KCQjw5uWGBhCTARIsAL70sLL2rom5tRMA31PjaFZXaRTZ-0yWoaulFMaVpcegx2n3tgrW5Kj-2kYaAsBTEALw_wcB%26utm_term%3DE_11%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD%26utm_campaign%3D0311%2BPC%2B%25EF%25BF%25BD%25EA%25B7%25A3%25EF%25BF%25BD%25EF%25BF%25BD%2B%25EF%25BF%25BD%25EF%25BF%25BD%25C4%25A1%2B%25C4%25B7%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD%2B%25EF%25BF%25BD%25C5%25B1%25EF%25BF%25BD%2BBO%26utm_source%3D%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD%25EF%25BF%25BD_PC_S%26utm_medium%3D%25EF%25BF%25BD%25CB%25BB%25EF%25BF%25BD%26ts%3D1624866165051");
        Thread.sleep(1000);

        WebElement eleID = driver.findElement(By.cssSelector("#loginName"));

        String userID="11번가 아이디";

        eleID.sendKeys(userID);

        Thread.sleep(2000);

        String passWord="11번가 비밀번호";
        WebElement elePW = driver.findElement(By.cssSelector("#passWord"));

        elePW.sendKeys(passWord);

        Thread.sleep(2000);

        WebElement eleBtn = driver.findElement(By.cssSelector("#loginbutton"));

        eleBtn.click();

    }
}
