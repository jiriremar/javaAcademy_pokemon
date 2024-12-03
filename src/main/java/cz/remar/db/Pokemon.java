package cz.remar.db;

public class Pokemon {
    private final int id;
    private final String pokemonName;
    private final String pokemonTrainer;
    private final String pokemonType;
    private String catchable;

    public Pokemon(int id, String pokemonName, String pokemonTrainer, String pokemonType, String catchable) {
        this.id = id;
        this.pokemonName = pokemonName;
        this.pokemonTrainer = pokemonTrainer;
        this.pokemonType = pokemonType;
        this.catchable = catchable;
    }

    public int getId() {
        return id;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonTrainer() {
        return pokemonTrainer;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public String getCatchable() {
        return catchable;
    }


    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", pokemonName='" + pokemonName + '\'' +
                ", pokemonTrainer='" + pokemonTrainer + '\'' +
                ", pokemonType='" + pokemonType + '\'' +
                ", catchable='" + catchable + '\'' +
                '}';
    }
}
