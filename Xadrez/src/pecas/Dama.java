/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecas;

 /*
 * @author Bruno
 */
public class Dama extends Peca {

    /**
     * Construtor do cavalo, responsavel por inicializar os atributos e definir
     * a posicao inicial da peca no inicio do jogo.
     *
     * @param cor Cor da peca (branca/preta)
     */
    public Dama(String cor) {
        if (cor.toLowerCase() == "branca" || cor.toLowerCase() == "preta") {
            this.capturada = false;
            this.cor = cor;
            desenho();
        }
    }

    /**
     * De acordo com a cor da peça define qual o desenho deve ser impresso no
     * tabuleiro.
     */
    protected String desenho() {
        if (this.cor == "branca") {
            this.desenho = "d";
        } else if (this.cor == "preta") {
            this.desenho = "D";
        }
        return this.desenho;
    }

    /**
     * Checa se a peca pode executar o movimento informado pelo usuario
     *
     * @param linhaOrigem A linha da posicao que a peca estava
     * @param colunaOrigem A coluna da posicao que a peca estava
     * @param linhaDestino A linha da posicao que a peca ira
     * @param colunaDestino A coluna da posicao que a peca ira
     * @return true caso o movimento seja valido, false se o movimento for
     * invalido
     */
    public boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        int intColunaOrigem = (int) colunaOrigem - 97;
        int intColunaDestino = (int) colunaDestino - 97;
        
        
        if (linhaOrigem == linhaDestino && intColunaOrigem == intColunaDestino) {
            return false;
        }
        // posicoes validas para a dama
        boolean flag = false;
        if (linhaOrigem == linhaDestino) {
            flag = true;
        }
        if (intColunaOrigem == intColunaDestino) {
            flag = true;
        }
        if (Math.abs(linhaOrigem - linhaDestino) == Math.abs(intColunaOrigem - intColunaDestino)) {
            flag = true;
        }

        return flag;
    }

}
