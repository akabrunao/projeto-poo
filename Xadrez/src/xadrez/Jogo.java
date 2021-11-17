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
			Posicao posicaoComPecaAdversaria = tb.getPosicao(c1, c2);

			if (posicaoComPecaAdversaria.getOcupada()) {
				posicaoComPecaAdversaria.getPeca().captura();
			}

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
					printarTabuleiro(tb);

					if (tb.reiEmXeque(jogador[i].rei)) {
						System.out.println("Rei do jogador: " + jogador[i].getNomeJogador() + " está em xeque!");
					}

					if (tb.reiEmXequeMate(jogador[i].rei)) {
						System.out.println("Rei do jogador: " + jogador[i].getNomeJogador() + " está em xeque mate!");
						System.out.println("Fim de Jogo!");
						if (i == 0) {
							System.out.println(jogador[1].getCorJogador() + " foi o vencedor! Parabens!");
						} else {
							System.out.println(jogador[0].getCorJogador() + " foi o vencedor! Parabens!");
						}
						return;
					}

					System.out.println("Escolha uma pe�a dispon�vel: ");
					String nome = scanner.next();
					nome = nome.toLowerCase();

					switch (nome) {
					case "p1":
						if (jogador[i].p1.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p1, tb));
						break;

					case "p2":
						if (jogador[i].p2.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p2, tb));
						break;

					case "p3":
						if (jogador[i].p3.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p3, tb));
						break;

					case "p4":
						if (jogador[i].p4.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p4, tb));
						break;

					case "p5":
						if (jogador[i].p5.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p5, tb));
						break;

					case "p6":
						if (jogador[i].p6.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p6, tb));
						break;

					case "p7":
						if (jogador[i].p7.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p7, tb));
						break;

					case "p8":
						if (jogador[i].p8.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].p8, tb));
						break;

					case "be":
						if (jogador[i].be.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].be, tb));
						break;

					case "bd":
						if (jogador[i].bd.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].bd, tb));
						break;

					case "ce":
						if (jogador[i].ce.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].ce, tb));
						break;

					case "cd":
						if (jogador[i].cd.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].cd, tb));
						break;

					case "r":
						if (jogador[i].rei.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].rei, tb));
						break;

					case "te":
						if (jogador[i].te.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].te, tb));
						break;

					case "td":
						if (jogador[i].td.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].td, tb));
						break;

					case "d":
						if (jogador[i].dama.isCapturada()) {
							System.out.println("Essa peça já foi capturada, escolha outra");
							continue;
						}
						while (!moverPosicao(jogador[i], jogador[i].dama, tb));
						break;

					default:
						System.out.println("A peça digitada não é válida");
						continue;
					}

					/*
					 * System.out.
					 * println("Aperte 1 se quiser continuar o jogo e 2 para encerrar o jogo."); op
					 * = scanner.nextInt(); if (op == 2) { break; }
					 */

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