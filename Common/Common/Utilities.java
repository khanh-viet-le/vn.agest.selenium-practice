package Common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.stream.Collectors;

import Constants.AppConstant;
import Constants.Timeout;

public class Utilities {
	// #region WebDriver Actions
	@SuppressWarnings("null")
	public static WebElement findElement(By locator) {
		return AppConstant.WEBDRIVER.findElement(locator);
	}

	@SuppressWarnings("null")
	public static List<WebElement> findElements(By locator) {
		return AppConstant.WEBDRIVER.findElements(locator);
	}

	@SuppressWarnings("null")
	public static WebElement findElement(String locator, Object... args) {
		return findElement(By.xpath(String.format(locator, args)));
	}

	@SuppressWarnings("null")
	public static By getLocatorElement(String locator, Object... args) {
		return By.xpath(String.format(locator, args));
	}

	@SuppressWarnings("null")
	public static void open(String url) {
		AppConstant.WEBDRIVER.navigate().to(url);
	}

	public static void reload() {
		AppConstant.WEBDRIVER.navigate().refresh();
	}

	public static void clear(By locator) {
		waitForVisible(locator);
		findElement(locator).clear();
	}

	public static void enter(By locator, String string) {
		waitForVisible(locator);
		scrollToElement(locator);
		clear(locator);
		findElement(locator).sendKeys(string);
	}

	public static String getText(By locator) {
		waitForVisible(locator);
		return findElement(locator).getText();
	}

	public static String getSelectedOptionText(By locator) {
		waitForVisible(locator);
		scrollToElement(locator);
		Select select = new Select(findElement(locator));
		WebElement selectedOption = select.getFirstSelectedOption();
		return selectedOption.getText();
	}

	public static List<String> getTextList(By locator) {
		waitForVisible(locator);
		List<String> textList = new ArrayList<>();
		for (WebElement element : findElements(locator)) {
			textList.add(element.getText());
		}

		return textList;
	}

	public static String getText(String locator, Object... args) {
		By locatorElement = getLocatorElement(locator, args);
		waitForVisible(locatorElement);
		return findElement(locatorElement).getText();
	}

	public static List<String> getTextList(String locator, Object... args) {
		By locatorElement = getLocatorElement(locator, args);
		waitForVisible(locatorElement);

		List<String> textList = new ArrayList<>();
		for (WebElement element : findElements(locatorElement)) {
			textList.add(element.getText());
		}

		return textList;
	}

	public static void click(By locator) {
		waitForVisible(locator);
		scrollToElement(locator);
		waitForClickable(locator);
		findElement(locator).click();
	}

	public static void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	public static void clickByJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) AppConstant.WEBDRIVER;
		js.executeScript("arguments[0].click();", findElement(locator));
	}
	// #endregion

	// #region Select Actions
	public static void selectByVisibleText(WebElement element, String text) {
		scrollToElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void selectByVisibleText(By locator, String text) {
		waitForVisible(locator);
		scrollToElement(locator);
		Select select = new Select(findElement(locator));
		select.selectByVisibleText(text);
	}

	public static void selectByIndex(By locator, int index) {
		waitForVisible(locator);
		scrollToElement(locator);
		Select select = new Select(findElement(locator));
		select.selectByIndex(index);
	}

	public static String getFirstSelectedText(WebElement element) {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText().trim();
	}

	public static void selectByValue(By locator, String value) {
		waitForVisible(locator);
		scrollToElement(locator);
		Select select = new Select(findElement(locator));
		select.selectByValue(value);
	}

	public static List<String> getAllSelectOptions(By locator, WebElement departElement, String departFrom) {
		waitForVisible(locator);
		scrollToElement(locator);
		Select select = new Select(findElement(locator));

		List<String> options = select.getOptions().stream().map(e -> e.getText().trim()).collect(Collectors.toList());

		System.out.println("Select options (" + locator + "): " + options);

		return options;
	}
	// #endregion

	// #region Scroll Actions
	public static void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) AppConstant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", findElement(locator));
	}

	public static void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) AppConstant.WEBDRIVER;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
	}
	// #endregion

	// #region Waits
	public static By waitForClickable(By locator) {
		return waitForClickable(locator, Timeout.DEFAULT);
	}

	@SuppressWarnings("null")
	public static By waitForClickable(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return locator;
	}

	public static By waitForVisible(By locator) {
		return waitForVisible(locator, Timeout.DEFAULT);
	}

	@SuppressWarnings("null")
	public static By waitForVisible(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return locator;
	}

	@SuppressWarnings("null")
	public static void waitUntilStale(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.stalenessOf(element));
		} catch (Exception e) {
			// ingore exception
		}

	}
	// #endregion

	// #region Wait Alerts
	public static Alert waitForAlertVisible() {
		return waitForAlertVisible(Timeout.DEFAULT);
	}

	public static Alert waitForAlertVisible(int timeout) {
		WebDriverWait wait = new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	// #endregion

	// #region Switch To Actions
	@SuppressWarnings("null")
	public static void switchToFirstTab() {
		List<String> tabs = new ArrayList<>(AppConstant.WEBDRIVER.getWindowHandles());
		AppConstant.WEBDRIVER.switchTo().window(tabs.get(0));
	}

	public static void switchToNewTab() {
		AppConstant.WEBDRIVER.switchTo().newWindow(WindowType.TAB);
		WebDriverWait wait = new WebDriverWait(AppConstant.WEBDRIVER, Duration.ofSeconds(Timeout.DEFAULT));
		wait.until(d -> d.getWindowHandles().size() > 1);
	}

	@SuppressWarnings("null")
	public static void switchToLastTab() {
		Set<String> windows = AppConstant.WEBDRIVER.getWindowHandles();
		String lastWindow = windows.toArray(new String[0])[windows.size() - 1];
		AppConstant.WEBDRIVER.switchTo().window(lastWindow);
	}

	public static void closeTab() {
		AppConstant.WEBDRIVER.close();
	}
	// #endregion

	// #region Alerts
	public static String getConfirmationText() {
		Alert alert = waitForAlertVisible();
		return alert.getText();
	}

	public static void acceptAlertConfirmation() {
		waitForAlertVisible().accept();
	}
	// #endregion

	// #region Table Handlers
	public static Map<String, Integer> getHeaderIndexMap(WebElement table) {

		List<WebElement> headers = table.findElements(By.tagName("th"));

		Map<String, Integer> headerIndexMap = new HashMap<>();

		for (int i = 0; i < headers.size(); i++) {
			headerIndexMap.put(headers.get(i).getText().trim(), i + 1);
		}

		return headerIndexMap;
	}

	public static String getCellText(WebElement row, Map<String, Integer> headerMap, String headerName) {

		Integer index = headerMap.get(headerName);
		if (index == null) {
			throw new RuntimeException("Header not found: " + headerName);
		}

		List<WebElement> cells = row.findElements(By.tagName("td"));

		return cells.get(index - 1).getText().trim();
	}
	// #endregion
}
