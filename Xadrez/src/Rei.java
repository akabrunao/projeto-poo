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
//preciso fazer
public class Rei {
    private boolean capturada;
    private String cor;
    private int linha;
    private int coluna;

    public Rei(String cor) {
        setCor(cor);
        setCapturada(false);

        definePosicaoInicial();
    }


	public void definePosicaoInicial() {
		if(cor == "branca") {
            setPosicao(0, 4);
        } else {
            setPosicao(7, 4);
        }
	}

    
    public String desenha() {
        if (getCor() == "branca") {
            return "r  ";
        } else  { // cor == "preta"
            return "R  ";
        }
    }

    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
    	if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
    		//retas
    		if (linhaOrigem - linhaDestino == 1 || linhaDestino - linhaOrigem == 1)
    			return true;
    		if (linhaOrigem - linhaDestino == -1 || linhaDestino - linhaOrigem == -1)
    			return true;
    		if (colunaOrigem - colunaDestino == 1 || colunaDestino - colunaOrigem == 1)
    			return true;
    		if (colunaOrigem - colunaDestino == -1 || colunaDestino - colunaOrigem == -1)
    			return true;
    		
    		// diagonais
    		if (linhaOrigem - linhaDestino == 1 && colunaOrigem - colunaDestino == -1)
    			return true;
    		if (linhaOrigem - linhaDestino == -1 && colunaOrigem - colunaDestino == 1)
    			return true;
    		if (linhaOrigem - linhaDestino == 1 && colunaOrigem - colunaDestino == 1)
    			return true;
    		if (linhaOrigem - linhaDestino == -1 && colunaOrigem - colunaDestino == -1)
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
}
