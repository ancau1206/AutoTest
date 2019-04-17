package unitTest;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dao.DepartsDAO;
import dao.StaffsDAO;
import pojo.Departs;
import pojo.Staffs;



@ContextConfiguration(locations = "spring-config-hibernate-testt.xml")
public class TestStaffs extends AbstractTestNGSpringContextTests {
	@Autowired
	StaffsDAO staffsDao;

	Staffs staffs;
	DepartsDAO departsDao;

	Departs Departs;
  @BeforeTest
  private void setup() {
	  staffs =new Staffs();
	  Departs = new Departs();
  }
  @AfterMethod
  private void clean() {
	  staffsDao.deleteAll();
  }
  //Bỏ trống tất cả các trường
  @Test
  void addStaff_001() {
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Điền tất cả các trường
  @Test
  void addStaff_002() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Chỉ nhập trường CodeId
  @Test
  void addStaff_003() {
	  staffs.setCodeId("NV01");
	  staffs.setName(null);
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường name
  @Test
  void addStaff_004() {
	  staffs.setCodeId(null);
	  staffs.setName("An Cầu");
	  
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường Gender
  @Test
  void addStaff_005() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	  staffs.setGender(false);
	  staffs.setBirthday(null);
	  staffs.setPhoto(null);
	  staffs.setEmail(null);
	  staffs.setPhone(null);
	  staffs.setNotes(null);
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường BirthDay
  @Test
  void addStaff_006() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	  staffs.setGender(false);
	  Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto(null);
	  staffs.setEmail(null);
	  staffs.setPhone(null);
	  staffs.setNotes(null);
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường Photo
  @Test
  void addStaff_007() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	  staffs.setPhoto("haha");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường email
  @Test
  void addStaff_008() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	 
	  staffs.setEmail("ancau12@gmail.com");
	 
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường Phone
  @Test
  void addStaff_009() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	  
	  staffs.setPhone("0123456789");
	  
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường salary
  @Test
  void addStaff_010() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	 
	  staffs.setSalary(10);
	  
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường level
  @Test
  void addStaff_011() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	 
	  staffs.setLevel((byte) 1);
	 
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Chỉ nhập trường notes
  @Test
  void addStaff_012() {
	  staffs.setCodeId(null);
	  staffs.setName(null);
	
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường CodeId
  @Test
  void addStaff_013() {
	  staffs.setCodeId(null);
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Name
  @Test
  void addStaff_014() {
	  staffs.setCodeId("NV01");
	  staffs.setName(null);
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Gender
  @Test(expectedExceptions = Exception.class)
  void addStaff_015() {
	  staffs.setCodeId("NV01");
	  staffs.setName("An Cầu");
	 Boolean gt=null;
	 staffs.setGender(gt);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Birhday
  @Test
  void addStaff_016() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	  staffs.setBirthday(null);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Photo
  @Test
  void addStaff_017() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto(null);
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
//Bỏ trống trường email
  @Test
  void addStaff_018() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail(null);
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Phone
  @Test
  void addStaff_019() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone(null);
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Salary
  @Test(expectedExceptions = Exception.class)
	void addStaff_020() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	 Float a= null;
	 staffs.setSalary(a);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Level
  @Test(expectedExceptions = Exception.class)
  void addStaff_021() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	Byte t= null;
	staffs.setLevel(t);
	  staffs.setNotes("hihi");
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Bỏ trống trường Notes
  @Test
  void addStaff_022() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes(null);
	  boolean kq=staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
//Nhập kí tự đặc biệt cho CodeID
  @Test
  void addStaff_023() {
	  staffs.setCodeId("NV-01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
//Nhập kí tự đặc biệt cho Name
  @Test
  void addStaff_024() {
	  staffs.setCodeId("NV01");
	  staffs.setName("An Cầu @ 1");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
//Nhập kí tự đặc biệt cho Photo
  @Test
  void addStaff_025() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("---");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
//Nhập kí tự đặc biệt cho Email
  @Test
  void addStaff_026() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
//Nhập kí tự đặc biệt cho Phone
  @Test
  void addStaff_027() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("---");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
  //Nhập dữ liệu chữ cho Phone
  @Test
  void addStaff_028() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("abcd");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  
}
  //Nhập dữ liệu chữ cho Salary
  @Test(expectedExceptions = Exception.class)
  void addStaff_029() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  String a="abcd";
	  staffs.setSalary(Float.parseFloat(a));
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
  staffsDao.addStaffs(staffs);
	 
}
  //Nhập dữ liệu chữ cho Level
  @Test(expectedExceptions = Exception.class)
  void addStaff_030() {
	  staffs.setCodeId("NV01");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  String a="abcd";
	  staffs.setLevel(Byte.parseByte(a));
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  
}
  //Nhập 1 kí tự cho trường CodeID
  @Test
  void addStaff_031() {
	  staffs.setCodeId("1");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 9 kí tự cho trường CodeID
  @Test
  void addStaff_032() {
	  staffs.setCodeId("A12345678");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 10  kí tự cho trường CodeID
  @Test
  void addStaff_033() {
	  staffs.setCodeId("A123456789");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 11  kí tự cho trường CodeID
  @Test
  void addStaff_034() {
	  staffs.setCodeId("AB123456789");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
  //Nhập 8 kí tự cho trường Phone
  @Test
  void addStaff_035() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("01234567");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }
  //Nhập 9 kí tự cho trường Phone
  @Test
  void addStaff_036() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("012345678");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 10 kí tự cho trường Phone
  @Test
  void addStaff_037() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("0123456789");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 24 kí tự cho trường Phone
  @Test
  void addStaff_038() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("01234567900000000000000");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 25 kí tự cho trường Phone
  @Test
  void addStaff_039() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("012345679000000000000000");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(true, kq);
  }
  //Nhập 26 kí tự cho trường Phone
  @Test
  void addStaff_040() {
	  staffs.setCodeId("AB123");
	  staffs.setName("AN CẦU");
	  staffs.setGender(false);
	   Date birthdays = new Date(0);
	  staffs.setBirthday(birthdays);
	  staffs.setPhoto("hihi");
	  staffs.setEmail("ancau@gmail.com");
	  staffs.setPhone("01234567890123456789012345");
	  staffs.setSalary(1000);
	  staffs.setLevel((byte) 1);
	  staffs.setNotes("hihi");
	  
	  boolean kq= staffsDao.addStaffs(staffs);
	  Assert.assertEquals(false, kq);
  }

}
