/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xadrez;

/**
 * Classe que gerencia o tabuleiro
 *
 * @author Bruno
 */

public class Tabuleiro {
	private Posicao[][] tabuleiro;

	/**
	 * Construtor do tableiro, que cria o mesmo e tamb�m � respons�vel por
	 * inicializ�-lo
	 * 
	 * @param j1 Recebe o jogador 1
	 * @param j2 Recebe o jogador 2
	 */
	public Tabuleiro(Peca[] p1, Peca[] p2) {
		tabuleiro = new Posicao[8][8];
		String cor;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if ((i % 2) == (j % 2)) {
					cor = "preta";
				} else {
					cor = "branca";
				}

				this.tabuleiro[i][j] = new Posicao(i, j, cor);
			}
		}

		colocaPecaNoTabuleiro(p1);
		colocaPecaNoTabuleiro(p2);

	}

	/**
	 * Coloca o vetor de peças nas posições adequadas do tabuleiro, considerando sua
	 * cor
	 * 
	 * @param p vetor de peças a ser inserido
	 */
	private void colocaPecaNoTabuleiro(Peca[] p) {
		int linhaPeao, demaisPecas, i = 0, peao = 0, cavalo = 1, torre = 0, bispo = 2, rainha = 3, rei = 4;

		if (p[0].getCor() == "preta") {
			linhaPeao = 1; // Se for preto, o peão começa na linha 1
			demaisPecas = 0; // As demais peças na linha 0
		} else {
			linhaPeao = 6; // Se for branco, o peão começa na linha 6
			demaisPecas = 7; // E as demais peças na linha 7
		}

		while (i < 16) {
			if (p[i] instanceof Peao) {
				tabuleiro[linhaPeao][peao].setPeca(p[i]);
				peao++;
			} else if (p[i] instanceof Cavalo) {
				tabuleiro[demaisPecas][cavalo].setPeca(p[i]);
				cavalo = 6;
			} else if (p[i] instanceof Torre) {
				tabuleiro[demaisPecas][torre].setPeca(p[i]);
				torre = 7;
			} else if (p[i] instanceof Bispo) {
				tabuleiro[demaisPecas][bispo].setPeca(p[i]);
				bispo = 5;
			} else if (p[i] instanceof Dama) {
				tabuleiro[demaisPecas][rainha].setPeca(p[i]);
			} else if (p[i] instanceof Rei) {
				tabuleiro[demaisPecas][rei].setPeca(p[i]);
			}
			i++;
		}

	}

	/**
	 * M�todo que ap�s uma jogada, atualiza a casa que a pe�a estava anteriormente,
	 * de modo que o desenho seja atualizado conforme a cor dessa casa
	 * 
	 * @param linha  A linha da posi��o que a pe�a estava
	 * @param coluna A coluna da posi��o que a pe�a estava
	 */
	public void atualizaTabuleiro(int linhaOrigem, int colunaOrigem, int linha, int coluna) {
		tabuleiro[linha][coluna].setPeca(tabuleiro[linhaOrigem][colunaOrigem].getPeca());
		tabuleiro[linhaOrigem][colunaOrigem].setOcupada(false);
	}

	/**
	 * Imprime todas as posi��es do tabuleiro na tela
	 */
	public void printTabuleiro() {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			System.out.printf("%d   ", i);
			for (int j = 0; j < 8; j++) {
				if (tabuleiro[i][j].getPeca() != null) {
					System.out.print(" " + tabuleiro[i][j].getPeca().getDesenho() + " ");
				} else {
					if ((i % 2 == 0) && (j % 2 == 0)) { // se os dois forem pares
						System.out.print(" + ");
					} else if ((i % 2 == 1) && (j % 2 == 1)) { // se os dois fore impares
						System.out.print(" + ");
					} else { // se forem diferentes
						System.out.print(" - ");
					}
				}
				count++;
				if (count == 8) {
					System.out.printf("\n");
					count = 0;
				}

			}
		}
		System.out.printf("\n     a  b  c  d  e  f  g  h\n");
	}

	public boolean checaLimitesDoTabuleiro(int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			return true;
		}
		return false;
	}

	public void setPosicao(int linha, int coluna, Peca p) {
		tabuleiro[linha][coluna].setPeca(p);
	}

	public boolean naoTemPecaNoCaminhoDiagonal(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

		while (linhaOrigem != linhaDestino && colunaOrigem != colunaDestino) {
			if (linhaDestino < linhaOrigem) {
				linhaOrigem--;
			} else {
				linhaOrigem++;
			}

			if (colunaDestino < colunaOrigem) {
				colunaOrigem--;
			} else {
				colunaOrigem++;
			}

			if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
				String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

				if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
					return true;
				}
				return false;
			}

		}
		return true;
	}

	public boolean naoTemPecaNoCaminhoReta(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

		if (linhaOrigem == linhaDestino) {
			while (colunaOrigem != colunaDestino) {

				if (colunaOrigem < colunaDestino) {
					colunaOrigem++;
				} else {
					colunaOrigem--;
				}

				if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
					String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

					if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
						return true;
					}
					return false;
				}
			}

		}

		if (colunaOrigem == colunaDestino) {
			while (linhaOrigem != linhaDestino) {

				if (linhaOrigem < linhaDestino) {
					linhaOrigem++;
				} else {
					linhaOrigem--;
				}

				if (tabuleiro[linhaOrigem][colunaOrigem].getOcupada()) {
					String corQueSeraCapturada = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

					if (cor != corQueSeraCapturada && linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
						return true;
					}
					return false;
				}
			}
		}

		return true;
	}

	public boolean naoTemPecaNoCaminhoPosicaoDestino(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		String cor = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();

		if (tabuleiro[linhaDestino][colunaDestino].getOcupada()) {
			String corQueSeraCapturada = tabuleiro[linhaDestino][colunaDestino].getPeca().getCor();

			if (cor != corQueSeraCapturada) {
				return true;
			}
			return false;
		}
		return true;
	}

	public boolean naoTemPecaNoCaminhoPeao(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
		String corOrigem = tabuleiro[linhaOrigem][colunaOrigem].getPeca().getCor();
		String corDestino;
		try {
			corDestino = tabuleiro[linhaDestino][colunaDestino].getPeca().getCor();
		} catch (Exception e) {
			if (colunaOrigem == colunaDestino) {
				return true;
			}
			return false;
		}

		if (corOrigem == "branca" && tabuleiro[linhaOrigem-1][colunaOrigem].getOcupada()) {
			return false;
		}
		if (corOrigem == "preta" && tabuleiro[linhaOrigem+1][colunaOrigem].getOcupada()) {
			return false;
		}

		return true;

	}

	public boolean reiEmXeque(String cor) {

		int reiLinha = 0;
		int reiColuna = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tabuleiro[i][j].getOcupada()) {
					Peca p = tabuleiro[i][j].getPeca();
					if (p instanceof Rei && p.getCor() == cor) {
						reiLinha = i;
						reiColuna = j;
						break;
					}
				}
			}
		}

		// Verifica se há uma peça da cor oposta que pode atacar o rei, caso sim, o rei
		// está em xeque.

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Peca peca = tabuleiro[i][j].getPeca();

				if (tabuleiro[i][j].getOcupada() && tabuleiro[i][j].getPeca().getCor() != cor) {
					if (peca.checaMovimento(i, j, reiLinha, reiColuna)) {
						return true;
					}
				}

			}
		}

		return false;

	}

	public boolean reiEmXequeMate(String cor){
		boolean flag = true;
		if(!reiEmXeque(cor)) return false;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(tabuleiro[i][j].getCor() == cor && tabuleiro[i][j].getOcupada()){
					for(int a = 0; a < 8; a++){
						for(int b = 0; b < 8; b++){
							Peca peca = tabuleiro[a][b].getPeca();
							try{
								if(checaJogadaValida(peca, i, j, a, b)){
									atualizaTabuleiro(i, j, a, b);

									if(!reiEmXeque(cor)) flag = false;

									atualizaTabuleiro(a, b, i, j);

									if(!flag) return flag;
								}
							} catch(Exception e){

							}	
						}
					}
				}
			}	
		}
		return flag;
	}	

	public Posicao getPosicao(int c1, int c2) {
		return tabuleiro[c1][c2];
	}

	/**
	 * Método que retorna uma peça em uma certa posição Se a posição estiver fora
	 * dos limites do tabuleiro, retorna uma peça nula caso não haja peças ou se
	 * estiver fora do tabuleiro
	 * 
	 * @param linha  linha da peça
	 * @param coluna coluna da peça
	 * @return retorna a peça que está na posição linha, coluna do tabuleiro
	 */
	public Peca getPecaPosicao(int linha, int coluna) {

		try {
			return tabuleiro[linha][coluna].getPeca();
		} catch (IndexOutOfBoundsException i) {
			return null;
		}
	}

	public boolean checaJogadaValida(Peca p, int linha, int coluna, int c1, int c2) {
		boolean flag = false;

		if (this.checaLimitesDoTabuleiro(c1, c2)) {

            if(p instanceof Rei){
                if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, c1, c2) && this.naoTemPecaNoCaminhoReta(linha, coluna, c1, c2)) {
                    flag = p.checaMovimento(linha, coluna, c1, c2);
                }

            } else if(p instanceof Bispo){
               if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, c1, c2)) {
                   flag = p.checaMovimento(linha, coluna, c1, c2);
               }
                
            } else if(p instanceof Dama){
                if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, c1, c2) 
                    && (this.naoTemPecaNoCaminhoReta(linha, coluna, c1, c2))) {
                        flag = p.checaMovimento(linha, coluna, c1, c2);
                    }

            } else if(p instanceof Cavalo){
                if (this.naoTemPecaNoCaminhoPosicaoDestino(linha, coluna, c1, c2)) {
                    flag = p.checaMovimento(linha, coluna, c1, c2);
                }

            } else if(p instanceof Peao){
				if (this.naoTemPecaNoCaminhoPeao(linha, coluna, c1, c2)) {
					flag = p.checaMovimento(linha, coluna, c1, c2);
				}
                
            } else if(p instanceof Torre){
                if (this.naoTemPecaNoCaminhoReta(linha, coluna, c1, c2)) {
                    flag = p.checaMovimento(linha, coluna, c1, c2);
                }
            }
            
            if (flag) {
                Posicao posicaoComPecaAdversaria = this.getPosicao(c1, c2);

                if (posicaoComPecaAdversaria.getOcupada()) {
                    posicaoComPecaAdversaria.getPeca().captura();
                }
    
                this.atualizaTabuleiro(linha, coluna, c1, c2);
                return true;
            } 
        } else {
            System.out.println("Coordenada fora dos limites do tabuleiro");
        }

		return flag;
	}

}