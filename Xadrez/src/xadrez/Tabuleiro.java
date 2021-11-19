/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

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

                this.tabuleiro[i][j] = new Posicao(i, j, cor);
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
            setPosicao(linhaPeao, i, p[i]);
        }

        // Torre
        tabuleiro[demaisPecas][0].setPeca(p[8]);
        tabuleiro[demaisPecas][7].setPeca(p[9]);
        setPosicao(demaisPecas, 0, p[8]);
        setPosicao(demaisPecas, 7, p[9]);

        // Cavalo
        tabuleiro[demaisPecas][1].setPeca(p[10]);
        tabuleiro[demaisPecas][6].setPeca(p[11]);
        setPosicao(demaisPecas, 1, p[10]);
        setPosicao(demaisPecas, 6, p[11]);

        // Bispo
        tabuleiro[demaisPecas][2].setPeca(p[12]);
        tabuleiro[demaisPecas][5].setPeca(p[13]);
        setPosicao(demaisPecas, 2, p[12]);
        setPosicao(demaisPecas, 5, p[13]);

        // Dama
        tabuleiro[demaisPecas][3].setPeca(p[14]);
        setPosicao(demaisPecas, 3, p[14]);

        // Rei
        tabuleiro[demaisPecas][4].setPeca(p[15]);
        setPosicao(demaisPecas, 4, p[15]);

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
    public void atualizaTabuleiro(int linhaOrigem, int colunaOrigem, int linha, int coluna) {
        try {
            tabuleiro[linha][coluna].setPeca(tabuleiro[linhaOrigem][colunaOrigem].getPeca());
            setPosicao(linha, coluna, tabuleiro[linhaOrigem][colunaOrigem].getPeca());
            tabuleiro[linhaOrigem][colunaOrigem].setOcupada(false);

        } catch (Exception e) {}
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
                    System.out.print(" " + tabuleiro[i][j].getPeca().desenho() + " ");
                } else {
                    if ((i % 2 == 0) && (j % 2 == 0)) { // se os dois forem pares
                        System.out.print(" + ");
                    } else if ((i % 2 == 1) && (j % 2 == 1)) { // se os dois fore impares
                        System.out.print(" + ");
                    } else { // se forem diferentes
                        System.out.print(" - ");
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
    public boolean checaLimitesDoTabuleiro(int linhaDestino, int colunaDestino) {
        if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
            return true;
        }
        return false;
    }

    /**
     * método que seta a posição da peça
     *
     * @param linha  linha da peça
     * @param coluna coluna da peça
     * @param p      a peça em si
     */
    public void setPosicao(int linha, int coluna, Peca p) {
        try {
            tabuleiro[linha][coluna].setPeca(p);
            tabuleiro[linha][coluna].setLinha(linha);
            tabuleiro[linha][coluna].setColuna(coluna);
        } catch (Exception e) {  }
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
    public boolean naoTemPecaNoCaminhoDiagonal(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

        while (linhaOrigem != linhaDestino && colunaOrigem != colunaDestino) {
            if (linhaDestino < linhaOrigem) {
                linhaOrigem--;
            } else {
                linhaOrigem++;
            }

            if (colunaDestino < colunaOrigem) {
                colunaOrigem--;
            } else {
                colunaOrigem++;
            }

            if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
                String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

                if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
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
    public boolean naoTemPecaNoCaminhoReta(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

        if (linhaOrigem == linhaDestino) {
            while (colunaOrigem != colunaDestino) {

                if (colunaOrigem < colunaDestino) {
                    colunaOrigem++;
                } else {
                    colunaOrigem--;
                }

                if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
                    String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

                    if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
                        return true;
                    }
                    return false;
                }
            }

        }

        if (colunaOrigem == colunaDestino) {
            while (linhaOrigem != linhaDestino) {

                if (linhaOrigem < linhaDestino) {
                    linhaOrigem++;
                } else {
                    linhaOrigem--;
                }

                if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
                    String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

                    if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
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
    public boolean naoTemPecaNoCaminhoPosicaoDestino(int linhaOrigem, int colunaOrigem, int linhaDestino,
            int colunaDestino) {
        String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

        if (tabuleiro[linhaDestino][colunaDestino].getOcupada()) {
            String corQueSeraCapturada = tabuleiro[linhaDestino][colunaDestino].getPeca().getCor();

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
    public boolean naoTemPecaNoCaminhoPeao(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        String corOrigem = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();
        String corDestino;
        try {
            corDestino = tabuleiro[linhaDestino][colunaDestino].getPeca().getCor();
        } catch (Exception e) {
            // se deu exception é porque a posição de destino está vazia
            if (corOrigem == "branca" && tabuleiro[linhaOrigem - 1][colunaOrigem].getOcupada()) {
                return false;
            }
            if (corOrigem == "preta" && tabuleiro[linhaOrigem + 1][colunaOrigem].getOcupada()) {
                return false;
            }
            if (colunaOrigem == colunaDestino) {
                return true;
            }
            return false;
        }

        if (corOrigem == "branca" && tabuleiro[linhaOrigem - 1][colunaOrigem].getOcupada()) {
            return false;
        }
        if (corOrigem == "preta" && tabuleiro[linhaOrigem + 1][colunaOrigem].getOcupada()) {
            return false;
        }

        return true;

    }

    /**
     * método que verifica se o rei está em xeque
     * 
     * @param cor do rei
     * @return Se o rei está em xeque, olhando se há alguma peça que pode atacá-lo
     */
    public boolean reiEmXeque(String cor) {
        int reiLinha = 0;
        int reiColuna = 0;

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
                        if (tabuleiro[i][j].getPeca().checaMovimento(i, j, reiLinha, reiColuna)
                                && checaPecasNoCaminho(tabuleiro[i][j].getPeca(), i, j, reiLinha, reiColuna)) {
                            return true;
                        }
                    }
                }

            }
        }

        return false;

    }

    /**
     * método que verifica se o rei está em xeque-mate, fazendo simulações para garantir que não há saida
     * 
     * @param cor do Rei
     * @return se o rei está em xeque mate, simulando jogadas das outras peças para
     *         tentar defendê-lo, se não adiantar, rei está em mate
     */
    public boolean reiEmXequeMate(String cor) {

        if (!reiEmXeque(cor)) {
            return false; // Se o rei não está em xeque, não está em xeque-mate
        }
        boolean flag = true;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tabuleiro[i][j].getOcupada() && tabuleiro[i][j].getPeca().getCor() == cor) {
                    for (int a = 0; a < 8; a++) {
                        for (int b = 0; b < 8; b++) {
                            // Pega-se a peça
                            Peca peca = tabuleiro[a][b].getPeca();
                            // Se a peça não for nula e sua cor for igual a do rei
                            if (peca != null && peca.getCor() == cor) {
                                // Conferimos se o movimento é válido e não há outras peças no caminho
                                // impedindo-a de realizá-lo
                                if (peca.checaMovimento(i, j, a, b) && checaPecasNoCaminho(peca, i, j, a, b)) {
                                    // Se for válido, atualizamos o tabuleiro movendo a peça
                                    atualizaTabuleiro(i, j, a, b);

                                    // Testamos se o movimento tirou o rei do xeque
                                    if (!reiEmXeque(cor)) {
                                        flag = false;
                                    }

                                    // Rei continua em xeque? Deu ruim, adiantou nada. Se o rei saiu do xeque, então
                                    // já não é xeque mate.
                                    // Desfaz o movimento
                                    atualizaTabuleiro(a, b, i, j);
                                    tabuleiro[a][b].setPeca(peca);

                                    if (!flag) {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        // Se para nenhuma das tentativas, o rei não saiu do xeque, é xeque-mate, se
        // saiu não é
        return flag;
    }

    /**
     *
     * @param linha  recebe a linha
     * @param coluna recebe a coluna
     * @return posição do tabuleiro
     */
    public Posicao getPosicao(int linha, int coluna) {
        try {
            return tabuleiro[linha][coluna];
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param linha  linha da peça
     * @param coluna coluna da peça
     * @return retorna a peça que está na posição linha, coluna do tabuleiro
     */
    public Peca getPecaPosicao(int linha, int coluna) {
        try {
            return tabuleiro[linha][coluna].getPeca();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * método que faz a verificação se certo movimento é valido levando em 
     * consideração a regra de cada peça e também a disposição das demais 
     * peças no tabuleiro
     *
     * @param p             recebe a Peça
     * @param linha         recebe a linha origem
     * @param coluna        recebe a coluna origem
     * @param linhaDestino  recebe a linha de destino
     * @param colunaDestino recebe a coluna de destino
     * @return se o caminho está livre ou não
     *
     */
    public boolean checaPecasNoCaminho(Peca p, int linha, int coluna, int linhaDestino, int colunaDestino) {
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
    public boolean checaJogadaValida(Peca p, int linha, int coluna, int linhaDestino, int colunaDestino) {
        boolean flag = false;

        if (this.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {

            flag = checaPecasNoCaminho(p, linha, coluna, linhaDestino, colunaDestino);

            if (flag) {
                Posicao posicaoComPecaAdversaria = this.getPosicao(linhaDestino, colunaDestino);

                if (posicaoComPecaAdversaria.getOcupada()) {
                    posicaoComPecaAdversaria.getPeca().captura();
                    tabuleiro[linhaDestino][colunaDestino].getPeca().captura();
                }

                this.atualizaTabuleiro(linha, coluna, linhaDestino, colunaDestino);
                return true;
            }
        } 

        return flag;
    }

    /**
     * método que verifica se a peça está cercada, ou seja, sem possiilidades de movimento
     *
     * @param p      peça
     * @param linha  linha de origem
     * @param coluna coluna de origem
     * @return se a peça está cercada, portanto incapaz de se mover, ou não
     */
    public boolean pecaCercada(Peca p, int linha, int coluna) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (!(i == linha && j == coluna) && checaPecasNoCaminho(p, linha, coluna, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

}
