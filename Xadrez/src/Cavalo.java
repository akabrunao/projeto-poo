/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author Bruno
 */
public class Cavalo {
	private boolean capturada;
	private String cor;
	private int linha;
	private int coluna;
	private String lado;

	public Cavalo(String cor, String lado) {
		setCor(cor);
		setCapturada(false);
		setLado(lado);

		definePosicaoInicial();
	}

	public void definePosicaoInicial() {
		if (cor == "branca" && lado == "esquerda") {
			setPosicao(0, 1);
		} else if (cor == "branca" && lado == "direita") {
			setPosicao(0, 6);
		} else if (cor == "preta" && lado == "esquerda") {
			setPosicao(7, 1);
		} else if (cor == "preta" && lado == "direita") {
			setPosicao(7, 6);
		}
	}

	public String desenha() {
		if (cor == "branca") {
			if (lado == "esquerda") {
				return "ce ";
			} else {
				return "cd ";
			}
		} else {
			if (lado == "esquerda") {
				return "CE ";
			} else {
				return "CD ";
			}
		}
	}

	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		//fora do tabuleiro
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			//posicoes validas para o cavalo
			if ((linhaOrigem - linhaDestino == -2 || linhaOrigem - linhaDestino == 2)
					&& (colunaOrigem - colunaDestino == 1 || colunaOrigem - colunaDestino == -1))
				return true;
			if ((colunaOrigem - colunaDestino == -2 || colunaOrigem - colunaDestino == 2)
					&& (linhaOrigem - linhaDestino == 1 || linhaOrigem - linhaDestino == -1))
				return true;
		}

		return false;
	}

	// GETTERS E SETTERS
	public boolean isCapturada() {
		return this.capturada;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
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
