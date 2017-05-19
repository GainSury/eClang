package controller;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

	@RequestMapping(value = { "/", "index" },method=RequestMethod.GET)
	public String showHomePage(Model model) {
		model.addAttribute("msg", "hello world!");
		return "home";
	}
}
