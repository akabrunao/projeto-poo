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
	 * Construtor da dama, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor Cor da pe�a (branca/preta)
	 */
	public Dama(String cor) {
		if(cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta"){
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
		if (getCor() == "branca") {
			this.desenho = "d";
		} else { // cor == "preta"
			this.desenho = "D";
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
	 * @return true caso o movimento seja v�lido, false se o movimento for inv�lido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		boolean flag = false;
		// fora do tabuleiro
			// posicoes validas para a dama
			if (linhaOrigem == linhaDestino)
				flag = true;
			if (colunaOrigem == colunaDestino)
				flag = true;
			if (Math.abs(linhaOrigem - linhaDestino) == Math.abs(colunaOrigem - colunaDestino))
				flag = true;

		

		return flag;
	}


}