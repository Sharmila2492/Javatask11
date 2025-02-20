package task11;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {

		WebDriver drive = new ChromeDriver();
		drive.navigate().to("http://the-internet.herokuapp.com/nested_frames");
		drive.manage().window().maximize();
		drive.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Switch to the top frame
		drive.switchTo().frame("frame-top");
		List<WebElement> iframes = drive.findElements(By.tagName("frame"));
		// Get the size inside the top frame
		int size = iframes.size();
		System.out.println("Print the no. of frames in Top frame: " + size);

		// Switch to the left frame
		drive.switchTo().frame("frame-left");
		WebElement ele = drive.findElement(By.tagName("body"));
		// Get the text from the left frame
		String txt = ele.getText();
		System.out.println("Print the Left text: " + txt);
		// Switch to the top frame
		drive.switchTo().parentFrame();
		// switch to the middle frame
		drive.switchTo().frame("frame-middle");
		WebElement ele1 = drive.findElement(By.xpath("//div[@id='content']"));
		// Get the text from the middle frame
		String txt1 = ele1.getText();
		System.out.println("Print the Middle text: " + txt1);
		drive.switchTo().parentFrame();
		// Switch to the right frame
		drive.switchTo().frame("frame-right");
		System.out.println("Print the right text: " + drive.findElement(By.tagName("body")).getText());
		drive.switchTo().defaultContent();
		// switch to the bottom frame
		drive.switchTo().frame("frame-bottom");
		System.out.println("Print the bottom text: " + drive.findElement(By.tagName("body")).getText());
		drive.switchTo().defaultContent();
		drive.switchTo().frame("frame-top");

	}
}
/*
 * Output: Print the no. of frames in Top frame: 3 Print the Left text: LEFT
 * Print the Middle text: MIDDLE Print the right text: RIGHT Print the bottom
 * text: BOTTOM
 */
