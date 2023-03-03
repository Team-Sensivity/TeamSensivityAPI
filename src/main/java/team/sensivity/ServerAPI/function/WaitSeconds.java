package team.sensivity.ServerAPI.function;

import team.sensivity.ServerAPI.Infos;
import team.sensivity.ServerAPI.mysql.UpdateStatus;

public class WaitSeconds {
    public static void waitnow(String status, String row){
        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        UpdateStatus.updateStatus(row, status);
                        System.out.println("Datenbank aktuell");

                        if(status.equals("stop_status")){
                            Infos.Status = 1;
                        }else if(status.equals("start_status")){
                            Infos.Status = 0;
                        }
                    }
                },
                1000 * 60 * 2
        );
    }
}
