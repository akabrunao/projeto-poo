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
/**
 * Ainda nÃ£o comecei a classe posiÃ§Ã£o, bastante coisa daqui vai migrar pra lÃ¡.
 * 
 * Utilizei int para as colunas por facilitar o calculo das posiÃ§Ãµes, mas provavelmente o input 
 * do usuario vai ser um char, a gente pode usar um enum para transformar o char em int.
 */
public class Tabuleiro{
    private Posicao[][] tabuleiro;
    

    //Construtor
    public Tabuleiro(Jogador j1, Jogador j2) {
        tabuleiro = new Posicao[8][8];
        inicializaTabuleiro(j1, j2);
    }

    public void atualizaTabuleiro(int linha, int coluna) {
    	tabuleiro[linha][coluna].setDesenho(defineCorDaCasa(linha, coluna));
    }

    
    private void inicializaTabuleiro(Jogador j1, Jogador j2) {
        criaTabuleiro();

        posicionaPecasParaInicioDoJogo(j1, j2);
    }
    
    public void colocaPecaNoTabuleiro(Dama p) {
    	Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
    	
        if(p.isCapturada() == false) {
        	pos.setOcupada(true);
            pos.setDesenho(p.desenha());
        }
    }
    public void colocaPecaNoTabuleiroRei(Rei p) {
    	Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
    	
        if(p.isCapturada() == false) {
        	pos.setOcupada(true);
            pos.setDesenho(p.desenha());
        }
    }
    public void colocaPecaNoTabuleiroCv(Cavalo p) {
    	Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
    	
        if(p.isCapturada() == false) {
        	pos.setOcupada(true);
            pos.setDesenho(p.desenha());
        }
    }
    
     public void colocaPecaNoTabuleiroTorre(Torre p) {
    	 Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
     	
         if(p.isCapturada() == false) {
         	pos.setOcupada(true);
             pos.setDesenho(p.desenha());
         }
    }
     
     public void colocaPecaNoTabuleiroPeao(Peao p) {
    	Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
    	
        if(p.isCapturada() == false) {
        	pos.setOcupada(true);
            pos.setDesenho(p.desenha());
        }
    }
        
     public void colocaPecaNoTabuleiroBispo(Bispo p) {
    	Posicao pos = tabuleiro[p.getLinha()][p.getColuna()];
    	
        if(p.isCapturada() == false) {
        	pos.setOcupada(true);
            pos.setDesenho(p.desenha());
        }
    }
     
     
    
    

    private void posicionaPecasParaInicioDoJogo(Jogador j1, Jogador j2) {
        //dama
        colocaPecaNoTabuleiro(j1.dama);
        colocaPecaNoTabuleiro(j2.dama);
        //rei
        colocaPecaNoTabuleiroRei(j1.rei);
        colocaPecaNoTabuleiroRei(j2.rei);
        //cavalo
        colocaPecaNoTabuleiroCv(j1.cd);
        colocaPecaNoTabuleiroCv(j1.ce);
        colocaPecaNoTabuleiroCv(j2.cd);
        colocaPecaNoTabuleiroCv(j2.ce);
        
        colocaPecaNoTabuleiroTorre(j1.td);
        colocaPecaNoTabuleiroTorre(j1.te);
        colocaPecaNoTabuleiroTorre(j2.td);
        colocaPecaNoTabuleiroTorre(j2.te);
        
        colocaPecaNoTabuleiroBispo(j1.bd);
        colocaPecaNoTabuleiroBispo(j1.be);
        colocaPecaNoTabuleiroBispo(j2.bd);
        colocaPecaNoTabuleiroBispo(j2.be);
       
        
        colocaPecaNoTabuleiroPeao(j1.p1);
        colocaPecaNoTabuleiroPeao(j1.p2);
        colocaPecaNoTabuleiroPeao(j1.p3);
        colocaPecaNoTabuleiroPeao(j1.p4);
        colocaPecaNoTabuleiroPeao(j1.p5);
        colocaPecaNoTabuleiroPeao(j1.p6);
        colocaPecaNoTabuleiroPeao(j1.p7);
        colocaPecaNoTabuleiroPeao(j1.p8);
        colocaPecaNoTabuleiroPeao(j2.p1);
        colocaPecaNoTabuleiroPeao(j2.p2);
        colocaPecaNoTabuleiroPeao(j2.p3);
        colocaPecaNoTabuleiroPeao(j2.p4);
        colocaPecaNoTabuleiroPeao(j2.p5);
        colocaPecaNoTabuleiroPeao(j2.p6);
        colocaPecaNoTabuleiroPeao(j2.p7);
        colocaPecaNoTabuleiroPeao(j2.p8);
        /**
         * Adicionar outras peÃ§as aqui conforme for criando,
         * 1 chamadas para cada peÃ§a
         */
    }
    
    
    

    private void criaTabuleiro() {
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
            	Posicao pos = new Posicao();
            	pos.setColuna(j);
            	pos.setLinha(i);
            	pos.setCor(defineCorDaCasa(i, j));
            	pos.setDesenho(defineCorDaCasa(i, j));
            	pos.setOcupada(false);
            	
                tabuleiro[i][j] = pos;
            }
        }
    }

    public String defineCorDaCasa(int i, int j) {
        if ((i % 2 == 0) && (j % 2 == 0)) { //se os dois forem pares
            return " + ";
        } else if ((i % 2 == 1) && (j % 2 == 1)) { //se os dois fore impares
            return " + ";
        } else { //se forem diferentes
            return " - " ;
        }
    }

    
    public void printTabuleiro() {
        int count = 0;
        for(int i = 0; i < 8; i++) {
        	System.out.printf("%d   ", i);
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j].getDesenho());
                count++;
                if (count == 8) {
                    System.out.printf("\n");
                    count = 0;
                }
            }
        }
       System.out.printf("\n     a  b  c  d  e  f  g  h\n");
    }
    
}
