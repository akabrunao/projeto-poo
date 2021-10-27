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
	private String nome;
	private boolean estado;
	Scanner scanner = new Scanner(System.in);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * M�todo que cria os dois jogadores e o tabuleiro para que o jogo possa ser
	 * inicializado.
	 */
	public void iniciarJogo() {
		// Inicializa o programa e recolhe os nomes dos jogadores
		System.out.println("Programa rodando...");
		System.out.println("BEM VINDO AO JOGO DE XADREZ!");
		System.out.println("Por gentileza, insira o nome do jogador 1 (pe�as brancas):");

		// Cria os jogadores
		Jogador[] jogador = new Jogador[2];

		jogador[0] = new Jogador("branca");
		nome = scanner.nextLine();
		jogador[0].setNomeJogador(this.getNome());
		System.out.println("Por gentileza, insira o nome do jogador 2 (pe�as pretas):");
		jogador[1] = new Jogador("preta");
		nome = scanner.nextLine();
		jogador[1].setNomeJogador(this.getNome());

		// Cria o tabuleiro
		Tabuleiro tb = new Tabuleiro(jogador[0], jogador[1]);

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
	 * @param j1            Recebe o jogador que ter� sua pe�a movida
	 * @param peao          Recebe a pe�a que ser� movida
	 * @param tb            Recebe o tabuleiro
	 * @param estadoInicial Recebe true caso seja o primeiro movimento deste peao
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoPeao(Jogador j1, Peao peao, Tabuleiro tb, boolean estadoInicial) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = peao.getLinha();
		int coluna = peao.getColuna();

		if (peao.checaMovimento(linha, coluna, c1, c2, estadoInicial)) {
			System.out.println("Movimento v�lido!");
			peao.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(peao);
			if (estadoInicial) {
				peao.setEstadoInicial(false);
			}
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1    Recebe o jogador que ter� sua pe�a movida
	 * @param bispo Recebe a pe�a que ser� movida
	 * @param tb    Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoBispo(Jogador j1, Bispo bispo, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = bispo.getLinha();
		int coluna = bispo.getColuna();

		if (bispo.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			bispo.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(bispo);
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1     Recebe o jogador que ter� sua pe�a movida
	 * @param cavalo Recebe a pe�a que ser� movida
	 * @param tb     Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoCavalo(Jogador j1, Cavalo cavalo, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = cavalo.getLinha();
		int coluna = cavalo.getColuna();

		if (cavalo.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			cavalo.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(cavalo);
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1   Recebe o jogador que ter� sua pe�a movida
	 * @param dama Recebe a pe�a que ser� movida
	 * @param tb   Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoDama(Jogador j1, Dama dama, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = dama.getLinha();
		int coluna = dama.getColuna();

		if (dama.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			dama.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(dama);
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1  Recebe o jogador que ter� sua pe�a movida
	 * @param rei Recebe a pe�a que ser� movida
	 * @param tb  Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoRei(Jogador j1, Rei rei, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = rei.getLinha();
		int coluna = rei.getColuna();

		if (rei.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			rei.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(rei);
			return true;
		} else {
			System.out.println("Movimento inv�lido! Por favor, insira uma coordenada v�lida!");
		}
		return false;
	}

	/**
	 * M�todo que l� uma coordenada e checa se a pe�a pode ser movida para essa
	 * posi��o, e ent�o executa o movimento
	 * 
	 * @param j1    Recebe o jogador que ter� sua pe�a movida
	 * @param torre Recebe a pe�a que ser� movida
	 * @param tb    Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contr�rio
	 */
	public boolean moverPosicaoTorre(Jogador j1, Torre torre, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = torre.getLinha();
		int coluna = torre.getColuna();

		if (torre.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento v�lido!");
			torre.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiro(torre);
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
					nome = scanner.next();
					nome = nome.toLowerCase();
					switch (nome) {
					case "p1":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p1, tb, jogador[i].p1.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p2":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p2, tb, jogador[i].p2.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p3":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p3, tb, jogador[i].p3.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p4":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p4, tb, jogador[i].p4.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p5":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p5, tb, jogador[i].p5.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p6":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p6, tb, jogador[i].p6.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p7":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p7, tb, jogador[i].p7.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "p8":
						while (!moverPosicaoPeao(jogador[i], jogador[i].p8, tb, jogador[i].p8.isEstadoInicial()));
						printarTabuleiro(tb);
						break;
					case "be":
						while (!moverPosicaoBispo(jogador[i], jogador[i].be, tb));
						printarTabuleiro(tb);
						break;
					case "bd":
						while (!moverPosicaoBispo(jogador[i], jogador[i].bd, tb));
						printarTabuleiro(tb);
						break;
					case "ce":
						while (!moverPosicaoCavalo(jogador[i], jogador[i].ce, tb));
						printarTabuleiro(tb);
						break;
					case "cd":
						while (!moverPosicaoCavalo(jogador[i], jogador[i].cd, tb));
						printarTabuleiro(tb);
						break;
					case "r":
						while (!moverPosicaoRei(jogador[i], jogador[i].rei, tb));
						printarTabuleiro(tb);
						break;
					case "te":
						while (!moverPosicaoTorre(jogador[i], jogador[i].te, tb));
						printarTabuleiro(tb);
						break;
					case "td":
						while (!moverPosicaoTorre(jogador[i], jogador[i].td, tb));
						printarTabuleiro(tb);
						break;
					case "d":
						while (!moverPosicaoDama(jogador[i], jogador[i].dama, tb));
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
