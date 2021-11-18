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
public class Jogador {


    private Peca[] pecas = new Peca[16];
    private String nome;
    private String cor;

    public Jogador(String cor) {
        this.cor = cor;
    }

    /**
     * retorna o vetor de peças do jogador
     * 
     * @return vetor de objetos do tipo Peca
     */
    public Peca[] getPecas() {
        return pecas;
    }
    
    public void setPeca(Peca[] p) {
        this.pecas = p;
    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    

    public boolean reiFoiCapturado() {
        for (int i = 0; i < 16; i++) {
            if (this.pecas[i] instanceof Rei)
                return pecas[i].isCapturada();
        }
        return false;
    }
}