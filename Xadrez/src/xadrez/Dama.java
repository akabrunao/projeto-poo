/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsável pela peça "Dama"
 * 
 * @author Bruno
 */
public class Dama {

	private boolean capturada;
	private String cor;
	private int linha;
	private int coluna;

	/**
	 * Construtor da dama, responsável por inicializar os atributos e definir a
	 * posição inicial da peça no inicio do jogo.
	 * 
	 * @param cor Cor da peça (branca/preta)
	 */
	public Dama(String cor) {
		setCor(cor);
		setCapturada(false);

		definePosicaoInicial();
	}

	/**
	 * De acordo com os atributos da peça, retorna o desenho correspondente para que
	 * possa ser impresso no tabuleiro
	 * 
	 * @return Uma String com o desenho correspondente
	 */
	public String desenha() {
		if (getCor() == "branca") {
			return "d  ";
		} else { // cor == "preta"
			return "D  ";
		}
	}

	/**
	 * Checa se a posição informada pelo jogador pertence ao tabuleiro, e então
	 * verifica se o movimento é válido de acordo com as regras da peça
	 * 
	 * @param linhaOrigem   A linha da posição que a peça estava
	 * @param colunaOrigem  A coluna da posição que a peça estava
	 * @param linhaDestino  A linha da posição que a peça irá
	 * @param colunaDestino A coluna da posição que a peça irá
	 * @return true caso o movimento seja válido, false se o movimento for inválido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		// fora do tabuleiro
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			// posicoes validas para a dama
			if (linhaOrigem == linhaDestino)
				return true;
			if (colunaOrigem == colunaDestino)
				return true;
			if ((linhaOrigem - linhaDestino) == (colunaOrigem - colunaDestino))
				return true;
			if ((linhaDestino - linhaOrigem) == (colunaDestino - colunaOrigem))
				return true;
		}

		return false;
	}

	/**
	 * De acordo com os atributos da peça, faz o set da posição que ela deverá estar
	 * no inicio do jogo
	 */
	public void definePosicaoInicial() {
		if (cor == "branca") {
			setPosicao(0, 3);
		} else {
			setPosicao(7, 3);
		}
	}

	// GETTERS E SETTERS
	public boolean isCapturada() {
		return this.capturada;
	}

	public void setPosicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setCapturada(boolean capturada) {
		this.capturada = capturada;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}
