package Twarita.AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileDownload {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
WebDriver driver = new ChromeDriver();
driver.get("https://www.ilovepdf.com/pdf_to_jpg");

driver.findElement(By.id("pickfiles")).click();
Thread.sleep(3000);
Runtime.getRuntime().exec("C:\\Users\\twari\\Repositories\\AutoITFiles\\FileUploadScript.exe");

driver.quit();

	}

}
