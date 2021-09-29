/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author Daniele
 */
public class Torre {
    private boolean capturada;
    private String cor;
    private String lado;
    private int linha;
    private int coluna;

    public Torre(String cor, String lado) {
        setCor(cor);
        setLado(lado);
        setCapturada(false);
        definePosicaoInicial();
    }

    public String getLado() {
        return lado;
    }

    public void setLado(String lado) {
        this.lado = lado;
    }

    
    
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


    //GETTERS E SETTERS
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
}
