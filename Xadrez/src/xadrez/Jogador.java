/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package xadrez;

import pecas.Peca;

/**
 * Classe responsavel por manter os atributos do jogador e guardar as peças
 *
 * @author Daniele
 */
public class Jogador {

    private Peca[] pecas = new Peca[16];
    private String nome;
    private String cor;

    public Jogador(String cor, String nome) {
        if (cor == "branca" || cor == "preta") {
            this.cor = cor;
            this.nome = nome;
        }
    }

    public void setPeca(Peca[] p) {
        if (p[0].getCor() == this.cor) {
            this.pecas = p;
        }
    }

    public Peca[] getPecas() {
        return pecas;
    }

    public String getCor() {
        return cor;
    }

    public String getNome() {
        return nome;
    }

}