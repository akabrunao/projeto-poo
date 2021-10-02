/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsável pela peça "Torre"
 *
 * @author Daniele
 */
public class Torre {
    private boolean capturada;
    private String cor;
    private String lado;
    private int linha;
    private int coluna;

	/**
	 * Construtor da torre, responsável por inicializar os atributos e definir a
	 * posição inicial da peça no inicio do jogo.
	 * 
	 * @param cor  Cor da peça (branca/preta)
	 * @param lado Informa se a torre é a esquerda ou a direita
	 */
    public Torre(String cor, String lado) {
        setCor(cor);
        setLado(lado);
        setCapturada(false);
        definePosicaoInicial();
    }

	/**
	 * De acordo com os atributos da peça, retorna o desenho correspondente para que
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
    	if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
    		//Linhas retas
    		if (linhaOrigem == linhaDestino)
    			return true;
    		if (colunaOrigem == colunaDestino)
    			return true;    		
    	}
        return false;
    }
    
	/**
	 * De acordo com os atributos da peça, faz o set da posição que ela deverá estar
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


}
