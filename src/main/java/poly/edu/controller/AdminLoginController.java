package poly.edu.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import poly.edu.domain.Account;
import poly.edu.domain.Product;
import poly.edu.model.AdminLoginDto;
import poly.edu.service.AccountService;
import poly.edu.service.ProductService;


import java.util.List;
import java.util.Optional;


@Controller
public class AdminLoginController {
	@Autowired
	AccountService accountService;

	@Autowired
	private ProductService productService;

	@Autowired
	private HttpSession session;
	




	@RequestMapping("/security/login/form")
	public String login(ModelMap model) {
		model.addAttribute(",message", "Vui lòng đăng nhập");
		return "/admins/accounts/loginnn";
	}

	@RequestMapping("/security/login/sucess")
	public String success(Model model){
		model.addAttribute("message", "Dang nhap thanh cong");
		return "redirect:/product/list";
	}

	@RequestMapping("/security/login/error")
	public String loginError(ModelMap model) {
		model.addAttribute("message", "Username or password khong chinh xac");
		return "/admins/accounts/loginnn";
	}

	@RequestMapping("/security/logoff/success")
	public String logoff(Model model){
		model.addAttribute("message", "Dang xuat thanh cong");
		return "/admins/accounts/loginnn";
	}

	@RequestMapping("/security/unauthoried")
	public String denied(Model model){
		model.addAttribute("message", "Ban khong co quyen truy xuat");
		return "/admins/accounts/loginnn";
	}


}	
