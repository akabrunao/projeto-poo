/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

import java.util.Scanner;

/**
 * Classe que lida com tudo relacionado ao jogo, como a inicializa��o do mesmo e
 * o gerenciamento das jogadas.
 *
 * @author Daniele
 */
public class Jogo {

    private Scanner scanner = new Scanner(System.in);
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private int estadoJogo;
    private int jogada;

    /**
     * @param j1 recebe o jogador 1 do Gerenciador
     * @param j2 recebe o jogador 2 do Gerenciador
     */
    public void iniciarJogo(Jogador j1, Jogador j2) {

        // Armazena os jogadores recebidos do gerenciador e os informa as peças!

        jogador1 = j1;
        jogador1.setPeca(criarPecas(jogador1.getCor()));

        jogador2 = j2;
        jogador2.setPeca(criarPecas(jogador2.getCor()));

        // Cria o tabuleiro
        this.tabuleiro = new Tabuleiro(jogador1.getPecas(), jogador2.getPecas());

        estadoJogo = 0; // Inicio
        this.jogada = 0; // Jogador 1 começa

        System.out.println("Programa rodando...");
        System.out.println("BEM VINDO AO JOGO DE XADREZ!");
        jogar();
    }



    /**
     * @param cor recebe a cor do Jogador e cria suas respectivas peças
     */
    private Peca[] criarPecas(String cor) {
        Peca[] p = new Peca[16];
        p[0] = new Peao(cor);
        p[1] = new Peao(cor);
        p[2] = new Peao(cor);
        p[3] = new Peao(cor);
        p[4] = new Peao(cor);
        p[5] = new Peao(cor);
        p[6] = new Peao(cor);
        p[7] = new Peao(cor);
        p[8] = new Torre(cor);
        p[9] = new Torre(cor);
        p[10] = new Cavalo(cor);
        p[11] = new Cavalo(cor);
        p[12] = new Bispo(cor);
        p[13] = new Bispo(cor);
        p[14] = new Dama(cor);
        p[15] = new Rei(cor);
        return p;
    }


    /**
     * retorna qual é o jogador da vez, de acordo com o valor do atributo jogada.
     */
    private Jogador getJogadorDaVez() {
        if (jogada == 0)
            return jogador1;
        else
            return jogador2;
    }

    /**
     * muda o atributo jogada, fazendo com que seja a vez do próximo jogador.
     */
    private void passarVezJogador() {
        if (jogada == 0) {
            jogada = 1;
        } else {
            jogada = 0;
        }
    }


    /**
     * Método que verifica se a peça 
     * 
     * @param p recebe a peça que deseja ser movimentada
     * @param linha recebe a linha origem da peça
     * @param coluna recebe a coluna origem da peça
     * @return return se a peça foi movida ou não
     */
    private boolean moverPosicao(Peca p, int linha, int coluna) {

        System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
        int l = scanner.nextInt();
        char cc = scanner.nextLine().charAt(1);
        int c = cc - 97;
        if (linha == l && coluna == c) {
            System.out.println("Não é possível mover a peca para a posição que ela já está, tente outra coordenada.");
			return false;
		}

        return tabuleiro.checaJogadaValida(p, linha, coluna, l, c);
    }

    /**
     * Método que controla o jogo em si, interagindo com o usuário
     */
    public void jogar() {
        while (true) {
            Jogador jogador = getJogadorDaVez();

            Peca[] p = jogador.getPecas();

            tabuleiro.printTabuleiro();


            if(p[15].isCapturada()){
                System.out.println("Rei foi capturado. O jogo acabou!");
                    if(p[15].getCor() == "branca"){
                            System.out.println("O " + jogador2.getNome() + " foi o vencedor!");
                            this.estadoJogo = 1;
                        } else {
                            System.out.println("O " + jogador1.getNome() + " foi o vencedor!");
                            this.estadoJogo = 1;
                        }

                break;
            }


            System.out.println("Vez do jogador: " + jogador.getNome());

            
        
             //Confere se o rei está em xeque mate
             if (tabuleiro.reiEmXequeMate("branca")) {
                System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque mate!");
                System.out.println("O jogo acabou. Jogador " + jogador2.getNome() + " é o vencedor!");
                break;
            } else if (tabuleiro.reiEmXequeMate("preta")) {
                System.out.println("Rei do jogador: " + jogador2.getNome() + " está em xeque mate!");
                System.out.println("O jogo acabou. Jogador " + jogador1.getNome() + " é o vencedor!");
                break;
            }

            //Confere se o rei está em xeque
            if (tabuleiro.reiEmXeque("branca")) {
                System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque!");
            }
            else if (tabuleiro.reiEmXeque("preta")) {
                System.out.println("Rei do jogador: " + jogador2.getNome() + " está em xeque!");
            }

           

            System.out.println("Insira a coordenada da peça que deseja mover!");
            int linha;
            int coluna;
            linha = scanner.nextInt();
            char cc = scanner.nextLine().charAt(1);
            // Recebe a coluna em char (letras) e transforma-a para int, segundo o funcionamento interno do jogo.
            coluna = cc - 97;

            if (tabuleiro.getPecaPosicao(linha, coluna) == null) {
                System.out.println("Jogada inválida!");
            } else {
                if (tabuleiro.getPecaPosicao(linha, coluna).getCor() == jogador.getCor()) {
                    if (tabuleiro.getPecaPosicao(linha, coluna).isCapturada()) {
                        System.out.println("Essa peça já foi capturada, escolha outra");
                        continue;   
                    }
                    while (!moverPosicao(tabuleiro.getPecaPosicao(linha, coluna), linha, coluna));
                    passarVezJogador();
                } else {
                    System.out.println("Não é possível escolher a peça do outro oponente!");
                }
            }

            
            

        }

    }

}