package poly.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.domain.Authority;
import poly.edu.service.AuthorityService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
    @Autowired
    AuthorityService authorityService;

    @GetMapping
    public List<Authority> findAll(){

        return authorityService.findAll();
    }


    //tìm kiếm vai trò của người dùng theo username
//    @GetMapping("{username}")
//    public List<Authority> getRoleByUsername(String username){
//        return authorityService.findRoleByUsername(username);
//    }

//    @PostMapping
//    public Authority post(@RequestBody Authority auth){
//        return authorityService.create(auth);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable("id") Integer id){
//        authorityService.deleteById(id);
//    }
}
