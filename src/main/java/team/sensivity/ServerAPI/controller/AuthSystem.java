package team.sensivity.ServerAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.sensivity.ServerAPI.auth.Roles;

import static team.sensivity.ServerAPI.auth.UserAuth.getJWTToken;

@RestController
public class AuthSystem {
    @GetMapping("/admin/createUser/{discordId}")
    public String createUser(@PathVariable String discordId){
        String token = getJWTToken(discordId, Roles.ADMIN);

        return token;
    }
}
