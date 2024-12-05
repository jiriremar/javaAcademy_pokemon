package cz.remar;

import cz.remar.db.DBPokemonService;
import cz.remar.db.HikaryCPDataSource;
import cz.remar.service.CRUDManager;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        CRUDManager crudManager = new CRUDManager();
        crudManager.printOptions();
    }
}