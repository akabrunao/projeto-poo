//preciso fazer
public class Dama { //extends peca

    private boolean capturada;
    private String cor;
    private int linha;
    private int coluna;

    public Dama(String cor) {
        setCor(cor);
        setCapturada(false);
        
        if(cor == "branca") {
            setPosicao(0, 3);
        } else {
            setPosicao(7, 3);
        }
    }

    
    public String desenha() {
        if (getCor() == "branca") {
            return " d";
        } else  { // cor == "preta"
            return " D";
        }
    }

    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if (linhaOrigem == linhaDestino)
            return true;
        if (colunaOrigem == colunaDestino)
            return true;
        if ((linhaOrigem - linhaDestino) == (colunaOrigem - colunaDestino))
            return true;
        if ((linhaDestino - linhaOrigem) == (colunaDestino - colunaOrigem))
            return true;

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
