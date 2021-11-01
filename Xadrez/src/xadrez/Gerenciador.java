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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogo jogo = new Jogo();

        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Programa rodando...");
		System.out.println("BEM VINDO AO JOGO DE XADREZ!");
		System.out.println("Por gentileza, insira o nome do jogador 1 (pe�as brancas):");

		// Cria os jogadores
		Jogador[] jogador = new Jogador[2];
        

		jogador[0] = new Jogador("branca");
		String nome = scanner.nextLine();
		jogador[0].setNomeJogador(nome);
		System.out.println("Por gentileza, insira o nome do jogador 2 (pe�as pretas):");
		jogador[1] = new Jogador("preta");
		nome = scanner.nextLine();
		jogador[1].setNomeJogador(nome);

		jogo.iniciarJogo(jogador);
        
		

    }
    
}
