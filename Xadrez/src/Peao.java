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
public class Peao {
	private boolean capturada;
	private String cor;
	private int linha;
	private int coluna;
	int num;

	public Peao(String cor, int num) {
		setCor(cor);
		setNum(num);
		setCapturada(false);
		definePosicaoInicial();
	}

	public void definePosicaoInicial() {
		if (cor == "branca") {
			setPosicao(1, num - 1);
		} else {
			setPosicao(6, num - 1);
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String desenha() {
		if (cor == "branca") {
			return "p" + num + " ";
		} else {
			return "P" + num + " ";
		}
	}

	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7)
			if (linhaDestino - linhaOrigem == 1 && colunaOrigem == colunaDestino)
				return true;

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
}
