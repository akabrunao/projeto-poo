/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe que gerencia o tabuleiro
 *
 * @author Bruno
 */

public class Tabuleiro {
	private Posicao[][] tabuleiro;

	/**
	 * Construtor do tableiro, que cria o mesmo e também é responsável por
	 * inicializá-lo
	 * 
	 * @param j1 Recebe o jogador 1
	 * @param j2 Recebe o jogador 2
	 */
	public Tabuleiro(Jogador j1, Jogador j2) {
		tabuleiro = new Posicao[8][8];

		criaTabuleiro();
		posicionaPecasParaInicioDoJogo(j1, j2);
	}

	/**
	 * Método que após uma jogada, atualiza a casa que a peça estava anteriormente,
	 * de modo que o desenho seja atualizado conforme a cor dessa casa
	 * 
	 * @param linha  A linha da posição que a peça estava
	 * @param coluna A coluna da posição que a peça estava
	 */
	public void atualizaTabuleiro(int linha, int coluna) {
		tabuleiro[linha][coluna].setOcupada(false);
		tabuleiro[linha][coluna].setDesenho(defineCorDaCasa(linha, coluna));
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroDama(Dama p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroRei(Rei p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroCv(Cavalo p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroTorre(Torre p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroPeao(Peao p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Faz com que a posição do tabuleiro receba o desenho da peça que está sobre
	 * ela
	 * 
	 * @param p Recebe a peça que será colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiroBispo(Bispo p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setDesenho(p.desenha());
		}
	}

	/**
	 * Organiza todas as peças para o inicio do jogo, colocando cada uma em sua respectiva posição
	 * 
	 * @param j1 Recebe o jogador 1
	 * @param j2 Recebe o jogador 2
	 */
	private void posicionaPecasParaInicioDoJogo(Jogador j1, Jogador j2) {
		// dama
		colocaPecaNoTabuleiroDama(j1.dama);
		colocaPecaNoTabuleiroDama(j2.dama);
		// rei
		colocaPecaNoTabuleiroRei(j1.rei);
		colocaPecaNoTabuleiroRei(j2.rei);
		// cavalo
		colocaPecaNoTabuleiroCv(j1.cd);
		colocaPecaNoTabuleiroCv(j1.ce);
		colocaPecaNoTabuleiroCv(j2.cd);
		colocaPecaNoTabuleiroCv(j2.ce);

		colocaPecaNoTabuleiroTorre(j1.td);
		colocaPecaNoTabuleiroTorre(j1.te);
		colocaPecaNoTabuleiroTorre(j2.td);
		colocaPecaNoTabuleiroTorre(j2.te);

		colocaPecaNoTabuleiroBispo(j1.bd);
		colocaPecaNoTabuleiroBispo(j1.be);
		colocaPecaNoTabuleiroBispo(j2.bd);
		colocaPecaNoTabuleiroBispo(j2.be);

		colocaPecaNoTabuleiroPeao(j1.p1);
		colocaPecaNoTabuleiroPeao(j1.p2);
		colocaPecaNoTabuleiroPeao(j1.p3);
		colocaPecaNoTabuleiroPeao(j1.p4);
		colocaPecaNoTabuleiroPeao(j1.p5);
		colocaPecaNoTabuleiroPeao(j1.p6);
		colocaPecaNoTabuleiroPeao(j1.p7);
		colocaPecaNoTabuleiroPeao(j1.p8);
		colocaPecaNoTabuleiroPeao(j2.p1);
		colocaPecaNoTabuleiroPeao(j2.p2);
		colocaPecaNoTabuleiroPeao(j2.p3);
		colocaPecaNoTabuleiroPeao(j2.p4);
		colocaPecaNoTabuleiroPeao(j2.p5);
		colocaPecaNoTabuleiroPeao(j2.p6);
		colocaPecaNoTabuleiroPeao(j2.p7);
		colocaPecaNoTabuleiroPeao(j2.p8);
	}

	/**
	 * Inicializa todas as posições do tabuleiro e atribui os valores iniciais
	 */
	private void criaTabuleiro() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Posicao pos = new Posicao();
				pos.setColuna(j);
				pos.setLinha(i);
				pos.setCor(defineCorDaCasa(i, j));
				pos.setDesenho(defineCorDaCasa(i, j));
				pos.setOcupada(false);

				tabuleiro[i][j] = pos;
			}
		}
	}
	
	/**
	 * Para cada casa do tabuleiro, com base em suas coordenadas, define se ela deve ser preta ou branca
	 * 
	 * @param i Recebe a linha
	 * @param j Recebe a coluna
	 * @return O desenho correspondente da casa vazia com base em sua cor
	 */
	public String defineCorDaCasa(int i, int j) {
		if ((i % 2 == 0) && (j % 2 == 0)) { // se os dois forem pares
			return " + ";
		} else if ((i % 2 == 1) && (j % 2 == 1)) { // se os dois fore impares
			return " + ";
		} else { // se forem diferentes
			return " - ";
		}
	}
	
	/**
	 * Imprime todas as posições do tabuleiro na tela
	 */
	public void printTabuleiro() {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			System.out.printf("%d   ", i);
			for (int j = 0; j < 8; j++) {
				System.out.print(tabuleiro[i][j].getDesenho());
				count++;
				if (count == 8) {
					System.out.printf("\n");
					count = 0;
				}
			}
		}
		System.out.printf("\n    a  b  c  d  e  f  g  h\n");
	}

}
