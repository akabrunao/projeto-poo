/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe que armazena todas as informações de cada função
 *
 * @author Bruno
 */
public class Posicao {
    private String cor;
    private int linha;
    private int coluna;
    private Peca peca;
    private String desenho;
    private boolean ocupada;

	
    
    
    
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
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
		setDesenho(peca.desenha());
	}
	public String getDesenho() {
		return desenho;
	}
	public void setDesenho(String desenho) {
		this.desenho = desenho;
	}
	public boolean getOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
	}
	
    
    
    
    
}
