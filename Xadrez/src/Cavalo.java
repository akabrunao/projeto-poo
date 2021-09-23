//preciso fazer
public class Cavalo {
    private boolean capturada;
    private String cor;
    private int linha;
    private int coluna;
    private String lado;

    public Cavalo(String cor, String lado) {
        setCor(cor);
        setCapturada(false);
        setLado(lado);

        definePosicaoInicial(cor);
    }


    private void definePosicaoInicial(String cor) {
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

    
    public String desenha() {
        if (getCor() == "branca") {
            return " c";
        } else  { // cor == "preta"
            return " C";
        }
    }

    
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        //TODO
        return false;
    }


    //GETTERS E SETTERS
    
    public boolean isCapturada() {
        return this.capturada;
    }

    public String getLado() {
        return lado;
    }


    public void setLado(String lado) {
        this.lado = lado;
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
