package br.edu.up.recyclerlist01;

import java.util.ArrayList;

public class ContatoLista {

    private static ArrayList<Contato> listaContatos = new ArrayList<>();

    public static void addContato(Contato c){
        listaContatos.add(c);
    }

    public static Contato getContato(int index){
        return listaContatos.get(index);
    }

    public static ArrayList<Contato> getLista(){
        return listaContatos;
    }


    public static void gerarLista(){

        listaContatos.add(new Contato("Huguinho", "3256-8956",
                "huguinho@duck.com", "Rua da paz, 123"));

        listaContatos.add(new Contato("Zézinho", "3256-8956",
                "zezinho@duck.com", "Rua da paz, 123"));

        listaContatos.add(new Contato("Luizinho", "3256-8956",
                "luizinho@duck.com", "Rua da paz, 123"));

        listaContatos.add(new Contato("João", "3234-5678",
                "joao@semmaria.com", "Bosque da bruxa, 321"));

        listaContatos.add(new Contato("Maria", "99222-8956",
                "maria@semjoao.com", "Indefinido"));
    }

    public static void deletarContato(int index){
        listaContatos.remove(index);
    }
}
