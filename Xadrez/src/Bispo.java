/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author Daniele
 */
public class Bispo {
	private boolean capturada;
	private String cor;
	private String lado;
	private int linha;
	private int coluna;

	public Bispo(String cor, String lado) {
		setCor(cor);
		setLado(lado);
		setCapturada(false);

		definePosicaoInicial();
	}

	public void definePosicaoInicial() {
		if (cor == "branca") {
			if (lado == "esquerda") {
				setPosicao(0, 2);
			} else {
				setPosicao(0, 5);
			}
		} else {
			if (lado == "esquerda") {
				setPosicao(7, 2);
			} else {
				setPosicao(7, 5);
			}
		}
	}

	public String desenha() {
		if (cor == "branca") {
			if (lado == "esquerda") {
				return "be ";
			} else {
				return "bd ";
			}
		} else {
			if (lado == "esquerda") {
				return "BE ";
			} else {
				return "BD ";
			}
		}

	}

	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			// diagonais
			if ((linhaOrigem - linhaDestino) == (colunaOrigem - colunaDestino))
				return true;
			if ((linhaDestino - linhaOrigem) == (colunaDestino - colunaOrigem))
				return true;
		}

		return false;
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

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}
}
