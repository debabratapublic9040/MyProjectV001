package pageObjects;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassLocal {
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups={"Saity","Regresson","Smoke","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException
	{
		
		FileReader file=new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
	
		logger=LogManager.getLogger(this.getClass());
		logger.info("***Open Browser***");
		switch(br.toLowerCase())
		{
		case "chrome":driver=new ChromeDriver();break;
		case "edge":driver=new EdgeDriver();break;
		case "safari":driver=new SafariDriver();break;
		case "firefox":driver=new FirefoxDriver();break;
		default:System.out.println("***Invalid browser***");return;
		}
		
		logger.info("***Delete All Cookies***");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("***Launch the URL***");
		driver.get(p.getProperty("appurl"));
		logger.info("***Maximize the browser window***");
		driver.manage().window().maximize();
	}
	@AfterClass(groups={"Saity","Regresson","Smoke","Master"})
	public void tearDown()
	{
		logger.info("***Close the browser***");
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		TakesScreenshot takesScreenshot= (TakesScreenshot)driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);//get path
		String targetFilePath =System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetfile=new File(targetFilePath);
		sourceFile.renameTo(targetfile);
		return targetFilePath;
	}

}
