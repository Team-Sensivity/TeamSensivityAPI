package team.sensivity.ServerAPI.object;

public class DiscordUser {
    private String discord_id;
    private String discord_pb;
    private String discord_username;
    private int user_points;

    public DiscordUser(String discord_id, String discord_pb, String discord_username, int user_points){
        this.discord_id = discord_id;
        this.discord_pb = discord_pb;
        this.discord_username = discord_username;

        this.user_points = user_points;
    }

    public DiscordUser(){
        this.discord_id = null;
        this.discord_username = null;
        this.discord_pb = null;

        this.user_points = 0;
    }

    public int getUser_points() {
        return user_points;
    }

    public String getDiscord_id() {
        return discord_id;
    }

    public String getDiscord_pb() {
        return discord_pb;
    }

    public String getDiscord_username() {
        return discord_username;
    }

    public void setDiscord_id(String discord_id) {
        this.discord_id = discord_id;
    }

    public void setDiscord_pb(String discord_pb) {
        this.discord_pb = discord_pb;
    }

    public void setDiscord_username(String discord_username) {
        this.discord_username = discord_username;
    }

    public void setUser_points(int user_points) {
        this.user_points = user_points;
    }
}
