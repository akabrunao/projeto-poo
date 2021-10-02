/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import java.util.Scanner;

/**
 * Classe que lida com tudo relacionado ao jogo, como a inicialização do mesmo e
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
	 * Método que cria os dois jogadores e o tabuleiro para que o jogo possa ser
	 * inicializado.
	 */
	public void iniciarJogo() {
		// Inicializa o programa e recolhe os nomes dos jogadores
		System.out.println("Programa rodando...");
		System.out.println("BEM VINDO AO JOGO DE XADREZ!");
		System.out.println("Por gentileza, insira o nome do jogador 1 (peças brancas):");

		// Cria os jogadores
		Jogador[] jogador = new Jogador[2];

		jogador[0] = new Jogador("branca");
		nome = scanner.nextLine();
		jogador[0].setNomeJogador(this.getNome());
		System.out.println("Por gentileza, insira o nome do jogador 2 (peças pretas):");
		jogador[1] = new Jogador("preta");
		nome = scanner.nextLine();
		jogador[1].setNomeJogador(this.getNome());

		// Cria o tabuleiro
		Tabuleiro tb = new Tabuleiro(jogador[0], jogador[1]);

		// Chama a função para jogar
		jogar(jogador, tb);
	}

	/**
	 * Método que faz uma chamada ao tabuleiro para que o mesmo seja impresso na
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
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1            Recebe o jogador que terá sua peça movida
	 * @param peao          Recebe a peça que será movida
	 * @param tb            Recebe o tabuleiro
	 * @param estadoInicial Recebe true caso seja o primeiro movimento deste peao
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoPeao(Jogador j1, Peao peao, Tabuleiro tb, boolean estadoInicial) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = peao.getLinha();
		int coluna = peao.getColuna();

		if (peao.checaMovimento(linha, coluna, c1, c2, estadoInicial)) {
			System.out.println("Movimento válido!");
			peao.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroPeao(peao);
			if (estadoInicial) {
				peao.setEstadoInicial(false);
			}
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1    Recebe o jogador que terá sua peça movida
	 * @param bispo Recebe a peça que será movida
	 * @param tb    Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoBispo(Jogador j1, Bispo bispo, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = bispo.getLinha();
		int coluna = bispo.getColuna();

		if (bispo.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento válido!");
			bispo.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroBispo(bispo);
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1     Recebe o jogador que terá sua peça movida
	 * @param cavalo Recebe a peça que será movida
	 * @param tb     Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoCavalo(Jogador j1, Cavalo cavalo, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = cavalo.getLinha();
		int coluna = cavalo.getColuna();

		if (cavalo.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento válido!");
			cavalo.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroCv(cavalo);
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1   Recebe o jogador que terá sua peça movida
	 * @param dama Recebe a peça que será movida
	 * @param tb   Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoDama(Jogador j1, Dama dama, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = dama.getLinha();
		int coluna = dama.getColuna();

		if (dama.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento válido!");
			dama.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroDama(dama);
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1  Recebe o jogador que terá sua peça movida
	 * @param rei Recebe a peça que será movida
	 * @param tb  Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoRei(Jogador j1, Rei rei, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = rei.getLinha();
		int coluna = rei.getColuna();

		if (rei.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento válido!");
			rei.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroRei(rei);
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lê uma coordenada e checa se a peça pode ser movida para essa
	 * posição, e então executa o movimento
	 * 
	 * @param j1    Recebe o jogador que terá sua peça movida
	 * @param torre Recebe a peça que será movida
	 * @param tb    Recebe o tabuleiro
	 * 
	 * @return true caso o movimento seja executado, false caso contrário
	 */
	public boolean moverPosicaoTorre(Jogador j1, Torre torre, Tabuleiro tb) {
		System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
		int c1 = scanner.nextInt();
		int c2 = scanner.nextInt();
		int linha = torre.getLinha();
		int coluna = torre.getColuna();

		if (torre.checaMovimento(linha, coluna, c1, c2)) {
			System.out.println("Movimento válido!");
			torre.setPosicao(c1, c2);
			tb.atualizaTabuleiro(linha, coluna);
			tb.colocaPecaNoTabuleiroTorre(torre);
			return true;
		} else {
			System.out.println("Movimento inválido! Por favor, insira uma coordenada válida!");
		}
		return false;
	}

	/**
	 * Método que lida com o jogo, gerenciando todas as jogadas.
	 * 
	 * @param jogador Recebe os dois jogadores do jogo
	 * @param tb      Recebe o tabuleiro
	 */
	public void jogar(Jogador[] jogador, Tabuleiro tb) {
		while (true) {
			System.out.println("Entre com sua opção: (1) INICIAR JOGO / (2) SAIR");
			int op = scanner.nextInt();
			switch (op) {
			case 1:
				int i = 0;
				while (true) {
					System.out.println("Vez do jogador: " + jogador[i].getNomeJogador());
					System.out.println("Escolha uma peãa disponível: ");
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
