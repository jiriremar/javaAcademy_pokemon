package cz.remar.service;

import cz.remar.db.DBPokemonService;
import cz.remar.db.PokemonAll;
import cz.remar.db.PokemonAndTrainer;
import cz.remar.utility.InputUtils;

import java.util.List;

public class CRUDManager {
    private final DBPokemonService dbPokemonService;

    public CRUDManager() {
        this.dbPokemonService = new DBPokemonService();
    }

    public void printOptions() {
        System.out.println("Hello, welcome to Pokemon world.");
        while (true) {
            System.out.println("\n1 - Get all Pokemon and your trainer");
            System.out.println("2 - Get all Pokemon");
            System.out.println("3 - Get all catchable Pokemon");
            System.out.println("4 - Get all Trainer");
            System.out.println("5 - Catch Pokemon");
            System.out.println("6 - New Pokemon");
            System.out.println("7 - New Trainer");
            System.out.println("8 - Exit");
            System.out.print("Enter your choice: ");

            final int choice = InputUtils.readInt();
            switch (choice) {
                case 1 -> printAllPokemonAndTrainer();
                case 2 -> printAllPokemon();
                case 3 -> System.out.println("Not implemented");
                case 4 -> System.out.println("Not implemented");
                case 5 -> System.out.println("Not implemented");
                case 6 -> System.out.println("Not implemented");
                case 7 -> System.out.println("Not implemented");
                case 8 -> {
                    System.out.println("Good bye");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    public void printAllPokemonAndTrainer() {
        final List<PokemonAndTrainer> pokemons = dbPokemonService.readAllPokemonAndTrainer();
        pokemons.forEach(System.out::println);
    }

    public void printAllPokemon() {
        final List<PokemonAll> pokemons = dbPokemonService.readAllPokemon();
        pokemons.forEach(System.out::println);
    }
}
