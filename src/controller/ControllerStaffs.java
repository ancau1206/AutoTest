package controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import dao.DepartsDAO;
import dao.RecordsDAO;
import dao.StaffsDAO;
import pojo.Departs;
import pojo.Staffs;

@Controller
@RequestMapping(value = "/nhanvien")
public class ControllerStaffs {
	@Autowired
	StaffsDAO staffsDao;
	@Autowired
	ServletContext context;
	@Autowired
	RecordsDAO recordsDao;

	@RequestMapping(value= "index")
	public String get(ModelMap model) {
		try {
			model.addAttribute("records", recordsDao.getTop10Records());
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "thanhtich";
	}
	@RequestMapping("list")
	public String listStaffs(ModelMap model) {
		model.addAttribute("staffs", staffsDao.getListStaffs());
		return "index2";
	}

	@RequestMapping(value = "/them", method = RequestMethod.GET)
	public String showInsert(ModelMap modelMap) {
		modelMap.addAttribute("Staffs", new Staffs());
		modelMap.addAttribute("url", "them");
		return "updateNhanVien";
	}

	@RequestMapping(value = "/them", method = RequestMethod.POST)
	public String addNhanVien(ModelMap model, Staffs staffs, @RequestParam("photo2") MultipartFile image) {
		String photo = uploadImage(model, image);
		staffs.setPhoto(photo);
		if (staffsDao.addStaffs(staffs) == true) {
			model.addAttribute("staffs", staffsDao.getListStaffs());
			return "redirect:/nhanvien/list";
		} else {
			model.addAttribute("message", "Thêm nhân viên thất bại");
			model.addAttribute("Staffs", staffs);
			return "updateNhanVIen";
		}

	}

	@RequestMapping(value = "list/xoa/{id}", method = RequestMethod.GET)
	public void deletePhongban(ModelMap model, @PathVariable Long id) {
		Staffs Staffs = staffsDao.getByid(id);
		staffsDao.deleteStaffs(Staffs);

	}

	@RequestMapping(value = "sua/{id}")
	public String showUpdate(ModelMap model, @PathVariable("id") Long id) {
		System.out.println("-------------" + id); 
		
		model.addAttribute("Staffs", staffsDao.getByid(id));
		model.addAttribute("url", "sua");
		return "updateNhanVien";
	}

	@RequestMapping(value = "sua", method = RequestMethod.POST)
	public String showUpdate(@ModelAttribute("Staffs") Staffs Staffs, ModelMap model, @RequestParam("photo2") MultipartFile image) {
		String photo = uploadImage(model, image);
		System.out.println("name: " + photo);
		System.out.println(Staffs.getPhoto());
		if(!photo.equals("")) {
			System.out.println("name: " + photo);
			System.out.println(Staffs.getPhoto());
			Staffs.setPhoto(photo);
		}
		
		
		if (staffsDao.updateStaffs(Staffs)) {
			return "redirect:/nhanvien/list";
		} else {
			model.addAttribute("error", "Lưu không thành công");
			return "updatePhongBan";
		}
	}

	@RequestMapping(value = "xem/{id}")
	public String showChitiet(ModelMap model, @PathVariable("id") Long id) {
		model.addAttribute("Staffs", staffsDao.getByid(id));
		return "chitietnhanvien";
	}

	@Autowired
	DepartsDAO departsDao;

	@ModelAttribute("Departs")
	public List<Departs> getDepart() {
		List<Departs> Departs = departsDao.getListDeparts(0, 10);
		return Departs;

	}

	public String uploadImage(ModelMap map, MultipartFile image) {
		if (image.isEmpty()) {
			System.out.println("File error");
			return "";
		} else {
			try {
				String path = context.getRealPath("/resources/img/") + image.getOriginalFilename();
				System.out.println(path);
				image.transferTo(new File(path));
				return image.getOriginalFilename();
			} catch (Exception e) {
				System.out.println("Loi: " + e);
				return "";
			}
		}
	}
}
