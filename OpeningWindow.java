package task11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpeningWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		String ParentAdd = driver.getWindowHandle();
		System.out.println("Parent window address: " + ParentAdd);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// set window handles
		Set<String> WindowHandles = driver.getWindowHandles();

		// Convert set to list
		List<String> firststWindow = new ArrayList<String>(WindowHandles);

		// Pick the particular window and switch to it
		driver.switchTo().window(firststWindow.get(1));
		System.out.println("Current Window address: " + driver.getWindowHandle());

		// get the text from the child window
		WebElement ele = driver.findElement(By.xpath("//div/h3"));
		String newWin = ele.getText();
		System.out.println("Window text is: " + newWin);
		if (newWin.equalsIgnoreCase("New Window"))
			System.out.println("New Window is present on the page");
		else
			System.out.println("New Window is not present on the page");
		driver.close();

		driver.switchTo().window(firststWindow.get(0));
		System.out.println(driver.getWindowHandle());
		String CurWinAdd = driver.getWindowHandle();
		if (ParentAdd.equals(CurWinAdd)) {
			System.out.println("Current window is active");
		} else {
			System.out.println("Current window is not active");
		}
		driver.close();
	}

}
/*
 * Output:
 * 
 * Parent window address: F1FE26BA08F4223BA15C9CB5A774112D Current Window
 * address: 2BC25568155EF481352EF94C3A0A9B28 Window text is: New Window New
 * Window is present on the page F1FE26BA08F4223BA15C9CB5A774112D Current window
 * is active
 */