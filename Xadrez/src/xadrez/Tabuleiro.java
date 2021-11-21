/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import pecas.Bispo;
import pecas.Cavalo;
import pecas.Dama;
import pecas.Peao;
import pecas.Peca;
import pecas.Rei;
import pecas.Torre;

/**
 * Classe que gerencia o tabuleiro
 *
 * @author Bruno
 */
public class Tabuleiro {

    private Posicao[][] tabuleiro;

    /**
     * Construtor do tableiro, que cria o mesmo e tambem e responsavel por
     * inicializa-lo
     *
     * @param p1 Recebe as peças brancas
     * @param p2 Recebe as peças pretas
     */
    public Tabuleiro(Peca[] p1, Peca[] p2) {
        tabuleiro = new Posicao[8][8];
        String cor;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i % 2) == (j % 2)) {
                    cor = "preta";
                } else {
                    cor = "branca";
                }

                this.tabuleiro[i][j] = new Posicao(i, ((char) (j + 'a')), cor);
            }
        }

        colocaPecaNoTabuleiro(p1);
        colocaPecaNoTabuleiro(p2);

    }

    /**
     * Coloca o vetor de peças nas posições adequadas do tabuleiro, considerando sua
     * cor
     *
     * @param p vetor de peças a ser inserido
     */
    private void colocaPecaNoTabuleiro(Peca[] p) {
        int linhaPeao, demaisPecas;

        if (p[0].getCor().equals("preta")) {
            linhaPeao = 1; // Se for preto, o peão começa na linha 1
            demaisPecas = 0; // As demais peças na linha 0
        } else {
            linhaPeao = 6; // Se for branco, o peão começa na linha 6
            demaisPecas = 7; // E as demais peças na linha 7
        }

        for (int i = 0; i < 8; i++) {
            tabuleiro[linhaPeao][i].setPeca(p[i]);
        }

        // Torre
        tabuleiro[demaisPecas][0].setPeca(p[8]);
        tabuleiro[demaisPecas][7].setPeca(p[9]);

        // Cavalo
        tabuleiro[demaisPecas][1].setPeca(p[10]);
        tabuleiro[demaisPecas][6].setPeca(p[11]);

        // Bispo
        tabuleiro[demaisPecas][2].setPeca(p[12]);
        tabuleiro[demaisPecas][5].setPeca(p[13]);

        // Dama
        tabuleiro[demaisPecas][3].setPeca(p[14]);

        // Rei
        tabuleiro[demaisPecas][4].setPeca(p[15]);
    }

    /**
     * Metodo que apos uma jogada, atualiza a casa que a peca estava anteriormente,
     * de modo que o desenho seja atualizado conforme a cor dessa casa
     *
     * @param linhaOrigem  A linha da posicao que a peca estava
     * @param colunaOrigem A coluna da posicao que a peca estava
     * @param linha        A linha destino
     * @param coluna       A coluna destino
     */
    public void atualizaTabuleiro(int linhaOrigem, char colunaOrigem, int linha, char coluna) {
        try {
            int intColuna = (int) coluna - 97;
            int intColunaOrigem = (int) colunaOrigem - 97;
            tabuleiro[linha][intColuna].setPeca(tabuleiro[linhaOrigem][intColunaOrigem].getPeca());
            tabuleiro[linhaOrigem][intColunaOrigem].setOcupada(false);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
    }

    /**
     * Imprime todas as posicoes do tabuleiro na tela
     */
    public void printTabuleiro() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d   ", i + 1);
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j].getPeca() != null) {
                    System.out.print(" " + tabuleiro[i][j].getPeca().getDesenho() + " ");
                } else {
                    if (tabuleiro[i][j].getCor().equals("branca")) {
                        System.out.print(" - ");
                    } else {
                        System.out.print(" + ");
                    }
                }
                count++;
                if (count == 8) {
                    System.out.printf("\n");
                    count = 0;
                }

            }
        }
        System.out.printf("\n     a  b  c  d  e  f  g  h\n");
    }

    /**
     * método que checa se a coordenada informada está dentro dos limites do
     * tabuleiro
     *
     * @param linhaDestino  recebe a linha destino
     * @param colunaDestino recebe a coluna destino
     * @return true se estiver dentro dos limites do tabuleiro, false caso não
     */
    private boolean checaLimitesDoTabuleiro(int linhaDestino, char colunaDestino) {
        int intColunaDestino = (int) colunaDestino - 97;
        if (linhaDestino >= 0 && linhaDestino <= 7 && intColunaDestino >= 0 && intColunaDestino <= 7) {
            return true;
        }
        return false;
    }



    /**
     * método que verifica a presenca de peças no caminho para uma certa jogada
     * 
     * @param linhaOrigem   linha ja posição de origem
     * @param colunaOrigem  coluna ja posição de origem
     * @param linhaDestino  linha ja posição de destino
     * @param colunaDestino coluna ja posição de destino
     * @return se há ou não peças no caminho considerando a direção diagonal
     */
    private boolean naoTemPecaNoCaminhoDiagonal(int linhaOrigem, char colunaOrigem, int linhaDestino,
            char colunaDestino) {
        int intColunaOrigem = (int) colunaOrigem - 97;
        int intColunaDestino = (int) colunaDestino - 97;

        String cor = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

        while (linhaOrigem != linhaDestino && intColunaOrigem != intColunaDestino) {
            if (linhaDestino < linhaOrigem) {
                linhaOrigem--;
            } else {
                linhaOrigem++;
            }

            if (intColunaDestino < intColunaOrigem) {
                intColunaOrigem--;
            } else {
                intColunaOrigem++;
            }

            if (tabuleiro[linhaOrigem][intColunaOrigem].getOcupada()) {
                String corQueSeraCapturada = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

                if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && intColunaOrigem == intColunaDestino) {
                    return true;
                }
                return false;
            }

        }
        return true;
    }

    /**
     * método que verifica a presenca de peças no caminho para uma certa jogada
     * 
     * @param linhaOrigem   linha ja posição de origem
     * @param colunaOrigem  coluna ja posição de origem
     * @param linhaDestino  linha ja posição de destino
     * @param colunaDestino coluna ja posição de destino
     * @return se há ou não peças no caminho considerando a direção
     *         horizontal/vertical
     */
    private boolean naoTemPecaNoCaminhoReta(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        int intColunaOrigem = (int) colunaOrigem - 97;
        int intColunaDestino = (int) colunaDestino - 97;
        String cor = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

        if (linhaOrigem == linhaDestino) {
            while (intColunaOrigem != intColunaDestino) {

                if (intColunaOrigem < intColunaDestino) {
                    intColunaOrigem++;
                } else {
                    intColunaOrigem--;
                }

                if (tabuleiro[linhaOrigem][intColunaOrigem].getOcupada()) {
                    String corQueSeraCapturada = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

                    if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino
                            && intColunaOrigem == intColunaDestino) {
                        return true;
                    }
                    return false;
                }
            }

        }

        if (intColunaOrigem == intColunaDestino) {
            while (linhaOrigem != linhaDestino) {

                if (linhaOrigem < linhaDestino) {
                    linhaOrigem++;
                } else {
                    linhaOrigem--;
                }

                if (tabuleiro[linhaOrigem][intColunaOrigem].getOcupada()) {
                    String corQueSeraCapturada = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

                    if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino
                            && intColunaOrigem == intColunaDestino) {
                        return true;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * método que verifica a presenca de peças na posição final de uma jogada
     * 
     * @param linhaOrigem   linha ja posição de origem
     * @param colunaOrigem  coluna ja posição de origem
     * @param linhaDestino  linha ja posição de destino
     * @param colunaDestino coluna ja posição de destino
     * @return se há ou não peças no caminho considerando a posição de destino
     */
    private boolean naoTemPecaNoCaminhoPosicaoDestino(int linhaOrigem, char colunaOrigem, int linhaDestino,
            char colunaDestino) {
        int intColunaOrigem = (int) colunaOrigem - 97;
        int intColunaDestino = (int) colunaDestino - 97;
        String cor = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

        if (tabuleiro[linhaDestino][intColunaDestino].getOcupada()) {
            String corQueSeraCapturada = tabuleiro[linhaDestino][intColunaDestino].getPeca().getCor();

            if (cor != corQueSeraCapturada) {
                return true;
            }
            return false;
        }
        return true;
    }

    /**
     * método que verifica a presenca de peças no caminho para o Peao
     * 
     * @param linhaOrigem   linha ja posição de origem
     * @param colunaOrigem  coluna ja posição de origem
     * @param linhaDestino  linha ja posição de destino
     * @param colunaDestino coluna ja posição de destino
     * @return se há ou não peças no caminho
     */
    private boolean naoTemPecaNoCaminhoPeao(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino) {
        int intColunaOrigem = (int) colunaOrigem - 97;
        int intColunaDestino = (int) colunaDestino - 97;
        String corOrigem = tabuleiro[linhaOrigem][intColunaOrigem].getPeca().getCor();

        if (!tabuleiro[linhaDestino][intColunaDestino].getOcupada()) {
            if (corOrigem == "branca" && tabuleiro[linhaOrigem - 1][intColunaOrigem].getOcupada()) {
                return false;
            }
            if (corOrigem == "preta" && tabuleiro[linhaOrigem + 1][intColunaOrigem].getOcupada()) {
                return false;
            }
            if (intColunaOrigem != intColunaDestino) {
                return false;
            }
            return true;

        } else {
            if (corOrigem == "branca" && linhaOrigem == 6 && tabuleiro[linhaOrigem - 2][intColunaOrigem].getOcupada()) {
                return false;
            }
            if (corOrigem == "preta" && linhaOrigem == 1 && tabuleiro[linhaOrigem + 2][intColunaOrigem].getOcupada()) {
                return false;
            }
            if (corOrigem == "branca" && tabuleiro[linhaOrigem - 1][intColunaOrigem].getOcupada()) {
                return false;
            }
            if (corOrigem == "preta" && tabuleiro[linhaOrigem + 1][intColunaOrigem].getOcupada()) {
                return false;
            }

            return true;
        }

    }

    /**
     * método que verifica se o rei está em xeque
     * 
     * @param cor do rei
     * @return Se o rei está em xeque, olhando se há alguma peça que pode atacá-lo
     */
    public boolean reiEmXeque(String cor) {
        int reiLinha = 0;
        char reiColuna = 'd';

        // Busca a linha e coluna do rei de acodo com a cor
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j].getOcupada()) {
                    if (tabuleiro[i][j].getPeca() instanceof Rei && tabuleiro[i][j].getPeca().getCor() == cor) {
                        reiLinha = tabuleiro[i][j].getLinha();
                        reiColuna = tabuleiro[i][j].getColuna();
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // Para as peças no tabuleiro de cor diferente do rei
                if (tabuleiro[i][j].getOcupada() && tabuleiro[i][j].getPeca().getCor() != cor) {
                    if (tabuleiro[i][j].getPeca() != null) {
                        // Testamos se a peça consegue capturar o rei, e se nenhuma peça a impede. Se
                        // sim, é xeque. Caso contrário, não é!
                        if (tabuleiro[i][j].getPeca().checaMovimento(i, ((char) (j + 'a')), reiLinha, reiColuna)
                                && checaPecasNoCaminho(tabuleiro[i][j].getPeca(), i, ((char) (j + 'a')), reiLinha,
                                        reiColuna)) {
                            return true;
                        }
                    }
                }

            }
        }

        return false;

    }

    /**
     * método que verifica se o rei está em xeque-mate, fazendo simulações para
     * garantir que não há saida
     * 
     * @param cor do Rei
     * @return se o rei está em xeque mate, simulando jogadas das outras peças para
     *         tentar defendê-lo, se não adiantar, rei está em mate
     */
    public boolean reiEmXequeMate(String cor) {

        if (!reiEmXeque(cor)) {
            return false; // Se o rei não está em xeque, não está em xeque-mate
        }
        boolean flag = true, capturou = false;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j].getOcupada() && tabuleiro[i][j].getPeca().getCor() == cor
                        && tabuleiro[i][j].getPeca() != null) {

                    // Para todas as peças da mesma cor do rei
                    Peca defendeRei = tabuleiro[i][j].getPeca();

                    for (int x = 0; x < 8; x++) {
                        for (int y = 0; y < 8; y++) {
                            // Vemos em cada movimento válido
                            if (defendeRei.checaMovimento(i, ((char) (j + 'a')), x, ((char) (y + 'a'))) && this
                                    .checaPecasNoCaminho(defendeRei, i, ((char) (j + 'a')), x, ((char) (y + 'a')))) {

                                // Podemos capturar uma peça sem querer durante a simulação, então a salvamos
                                // anteriormente
                                Peca possivelPecaCapturada = tabuleiro[x][y].getPeca();
                                if (possivelPecaCapturada != null) {
                                    // Se não for nula, a peça é capturada, pois o movimento é válido
                                    capturou = true;
                                }

                                // Atualizamos o tabuleiro com a simulação
                                this.atualizaTabuleiro(i, ((char) (j + 'a')), x, ((char) (y + 'a')));

                                // Se não há xeque, o rei conseguiu escapar, portanto não é xeque-mate
                                if (!reiEmXeque(cor)) {
                                    flag = false;
                                }

                                // Desfazemos nossa simulação
                                this.atualizaTabuleiro(x, ((char) (y + 'a')), i, ((char) (j + 'a')));

                                // Porém como é possível de termos capturado algo, temos que desfazer
                                if (capturou) {
                                    possivelPecaCapturada.desfazSimulacao(); // Desfaz a captura
                                    tabuleiro[x][y].setPeca(possivelPecaCapturada); // Coloca a peça onde estava no
                                                                                    // tabuleiro
                                    capturou = false;
                                }

                                // Se a flag está falsa, significa que conseguiu escapar, podemos encerrar aqui
                                // e retornar que não há xeque mate
                                if (!flag)
                                    return flag;
                            }
                        }
                    }

                }
            }
        }
        // Se para todos os movimentos, nenhum defendeu o rei, é xeque-mate
        return flag;
    }

    /**
     *
     * @param linha  recebe a linha
     * @param coluna recebe a coluna
     * @return posição do tabuleiro
     */
    public Posicao getPosicao(int linha, char coluna) {
        try {
            int intColuna = (int) coluna - 97;
            return tabuleiro[linha][intColuna];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    /**
     * método que faz a verificação se certo movimento é valido levando em
     * consideração a regra de cada peça e também a disposição das demais peças no
     * tabuleiro
     *
     * @param p             recebe a Peça
     * @param linha         recebe a linha origem
     * @param coluna        recebe a coluna origem
     * @param linhaDestino  recebe a linha de destino
     * @param colunaDestino recebe a coluna de destino
     * @return se o caminho está livre ou não
     *
     */
    private boolean checaPecasNoCaminho(Peca p, int linha, char coluna, int linhaDestino, char colunaDestino) {
        boolean flag = false;
        if (p instanceof Rei) {
            if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, linhaDestino, colunaDestino)
                    && this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino)) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }

        } else if (p instanceof Bispo) {
            if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, linhaDestino, colunaDestino)) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }

        } else if (p instanceof Dama) {
            if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, linhaDestino, colunaDestino)
                    && (this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino))) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }

        } else if (p instanceof Cavalo) {
            if (this.naoTemPecaNoCaminhoPosicaoDestino(linha, coluna, linhaDestino, colunaDestino)) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }

        } else if (p instanceof Peao) {
            if (this.naoTemPecaNoCaminhoPeao(linha, coluna, linhaDestino, colunaDestino)) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }

        } else if (p instanceof Torre) {
            if (this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino)) {
                flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
            }
        }
        return flag;
    }

    /**
     * método que verifica se o movimento é válido, e se for, executa o mesmo
     * 
     * @param p             peça
     * @param linha         linha de origem
     * @param coluna        coluna de origem
     * @param linhaDestino  linha de destino
     * @param colunaDestino coluna de destino
     * @return se a jogada foi válida e atualiza o tabuleiro
     */
    public boolean checaJogadaValida(Peca p, int linha, char coluna, int linhaDestino, char colunaDestino) {
        boolean flag = false;
        int intColunaDestino = (int) colunaDestino - 97;

        if (this.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {

            flag = checaPecasNoCaminho(p, linha, coluna, linhaDestino, colunaDestino);

            if (flag) {
                Posicao posicaoComPecaAdversaria = this.getPosicao(linhaDestino, colunaDestino);

                if (posicaoComPecaAdversaria.getOcupada()) {
                    posicaoComPecaAdversaria.getPeca().captura();
                    tabuleiro[linhaDestino][intColunaDestino].getPeca().captura();
                }

                this.atualizaTabuleiro(linha, coluna, linhaDestino, colunaDestino);
                return true;
            }
        }

        return flag;
    }

    /**
     * método que verifica se a peça está cercada, ou seja, sem possiilidades de
     * movimento
     *
     * @param p      peça
     * @param linha  linha de origem
     * @param coluna coluna de origem
     * @return se a peça está cercada, portanto incapaz de se mover, ou não
     */
    public boolean pecaCercada(Peca p, int linha, char coluna) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(i == linha && j == (int) coluna - 97)
                        && checaPecasNoCaminho(p, linha, coluna, i, ((char) (j + 'a')))) {
                    return false;
                }
            }
        }
        return true;
    }

}
