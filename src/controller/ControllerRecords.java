package controller;

import java.sql.Date;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.RecordsDAO;
/*import dao.StaffsDAO;
import pojo.Records;
import pojo.Staffs;

@Controller
public class ControllerRecords {
	@Autowired
	RecordsDAO recordsDao;
	@Autowired StaffsDAO std;
	@Autowired JavaMailSender mailer;
	

	@RequestMapping("/xephang")
	public String listRecords(ModelMap model) {
		model.addAttribute("records", recordsDao.getListRecords());
		
		return "xephang";
	}
	@RequestMapping("xephang/them/{id}")
	public String addthanhtich(ModelMap model,@PathVariable Long id) {
		System.out.println("-----------"+ id);
		model.addAttribute("id", std.getByid(id).getId());
		model.addAttribute("email", std.getByid(id).getEmail());
		model.addAttribute("records", recordsDao.getListRecords());
		return "addthanhtich";
	}
	@RequestMapping("/xephangphongban")
	public String listRecordsPhongBan(ModelMap model) {
		model.addAttribute("recordspb", recordsDao.getListRecordsDeparts());
	
		return "xephangphongban";
	}
	@RequestMapping(value="themmm",method=RequestMethod.POST)
	public String add(@PathParam("id2") Long id2,  @RequestParam("reason") String reason, @RequestParam("type") int type, @PathParam("email") String email) {
	
		System.out.println("-----------"+ id2);
		System.out.println("-----------"+ reason);
		String subject;
		if(type==1) {
		subject="Thông báo khen thưởng";
	}
	else {
		subject="Thông báo kỉ luật";
	}
		if(recordsDao.insertRecord(id2, reason, type)) {
			if(send("Manager", email, subject, reason)) {
				System.out.println("----------Thành coong");
			}
			else {
				System.out.println("------------Loi");
			}
			return "redirect:/xephang/";
		}
		else {
			return "addthanhtich";
		}
		
		
	}
	public boolean send(String from, String to, String subject, String body) {
		try {
		
			MimeMessage mail = mailer.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail);
			helper.setFrom(from,from);
			helper.setTo(to);
			helper.setReplyTo(from,from);
			helper.setSubject(subject);
			helper.setText(body,true);
			mailer.send(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
*/