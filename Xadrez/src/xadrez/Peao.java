/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsável pela peça "Peao"
 *
 * @author Daniele
 */
public class Peao {
	private boolean capturada;
	private String cor;
	private int num;
	private int linha;
	private int coluna;
	private boolean estadoInicial; // Guarda se é a primeira jogada do peao

	/**
	 * Construtor do peao, responsável por inicializar os atributos e definir a
	 * posição inicial da peça no inicio do jogo.
	 * 
	 * @param cor recebe a cor da peça
	 * @param num recebe o id do peão
	 */
	public Peao(String cor, int num) {
		setCor(cor);
		setNum(num);
		setCapturada(false);
		definePosicaoInicial();
		setEstadoInicial(true);
	}

	/**
	 * De acordo com os atributos da peça, retorna o desenho correspondente para que
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

	/**
	 * Checa se a posição informada pelo jogador pertence ao tabuleiro, e então
	 * verifica se o movimento é válido de acordo com as regras da peça
	 * 
	 * @param linhaOrigem   A linha da posição que a peça estava
	 * @param colunaOrigem  A coluna da posição que a peça estava
	 * @param linhaDestino  A linha da posição que a peça irá
	 * @param colunaDestino A coluna da posição que a peça irá
	 * @return true caso o movimento seja válido, false se o movimento for inválido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7)
			if (linhaDestino - linhaOrigem == 1 && colunaOrigem == colunaDestino)
				return true;

		return false;
	}

	/**
	 * Checa se a posição informada pelo jogador pertence ao tabuleiro, e então
	 * verifica se o movimento é válido de acordo com as regras da peça
	 * 
	 * @param linhaOrigem    A linha da posição que a peça estava
	 * @param colunaOrigem   A coluna da posição que a peça estava
	 * @param linhaDestino   A linha da posição que a peça irá
	 * @param colunaDestino  A coluna da posição que a peça irá
	 * @param primeiraJogada Se for o seu primeiro movimento, o peao pode andar duas
	 *                       casas para frente, esse parametro recebe true caso seja
	 *                       a primeira jogada
	 * @return true caso o movimento seja válido, false se o movimento for inválido
	 */
	public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, boolean primeiraJogada) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7)
			if (primeiraJogada) {
				if ((Math.abs(linhaDestino - linhaOrigem) == 1 || Math.abs(linhaDestino - linhaOrigem) == 2)
						&& colunaOrigem == colunaDestino)
					return true;
			}
		if (Math.abs(linhaDestino - linhaOrigem) == 1 && colunaOrigem == colunaDestino)
			return true;

		return false;
	}

	/**
	 * De acordo com os atributos da peça, faz o set da posição que ela deverá estar
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

	public boolean isCapturada() {
		return this.capturada;
	}

	public void setPosicao(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setCapturada(boolean capturada) {
		this.capturada = capturada;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public boolean isEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(boolean estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

}
