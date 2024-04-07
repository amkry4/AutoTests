import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.example.Main.getSum;
import static org.testng.Assert.assertEquals;

public class MainTest {

    @Test
    public void testGetSum(){

//        System.out.println(getSum(0,0) == 0);
//        System.out.println(getSum(5,5) == 10);
//        System.out.println(getSum(100_000_000,100000000) == 200000000);
//        System.out.println(getSum(-5,-5) == -10);

        assertEquals(getSum(0,0),0 );
        assertEquals(getSum(5,5),10);
        assertEquals(getSum(100000000,100000000),200000000);
        assertEquals(getSum(-5,-5),-10);
    }
    @Test
    public void eightComponents() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        String value = message.getText();
        assertEquals("Received!", value);

        driver.quit();

    }


    @Test
    public void testGoogle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
//            WebDriver driver = getDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        WebElement text = driver.findElement(By.id("APjFqb"));
        text.sendKeys("Selenium");

        Thread.sleep(1000);

        WebElement button = driver.findElement(By.className("gNO89b"));
        button.click();

        WebElement link = driver.findElement(By.xpath("//a[@href = 'https://www.selenium.dev/']/h3"));
        String resultText = link.getText();

        Assert.assertEquals(resultText, "Selenium");
        driver.quit();

    }
    @Test
    public void testCalculator(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.eviltester.com/styled/index.html");

        WebElement link = driver.findElement(By.id("calculatetest"));
        link.click();

        WebElement textBox1 = driver.findElement(By.id("number1"));
        textBox1.sendKeys("5");
        WebElement textBox2 = driver.findElement(By.id("number2"));
        textBox2.sendKeys("5");
        WebElement button = driver.findElement(By.id("calculate"));
        button.click();
        WebElement result = driver.findElement(By.id("answer"));
        Assert.assertEquals(result.getText(), "10");

        driver.quit();

    }
    @Test
    public void sauceTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");

        WebElement userName = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("login-button"));

        userName.sendKeys("problem_user");
        password.sendKeys("secret_sauce");
        submitButton.click();

        String message = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(message,"Products" );

        driver.quit();
    }

}
