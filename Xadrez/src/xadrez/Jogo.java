/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import java.util.Scanner;

/**
 * Classe que lida com tudo relacionado ao jogo, como a inicializa��o do mesmo e
 * o gerenciamento das jogadas.
 *
 * @author Daniele
 */
public class Jogo {

	Scanner scanner = new Scanner(System.in);

	/**
	 * M�todo que cria os dois jogadores e o tabuleiro para que o jogo possa ser
	 * inicializado.
	 */
	public void iniciarJogo(Jogador[] jogador) {
		// Inicializa o programa e recolhe os nomes dos jogadores
		System.out.println("Programa rodando...");
		System.out.println("BEM VINDO AO JOGO DE XADREZ!");
		System.out.println("Por gentileza, insira o nome do jogador 1 (pe�as brancas):");

		// Cria o tabuleiro
		Tabuleiro tb = new Tabuleiro(jogador[0], jogador[1]);

		jogador[0].inicializaJogador(tb);
		jogador[1].inicializaJogador(tb);

		// Chama a fun��o para jogar
		jogar(jogador, tb);
	}

	/**
	 * M�todo que faz uma chamada ao tabuleiro para que o mesmo seja impresso na
	 * tela.
	 * 
	 * @param tb Recebe o tabuleiro para que a chamada possa ser executada
	 */
	public void printarTabuleiro(Tabuleiro tb) {
		System.out.println("---------- TABULEIRO ----------");
		tb.printTabuleiro();
		System.out.println("-------------------------------");
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1 Recebe o jogador que ter� sua pe�a movida
	 * @param p  Recebe a pe�a que ser� movida
	 * @param tb Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */

	private boolean moverPosicao(Jogador j1, Peca p, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		char letra = scanner.nextLine().charAt(1);
		int c2 = letra - 97;
		int linha = p.getLinha();
		int coluna = p.getColuna();

		if (p.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			p.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(p);
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que lida com o jogo, gerenciando todas as jogadas.
	 * 
	 * @param jogador Recebe os dois jogadores do jogo
	 * @param tb      Recebe o tabuleiro
	 */
	public void jogar(Jogador[] jogador, Tabuleiro tb) {
		while (true) {
			System.out.println("Entre com sua op��o: (1) INICIAR JOGO / (2) SAIR");
			int op = scanner.nextInt();
			switch (op) {
			case 1:
				int i = 0;
				while (true) {
					System.out.println("Vez do jogador: " + jogador[i].getNomeJogador());
					System.out.println("Escolha uma pe�a dispon�vel: ");
					printarTabuleiro(tb);
					String nome = scanner.next();
					nome = nome.toLowerCase();
					switch (nome) {
					case "p1":
						while (!moverPosicao(jogador[i], jogador[i].p1, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p2":
						while (!moverPosicao(jogador[i], jogador[i].p2, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p3":
						while (!moverPosicao(jogador[i], jogador[i].p3, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p4":
						while (!moverPosicao(jogador[i], jogador[i].p4, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p5":
						while (!moverPosicao(jogador[i], jogador[i].p5, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p6":
						while (!moverPosicao(jogador[i], jogador[i].p6, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p7":
						while (!moverPosicao(jogador[i], jogador[i].p7, tb))
							;
						printarTabuleiro(tb);
						break;
					case "p8":
						while (!moverPosicao(jogador[i], jogador[i].p8, tb))
							;
						printarTabuleiro(tb);
						break;
					case "be":
						while (!moverPosicao(jogador[i], jogador[i].be, tb))
							;
						printarTabuleiro(tb);
						break;
					case "bd":
						while (!moverPosicao(jogador[i], jogador[i].bd, tb))
							;
						printarTabuleiro(tb);
						break;
					case "ce":
						while (!moverPosicao(jogador[i], jogador[i].ce, tb))
							;
						printarTabuleiro(tb);
						break;
					case "cd":
						while (!moverPosicao(jogador[i], jogador[i].cd, tb))
							;
						printarTabuleiro(tb);
						break;
					case "r":
						while (!moverPosicao(jogador[i], jogador[i].rei, tb))
							;
						printarTabuleiro(tb);
						break;
					case "te":
						while (!moverPosicao(jogador[i], jogador[i].te, tb))
							;
						printarTabuleiro(tb);
						break;
					case "td":
						while (!moverPosicao(jogador[i], jogador[i].td, tb))
							;
						printarTabuleiro(tb);
						break;
					case "d":
						while (!moverPosicao(jogador[i], jogador[i].dama, tb))
							;
						printarTabuleiro(tb);
						break;
					}

					System.out.println("Aperte 1 se quiser continuar o jogo e 2 para encerrar o jogo.");
					op = scanner.nextInt();
					if (op == 2) {
						break;
					}

					if (i == 0) {
						i = 1;
					} else {
						i = 0;
					}
				}

			case 2:
				scanner.close();
				System.out.println("O jogo foi finalizado.");
				break;
			default:
				break;

			}
			if (op == 2) {
				break;
			}
		}
	}

}