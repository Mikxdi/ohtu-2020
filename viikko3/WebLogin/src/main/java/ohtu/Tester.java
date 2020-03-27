package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Random r = new Random();
        driver.get("http://localhost:4567");
        
        sleep(2);


        WebElement element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("vaara");
        element = driver.findElement(By.name("login"));
        element.submit();

        element = driver.findElement(By.linkText("back to home"));
        element.click();
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("arto"+r.nextInt(100000));
        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");
        element = driver.findElement(By.name("signup"));
        element.submit();


        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        element = driver.findElement(By.linkText("logout"));
        element.click();
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
