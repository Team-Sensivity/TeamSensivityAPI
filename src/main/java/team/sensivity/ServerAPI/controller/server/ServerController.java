package team.sensivity.ServerAPI.controller.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import team.sensivity.ServerAPI.Infos;
import team.sensivity.ServerAPI.function.WaitSeconds;
import team.sensivity.ServerAPI.mysql.UpdateStatus;

import java.io.IOException;

@RestController
public class ServerController {
    @GetMapping("/stop-server")
    public String stopServer(){

        if(UpdateStatus.isOn("stop_status")) {
            ProcessBuilder pb = new ProcessBuilder("/home/michel929/stop.sh");
            try {
                Process p = pb.start();
                System.out.println("Stoppe Server");
                UpdateStatus.updateStatus("stop_status", "0");
                UpdateStatus.updateStatus("neustart_status", "0");

                WaitSeconds.waitnow("1", "start_status");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return "Stoppe Server";
    }

    @GetMapping("/start-server")
    public String startServer(){

        if(UpdateStatus.isOn("start_status")) {
            ProcessBuilder pb = new ProcessBuilder("/home/michel929/start.sh");
            try {
                Process p = pb.start();
                System.out.println("Starte Server");
                UpdateStatus.updateStatus("start_status", "0");

                WaitSeconds.waitnow("1", "stop_status");
                WaitSeconds.waitnow("1", "neustart_status");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return "Starte Server";
    }

    @GetMapping("/status")
    public String getStatus(){
        return String.valueOf(Infos.Status);
    }
}
