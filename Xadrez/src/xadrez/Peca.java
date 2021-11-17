/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author
 */
public abstract class Peca {
	protected boolean capturada;
	protected String cor;
	protected int linha;
	protected int coluna;
	
	protected Tabuleiro tabuleiro;

	// public Peca(Tabuleiro tb) {
	// 	setTabuleiro(tabuleiro);
	// }
	
	public abstract String desenha();
	public abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);
	public abstract void definePosicaoInicial();
	
	public void captura() {
		capturada = true;
	}
	public boolean isCapturada() {
		return capturada;
	}
	public void setCapturada(boolean capturada) {
		this.capturada = capturada;
	}
	public String getCor() {
		return cor;
	}
	protected void setCor(String cor) {
		this.cor = cor;
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public void setPosicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	
}