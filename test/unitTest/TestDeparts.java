package unitTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dao.DepartsDAO;
import pojo.Departs;

@ContextConfiguration(locations = "spring-config-hibernate-testt.xml")
public class TestDeparts extends AbstractTestNGSpringContextTests {

	@Autowired
	DepartsDAO departsDao;

	Departs Departs;

	@BeforeTest
	private void setup() {
		Departs = new Departs();

	}

	@AfterMethod
	private void del() {
		departsDao.deleteAll();
	}
	// bỏ trống tất cả các trường

	@Test
	void addDepart_01() {
		Departs.setCodeId(null);
		Departs.setName(null);
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// điền đầy đủ các trường
	@Test
	void addDepart_02() {
		Departs.setCodeId("7000");
		Departs.setName("78888");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}

	// bỏ trống trường CodeId
	@Test
	void addDepart_03() {
		Departs.setCodeId(null);
		Departs.setName("Phong01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// bỏ trống trường Name
	@Test
	void addDepart_04() {
		Departs.setCodeId("00001");
		Departs.setName(null);
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// thêm kí tự đặc biệt trường codeId
	@Test
	void addDepart_05() {
		Departs.setCodeId("PB_01");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}

	// thêm kí tự đặc biệt trường name
	@Test
	void addDepart_06() {
		Departs.setCodeId("00001");
		Departs.setName("---");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// thêm CodeId 1 kí tự
	@Test
	void addDepart_07() {
		Departs.setCodeId("1");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// thêm CodeId 2 kí tự
	@Test
	void addDepart_08() {
		Departs.setCodeId("P1");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}
	// thêm CodeId 3 kí tự
		@Test
		void addDepart_09() {
			Departs.setCodeId("PB1");
			Departs.setName("PB01");
			boolean kq = departsDao.addDepart(Departs);
			Assert.assertEquals(true, kq);
		}
		// thêm CodeId 9 kí tự
		@Test
		void addDepart_010() {
			Departs.setCodeId("PH0000001");
			Departs.setName("PB01");
			boolean kq = departsDao.addDepart(Departs);
			Assert.assertEquals(true, kq);
		}
	// thêm CodeId 10 kí tự
	@Test
	void addDepart_011() {
		Departs.setCodeId("PH00000001");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}

	// thêm CodeId 11 kí tự
	@Test
	void addDepart_012() {
		Departs.setCodeId("PH000000001");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// thêm Name 2 kí tự
	@Test
	void addDepart_013() {
		Departs.setCodeId("PB01");
		Departs.setName("PH");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}

	// thêm name 3 kí tự
	@Test
	void addDepart_014() {
		Departs.setCodeId("PB01");
		Departs.setName("Y TE");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}
	// thêm name 4 kí tự
		@Test
		void addDepart_015() {
			Departs.setCodeId("PB01");
			Departs.setName("Y TE 1");
			boolean kq = departsDao.addDepart(Departs);
			Assert.assertEquals(true, kq);
		}
	// thêm CodeId 49 kí tự
		@Test
		void addDepart_016() {
			Departs.setCodeId("P01");
			Departs.setName("PBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			boolean kq = departsDao.addDepart(Departs);
			Assert.assertEquals(true, kq);
		}
	// thêm CodeId 50 kí tự
	@Test
	void addDepart_017() {
		Departs.setCodeId("P01");
		Departs.setName("PBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(true, kq);
	}

	// thêm CodeId 51 kí tự
	@Test
	void addDepart_018() {
		Departs.setCodeId("PBAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}
	// thêm CodeId trùng
	@Test
	void addDepart_019() {
		Departs.setCodeId("PB01");
		Departs.setName("PB01");
		departsDao.addDepart(Departs);
		Departs.setCodeId("PB01");
		Departs.setName("PB01");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}
	// thêm name trùng
	@Test
	void addDepart_020() {
		Departs.setCodeId("PB01");
		Departs.setName("PHAA");
		departsDao.addDepart(Departs);
		Departs.setCodeId("PB01");
		Departs.setName("PHAA");
		boolean kq = departsDao.addDepart(Departs);
		Assert.assertEquals(false, kq);
	}
}
