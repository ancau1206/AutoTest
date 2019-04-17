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
import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dao.StaffsDAO;
import pojo.Staffs;
@ContextConfiguration(locations = "spring-config-hibernate-testt2.xml")
public class testStaffs extends AbstractTestNGSpringContextTests{
	@Autowired
	StaffsDAO staffsDao;

	Staffs staffs;
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
		String url = "http://localhost:8080/Assiment/nhanvien/them";
		driver.get(url);
		staffs =new Staffs();
	}
@AfterMethod
public void clear() {
	staffsDao.deleteAll();
}
	 @AfterTest
	 public static void close() {
	 driver.close();
	 }

	// Bỏ trống trường CodeID
	@Test(priority = 1)
	public void addStaffs_01() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
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

	// Thêm 1 kí tự trường CodeID
	@Test(priority = 2)
	public void addStaffs_02() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
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

	// Thêm 2 kí tự trường CodeID
	@Test(priority = 3)
	public void addStaffs_03() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
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

	// Thêm 9 kí tự trường CodeID
	@Test(priority = 4)
	public void addStaffs_04() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
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

	// Thêm 10 kí tự trường CodeID
	@Test(priority = 5)
	public void addStaffs_05() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
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

	// Thêm 11 kí tự trường CodeID
	@Test(priority = 6)
	public void addStaffs_06() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("A012345678");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFiel);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường Name
	@Test(priority = 7)
	public void addStaffs_07() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 4 kí tự cho trường Name
	@Test(priority = 8)
	public void addStaffs_08() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCD");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual,
					"Please lengthen this text to 5 characters or more (you are currently using 4 characters).");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 5 kí tự cho trường Name
	@Test(priority = 9)
	public void addStaffs_09() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDE");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 6 kí tự cho trường Name
	@Test(priority = 10)
	public void addStaffs_10() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDEF");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 49 kí tự cho trường Name
	@Test(priority = 11)
	public void addStaffs_11() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDEF0123456789999999999999999999999999999999999");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 50 kí tự cho trường Name
	@Test(priority = 12)
	public void addStaffs_12() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("A1BCDEF0123456789999999999999999999999999999999999");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 51 kí tự cho trường Name
	@Test(priority = 13)
	public void addStaffs_13() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("ABCDEF012345678999999AB9999999999999999999999999999");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie2);
			System.out.println(actual);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường Birthday
	@Test(priority = 14)
	public void addStaffs_14() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie3);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Nhập dữ liệu chữ vào trường Birthday
	@Test(priority = 15)
	public void addStaffs_15() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("aaaaaa");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie3);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập kí tự đặc biệt vào trường Birthday
	@Test(priority = 16)
	public void addStaffs_16() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("//////");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie3);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập sai dữ liệu ngày tháng vào trường Birthday
	@Test(priority = 17)
	public void addStaffs_17() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("31021999");
//			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
//			WebElement codeIDFie5 = driver.findElement(By.id("email"));
//			codeIDFie5.sendKeys("ancau12061997@gmail.com");
//			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
//			codeIDFie6.sendKeys("0123456789");
//			WebElement codeIDFie7 = driver.findElement(By.id("salary"));
//			codeIDFie7.sendKeys("1000");
//			WebElement codeIDFie8 = driver.findElement(By.id("notes"));
//			codeIDFie8.sendKeys("abcd12340000000000000000000005");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie3);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường Photo
	@Test(priority = 18)
	public void addStaffs_18() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			codeIDFie4.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie4);
			assertEquals(actual, "Please select a file.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Bỏ trống trường Email
	@Test(priority = 19)
	public void addStaffs_19() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập sai định dạng trường Email
	@Test(priority = 20)
	public void addStaffs_20() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("abcd.com");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "Please include an '@' in the email address. 'abcd.com' is missing an '@'.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 7 kí tự cho trường Email
	@Test(priority = 21)
	public void addStaffs_21() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ab@gm.c");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual,
					"Please lengthen this text to 8 characters or more (you are currently using 7 characters).");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 8 kí tự cho trường Email
	@Test(priority = 22)
	public void addStaffs_22() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ab@gm.co");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 9 kí tự cho trường Email
	@Test(priority = 23)
	public void addStaffs_23() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ab@gm.com");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 29 kí tự cho trường Email
	@Test(priority = 24)
	public void addStaffs_24() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("abccccccccccccccccc@gmail.com");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 30 kí tự cho trường Email
	@Test(priority = 25)
	public void addStaffs_25() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("abaccccccccccccccccc@gmail.com");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 31 kí tự cho trường Email
	@Test(priority = 26)
	public void addStaffs_26() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("abacccccccccccccccccc@gmail.com");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie5);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường Phone
	@Test(priority = 27)
	public void addStaffs_27() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Nhập kí tự chữ cho trường Phone
	@Test(priority = 28)
	public void addStaffs_28() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("abcde");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Nhập kí tự đặc biệt cho trường Phone
	@Test(priority = 29)
	public void addStaffs_29() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("//////");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "Please match the requested format.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Nhập 8 kí tự cho trường Phone
	@Test(priority = 30)
	public void addStaffs_30() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("01234567");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual,
					"Please lengthen this text to 9 characters or more (you are currently using 8 characters).");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}

	// Nhập 9 kí tự cho trường Phone
	@Test(priority = 31)
	public void addStaffs_31() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("012345678");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 10 kí tự cho trường Phone
	@Test(priority = 32)
	public void addStaffs_32() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("012345678");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 14 kí tự cho trường Phone
	@Test(priority = 33)
	public void addStaffs_33() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("01234444444444");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 15 kí tự cho trường Phone
	@Test(priority = 34)
	public void addStaffs_34() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("012344444444444");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Nhập 16 kí tự cho trường Phone
	@Test(priority = 35)
	public void addStaffs_35() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("01234444444444444");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie6);
			assertEquals(actual, "");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}

	// Bỏ trống trường Salary
	@Test(priority = 36)
	public void addStaffs_36() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("0123456789");
			WebElement codeIDFie7 = driver.findElement(By.id("salary"));
			codeIDFie7.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie7);
			assertEquals(actual, "Value must be greater than or equal to 100.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}
	}
	// Nhập dữ liệu chữ vào trường Salary
		@Test(priority = 37)
		public void addStaffs_37() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("code"));
				codeIDFiel.sendKeys("NV01");
				WebElement codeIDFie2 = driver.findElement(By.id("name"));
				codeIDFie2.sendKeys("An Cầu");
				WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
				codeIDFie3.sendKeys("01011999");
				WebElement codeIDFie4 = driver.findElement(By.id("photo"));
				WebElement codeIDFie5 = driver.findElement(By.id("email"));
				codeIDFie5.sendKeys("ancau12061997@gmail.com");
				WebElement codeIDFie6 = driver.findElement(By.id("phone"));
				codeIDFie6.sendKeys("0123456789");
				WebElement codeIDFie7 = driver.findElement(By.id("salary"));
				codeIDFie7.sendKeys("eeee");
				WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
				LoginButun.click();
				Thread.sleep(1000);
				String actual = getHtml5ValidationMessage(codeIDFie7);
				assertEquals(actual, "Please enter a number.");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}
		}
		// Nhập kí tự đặc biệt vào trường Salary
				@Test(priority = 38)
				public void addStaffs_38() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("......");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "Please enter a number.");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				// Nhập giá trị 99 vào trường Salary
				@Test(priority = 39)
				public void addStaffs_39() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("9");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "Value must be greater than or equal to 100.");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				// Nhập giá trị 100 vào trường Salary
				@Test(priority = 40)
				public void addStaffs_40() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("0100");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				// Nhập giá trị 9999 vào trường Salary
				@Test(priority = 41)
				public void addStaffs_41() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("999");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				// Nhập giá trị 10000 vào trường Salary
				@Test(priority = 42)
				public void addStaffs_42() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys(String.valueOf(1000));
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				// Nhập giá trị 10001 vào trường Salary
				@Test(priority = 43)
				public void addStaffs_43() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.name("salary"));
						codeIDFie7.sendKeys("10001");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String actual = getHtml5ValidationMessage(codeIDFie7);
						assertEquals(actual, "Value must be less than or equal to 10000.");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}
				}
				//Bỏ trống trường Notes
	@Test(priority = 44)
	public void addStaffs_44() {
		try {
			WebElement codeIDFiel = driver.findElement(By.id("code"));
			codeIDFiel.sendKeys("NV01");
			WebElement codeIDFie2 = driver.findElement(By.id("name"));
			codeIDFie2.sendKeys("An Cầu");
			WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
			codeIDFie3.sendKeys("01011999");
			WebElement codeIDFie4 = driver.findElement(By.id("photo"));
			WebElement codeIDFie5 = driver.findElement(By.id("email"));
			codeIDFie5.sendKeys("ancau12061997@gmail.com");
			WebElement codeIDFie6 = driver.findElement(By.id("phone"));
			codeIDFie6.sendKeys("0123456789");
			WebElement codeIDFie7 = driver.findElement(By.id("salary"));
			codeIDFie7.sendKeys("1000");
			WebElement codeIDFie8 = driver.findElement(By.id("notes"));
			codeIDFie8.sendKeys("");
			WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
			LoginButun.click();
			Thread.sleep(1000);
			String actual = getHtml5ValidationMessage(codeIDFie8);
			assertEquals(actual, "Please fill out this field.");
		} catch (Exception e) {
			fail("Lỗi: Không nhập tên vẫn hợp lệ");
		}

	}
	//Nhập 9 kí tự trường Notes
		@Test(priority = 45)
		public void addStaffs_45() {
			try {
				WebElement codeIDFiel = driver.findElement(By.id("code"));
				codeIDFiel.sendKeys("NV01");
				WebElement codeIDFie2 = driver.findElement(By.id("name"));
				codeIDFie2.sendKeys("An Cầu");
				WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
				codeIDFie3.sendKeys("01011999");
				WebElement codeIDFie4 = driver.findElement(By.id("photo"));
				WebElement codeIDFie5 = driver.findElement(By.id("email"));
				codeIDFie5.sendKeys("ancau12061997@gmail.com");
				WebElement codeIDFie6 = driver.findElement(By.id("phone"));
				codeIDFie6.sendKeys("0123456789");
				WebElement codeIDFie7 = driver.findElement(By.id("salary"));
				codeIDFie7.sendKeys("1000");
				WebElement codeIDFie8 = driver.findElement(By.id("notes"));
				codeIDFie8.sendKeys("abcd12345");
				WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
				LoginButun.click();
				Thread.sleep(1000);
				String actual = getHtml5ValidationMessage(codeIDFie8);
				assertEquals(actual, "Please lengthen this text to 10 characters or more (you are currently using 9 characters).");
			} catch (Exception e) {
				fail("Lỗi: Không nhập tên vẫn hợp lệ");
			}

		}
		//Nhập 10 kí tự trường Notes
				@Test(priority = 46)
				public void addStaffs_46() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("1000");
						WebElement codeIDFie8 = driver.findElement(By.id("notes"));
						codeIDFie8.sendKeys("abcd123456");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String url = driver.getCurrentUrl();;
						assertEquals(url, "http://localhost:8080/Assiment/nhanvien/list");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}

				}
				//Nhập 11 kí tự trường Notes
				@Test(priority = 47)
				public void addStaffs_47() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("1000");
						WebElement codeIDFie8 = driver.findElement(By.id("notes"));
						codeIDFie8.sendKeys("abcd1234567");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String url = driver.getCurrentUrl();;
						assertEquals(url, "http://localhost:8080/Assiment/nhanvien/list");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}

				}
				//Nhập 99 kí tự trường Notes
				@Test(priority = 48)
				public void addStaffs_48() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("1000");
						WebElement codeIDFie8 = driver.findElement(By.id("notes"));
						codeIDFie8.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String url = driver.getCurrentUrl();;
						assertEquals(url, "http://localhost:8080/Assiment/nhanvien/list");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}

				}
				//Nhập 100 kí tự trường Notes
				@Test(priority = 49)
				public void addStaffs_49() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("1000");
						WebElement codeIDFie8 = driver.findElement(By.id("notes"));
						codeIDFie8.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String url = driver.getCurrentUrl();;
						assertEquals(url, "http://localhost:8080/Assiment/nhanvien/list");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}

				}
				//Nhập 101 kí tự trường Notes
				@Test(priority = 50)
				public void addStaffs_50() {
					try {
						WebElement codeIDFiel = driver.findElement(By.id("code"));
						codeIDFiel.sendKeys("NV01");
						WebElement codeIDFie2 = driver.findElement(By.id("name"));
						codeIDFie2.sendKeys("An Cầu");
						WebElement codeIDFie3 = driver.findElement(By.id("birthday"));
						codeIDFie3.sendKeys("01011999");
						WebElement codeIDFie4 = driver.findElement(By.id("photo"));
						WebElement codeIDFie5 = driver.findElement(By.id("email"));
						codeIDFie5.sendKeys("ancau12061997@gmail.com");
						WebElement codeIDFie6 = driver.findElement(By.id("phone"));
						codeIDFie6.sendKeys("0123456789");
						WebElement codeIDFie7 = driver.findElement(By.id("salary"));
						codeIDFie7.sendKeys("1000");
						WebElement codeIDFie8 = driver.findElement(By.id("notes"));
						codeIDFie8.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
						WebElement LoginButun = driver.findElement(By.id("frmSubmit"));
						LoginButun.click();
						Thread.sleep(1000);
						String url = driver.getCurrentUrl();;
						assertEquals(url, "http://localhost:8080/Assiment/nhanvien/list");
					} catch (Exception e) {
						fail("Lỗi: Không nhập tên vẫn hợp lệ");
					}

				}
	public String getHtml5ValidationMessage(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", element);
	}
}
