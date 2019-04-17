package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.RecordsDAO;
import dao.UserDAO;

@Controller
@RequestMapping()
public class ControllerUser {
	@Autowired
	UserDAO gUser;
	@Autowired
	RecordsDAO recordsDao;
@RequestMapping(value= {"/"},method=RequestMethod.GET)
public String index() {
	return "login";
}

/*
@RequestMapping(value = "checkLogin", method = RequestMethod.POST)
public String Login(HttpServletRequest req, HttpSession ses, ModelMap model) {
	String user = req.getParameter("user");
	String pass = req.getParameter("pass");
	System.out.println(user + pass);
	if (gUser.checkLogin(user, pass)) {
		ses.setAttribute("user", user);
		model.addAttribute("records", recordsDao.getTop10Records());
		return "thanhtich";
	} else {
		model.addAttribute("messenger", "Sai tài khoản hoặc mật khẩu.");
		return "login";
	}

}*/
}
