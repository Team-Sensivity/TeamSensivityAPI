package team.sensivity.ServerAPI.controller.server;

import org.springframework.web.bind.annotation.*;
import team.sensivity.ServerAPI.function.Whitelist;

import java.io.IOException;

@RestController
public class EcoUserController {

    @PostMapping("/addID/{steamid}")
    public void addID(@PathVariable String steamid) throws IOException {
        Whitelist.addID(steamid);
    }

    @PostMapping("/removeID/{steamid}")
    public void removeID(@PathVariable String steamid) throws IOException {
        Whitelist.removeID(steamid);
    }
}
