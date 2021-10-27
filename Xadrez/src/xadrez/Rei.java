/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe respons�vel pela pe�a "Rei"
 *
 * @author Bruno
 */
public class Rei extends Peca {
	

	/**
	 * Construtor do Rei, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor  Cor da pe�a (branca/preta)
	 */
	public Rei(String cor) {
		setCor(cor);
		setCapturada(false);

		definePosicaoInicial();
	}

	/**
	 * De acordo com os atributos da pe�a, retorna o desenho correspondente para que
	 * possa ser impresso no tabuleiro
	 * 
	 * @return Uma String com o desenho correspondente
	 */
	public String desenha() {
		if (getCor() == "branca") {
			return "r  ";
		} else { // cor == "preta"
			return "R  ";
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
		if (tabuleiro.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {
			if ((Math.abs(linhaOrigem - linhaDestino) <= 1 && (Math.abs(colunaOrigem - colunaDestino) <= 1))
					&& (Math.abs(linhaOrigem - linhaDestino) == 1 || 1 == Math.abs(colunaOrigem - colunaDestino))) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * De acordo com os atributos da pe�a, faz o set da posi��o que ela dever� estar
	 * no inicio do jogo
	 */
	public void definePosicaoInicial() {
		if (cor == "branca") {
			setPosicao(0, 4);
		} else {
			setPosicao(7, 4);
		}
	}

}
