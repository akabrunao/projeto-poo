/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe respons�vel pela pe�a "Peao"
 *
 * @author Daniele
 */
public class Peao extends Peca {

	/**
	 * Construtor do peao, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor recebe a cor da pe�a
	 */
	public Peao(String cor) {
		if (cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta") {
			this.capturada = false;
			setCor(cor);
			desenha();
		} else {
			System.out.println("Cor atribuída é inválida!");
		}
	}

	/**
	 * De acordo com os atributos da pe�a, retorna o desenho correspondente para que
	 * possa ser impresso no tabuleiro
	 * 
	 * @return Uma String com o desenho correspondente
	 */
	public void desenha() {
		if (cor == "branca") {
			this.desenho = "p";
		} else {
			this.desenho = "P";
		}
	}

	/**
	 * Checa se a posi��o informada pelo jogador pertence ao tabuleiro, e ent�o
	 * verifica se o movimento � v�lido de acordo com as regras da pe�a
	 * 
	 * @param linhaOrigem   A linha da posi��o que a pe�a estava
	 * @param colunaOrigem  A coluna da posi��o que a pe�a estava
	 * @param linhaDestino  A linha da posi��o que a pe�a ir�
	 * @param colunaDestino A coluna da posi��o que a pe�a ir� 
	 * 
	 * @return true caso o movimento seja v�lido, false se o movimento for inv�lido    
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if(linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) return false;		

		if (cor == "branca") {
			return ((colunaOrigem == colunaDestino || (Math.abs(colunaOrigem - colunaDestino) == 1 && linhaOrigem - linhaDestino == 1)) && ((linhaOrigem - linhaDestino == 1) || (linhaOrigem == 6 && linhaOrigem - linhaDestino == 2)));
		} else {
			return ((colunaOrigem == colunaDestino || (Math.abs(colunaOrigem - colunaDestino) == 1 && linhaOrigem - linhaDestino == -1)) && ((linhaOrigem - linhaDestino == -1) || (linhaOrigem == 1 && linhaOrigem - linhaDestino == -2)));
		}
	}

}