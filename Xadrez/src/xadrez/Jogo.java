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
     * Método que recebe os dois jogadores e inicializa o jogo!
     */
    public void iniciarJogo(Jogador j1, Jogador j2) {

        // Armazena os jogadores recebidos do gerenciador e os entrega as peças!

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

    private Peca[] criarPecas(String cor) {
        Peca[] p = new Peca[16];

        for (int i = 0; i < 16; i++) {
            if (i < 8) {
                p[i] = new Peao(cor);
            } else if (i < 10) {
                p[i] = new Torre(cor);
            } else if (i < 12) {
                p[i] = new Cavalo(cor);
            } else if (i < 14) {
                p[i] = new Bispo(cor);
            } else if (i == 14) {
                p[i] = new Dama(cor);
            } else if (i == 15) {
                p[i] = new Rei(cor);
            }

        }
        return p;
    }

    private Jogador getJogadorDaVez() {
        if (jogada == 0)
            return jogador1;
        else
            return jogador2;
    }

    private void passarVezJogador() {
        if (jogada == 0) {
            jogada = 1;
        } else {
            jogada = 0;
        }
    }

    private boolean moverPosicao(Peca p, int linha, int coluna) {

        System.out.println("Por gentileza, insira a coordenada em que deseja mover-se!");
        int c1 = scanner.nextInt();
        int c2 = scanner.nextInt();

        if (linha == c1 && coluna == c2) {
            System.out.println("Não é possível mover a peca para a posição que ela já está, tente outra coordenada.");
			return false;
		}

        return tabuleiro.checaJogadaValida(p, linha, coluna, c1, c2);
    }

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

            



            if (tabuleiro.reiEmXeque("branca")) {
                System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque!");
            } else if (tabuleiro.reiEmXeque("preta")) {
                System.out.println("Rei do jogador: " + jogador2.getNome() + " está em xeque!");
            }

            // if (tabuleiro.reiEmXequeMate("branca")) {
            //     System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque mate!");
            //     System.out.println("Fim de Jogo!");
            //     break;
            // } else if (tabuleiro.reiEmXequeMate("preta")) {
            //     System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque mate!");
            //     System.out.println("Fim de Jogo!");
            //     break;
            // }

            System.out.println("Insira a coordenada da peça que deseja mover!");
            int linha;
            int coluna;
            linha = scanner.nextInt();
            coluna = scanner.nextInt();

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