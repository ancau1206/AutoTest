package controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.DepartsDAO;
import dao.StaffsDAO;
import javafx.geometry.Side;
import pojo.Departs;
import pojo.Staffs;

@RestController
@RequestMapping(value="/check")
public class ControllerCheck {

	@Autowired
	private StaffsDAO staffsDAO;
	
	@Autowired
	private DepartsDAO departDAO;
	
	@RequestMapping(value="/staff/codeId", method = RequestMethod.POST)
	public String checkCodeId( String codeId, Long id) {
		if (codeId == null || codeId.length() == 0) {
			return "false";
		}
		List<Staffs> staffs = staffsDAO.getByCodeId(codeId);
		if (id == null || id == 0) {
			if (staffs.size() == 0) {
				return "true";
			}else {
				return "false";
			}
		} else {
			Staffs staffs2 = staffsDAO.getByid(id);
			if (staffs.size() == 0) {
				return "true";
			} else {
				if (staffs.contains(staffs2)) {
					return "true";
				} else {
					return "false";
				}
			}
		}
	}
	
	@RequestMapping(value="/depart/codeId", method = RequestMethod.POST)
	public String checkDepartCodeId( String codeId, Integer id) {
		if (codeId == null || codeId.length() == 0) {
			return "false";
		}
		List<Departs> departs = departDAO.getByCodeId(codeId);
		if (id == null || id == 0) {
			if (departs.size() == 0) {
				return "true";
			}else {
				return "false";
			}
		} else {
			Departs departs2 = departDAO.getDeparts(id);
			if (departs.size() == 0) {
				return "true";
			} else {
				if (departs.contains(departs2)) {
					return "true";
				} else {
					return "false";
				}
			}
		}
	}
	
	@RequestMapping(value="/phone", method = RequestMethod.POST)
	public String checkPhone(String phone) {		
		for (int i = 0; i < phone.length(); i++) {
			if  (phone.charAt(i)<48 || phone.charAt(i) > 57) {
				return "false";
			}
		}
		if (phone.length() != 10) {
			return "false";
		}
		return "true";
	}
}
//select codeID
//from Staffs
//where ID=2
