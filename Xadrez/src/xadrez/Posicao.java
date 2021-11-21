package xadrez;

import pecas.Peca;

/**
 * Classe que armazena atributos e métodos de cada posição
 *
 * @author Bruno
 */
public class Posicao {
	private String cor;
	private int linha;
	private char coluna;
	private Peca peca;
	private boolean ocupada;

	public Posicao(int linha, char coluna, String cor) {
		this.setOcupada(false);
		this.setLinha(linha);
		this.setColuna(coluna);
		this.setCor(cor);
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		if (linha >= 0 && linha <= 7) {
			this.linha = linha;
		}
	}

	public char getColuna() {
		return coluna;
	}

	public void setColuna(char coluna) {
		if (coluna >= 'a' && coluna <= 'h') {
			this.coluna = coluna;
		}
	}

	public Peca getPeca() {
		if (this.getOcupada()) {
			return this.peca;
		} else {
			return null;
		}
	}

	public void setPeca(Peca peca) {
		this.peca = peca;
		if (peca == null) {
			this.setOcupada(false);
		} else {
			this.setOcupada(true);
		}
	}

	public boolean getOcupada() {
		return ocupada;
	}

	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}

}