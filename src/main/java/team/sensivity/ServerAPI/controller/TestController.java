package team.sensivity.ServerAPI.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sensivity.ServerAPI.auth.Roles;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String helloWorld(){
         return "test";
    }

    @GetMapping("/test")
    public String getTEst(){
     return "test";
    }
}
