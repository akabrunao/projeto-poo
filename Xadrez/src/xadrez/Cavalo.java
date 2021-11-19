/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsavel pela peca "Cavalo"
 *
 * @author Bruno
 */
public class Cavalo extends Peca {

	/**
	 * Construtor do cavalo, responsavel por inicializar os atributos e definir a
	 * posicao inicial da peca no inicio do jogo.
	 * 
	 * @param cor Cor da peca (branca/preta)
	 */
	public Cavalo(String cor) {
		if (cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta") {
			this.capturada = false;
			this.cor = cor;
			desenha();
		}
	}

	/**
	 * De acordo com a cor da peça define qual o desenho deve ser impresso no
	 * tabuleiro.
	 */
	protected void desenha() {
		if (this.cor == "branca") {
			this.desenho = "c";
		} else if (this.cor == "preta") {
			this.desenho = "C";
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
		if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino)
			return false;
		// posicoes validas para o cavalo
		if ((linhaOrigem - linhaDestino == -2 || linhaOrigem - linhaDestino == 2)
				&& (colunaOrigem - colunaDestino == 1 || colunaOrigem - colunaDestino == -1))
			return true;
		if ((colunaOrigem - colunaDestino == -2 || colunaOrigem - colunaDestino == 2)
				&& (linhaOrigem - linhaDestino == 1 || linhaOrigem - linhaDestino == -1))
			return true;

		return false;
	}

}