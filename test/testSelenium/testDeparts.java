package testSelenium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dao.DepartsDAO;
import pojo.Departs;
@ContextConfiguration(locations = "spring-config-hibernate-testt2.xml")
public class testDeparts extends AbstractTestNGSpringContextTests {
	@Autowired
	DepartsDAO departsDao;

	Departs Departs;
	public static WebDriver driver;

	@BeforeTest
	public static void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\anvietcau\\Desktop\\TaiNguyen\\TaiNguyen\\chromedriver.exe");
		driver = new ChromeDriver();
		String url = "http://localhost:8080/Assiment/";
		driver.get(url);
		WebElement codeIDFiel = driver.findElement(By.id("usename"));
		codeIDFiel.sendKeys("Admin");
		WebElement codeIDFie2 = driver.findElement(By.id("password"));
		codeIDFie2.sendKeys("admin");
		WebElement LoginButun = driver.findElement(By.id("submit"));
		LoginButun.click();
		Thread.sleep(1000);
	}

	@BeforeMethod
	public void haha() {
		String url = "http://localhost:8080/Assiment/phongban/them";
		driver.get(url);
		Departs = new Departs();
	}
	@AfterMethod
	public void clear() {
		departsDao.deleteAll();
	}
	 @AfterTest
	 public static void close() {
	 driver.close();
	 }

	// Bỏ trống trường CodeID
	@Test(priority = 51)
	public void addDeparts_01() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 1 kí tự vào trường codeId
	@Test(priority = 52)
	public void addDeparts_02() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("1");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual,
					"Please lengthen this text to 2 characters or more (you are currently using 1 character).");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 2 kí tự trường codeId
	@Test(priority = 53)
	public void addDeparts_03() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("A1");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 9 kí tự trường codeId
	@Test(priority = 54)
	public void addDeparts_04() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("A12345678");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 10 kí tự trường codeId
	@Test(priority = 55)
	public void addDeparts_05() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("A123456789");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 11 kí tự trường codeId
	@Test(priority = 56)
	public void addDeparts_06() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("A1234567890");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường name
	@Test(priority = 57)
	public void addDeparts_07() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 4 kí tự trường name
	@Test(priority = 58)
	public void addDeparts_08() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCD");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			assertEquals(actual,
					"Please lengthen this text to 5 characters or more (you are currently using 4 characters).");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 5 kí tự trường name
	@Test(priority = 59)
	public void addDeparts_09() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDE");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();;
			assertEquals(url, "http://localhost:8080/Assiment/phongban/list");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 6 kí tự trường name
	@Test(priority = 60)
	public void addDeparts_10() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDEF");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();;
			assertEquals(url, "http://localhost:8080/Assiment/phongban/list");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 49 kí tự trường name
	@Test(priority = 61)
	public void addDeparts_11() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();;
			assertEquals(url, "http://localhost:8080/Assiment/phongban/list");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 50 kí tự trường name
	@Test(priority = 62)
	public void addDeparts_12() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();;
			assertEquals(url, "http://localhost:8080/Assiment/phongban/list");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 51 kí tự trường name
	@Test(priority = 63)
	public void addDeparts_13() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("codeId"));
			codeIDFiel.sendKeys("PB01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String url = driver.getCurrentUrl();;
			assertEquals(url, "http://localhost:8080/Assiment/phongban/list");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
}
