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
	 * Construtor do tableiro, que cria o mesmo e tamb�m � respons�vel por
	 * inicializ�-lo
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
	 * Construtor vazio
	 */
	public Tabuleiro() {};

	/**
	 * M�todo que ap�s uma jogada, atualiza a casa que a pe�a estava anteriormente,
	 * de modo que o desenho seja atualizado conforme a cor dessa casa
	 * 
	 * @param linha  A linha da posi��o que a pe�a estava
	 * @param coluna A coluna da posi��o que a pe�a estava
	 */
	public void atualizaTabuleiro(int linha, int coluna) {
		tabuleiro[linha][coluna].setOcupada(false);
		tabuleiro[linha][coluna].setDesenho(defineCorDaCasa(linha, coluna));
	}

	/**
	 * Faz com que a posi��o do tabuleiro receba o desenho da pe�a que est� sobre
	 * ela
	 * 
	 * @param p Recebe a pe�a que ser� colocada no tabuleiro
	 */
	public void colocaPecaNoTabuleiro(Peca p) {
		Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];

		if (p.isCapturada() == false) {
			pos.setOcupada(true);
			pos.setPeca(p);
		}
	}

	/**
	 * Organiza todas as pe�as para o inicio do jogo, colocando cada uma em sua respectiva posi��o
	 * 
	 * @param j1 Recebe o jogador 1
	 * @param j2 Recebe o jogador 2
	 */
	private void posicionaPecasParaInicioDoJogo(Jogador j1, Jogador j2) {
		// dama
		colocaPecaNoTabuleiro(j1.dama);
		colocaPecaNoTabuleiro(j2.dama);
		// rei
		colocaPecaNoTabuleiro(j1.rei);
		colocaPecaNoTabuleiro(j2.rei);
		// cavalo
		colocaPecaNoTabuleiro(j1.cd);
		colocaPecaNoTabuleiro(j1.ce);
		colocaPecaNoTabuleiro(j2.cd);
		colocaPecaNoTabuleiro(j2.ce);

		colocaPecaNoTabuleiro(j1.td);
		colocaPecaNoTabuleiro(j1.te);
		colocaPecaNoTabuleiro(j2.td);
		colocaPecaNoTabuleiro(j2.te);

		colocaPecaNoTabuleiro(j1.bd);
		colocaPecaNoTabuleiro(j1.be);
		colocaPecaNoTabuleiro(j2.bd);
		colocaPecaNoTabuleiro(j2.be);

		colocaPecaNoTabuleiro(j1.p1);
		colocaPecaNoTabuleiro(j1.p2);
		colocaPecaNoTabuleiro(j1.p3);
		colocaPecaNoTabuleiro(j1.p4);
		colocaPecaNoTabuleiro(j1.p5);
		colocaPecaNoTabuleiro(j1.p6);
		colocaPecaNoTabuleiro(j1.p7);
		colocaPecaNoTabuleiro(j1.p8);
		colocaPecaNoTabuleiro(j2.p1);
		colocaPecaNoTabuleiro(j2.p2);
		colocaPecaNoTabuleiro(j2.p3);
		colocaPecaNoTabuleiro(j2.p4);
		colocaPecaNoTabuleiro(j2.p5);
		colocaPecaNoTabuleiro(j2.p6);
		colocaPecaNoTabuleiro(j2.p7);
		colocaPecaNoTabuleiro(j2.p8);
	}

	/**
	 * Inicializa todas as posi��es do tabuleiro e atribui os valores iniciais
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
	 * Imprime todas as posi��es do tabuleiro na tela
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
	
	public boolean checaLimitesDoTabuleiro(int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			return true;
		}
		return false;
	}

	public void setPosicao(int linha, int coluna, Peca p) {
		tabuleiro[linha][coluna].setPeca(p);
	}

}
