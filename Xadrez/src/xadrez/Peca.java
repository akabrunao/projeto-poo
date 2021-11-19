/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 *
 * @author Bruno
 */
public abstract class Peca {
	protected boolean capturada;
	protected String cor;
	protected String desenho;

	protected abstract void desenha();
	protected abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);

	protected void captura() {
		capturada = true;
	}

	protected String desenho() {
		return desenho;
	}

	protected boolean isCapturada() {
		return capturada;
	}

	protected String getCor() {
		return cor;
	}
}