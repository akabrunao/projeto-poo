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
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private String estadoJogo;
    private int jogada;

    /**
     * @param j1 recebe o jogador 1 do Gerenciador
     * @param j2 recebe o jogador 2 do Gerenciador
     */
    public void iniciarJogo(Jogador j1, Jogador j2) {

        // Armazena os jogadores recebidos do gerenciador e os informa as peças!

        this.jogador1 = j1;
        jogador1.setPeca(criarPecas(jogador1.getCor()));

        this.jogador2 = j2;
        jogador2.setPeca(criarPecas(jogador2.getCor()));

        // Cria o tabuleiro
        this.tabuleiro = new Tabuleiro(jogador1.getPecas(), jogador2.getPecas());

        this.estadoJogo = "Início";
        this.jogada = 0; // Jogador 1 começa

        System.out.println("Programa rodando...");
        System.out.println("BEM VINDO AO JOGO DE XADREZ!");
        jogar();
    }



    /**
     * 
     * @param cor recebe a cor da peça
     * @return um vetor de peças
     */
    private Peca[] criarPecas(String cor) {
        Peca[] p = new Peca[16];
        for(int i = 0; i<8; i++){
          p[i] = new Peao(cor);  
        }
        
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
     * 
     * @return qual o jogador da rodada
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
        int l = 0;
        char cc = 'a';

        boolean pronto = false;
            while(!pronto){
                try{
                    Scanner ler = new Scanner(System.in);
                    l = ler.nextInt();
                    cc = ler.nextLine().charAt(1);
                    pronto = true;
                }catch(Exception e){
                    System.out.println("Por favor, insira a coordenada corretamente!");
                }
            }
            
        int c = cc - 97;
        l = l - 1;
        
        
        if (linha == l && coluna == c) {
            System.out.println("Não é possível mover a peca para a posição que ela já está, tente outra coordenada.");
			return false;
	}
        
        if(!tabuleiro.checaJogadaValida(p, linha, coluna, l, c)){
            System.out.println("Jogada inválida!");
            return false;
        }

        return true;
    }
    
    private void printarEstadoJogo(){
        System.out.println("ESTADO DO JOGO: " + this.estadoJogo);
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
                            this.estadoJogo = "Fim";
                        } else {
                            System.out.println("O " + jogador1.getNome() + " foi o vencedor!");
                            this.estadoJogo = "Fim"; 
                             
                        }
                printarEstadoJogo();
                break;
            }


            System.out.println("Vez do jogador: " + jogador.getNome());
            printarEstadoJogo();
            
             
            
        
             //Confere se o rei está em xeque mate
             if (tabuleiro.reiEmXequeMate("branca")) {
                System.out.println("Rei do jogador " + jogador1.getNome() + " está em xeque mate!");
                System.out.println("O jogo acabou. Jogador " + jogador2.getNome() + " é o vencedor!");
                this.estadoJogo = "Xeque-Mate";
                printarEstadoJogo();
                break;
            } else if (tabuleiro.reiEmXequeMate("preta")) {
                System.out.println("Rei do jogador " + jogador2.getNome() + " está em xeque mate!");
                System.out.println("O jogo acabou. Jogador " + jogador1.getNome() + " é o vencedor!");
                this.estadoJogo = "Xeque-Mate";
                printarEstadoJogo();
                break;
            } else {
                this.estadoJogo = "Em andamento";
            }

            //Confere se o rei está em xeque
            if (tabuleiro.reiEmXeque("branca")) {
                System.out.println("Rei do jogador: " + jogador1.getNome() + " está em xeque!");
                this.estadoJogo = "Xeque";
            }
            else if (tabuleiro.reiEmXeque("preta")) {
                System.out.println("Rei do jogador: " + jogador2.getNome() + " está em xeque!");
                this.estadoJogo = "Xeque";
            } else {
                this.estadoJogo = "Em andamento";
            }

           

            System.out.println("Insira a coordenada da peça que deseja mover!");
            int linha = 0;
            int coluna = 0;
            char cc = 'a';
            
            boolean pronto = false;
            while(!pronto){
                try{
                    Scanner ler = new Scanner(System.in);
                    linha = ler.nextInt();
                    cc = ler.nextLine().charAt(1);
                    pronto = true;
                }catch(Exception e){
                    System.out.println("Por favor, insira a coordenada corretamente");
                }
            }
            // Recebe a coluna em char (letras) e transforma-a para int, segundo o funcionamento interno do jogo.
            coluna = cc - 97;
            linha = linha - 1;

            if (tabuleiro.getPecaPosicao(linha, coluna) == null) {
                System.out.println("Jogada inválida!");
            } else {
                if (tabuleiro.getPecaPosicao(linha, coluna).getCor() == jogador.getCor()) {
                    if (tabuleiro.getPecaPosicao(linha, coluna).isCapturada()) {
                        System.out.println("Essa peça já foi capturada, escolha outra");
                        continue;   
                    }
                    if(tabuleiro.pecaCercada(tabuleiro.getPecaPosicao(linha, coluna), linha, coluna)){
                        System.out.println("Essa peça está cercada, portanto não pode se mover. Escolha outra peça!");
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