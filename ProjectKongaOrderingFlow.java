import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class ProjectKongaOrderingFlow {

    //Import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    private void Setup() {

        //Locate chrome driver
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");

    }

    @Test (priority = 0)
    private void visitUrl() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        //1. Open chrome driver
        driver = new ChromeDriver(options);

        //2. Visit url https://www.konga.com/
        driver.get("https://www.konga.com");

        //Test Case 1: Confirm that the url leads to the right page
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("Url opens the Konga webpage: Case Passed");
        else
            //Fail
            System.out.println("Url does not open the Konga webpage: Case Failed");

        //3. Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(4000);

    }

    @Test (priority = 1)
    private void Signin() throws InterruptedException {
        //4. Click on the Signin botton
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(4000);

       //Test Case 2 Confrim that the button takes you to the Signin page
        String expectedXpath = "//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5";
        String actualXpath = String.valueOf(driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[1]/div/h5")));
        if (actualXpath.contains(expectedXpath))
            //Pass
            System.out.println("Button takes you to the signin page");
        else
            //Fail
            System.out.println("Button does not take you to the signin page");

    }
    @Test (priority = 2)
    private void postivelogin() throws InterruptedException {
        //5. Input email
        driver.findElement(By.id("username")).sendKeys("moluwaseun081@gmail.com");

        //6. Input password
        driver.findElement(By.id("password")).sendKeys("Owodunni90");

        //7. Click on login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(4000);

        //Test Case 3. Verify that you can login succefully with valid ID
        String expectedProfile = "//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span";
        String actualProfile = String.valueOf(driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span")));
        if (actualProfile.contains(expectedProfile))
            //Pass
            System.out.println("User login successfuly");
        else
            //Fail
            System.out.println("User does not login successfully");

    }
    @Test (priority = 3)
    private void ComputerAccessories() throws InterruptedException {
        //8. click on the "Computers and Accessories
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[3]/nav/div[2]/div[2]/div/a[2]")).click();
        Thread.sleep(4000);

        //Test Case 4. Confrim that the button opens the Computer and Accessories page
        String expectedUrl = "https://www.konga.com/category/accessories-computing-5227";
        String actualUrl = String.valueOf(driver.getCurrentUrl());
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Computer and accessories opens");
        else
            //Fail
            System.out.println("Computer does not open");

        //9. Click on Laptop SubCategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(4000);

        //10. Click on the Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label")).click();
        Thread.sleep(4000);

    }

    @Test (priority = 4)
            private void addtocart() throws InterruptedException {
        //11. Add item to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[5]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(4000);

        //Test Case 5. Confrim that an item was added on the cart
        String expectedcartresult = "//*[@id=\"app-content-wrapper\"]/div[1]";
        String actualcartresult = String.valueOf(driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[1]")));
        if (actualcartresult.contains(expectedcartresult))
            //Pass
            System.out.println("Item was added to cart");
        else
            //Fail
            System.out.println("Item was not added to cart");

        //12. Click on my cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]")).click();
        Thread.sleep(10000);

        //13. Click on check out
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(10000);

        //14. Add adrress
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(10000);

        //15. Click on 'Pay Now' button
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);

        //16. Continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(7000);

        //17. Open and establsih string on the modal page
        String modal = "kpg-frame-component";
        String cardPaymentBtn = "//*[@id=\"channel-template\"]/div[2]/div/div[2]/button";   //Set the card payment button xpath to be = cardPaymentBtn

        //18. Allow modal page to wait for interaction
        Duration timeout = Duration.ofSeconds(50);
        WebDriverWait wait = new WebDriverWait(driver, timeout);

        //19. Allow modal page to switch for interaction
        WebElement modalIFrame = driver.findElement(By.id(modal));
        driver.switchTo().frame(modalIFrame);

        //20. on the modal Click on the 'Card' button
        WebElement CardOption = driver.findElement(By.xpath(cardPaymentBtn));
        CardOption.click();
        Thread.sleep(5000);
    }

    @Test (priority = 5)
    private  void PaymentCardDetails() throws InterruptedException {

        //21. Input the payment card number to allow for the transaction
        driver.findElement(By.id("card-number")).sendKeys("123456789");

        //22. Input the expiry date on the payment card to allow for the transaction
        driver.findElement(By.id("expiry")).sendKeys("1222");

        //23. Input the cvv on the payment card to allow for the transaction
        driver.findElement(By.id("cvv")).sendKeys("987");

        Thread.sleep(5000);

        //24. Click on pay now button to allow for payment to be made
        driver.findElement(By.id("validateCardForm")).click();

        Thread.sleep(3000);

        //25. Print the error code response
        String errorCode = driver.findElement(By.id("card-number_unhappy")).getText();
        System.out.println(errorCode);

    }


    @Test(priority = 6)
    private void iframemodal() throws InterruptedException {

        //26. Close the iFrame
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

        //TEST CASE6: Verify that closing the card details i-Frame takes user back to the order page
        if (driver.getCurrentUrl().contains("https://www.konga.com/checkout/complete-order"))
            //Pass
            System.out.println("iFrame Closed");
        else
            //Fail
            System.out.println("iFrame Failed to Close");

        Thread.sleep(5000);

    }

    @AfterTest
    private void exitBrowser() {

        //27. Quit chrome browser
        driver.quit();
    }



}
