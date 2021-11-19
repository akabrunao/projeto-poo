/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe respons�vel pela pe�a "Dama"
 * 
 * @author Bruno
 */
public class Dama extends Peca {

	/**
	 * Construtor do cavalo, responsavel por inicializar os atributos e definir a
	 * posicao inicial da peca no inicio do jogo.
	 * 
	 * @param cor  Cor da peca (branca/preta)
	 */
	public Dama(String cor) {
		if (cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta") {
			this.capturada = false;
			setCor(cor);
			desenha();
		} else {
			System.out.println("Cor atribuída é inválida!");
		}
	}

	/**
	 * De acordo com a cor da peça define qual o desenho deve ser
         * impresso no tabuleiro.
	 */
	public void desenha() {
		if (getCor() == "branca") {
			this.desenho = "d";
		} else { // cor == "preta"
			this.desenho = "D";
		}
	}

	/**
	 * Checa se a posicao informada pelo jogador pertence ao tabuleiro, e entao
	 * verifica se o movimento é valido de acordo com as regras da peca
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
		// posicoes validas para a dama
		boolean flag = false;
		if (linhaOrigem == linhaDestino)
			flag = true;
		if (colunaOrigem == colunaDestino)
			flag = true;
		if (Math.abs(linhaOrigem - linhaDestino) == Math.abs(colunaOrigem - colunaDestino))
			flag = true;

		return flag;
	}

}