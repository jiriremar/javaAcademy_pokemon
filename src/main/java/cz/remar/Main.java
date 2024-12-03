package cz.remar;

import cz.remar.db.DBPokemonService;
import cz.remar.db.HikaryCPDataSource;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        DBPokemonService service = new DBPokemonService();
        service.readAll().forEach(System.out::println);
    }
}