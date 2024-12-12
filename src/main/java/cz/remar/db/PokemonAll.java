package cz.remar.db;

public class PokemonAll {
    private final int id_pokemon;
    private final String pokemonName;
    private final String pokemonType;
    private final int pokemonAttack;
    private final int pokemonDefense;
    private String catchable = "";

    public PokemonAll(int id_pokemon, String pokemonName, String pokemonType, int pokemonAttack, int pokemonDefense, String catchable) {
        this.id_pokemon = id_pokemon;
        this.pokemonName = pokemonName;
        this.pokemonType = pokemonType;
        this.pokemonAttack = pokemonAttack;
        this.pokemonDefense = pokemonDefense;
        this.catchable = catchable;
    }

    public int getId_pokemon() {
        return id_pokemon;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return pokemonType;
    }

    public int getPokemonAttack() {
        return pokemonAttack;
    }

    public int getPokemonDefense() {
        return pokemonDefense;
    }

    public String getCatchable() {
        return catchable;
    }

    @Override
    public String toString() {
        return "    " +
                "ID=" + id_pokemon +
                ", Pokemon name='" + pokemonName + '\'' +
                ", Pokemon type='" + pokemonType + '\'' +
                ", Pokemon attack=" + pokemonAttack +
                ", Pokemon defence=" + pokemonDefense +
                ", catchable='" + catchable;
    }
}
