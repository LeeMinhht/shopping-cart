package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.domain.Account;
import poly.edu.domain.Authority;
import poly.edu.service.AccountService;
import poly.edu.service.AuthorityService;

import java.util.List;

@Controller
public class AuthoController {
    @Autowired
    AuthorityService authorityService;

    @Autowired
    AccountService accountService;
    @RequestMapping("/getRole")
    public String getRole(Model model){
//
//        List<RoleDto> list = authorityService.findRoleByUsername("LeeMinh");
//        model.addAttribute("list",list);
        List<Authority> list = authorityService.findAll();
        model.addAttribute("list",list);
        System.out.println(list.size());
        return "admins/accounts/list";
    }

    @GetMapping("List/account")
    public String getAccount(Model model){
        List<Account> list =accountService.findAll();
        model.addAttribute("accounts",list);
        return "admins/accounts/list";
    }
}
