/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pecas;

/**
 *
 * @author Bruno
 */
public abstract class Peca {
	protected boolean capturada;
	protected String cor;
	protected String desenho;

	protected abstract String desenho();
	public abstract boolean checaMovimento(int linhaOrigem, char colunaOrigem, int linhaDestino, char colunaDestino);

	public void desfazSimulacao() {
		capturada = false;
	}

	public void captura() {
		capturada = true;
	}

	public boolean isCapturada() {
		return capturada;
	}

	public String getCor() {
		return cor;
	}

	public String getDesenho() {
		return desenho;
	}


}