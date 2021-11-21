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

        try{
            
            System.out.println("Por gentileza, insira o nome do jogador 1 (cor branca):");
            String nome = scanner.nextLine();
            Jogador j1 = new Jogador("branca", nome);

            System.out.println("Por gentileza, insira o nome do jogador 2 (cor preta):");
            nome = scanner.nextLine();
            Jogador j2 = new Jogador("preta", nome);
            jogo.iniciarJogo(j1, j2);
        
        } catch(Exception e){
            System.out.println("Erro: " + e.getLocalizedMessage());
            System.out.println("Jogo será encerrado pois não foi possível inicializá-lo!");
            System.exit(0); 
        }

        

        scanner.close();

    }

}
