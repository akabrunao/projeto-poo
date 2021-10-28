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
	private int num;
	private boolean estadoInicial; // Guarda se � a primeira jogada do peao

	/**
	 * Construtor do peao, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor recebe a cor da pe�a
	 * @param num recebe o id do pe�o
	 */
	public Peao(String cor, int num) {
		setCor(cor);
		setNum(num);
		setCapturada(false);
		definePosicaoInicial();
		setEstadoInicial(true);
	}

	/**
	 * De acordo com os atributos da pe�a, retorna o desenho correspondente para que
	 * possa ser impresso no tabuleiro
	 * 
	 * @return Uma String com o desenho correspondente
	 */
	public String desenha() {
		if (cor == "branca") {
			return "p" + num + " ";
		} else {
			return "P" + num + " ";
		}
	}

	public boolean primeiraJogada(){
            if(this.estadoInicial){
                this.estadoInicial = false;
                return true;
            }
            return false;
        }

	/**
	 * Checa se a posi��o informada pelo jogador pertence ao tabuleiro, e ent�o
	 * verifica se o movimento � v�lido de acordo com as regras da pe�a
	 * 
	 * @param linhaOrigem    A linha da posi��o que a pe�a estava
	 * @param colunaOrigem   A coluna da posi��o que a pe�a estava
	 * @param linhaDestino   A linha da posi��o que a pe�a ir�
	 * @param colunaDestino  A coluna da posi��o que a pe�a ir�
	 * * @return true caso o movimento seja v�lido, false se o movimento for inv�lido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if (tabuleiro.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {
			if (primeiraJogada()) {
				if (this.getCor() == "branca") {
					if (((linhaDestino - linhaOrigem) == 1 || (linhaDestino - linhaOrigem) == 2) && colunaOrigem == colunaDestino)
						return true;
				} else {
					if (((linhaOrigem - linhaDestino) == 1 || (linhaOrigem - linhaDestino) == 2) && colunaOrigem == colunaDestino)
						return true;
				}
				return false;
			}
			if (this.getCor() == "branca") {
				if ((linhaDestino - linhaOrigem) == 1 && colunaOrigem == colunaDestino)
					return true;
			} else {
				if ((linhaOrigem - linhaDestino) == 1 && colunaOrigem == colunaDestino)
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
			setPosicao(1, num - 1);
		} else {
			setPosicao(6, num - 1);
		}
	}

	// GETTERS E SETTERS
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public boolean isEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(boolean estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

}