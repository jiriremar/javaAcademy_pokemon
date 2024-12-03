package cz.remar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;

public class DBPokemonService {
    private static final String READ_ALL = "SELECT t.trainer_name, p.pokemon_name, p.id_pokemon, pt.type_name\n" +
            "FROM pokemon p\n" +
            "JOIN trainer t ON p.id_trainer = t.id_trainer\n" +
            "JOIN pokemon_type pt ON p.id_type_pokemon = pt.id_type;";

    private static final Logger logger = getLogger(String.valueOf(DBPokemonService.class));
    String catchable = "";

    public List<Pokemon> readAll() {
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_ALL);
        ) {

            ResultSet resultSet = statement.executeQuery();
            List<Pokemon> pokemons = new ArrayList<>();
            while (resultSet.next()) {
                if (resultSet.getString("trainer_name") != null) {
                    catchable = "NE";
                } else if (resultSet.getString("pokemon_name") == null) {
                    catchable = "ANO";
                }
                pokemons.add(new Pokemon(
                        resultSet.getInt("id_pokemon"),
                        resultSet.getString("pokemon_name"),
                        resultSet.getString("trainer_name"),
                        resultSet.getString("type_name"),
                        catchable

                ));
            }
            return pokemons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
