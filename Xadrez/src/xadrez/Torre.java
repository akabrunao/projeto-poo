/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe respons�vel pela pe�a "Torre"
 *
 * @author Daniele
 */
public class Torre extends Peca {
    private String lado;

	/**
	 * Construtor da torre, respons�vel por inicializar os atributos e definir a
	 * posi��o inicial da pe�a no inicio do jogo.
	 * 
	 * @param cor  Cor da pe�a (branca/preta)
	 * @param lado Informa se a torre � a esquerda ou a direita
	 */
    public Torre(String cor, String lado, Tabuleiro tabuleiro) {
		setTabuleiro(tabuleiro);
        setCor(cor);
        setLado(lado);
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
    	if(cor == "branca") {
            if(lado == "esquerda"){
                return "te ";
            } else {
            	return "td ";
            }
        } else {
            if(lado == "esquerda"){
            	return "TE ";
            } else {
            	return "TD ";
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
		// System.out.printf("linha: %B\ncoluna: %B\n", tabuleiro.pecaNoCaminhoReta(linhaOrigem, linhaDestino, colunaOrigem, colunaDestino));
    	if (tabuleiro.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {
    		//Linhas retas
    		if (linhaOrigem == linhaDestino && tabuleiro.pecaNoCaminhoReta(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
    			return true;
    		if (colunaOrigem == colunaDestino && tabuleiro.pecaNoCaminhoReta(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino))
    			return true;    		
    	}
        return false;
    }
    
	/**
	 * De acordo com os atributos da pe�a, faz o set da posi��o que ela dever� estar
	 * no inicio do jogo
	 */
	public void definePosicaoInicial() {
		if(cor == "branca") {
         if(lado == "esquerda"){
		setPosicao(0,0);
         } else {
		setPosicao(0,7);
         }
      } else {
         if(lado == "esquerda"){
		setPosicao(7,0);
         } else {
		setPosicao(7,7);
         }
      }
	}


    //GETTERS E SETTERS
    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }
}
