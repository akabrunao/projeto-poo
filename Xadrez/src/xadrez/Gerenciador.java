/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import java.util.Scanner;

/**
 *
 * @author Daniele
 */
public class Gerenciador {

    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Programa rodando...");
        System.out.println("BEM VINDO AO JOGO DE XADREZ!");

        
        System.out.println("Por gentileza, insira o nome do jogador 1 (cor branca):");
        Jogador j1 = new Jogador("branca");
        String nome = scanner.nextLine();
        j1.setNome(nome);

        System.out.println("Por gentileza, insira o nome do jogador 2 (cor preta):");
        Jogador j2 = new Jogador("preta");
        nome = scanner.nextLine();
        j2.setNome(nome);

        jogo.iniciarJogo(j1, j2);

        scanner.close();

    }

}
