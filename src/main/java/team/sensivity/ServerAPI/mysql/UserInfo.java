package team.sensivity.ServerAPI.mysql;

import team.sensivity.ServerAPI.Infos;
import team.sensivity.ServerAPI.object.DiscordUser;
import team.sensivity.ServerAPI.object.UserConnections;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserInfo {
    public static DiscordUser getUserInfos(String id){
        DiscordUser discordUser = new DiscordUser();

        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM users WHERE discord_id = '" + id + "'";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                discordUser.setDiscord_id(id);
                discordUser.setDiscord_pb(rs.getString("discord_pb"));
                discordUser.setDiscord_username(rs.getString("discord_username"));

                discordUser.setUser_points(rs.getInt("points"));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return discordUser;
    }

    public static ArrayList<DiscordUser> getUsers(){
        ArrayList<DiscordUser> users = new ArrayList<>();

        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM users ORDER BY points DESC";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                users.add(new DiscordUser(rs.getString("discord_id"), rs.getString("discord_pb"), rs.getString("discord_username"), rs.getInt("points")));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public static ArrayList<UserConnections> getUserConnections(String id){
        ArrayList<UserConnections> connections = new ArrayList<>();

        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM connections WHERE discord_id = '" + id + "'";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                connections.add(new UserConnections(rs.getString("type"), rs.getString("connect_id"), rs.getString("connect_name")));
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connections;
    }
}
