package Test_1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Learn1 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Thread.sleep(3000);
		driver.get("https://pib.gov.in/");
		Thread.sleep(3000);
		Robot R = new Robot();
		R.keyPress(KeyEvent.VK_TAB);Thread.sleep(1000);
		R.keyPress(KeyEvent.VK_ENTER);Thread.sleep(1000);
		R.keyRelease(KeyEvent.VK_TAB);Thread.sleep(1000);
		WebElement Link = driver.findElement(By.linkText("Ministry of Education"));
		Actions a = new Actions(driver);
		a.scrollToElement(Link).perform();          
		Link.click();
		driver.switchTo().alert().accept();
		
		Set<String> S = driver.getWindowHandles();
		Iterator<String> I = S.iterator();
		String Parent_id= I.next();
		String Child_id=I.next();
		driver.switchTo().window(Child_id);Thread.sleep(2000);
		System.out.println("The Tittle of Child Window :"+""+driver.getTitle());Thread.sleep(2000);
		driver.switchTo().window(Parent_id);Thread.sleep(2000);
		driver.close();
		Thread.sleep(2000);
	    driver.quit();
		

	}

}
