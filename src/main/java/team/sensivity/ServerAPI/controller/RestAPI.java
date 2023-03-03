package team.sensivity.ServerAPI.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import team.sensivity.ServerAPI.mysql.UserInfo;
import team.sensivity.ServerAPI.object.DiscordUser;
import team.sensivity.ServerAPI.object.UserConnections;

import java.util.ArrayList;

@RestController
public class RestAPI {
    @GetMapping("/auth/getUser/{discordId}")
    public String getUserFromID(@PathVariable String discordId){

        DiscordUser user = UserInfo.getUserInfos(discordId);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";

        try {
            json = ow.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    @GetMapping("/auth/getUsers")
    public String getUserFromID(){

        ArrayList<DiscordUser> user = UserInfo.getUsers();

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";

        try {
            json = ow.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }

    @GetMapping("/auth/getConnections/{discordId}")
    public String getConnectionsFromID(@PathVariable String discordId){

        ArrayList<UserConnections> connections = UserInfo.getUserConnections(discordId);

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = "";

        try {
            json = ow.writeValueAsString(connections);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return json;
    }
}
