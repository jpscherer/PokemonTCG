package com.example.android.services;

import com.example.android.common.pokemon.Carta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo.Hille on 08/12/2017.
 */

public class CriarListaObjetosServico {
    public static List<Carta> cartas;
    public static List<Carta> cartasParaTroca;
    public static int cartaOferecida;
    public static int cartaRecebida;
    public static boolean iniciado;

    public static boolean isTrocando = false;

    public CriarListaObjetosServico(){
        cartas = new ArrayList<Carta>();
        cartasParaTroca = new ArrayList<Carta>();
        cartas = popularListaCartas();
        cartasParaTroca = popularListCartasParaTroca();
        iniciado = true;
    }

    private List<Carta> popularListaCartas(){
        cartas.add(new Carta(1, "Shroomish", "Primal Clash", "Planta", "https://images.pokemontcg.io/xy5/15.png", "Pokémon", "Básico"));
        cartas.add(new Carta(2, "Breloom","Primal Clash","Planta","https://images.pokemontcg.io/xy5/16.png","Pokémon","Estágio 1"));
        cartas.add(new Carta(3, "Pidgeot","POP Series 2","Incolor","https://images.pokemontcg.io/pop2/2.png","Pokémon","Estágio 2"));
        cartas.add(new Carta(4, "Braixen","XY","Fogo","https://images.pokemontcg.io/xy0/9.png","Pokémon","Estágio 1"));
        cartas.add(new Carta(5, "Panpour","XY","Água","https://images.pokemontcg.io/xy0/11.png","Pokémon","Básico"));
        cartas.add(new Carta(6, "Combee","Ancient Origins","Planta","https://images.pokemontcg.io/xy7/9.png","Pokémon","Básico"));

        return cartas;
    }

    private List<Carta> popularListCartasParaTroca() {
        cartasParaTroca.add(new Carta(7, "Energia Psíquica", "Base Set", "Psiquico", "https://images.pokemontcg.io/gym1/131.png", "Energia", "Básica"));
        cartasParaTroca.add(new Carta(8, "Larvesta","Primal Clash","Fogo","https://images.pokemontcg.io/xy7/16.png","Pokémon","Estágio 1"));
        cartasParaTroca.add(new Carta(9, "Jynx","POP Series 2","Psiquico","https://images.pokemontcg.io/base1/31.png","Pokémon","Estágio 2"));
        cartasParaTroca.add(new Carta(10, "Froakie","XY","Fogo","https://images.pokemontcg.io/xy0/12.png","Pokémon","Estágio 1"));
        cartasParaTroca.add(new Carta(11, "Frogadier","XY","Água","https://images.pokemontcg.io/xy0/13.png","Pokémon","Básico"));
        cartasParaTroca.add(new Carta(12, "Ponyta","Ancient Origins","Planta","https://images.pokemontcg.io/xy11/16.png","Pokémon","Básico"));

        return cartasParaTroca;
    }
}
