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
public class Jogo {
       public static void main(String[] args) {
       
       String nome;
       int status;
       
      
       Scanner scanner = new Scanner(System.in);
       System.out.println("Programa rodando...");
       System.out.println("BEM VINDO AO JOGO DE XADREZ!");
       System.out.println("Por gentileza, insira o nome do jogador 1 (peças brancas):");
       Jogador j1 = new Jogador("branca");
       nome = scanner.nextLine();
       j1.setNomeJogador(nome);
       System.out.println("Por gentileza, insira o nome do jogador 2 (peças pretas):");
       Jogador j2 = new Jogador("preta");
       nome = scanner.nextLine();
       j2.setNomeJogador(nome);
       Tabuleiro tb = new Tabuleiro(j1, j2);
       
       while(true){
           System.out.println("Entre com sua opção: (1) INICIAR JOGO / (2) SAIR");
           int op = scanner.nextInt();
           switch(op){
               case 1:
                   System.out.println("Jogo iniciado com sucesso!");
                   status = 1;
                   System.out.println("---------- TABULEIRO ----------");
                   tb.printTabuleiro();
                   System.out.println("-------------------------------");
                   
                   System.out.println("Vez do jogador: " + j1.getNomeJogador());
                   System.out.println("Escolha uma peça disponível: ");
                   nome = scanner.next();
                   System.out.println("Ótimo! Agora insira a coordenada que deseja que a peça irá!");
                   int c1 = scanner.nextInt();
                   int c2 = scanner.nextInt();
                   switch(nome){
                       case "ce":
                    	   int linha = j1.ce.getLinha();
                    	   int coluna = j1.ce.getColuna();
                           if(j1.ce.checaMovimento(linha, coluna, c1, c2)){
                               System.out.println("Movimento válido!");
                               j1.ce.setPosicao(c1, c2);
                               tb.atualizaTabuleiro(linha, coluna);
                               tb.colocaPecaNoTabuleiroCv(j1.ce);
                           } else {
                               System.out.println("Movimento inválido!");
                           }
                        System.out.println("---------- TABULEIRO ----------");
                        tb.printTabuleiro();
                        System.out.println("-------------------------------");
                        break;
                   }
                   break;
               case 2:
                   break;
               default:
                   break;
           }
          if(op == 2){
              break;
          }
		}

	}
}
