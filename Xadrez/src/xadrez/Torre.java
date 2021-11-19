/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsavel pela peca "Torre"
 *
 * @author Daniele
 */
public class Torre extends Peca {

	/**
	 * Construtor da torre responsavel por inicializar os atributos e definir a
	 * posicao inicial da peca no inicio do jogo.
	 * 
	 * @param cor  Cor da peca (branca/preta)
	 */
    public Torre(String cor) {
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
    public void desenha(){
    	if(cor == "branca") {
            this.desenho = "t";
        } else {
            this.desenho = "T";
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
    		if (linhaOrigem == linhaDestino)
    			return true;
    		if (colunaOrigem == colunaDestino)
    			return true;    		
                
        return false;
    }
    
}
