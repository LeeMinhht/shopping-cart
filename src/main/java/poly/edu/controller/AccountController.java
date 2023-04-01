package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.domain.Account;
import poly.edu.domain.Authority;
import poly.edu.domain.Role;
import poly.edu.service.AccountService;
import poly.edu.service.AuthorityService;

import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AuthorityService authorityService;
    @RequestMapping("/account/register")
    public String register(Model model){
        model.addAttribute("account",new Account());
        return "admins/accounts/register";
    }
    @PostMapping ("/account/register")
    public String register(Model model,@ModelAttribute("account")Account account){
        Optional<Account> ac = accountService.findById(account.getUsername());

        if(ac.isPresent()){

            model.addAttribute("message","Username không hợp lệ");
            return "admins/accounts/register";
        }
        account.setPhoto("User.jpg");
        accountService.save(account);
        Role role= new Role();
        role.setId("CUS");
        role.setName("CUSTOMER");

        Authority autho = new Authority();
        autho.setAccount(account);
        autho.setRole(role);
        authorityService.save(autho);
        model.addAttribute("message","Đăng kí thành công");
        return "admins/accounts/loginnn";
    }
}
