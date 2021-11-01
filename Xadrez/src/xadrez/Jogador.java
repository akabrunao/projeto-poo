/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package xadrez;

/**
 * Classe respons�vel por criar os dois jogadores junto com suas pe�as
 *
 * @author Daniele
 */
public class Jogador{
    private String nomeJogador;
    private float pontuacaoJogador;
    private String corJogador;
    private Tabuleiro tabuleiro;
    
    public Jogador(String cor){
        setCorJogador(cor);
        atualizarCorPecas();
        definePosicaoInicial();   
    }
    
    public void inicializaJogador( Tabuleiro tabuleiro) {
        dama.setTabuleiro(tabuleiro);
    	rei.setTabuleiro(tabuleiro);
    	ce.setTabuleiro(tabuleiro);
    	cd.setTabuleiro(tabuleiro);
    	bd.setTabuleiro(tabuleiro);
    	be.setTabuleiro(tabuleiro);
    	te.setTabuleiro(tabuleiro);
    	td.setTabuleiro(tabuleiro);
    	p1.setTabuleiro(tabuleiro);
    	p2.setTabuleiro(tabuleiro);
    	p3.setTabuleiro(tabuleiro);
    	p4.setTabuleiro(tabuleiro);
    	p5.setTabuleiro(tabuleiro);
    	p6.setTabuleiro(tabuleiro);
    	p7.setTabuleiro(tabuleiro);
    	p8.setTabuleiro(tabuleiro);
    }
    // instanciando pe�as
    Dama dama = new Dama(this.getCorJogador(), tabuleiro);
    
    Rei rei = new Rei(this.getCorJogador(), tabuleiro);
    
    Peao p1 = new Peao(this.getCorJogador(), 1, tabuleiro);
    Peao p2 = new Peao(this.getCorJogador(), 2, tabuleiro);
    Peao p3 = new Peao(this.getCorJogador(), 3, tabuleiro);
    Peao p4 = new Peao(this.getCorJogador(), 4, tabuleiro);
    Peao p5 = new Peao(this.getCorJogador(), 5, tabuleiro);
    Peao p6 = new Peao(this.getCorJogador(), 6, tabuleiro);
    Peao p7 = new Peao(this.getCorJogador(), 7, tabuleiro);
    Peao p8 = new Peao(this.getCorJogador(), 8, tabuleiro);
   
    
    Torre te = new Torre(this.getCorJogador(), "esquerda", tabuleiro);
    Torre td = new Torre(this.getCorJogador(), "direita", tabuleiro);
    

    Bispo be = new Bispo(this.getCorJogador(), "esquerda", tabuleiro);
    Bispo bd = new Bispo(this.getCorJogador(), "direita", tabuleiro);
    

    Cavalo ce = new Cavalo(this.getCorJogador(), "esquerda", tabuleiro);
    Cavalo cd = new Cavalo(this.getCorJogador(), "direita", tabuleiro);
    /**
     * Construtor do jogador, respons�vel por setar a cor e definir parametros de suas pe�as
     * 
     * @param cor Recebe a cor do jogador (branca/preta)
     */
    
    /**
     * Atribui para cada pe�a a sua devida posi��o inicial
     */
    public void definePosicaoInicial() {
    	dama.definePosicaoInicial();
    	rei.definePosicaoInicial();
    	ce.definePosicaoInicial();
    	cd.definePosicaoInicial();
    	bd.definePosicaoInicial();
    	be.definePosicaoInicial();
    	te.definePosicaoInicial();
    	td.definePosicaoInicial();
    	p1.definePosicaoInicial();
    	p2.definePosicaoInicial();
    	p3.definePosicaoInicial();
    	p4.definePosicaoInicial();
    	p5.definePosicaoInicial();
    	p6.definePosicaoInicial();
    	p7.definePosicaoInicial();
    	p8.definePosicaoInicial();
    }
    
    /**
     * Para cada pe�a do jogador, faz o set da sua cor
     */
    public void atualizarCorPecas(){
       dama.setCor(this.getCorJogador());
       rei.setCor(this.getCorJogador());
       p1.setCor(this.getCorJogador());
       p2.setCor(this.getCorJogador());
       p3.setCor(this.getCorJogador());
       p4.setCor(this.getCorJogador());
       p5.setCor(this.getCorJogador());
       p6.setCor(this.getCorJogador());
       p7.setCor(this.getCorJogador());
       p8.setCor(this.getCorJogador());
       te.setCor(this.getCorJogador());
       td.setCor(this.getCorJogador());
       bd.setCor(this.getCorJogador());
       be.setCor(this.getCorJogador());
       ce.setCor(this.getCorJogador());
       cd.setCor(this.getCorJogador());
    }
   
    // Getters e Setters
    public String getNomeJogador() {
        return nomeJogador;
    }

    public void setNomeJogador(String nomeJogador) {
        this.nomeJogador = nomeJogador;
    }

    public float getPontuacaoJogador() {
        return pontuacaoJogador;
    }

    public void setPontuacaoJogador(float pontuacaoJogador) {
        this.pontuacaoJogador = pontuacaoJogador;
    }

    public String getCorJogador() {
        return corJogador;
    }

    public void setCorJogador(String corJogador) {
        this.corJogador = corJogador;
	}

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    

}
