package cz.remar.db;

import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.util.logging.Logger.getLogger;


public class DBPokemonService {

    private static final String READ_ALL_POKEMON_AND_TRAINER = "SELECT t.trainer_name, p.pokemon_name, p.id_pokemon, pt.type_name\n" +
            "FROM pokemon p\n" +
            "JOIN trainer t ON p.id_trainer = t.id_trainer\n" +
            "JOIN pokemon_type pt ON p.id_type_pokemon = pt.id_type;";

    private static final String READ_ALL_POKEMON = "SELECT p.pokemon_name, p.id_pokemon, pt.type_name, p.attack, p.defence, p.id_trainer\n" +
            "FROM pokemon p\n"+
            "JOIN pokemon_type pt ON p.id_type_pokemon = pt.id_type;";

    private static final Logger logger = getLogger(String.valueOf(DBPokemonService.class));
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(DBPokemonService.class);
    private String catchable = "";
    private String endLine = "-----------------------";


    public List<PokemonAndTrainer> readAllPokemonAndTrainer() {
        System.out.println("\nList Pokemon and Trainer\n------------------------");
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_ALL_POKEMON_AND_TRAINER);
        ) {
            ResultSet resultSet = statement.executeQuery();
            List<PokemonAndTrainer> pokemonAndTrainers = new ArrayList<>();
            while (resultSet.next()) {
                if (resultSet.getString("trainer_name") != null) {
                    catchable = "NO";
                } else if (resultSet.getString("pokemon_name") == null) {
                    catchable = "YES";
                }
                pokemonAndTrainers.add(new PokemonAndTrainer(
                        resultSet.getInt("id_pokemon"),
                        resultSet.getString("pokemon_name"),
                        resultSet.getString("trainer_name"),
                        resultSet.getString("type_name"),
                        catchable
                ));
            }
            return pokemonAndTrainers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PokemonAll> readAllPokemon() {
        System.out.println("\nList Pokemon\n------------------------");
        try (
                Connection connection = HikaryCPDataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement(READ_ALL_POKEMON);
        ) {
            ResultSet resultSet = statement.executeQuery();
            List<PokemonAll> pokemons = new ArrayList<>();
            while (resultSet.next()) {
                if (resultSet.getString("id_trainer") != null) {
                    catchable = "NO";
                } else if (resultSet.getString("id_trainer") == null) {
                    catchable = "YES";
                }

                pokemons.add(new PokemonAll(
                        resultSet.getInt("id_pokemon"),
                        resultSet.getString("pokemon_name"),
                        resultSet.getString("type_name"),
                        resultSet.getInt("attack"),
                        resultSet.getInt("defence"),
                        catchable
                ));
            }
        return pokemons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
