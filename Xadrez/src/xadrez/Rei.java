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
	 * Construtor do cavalo, responsavel por inicializar os atributos e definir a
	 * posicao inicial da peca no inicio do jogo.
	 * 
	 * @param cor  Cor da peca (branca/preta)
	 */
	public Rei(String cor) {
		if(cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta"){
                    setCapturada(false);
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
		if (this.cor == "branca") {
			this.desenho = "r";
		} else if (this.cor == "preta") {
			this.desenho = "R";
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
			if ((Math.abs(linhaOrigem - linhaDestino) <= 1 && (Math.abs(colunaOrigem - colunaDestino) <= 1))
					&& (Math.abs(linhaOrigem - linhaDestino) == 1 || 1 == Math.abs(colunaOrigem - colunaDestino))) {
				return true;
			}
	
		return false;
	}


}