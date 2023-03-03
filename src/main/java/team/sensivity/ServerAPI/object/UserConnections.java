package team.sensivity.ServerAPI.object;

public class UserConnections {
    private String type;
    private String connect_id;
    private String connect_username;

    public UserConnections(String type, String connect_id, String connect_username){
        this.type = type;
        this.connect_id = connect_id;
        this.connect_username = connect_username;
    }

    public String getConnect_id() {
        return connect_id;
    }

    public String getConnect_username() {
        return connect_username;
    }

    public String getType() {
        return type;
    }
}
