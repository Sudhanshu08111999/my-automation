package evs.vtiger.framework.utillity;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
////Generic methods , utility methods , Application Independent methods ,
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class WebUtillFrameWork {

	// ====================================extentReport==============================//

	public ExtentReports extentReport() {
		ExtentHtmlReporter extenthtml = new ExtentHtmlReporter("C:\\Users\\HP\\Desktop\\New folder/result.html");
		ExtentReports extentreport = new ExtentReports();
		extentreport.attachReporter(extenthtml);
		return extentreport;
	}

	// ===============================LaunchBrowser======================================//

	WebDriver driver;

	public WebDriver launchbrowser(String browName) {

		if (browName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\\\eclipseWorkshop\\\\action_class\\\\driver\\\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browName.equalsIgnoreCase("firFox")) {
			System.setProperty("webdriver.chrome.driver", "browexe/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		return driver;
	}

	// ==================================get url////
	// =======================================//
	public void get(String url) {
		driver.get(url);

	}

	// ==============================getWebElement
	// method========================================//

	public WebElement getWebElement(WebDriver driver, ExtentTest extTest, String xpath) {
		WebElement weEl;
		try {
			weEl = driver.findElement(By.xpath(xpath));
		} catch (NoSuchElementException nse) {
			nse.printStackTrace();
			extTest.log(Status.INFO, "exception occured while finding element" + nse);
			weEl = driver.findElement(By.xpath(xpath));
		}
		return weEl;
	}

	// ======================================SendKeys
	// method=========================================//

	public void inputData(WebDriver driver, ExtentTest extentTest, String xpath, String inputValue, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);
		try {
			weEle.clear();
			weEle.sendKeys(inputValue);

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

	// ===============================================click
	// method================================================

	public void click(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);
		try {
			weEle.click();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			// weEle.click();

		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//============================================action mouseOver method=====================================//
	Actions actobj;

	public void actionMouseOver(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.moveToElement(weEle).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.moveToElement(weEle).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}
	// ==========================actionsRightClick
	// method================================//

	public void actionRightclick(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.contextClick(weEle).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.contextClick(weEle).build().perform();

		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//==========================actionsdoubleClick method================================//

	public void actiondoubleclick(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.doubleClick(weEle).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.doubleClick(weEle).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//==========================actionsdragAndDropClick method================================//

	public void actiondragAndDrop(WebDriver driver, ExtentTest extentTest, String dragxpath, String dropxpath,
			String msg) {

		WebElement weEle = getWebElement(driver, extentTest, dragxpath);
		WebElement weEl = getWebElement(driver, extentTest, dropxpath);
		actobj = new Actions(driver);
		try {
			actobj.dragAndDrop(weEle, weEl).build().perform();

		} catch (StaleElementReferenceException se) {
			WebElement weE = getWebElement(driver, extentTest, dragxpath);
			WebElement weE1 = getWebElement(driver, extentTest, dropxpath);
			actobj.dragAndDrop(weE, weE1).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//==================================actionclick method==========================//

	public void actionclick(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.click(weEle).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.click(weEle).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}
	// ====================================== action clickAndHold
	// method===================================//

	public void actionclickAndHold(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.clickAndHold(weEle).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.clickAndHold(weEle).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}
//==================================actionSendKeys method==========================//

	public void actionsendKeys(WebDriver driver, ExtentTest extentTest, String xpath, String inputValue, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);

		actobj = new Actions(driver);
		try {
			actobj.sendKeys(weEle, inputValue).build().perform();

		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			actobj.sendKeys(weEle, inputValue).build().perform();
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//====================================selectByVisibleText method========================================//
	Select selobj;

	public void selectByVisibleText(WebDriver driver, ExtentTest extentTest, String xpath, String selectText,
			String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);
		selobj = new Select(weEle);
		try {
			selobj.selectByVisibleText(selectText);
			WebElement gfseo = selobj.getFirstSelectedOption();
			String actualfirstText = gfseo.getText();
			if (actualfirstText.equalsIgnoreCase(selectText)) {
				extentTest.log(Status.PASS, msg);
			} else {
				extentTest.log(Status.FAIL, msg);
			}
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			selobj.selectByVisibleText(selectText);
			WebElement gfseo = selobj.getFirstSelectedOption();
			String actualfirstText = gfseo.getText();
			if (actualfirstText.equalsIgnoreCase(selectText)) {
				extentTest.log(Status.PASS, msg);
			} else {
				extentTest.log(Status.FAIL, msg);
			}
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//====================================selectByValue method========================================//

	public void selectByValue(WebDriver driver, ExtentTest extentTest, String xpath, String selectValue, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);
		selobj = new Select(weEle);
		try {
			selobj.selectByValue(selectValue);
			WebElement gfseo = selobj.getFirstSelectedOption();
			String actualfirstText = gfseo.getText();
			if (actualfirstText.equalsIgnoreCase(selectValue)) {
				extentTest.log(Status.PASS, msg);
			} else {
				extentTest.log(Status.FAIL, msg);
			}
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			selobj.selectByValue(selectValue);
			WebElement gfseo = selobj.getFirstSelectedOption();
			String actualfirstText = gfseo.getText();
			if (actualfirstText.equalsIgnoreCase(selectValue)) {
				extentTest.log(Status.PASS, msg);
			} else {
				extentTest.log(Status.FAIL, msg);
			}
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}

	}

//====================================selectByIndex method========================================//

	public void selectByIndex(WebDriver driver, ExtentTest extentTest, String xpath, int selectInnerText, String msg) {

		WebElement weEle = getWebElement(driver, extentTest, xpath);
		selobj = new Select(weEle);
		try {
			selobj.selectByIndex(selectInnerText);
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			selobj.selectByIndex(selectInnerText);
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}
	// =======================================getInerTextVerify====================================//

	public void getInnerTextVerify(WebDriver driver, ExtentTest extent, String xpath, String expInerText, String msg) {
		WebElement weEle = getWebElement(driver, extent, xpath);
		String actualText = null;
		try {
			actualText = weEle.getText();
		} catch (StaleElementReferenceException stle) {
			weEle = driver.findElement(By.xpath(xpath));
			actualText = weEle.getText();
		} catch (ElementNotInteractableException elm) {
			// java script
		}

		if (actualText.equalsIgnoreCase(expInerText)) {
			extent.log(Status.PASS, msg);
		} else {
			extent.log(Status.FAIL, msg);
		}
	}
	// ==============================================getAttributeValue=================================//

	public void getAttributeValue(WebDriver driver, ExtentTest extent, String xpath, String Attribute,
			String expAttributValue, String msg) {
		WebElement weEle = getWebElement(driver, extent, xpath);
		String actualAttribute;
		try {
			actualAttribute = weEle.getAttribute(Attribute);
		} catch (StaleElementReferenceException stle) {
			// java scri
		} catch (ElementNotInteractableException elm) {
			weEle = driver.findElement(By.xpath(xpath));
			actualAttribute = weEle.getAttribute(Attribute);
		}actualAttribute = weEle.getAttribute(Attribute);

		if (actualAttribute.equalsIgnoreCase(expAttributValue)) {
			extent.log(Status.PASS, msg);
		} else {
			extent.log(Status.FAIL, msg);
		}
	}

//===============================================switchToFrameWebElementByXpath method================================================

	public void switchToFrameWebElementByXpath(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {
		WebElement weEle = getWebElement(driver, extentTest, xpath);
		try {
			driver.switchTo().frame(weEle);
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			driver.switchTo().frame(weEle);
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}

//===============================================switchToFrameintIndex method================================================

	public void switchToFrameIndex(WebDriver driver, ExtentTest extentTest, int frameindex, String msg) {       
		driver.switchTo().frame(frameindex);
		extentTest.log(Status.INFO, msg);
	}
	
//===============================================switchToFrameStringName method================================================

	public void switchToFrameStringName(WebDriver driver, ExtentTest extentTest, String framename, String msg) {
		driver.switchTo().frame(framename);		
		extentTest.log(Status.INFO, msg);
	}

//===============================================switchToParentFrame method================================================

	public void switchToParentFrame(WebDriver driver, ExtentTest extentTest, String msg) {
		driver.switchTo().parentFrame();
		extentTest.log(Status.INFO, msg);
	}

//===============================================switchToDefaultcontent method================================================

	public void switchToDefaultContent(WebDriver driver, ExtentTest extentTest, String msg) {

		driver.switchTo().defaultContent();
		extentTest.log(Status.INFO, msg);

	}
	// =========================================getWindowHandls=========================================//

	public void getWindowHandls(WebDriver driver, ExtentTest extent, String titleOrURL, String msg) {
		Set<String> gwihandls = driver.getWindowHandles();
		Iterator<String> itr = gwihandls.iterator();
		while (itr.hasNext()) {
			String strnext = itr.next();
			driver.switchTo().window(strnext);
			String getTitle;
			String getCurrentUrl;
			// try catch
			try {
				getTitle = driver.getTitle();
				getCurrentUrl = driver.getCurrentUrl();
			} catch (NoSuchElementException nse) {
				nse.printStackTrace();
				getTitle = driver.getTitle();
				getCurrentUrl = driver.getCurrentUrl();
			}
			if (getTitle.equalsIgnoreCase(titleOrURL)) {
				extent.log(Status.PASS, msg);
				break;
			} else if (getCurrentUrl.equalsIgnoreCase(titleOrURL)) {
				extent.log(Status.PASS, msg);
				break;
			}
		}
	}
	// ================================getWindowHandle====================================//

	public void getWindowHandle(WebDriver driver, ExtentTest extent, String msg) {
		driver.getWindowHandle();
		extent.log(Status.INFO, msg);
	}
	// ========================================methods size of
	// height========================//

	public void Sizeheight(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {
		WebElement weEle = getWebElement(driver, extentTest, xpath);
		int hight;
		try {
			hight = weEle.getSize().height;
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			hight = weEle.getSize().height;
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);

	}
	// ===================================method size of
	// width===========================//

	public void SizeWidth(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {
		WebElement weEle = getWebElement(driver, extentTest, xpath);
		int weith;
		try {
			weith = weEle.getSize().width;
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			weith = weEle.getSize().width;
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);
	}
	// =======================================method location of
	// x=============================//

	public void getLocationX(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {
		WebElement weEle = getWebElement(driver, extentTest, xpath);
		int x;
		try {
			x = weEle.getLocation().x;
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			x = weEle.getLocation().x;
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);

	}
	// =================================method location of
	// y=============================//

	public void getLocationY(WebDriver driver, ExtentTest extentTest, String xpath, String msg) {
		WebElement weEle = getWebElement(driver, extentTest, xpath);
		int y;
		try {
			y = weEle.getLocation().y;
		} catch (StaleElementReferenceException se) {
			weEle = driver.findElement(By.xpath(xpath));
			y = weEle.getLocation().y;
		} catch (ElementNotInteractableException ent) {
			/// javaScript
		}
		extentTest.log(Status.INFO, msg);

	}
}
