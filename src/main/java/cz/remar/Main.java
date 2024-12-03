package cz.remar;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String select = "SELECT * FROM pokemon";
        String connectionUrl = "jdbc:mysql://localhost:3306/pokemons";
        String catchtable = "";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl, "root", "password");
            PreparedStatement ps = conn.prepareStatement(select);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("pokemon_name");
                int trainer = rs.getInt("id_trainer");
                if (trainer > 0){
                    catchtable = "NE";
                }else {
                    catchtable = "ANO";
                }
                System.out.println("Jméno: " + name + " můžeme ho chytat: " + catchtable);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}