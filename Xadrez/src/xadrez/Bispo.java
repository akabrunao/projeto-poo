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
			setCor(cor);
			this.capturada = false;
			desenha();
		} else {
			System.out.println("Cor escolhida é inválida!");
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
			this.desenho = "b";
		} else if (cor == "preta") {
			this.desenho = "B";
		} else {
			System.out.println("Cor inválida!");
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

		if (Math.abs(linhaOrigem - linhaDestino) == Math.abs(colunaOrigem - colunaDestino))
			return true;
		return false;
	}

}