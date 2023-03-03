package team.sensivity.ServerAPI.function;

import java.io.IOException;
import java.util.List;

import static team.sensivity.ServerAPI.function.EditFile.readFile;
import static team.sensivity.ServerAPI.function.EditFile.saveFile;

public class ReservSlot {
    public static void addID(String ID) throws IOException {
        List<String> file = readFile("/home/michel929/eco/Configs/Users.eco");

        System.out.println("ID wurde hinzugefügt (ID: " + ID + ")");

        ID = "\"" + ID + "\",";

        int i = file.indexOf("    \"UsersWithReserverSlotsAtQueue\": {");
        String lastID = file.get(i + 5) + ",";
        file.add(i + 5, ID);

        saveFile(file, "/home/michel929/eco/Configs/Users.eco");

    }

    public static void removeID(String ID) throws IOException {
        List<String> file = readFile("/home/michel929/eco/Configs/Users.eco");
        System.out.println("ID wurde entfernt (ID: " + ID + ")");

        ID = "\"" + ID + "\",";

        if(file.contains(ID)) {
            file.remove(ID);

            saveFile(file, "/home/michel929/eco/Configs/Users.eco");
        }else {
            System.out.println("Fehler ist aufgetreten!");
        }
    }
}
