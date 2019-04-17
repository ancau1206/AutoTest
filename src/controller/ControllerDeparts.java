package controller;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.regexp.internal.recompile;

import dao.DepartsDAO;
import dao.StaffsDAO;
import pojo.Departs;
import pojo.Staffs;

@Controller
@RequestMapping(value="/phongban")
public class ControllerDeparts {

	@Autowired
	DepartsDAO departsDao;
	
	@RequestMapping(value="them")
	public String showInsert(ModelMap modelMap) {
		return "addphongban";
	}
	// BẮT ĐẦU QUẢN LÝ PHÒNG BAN
	@RequestMapping("list")
	public String listDepart(ModelMap model) {
		model.addAttribute("departs", departsDao.getListDeparts(0, 10));
		return "phongban";
	}
	
	@RequestMapping(value="/them",method=RequestMethod.POST)
	public String addPhongban(ModelMap model, Departs departs) {
		if(departsDao.addDepart(departs)==true) {
			model.addAttribute("departs", departsDao.getListDeparts(0, 10));
			return "redirect:/phongban/list";
		}else {
			model.addAttribute("error","Thêm phòng ban thất bại");
			return "addphongban";
		}
	}
	
	@RequestMapping(value="/sua/{id}",method=RequestMethod.GET)
	public String getViewPhongban(ModelMap model, @PathVariable int id) {
		Departs departs = departsDao.getDeparts(id);
		if(departsDao.updateDepart(departs)==true) {
			model.addAttribute("departs", departs);
		}else {
			model.addAttribute("error", "Không tìm thấy Phòng Ban");
		}
		return "addphongban";
	}
	
	@RequestMapping(value="/sua",method=RequestMethod.POST)
	public String updatePhongban(ModelMap model, Departs departs) {
		if(departsDao.updateDepart(departs)==true) {
			return "redirect:/phongban/list";
		}else {
			model.addAttribute("error", "Lưu không thành công");
			return "addphongban";
		}
		
	}
	
	@RequestMapping(value="list/xoa/{id}",method=RequestMethod.GET)
	public void deletePhongban(ModelMap model, @PathVariable int id) {
		Departs departs = departsDao.getDeparts(id);
		departsDao.deleteDepart(departs);	
	}
	

}