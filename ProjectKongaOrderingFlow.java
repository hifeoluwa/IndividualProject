import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
 *1. Visit the URL https://www.konga.com/
 // Confirm that the url leads to the right page
 *2. Sign in to https://www.konga.com/ successfully
 // Confrim that the button takes you to the Signin page
 // Verify that you can login succefully with valid ID
 *3. From the Categories, click on the "Computers and Accessories"
 // Confrim that the button opens the Computer and Accessories page
 *4. Click on the Laptop SubCategory
 *5. Click on the Apple MacBooks
 *6. Add an item to the cart
 //Confrim that an item was added on the cart
 *7. Select Address
 *8. Continue to make payment
 // Verify that the button takes you to the payement page
 *9. Select a Card Payment Method
 // Confrim that the button takes you to the Signin page
 *10. Input invalid card details
 *11. Print Out the error message: Invalid card number
 *12. Close the iFrame that displays the input card Modal
 *13. Quit the browser.
 *
 */
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
        Thread.sleep(4000);

        //13. Click on check out
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(4000);

        //14. Add adrress
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(4000);

    }

    @AfterTest
    private void exitBrowser() {

        //15. Quit chrome browser
        driver.quit();
    }



}
