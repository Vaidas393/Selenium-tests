package Utils;

import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Utils {

	public Utils() {

	}

	public String generateName(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public String generateDescription(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}

	public String generateSeverity(int min, int max) {
		Random r = new Random();
		int a = r.nextInt((max - min) + 1) + min;
		return Integer.toString(a);
	}

	public String status() {
		return "Active";
	}

	public String getUsername() {
		String username = "vaidas393@gmail.com";
		return username;
	}

	public String getUrl() {
		String url = "http://www.qaontime.com/register";
		return "";
	}

}
