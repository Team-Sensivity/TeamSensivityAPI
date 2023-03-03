package team.sensivity.ServerAPI.mysql;

import team.sensivity.ServerAPI.Infos;

import java.sql.*;

public class UpdateStatus {
    public static void updateStatus(String row, String newInfos){
        try {
            Connection con = Connect.getConnection();

            PreparedStatement posted = con.prepareStatement("UPDATE server_infos SET " + row + " = '" + newInfos + "' WHERE servername = '" + Infos.servername + "'");

            posted.executeUpdate();
            con.close();

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isOn(String status){
        boolean exist = false;
        try {
            Connection con = Connect.getConnection();
            String sql = "SELECT * FROM server_infos";
            Statement stmt  = con.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);

            while (rs.next()) {
                if(Infos.servername.equals(rs.getString("servername"))){
                    if(rs.getString(status).equals("1")){
                        exist = true;
                    }
                }

            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exist;
    }
}
