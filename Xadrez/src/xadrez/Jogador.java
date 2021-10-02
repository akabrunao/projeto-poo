/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe responsável por criar os dois jogadores junto com suas peças
 *
 * @author Daniele
 */
public class Jogador{
    private String nomeJogador;
    private float pontuacaoJogador;
    private String corJogador;
    
    // instanciando peças
    Dama dama = new Dama(this.getCorJogador());
    
    Rei rei = new Rei(this.getCorJogador());
    
    Peao p1 = new Peao(this.getCorJogador(), 1);
    Peao p2 = new Peao(this.getCorJogador(), 2);
    Peao p3 = new Peao(this.getCorJogador(), 3);
    Peao p4 = new Peao(this.getCorJogador(), 4);
    Peao p5 = new Peao(this.getCorJogador(), 5);
    Peao p6 = new Peao(this.getCorJogador(), 6);
    Peao p7 = new Peao(this.getCorJogador(), 7);
    Peao p8 = new Peao(this.getCorJogador(), 8);
   
    
    Torre te = new Torre(this.getCorJogador(), "esquerda");
    Torre td = new Torre(this.getCorJogador(), "direita");
    

    Bispo be = new Bispo(this.getCorJogador(), "esquerda");
    Bispo bd = new Bispo(this.getCorJogador(), "direita");
    

    Cavalo ce = new Cavalo(this.getCorJogador(), "esquerda");
    Cavalo cd = new Cavalo(this.getCorJogador(), "direita");

    /**
     * Construtor do jogador, responsável por setar a cor e definir parametros de suas peças
     * 
     * @param cor Recebe a cor do jogador (branca/preta)
     */
    public Jogador(String cor){
    	setCorJogador(cor);
        atualizarCorPecas();
        definePosicaoInicial();
    }
    
    /**
     * Atribui para cada peça a sua devida posição inicial
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
     * Para cada peça do jogador, faz o set da sua cor
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

}
