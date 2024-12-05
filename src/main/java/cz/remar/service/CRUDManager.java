package cz.remar.service;

import cz.remar.db.DBPokemonService;
import cz.remar.db.Pokemon;
import cz.remar.utility.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class CRUDManager {
    private final DBPokemonService dbPokemonService;

    public CRUDManager() {
        this.dbPokemonService = new DBPokemonService();
    }

    public void printOptions() {
        System.out.println("Hello, welcome to Pokemon world.");
        while (true) {
            System.out.println("\n0 - Get all Pokemon and your trainer");
            System.out.println("1 - Get all Pokemon");
            System.out.println("2 - Get all catchable Pokemon");
            System.out.println("3 - Get all Trainer");
            System.out.println("4 - Catch Pokemon");
            System.out.println("5 - New Pokemon");
            System.out.println("6 - New Trainer");
            System.out.println("7 - Exit");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 0 -> printAllPokemonAndTrainer();
                case 1 -> System.out.println("Not implemented");
                case 2 -> System.out.println("Not implemented");
                case 3 -> System.out.println("Not implemented");
                case 4 -> System.out.println("Not implemented");
                case 5 -> System.out.println("Not implemented");
                case 6 -> System.out.println("Not implemented");
                case 7 -> {
                    System.out.println("Good bye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void printAllPokemonAndTrainer() {
        final List<Pokemon> pokemons = dbPokemonService.readAll();
        pokemons.forEach(System.out::println);
    }
}
