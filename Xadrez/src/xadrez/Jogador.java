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
        if(cor == "branca" || cor == "preta"){
             this.cor = cor;
        } else {
            System.out.println("Cor inválida!");
        }
    }

    public Peca[] getPecas() {
        return pecas;
    }
    
    public void setPeca(Peca[] p) {
        if(p[0].getCor() == this.cor){
            this.pecas = p;
        } else {
            System.out.println("Jogador não pode receber peças da cor oposta a sua!");
        }
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
    
}