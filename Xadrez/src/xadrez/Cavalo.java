/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe respons�vel pela pe�a "Cavalo"
 *
 * @author Bruno
 */
public class Cavalo extends Peca {
	private String lado;

	/**
	 * Construtor do cavalo, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor  Cor da pe�a (branca/preta)
	 * @param lado Informa se o cavalo � o esquerdo ou o direito
	 */
	public Cavalo(String cor, String lado, Tabuleiro tabuleiro) {
		setTabuleiro(tabuleiro);
		setCor(cor);
		capturada = false;
		setLado(lado);

		definePosicaoInicial();
	}

	/**
	 * De acordo com os atributos da pe�a, retorna o desenho correspondente para que
	 * possa ser impresso no tabuleiro
	 * 
	 * @return Uma String com o desenho correspondente
	 */
	public String desenha() {
		if (cor == "branca") {
			if (lado == "esquerda") {
				return "ce ";
			} else {
				return "cd ";
			}
		} else {
			if (lado == "esquerda") {
				return "CE ";
			} else {
				return "CD ";
			}
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
		// fora do tabuleiro
		if (tabuleiro.checaLimitesDoTabuleiro(linhaDestino, colunaDestino) && tabuleiro.naoTemPecaNoCaminhoPosicaoDestino(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)) {
			// posicoes validas para o cavalo
			if ((linhaOrigem - linhaDestino == -2 || linhaOrigem - linhaDestino == 2)
					&& (colunaOrigem - colunaDestino == 1 || colunaOrigem - colunaDestino == -1))
				return true;
			if ((colunaOrigem - colunaDestino == -2 || colunaOrigem - colunaDestino == 2)
					&& (linhaOrigem - linhaDestino == 1 || linhaOrigem - linhaDestino == -1))
				return true;
		}

		return false;
	}

	/**
	 * De acordo com os atributos da pe�a, faz o set da posi��o que ela dever� estar
	 * no inicio do jogo
	 */
	public void definePosicaoInicial() {
		if (cor == "branca" && lado == "esquerda") {
			setPosicao(0, 1);
		} else if (cor == "branca" && lado == "direita") {
			setPosicao(0, 6);
		} else if (cor == "preta" && lado == "esquerda") {
			setPosicao(7, 1);
		} else if (cor == "preta" && lado == "direita") {
			setPosicao(7, 6);
		}
	}

	// GETTERS E SETTERS
	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

}