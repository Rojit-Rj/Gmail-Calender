package demo;

import java.util.concurrent.TimeUnit;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases() 
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().browserVersion("123.0.6312.123").setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://calendar.google.com/");
        Thread.sleep(5000);
        if(driver.getCurrentUrl().contains("calendar"))
        System.out.println("The URL contains the Keyword 'calender' in it");
        else
        System.out.println("The URL Does not contains the Keyword 'calender' in it");
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException
{
    System.out.println("Start Test case: testCase02");
    driver.get("https://calendar.google.com/");
    Thread.sleep(5000);

    WebElement dropdownbutton=driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb']/following-sibling::span)[5]"));
    dropdownbutton.click();
    Thread.sleep(1000);
    
    //making a list of dropdown, iterating each and clicking when we encounter month
    List <WebElement> dropdownlist = driver.findElements(By.xpath("//li[@class='OwNvm VfPpkd-StrnGf-rymPhb-ibnC6b']"));
    for(WebElement mon: dropdownlist){
        if(mon.getText().contains("Month"))
        {
        mon.click();
        break;
        }
    }
        
    WebElement Date=driver.findElement(By.xpath("//div[@class='kbf0gd']/div[3]/div/div[5]"));
    Date.click();
    Thread.sleep(1000);


    WebElement taskButton=driver.findElement(By.xpath("//div[@jsname='SF0uGd']//div[3]/div[1]/button[2]/div[text()='Task']"));
    taskButton.click();
    Thread.sleep(1000);
    
    WebElement Title=driver.findElement(By.xpath("//div[@jsname='SF0uGd']//input[@aria-label='Add title and time']"));
    Title.click();
    Title.sendKeys("Crio INTV Task Automation");

    WebElement Descrption=driver.findElement(By.xpath("//div[@jsname='SF0uGd']//textarea[@aria-label='Add description']"));
    Descrption.click();
    Descrption.sendKeys("Crio INTV Calendar Task Automation");

    WebElement saveButts=driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']"));
    saveButts.click();
    Thread.sleep(1000);
    
}

public void testCase03() throws InterruptedException
{
    System.out.println("Start Test case: testCase03");
    driver.get("https://calendar.google.com/");
    Thread.sleep(5000);

       
        
    WebElement CRYIODate=driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation']"));
    CRYIODate.click();
    Thread.sleep(1000);



    WebElement Editbutt=driver.findElement(By.xpath("(//span[@class='VfPpkd-kBDsod meh4fc KU3dEf'])[3]"));
    Editbutt.click();
    Thread.sleep(1000);
    
    WebElement Title=driver.findElement(By.xpath("(//label[@jsname='vhZMvf'])[2]/child::span[1]/following-sibling::input"));
    Title.click();
    Thread.sleep(1000);
    Title.clear();
    Thread.sleep(1000);
    Title.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");

    WebElement saveButt=driver.findElement(By.xpath("//span[text()='Save']"));
    Actions act = new Actions(driver);
    act.moveToElement(saveButt).perform();    
    act.click().perform();
    Thread.sleep(1000);

    WebElement updatedtask=driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application']"));
    //updatedtask.click();
    Thread.sleep(1000);

    if(updatedtask.getText().contains("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application"))
    System.out.println("the Task is updated sucessfully");
    else
    System.out.println("the Task is NOT updated sucessfully");   
       
}


public void testCase04() throws InterruptedException
{
    System.out.println("Start Test case: testCase04");
    driver.get("https://calendar.google.com/");
    Thread.sleep(5000);

       
        
    WebElement CRYioTaskDate=driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application']"));
    CRYioTaskDate.click();
    Thread.sleep(1000);
   
    // WebElement updatedTitle=driver.findElement(By.xpath("//span[text()='Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application']"));
    // Thread.sleep(1000);

    WebElement deleteBtn=driver.findElement(By.xpath("(//button[@class='VfPpkd-Bz112c-LgbsSe yHy1rc eT1oJ mN1ivc m2yD4b HfYfLe'])[2]"));
    // Actions Dbutt = new Actions(driver);
    // Dbutt.moveToElement(deleteBtn).perform();    
    // Dbutt.click().perform();
    // Thread.sleep(1000);   
    deleteBtn.click();
    Thread.sleep(1000);

    WebElement taskDeletedAlert=driver.findElement(By.xpath("//div[@class='VYTiVb']"));
    String eventMessage = taskDeletedAlert.getText();
    System.out.println(eventMessage);
    if(eventMessage.contains("Task deleted"))
    System.out.println("Task deleted Alert is displayed");
    else
    System.out.println("Task deleted Alert failed to appear");   
       
}
}
