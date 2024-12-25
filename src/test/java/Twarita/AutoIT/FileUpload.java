package Twarita.AutoIT;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
String downloadPath = System.getProperty("user.dir")+"\\FilesForUploadAndDownload";
HashMap<String, Object> chromePrefs = new HashMap<>();
chromePrefs.put("download.default_directory", downloadPath);

ChromeOptions options = new ChromeOptions();
options.setExperimentalOption("prefs", chromePrefs);

		
WebDriver driver = new ChromeDriver(options);
WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));


driver.get("https://www.ilovepdf.com/pdf_to_jpg");

driver.findElement(By.id("pickfiles")).click();
Thread.sleep(3000);

//Upload
Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\FileUploadScript - Copy.exe");


//Download
eWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
driver.findElement(By.id("processTask")).click();
eWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
driver.findElement(By.id("pickfiles")).click();
Thread.sleep(5000);

//Verify File Downloaded
File f = new File(downloadPath+"\\Test File_page-0001.jpg");

if(f.exists()) System.out.println("File exists");
if(f.delete()) System.out.println("File Deleted");;


driver.quit();

	}

}
