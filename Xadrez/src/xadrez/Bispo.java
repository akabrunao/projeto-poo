/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsavel pela peca "Bispo"
 *
 * @author Daniele
 */
public class Bispo extends Peca {
	/**
	 * Construtor do bispo, responsavel por inicializar os atributos e definir a
	 * posicao inicial da peca no inicio do jogo.
	 * 
	 * @param cor Cor da peca (branca/preta)
	 */
	public Bispo(String cor) {
		if (cor.toLowerCase().equals("branca") || cor.toLowerCase().equals("preta")) {
			this.cor = cor;
			this.capturada = false;
			desenha();
		} 
	}

	/**
	 * De acordo com a cor da peça define qual o desenho deve ser
	 * impresso no tabuleiro.
	 */
	protected void desenha() {
		if (this.cor == "branca") {
			this.desenho = "b";
		} else if (this.cor == "preta") {
			this.desenho = "B";
		} 
	}

	/**
	 * Checa se a peca pode executar o movimento informado pelo usuario
	 * 
	 * @param linhaOrigem   A linha da posicao que a peca estava
	 * @param colunaOrigem  A coluna da posicao que a peca estava
	 * @param linhaDestino  A linha da posicao que a peca ira
	 * @param colunaDestino A coluna da posicao que a peca ira
	 * @return true caso o movimento seja valido, false se o movimento for invalido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if(linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) return false;
		if (Math.abs(linhaOrigem - linhaDestino) == Math.abs(colunaOrigem - colunaDestino))
			return true;
		return false;
	}

}