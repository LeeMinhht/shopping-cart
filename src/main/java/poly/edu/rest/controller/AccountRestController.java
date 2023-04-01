package poly.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.domain.Account;
import poly.edu.domain.Role;
import poly.edu.service.AccountService;
import poly.edu.service.RoleService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
    @Autowired
    AccountService accountService;

//    @GetMapping()
//    public List<Account> getAccounts(@RequestParam("admin")Optional<Boolean> admin){
//        if(admin.orElse(false)){
//            return accountService.getAdministrator();
//        }
//        return accountService.findAll();
//    }

    @GetMapping()
    public List<Account> getAccounts(){
        return accountService.findAll();
    }

}
