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
	 * Construtor do tableiro, que cria o mesmo e tambem e responsavel por
	 * inicializa-lo
	 * 
	 * @param p1 Recebe as peças brancas
	 * @param p2 Recebe as peças pretas
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
		int linhaPeao, demaisPecas;
                
                if(!(p[0].getCor().equals("preta") || p[0].getCor().equals("branca"))){
                    System.out.println("Cor inválida!");
                }

		if (p[0].getCor().equals("preta")) {
			linhaPeao = 1; // Se for preto, o peão começa na linha 1
			demaisPecas = 0; // As demais peças na linha 0
		} else {
			linhaPeao = 6; // Se for branco, o peão começa na linha 6
			demaisPecas = 7; // E as demais peças na linha 7
		}
                
                
                for(int i = 0; i < 8; i++){
                   tabuleiro[linhaPeao][i].setPeca(p[i]);
                   setPosicao(linhaPeao, i, p[i]);
                }
                
                //Torre
                tabuleiro[demaisPecas][0].setPeca(p[8]);
                tabuleiro[demaisPecas][7].setPeca(p[9]);
                setPosicao(demaisPecas, 0, p[8]);
                setPosicao(demaisPecas, 7, p[9]);
                 
                
                //Cavalo
                tabuleiro[demaisPecas][1].setPeca(p[10]);
                tabuleiro[demaisPecas][6].setPeca(p[11]);
                setPosicao(demaisPecas, 1, p[10]);
                setPosicao(demaisPecas, 6, p[11]);
                
                //Bispo
                tabuleiro[demaisPecas][2].setPeca(p[12]);
                tabuleiro[demaisPecas][5].setPeca(p[13]);
                setPosicao(demaisPecas, 2, p[12]);
                setPosicao(demaisPecas, 5, p[13]);
                
                //Dama
                tabuleiro[demaisPecas][3].setPeca(p[14]);
                setPosicao(demaisPecas, 3, p[14]);
                
                //Rei
		tabuleiro[demaisPecas][4].setPeca(p[15]);
                setPosicao(demaisPecas, 4, p[15]);
                          

	}

	/**
	 * Metodo que apo uma jogada, atualiza a casa que a peca estava anteriormente,
	 * de modo que o desenho seja atualizado conforme a cor dessa casa
	 * 
	 * @param linhaOrigem  A linha da posicao que a peca estava
	 * @param colunaOrigem A coluna da posicao que a peca estava
         * @param linha A linha destino
         * @param coluna A coluna destino
	 */
	public void atualizaTabuleiro(int linhaOrigem, int colunaOrigem, int linha, int coluna) {
                try{
                    tabuleiro[linha][coluna].setPeca(tabuleiro[linhaOrigem][colunaOrigem].getPeca());
                    setPosicao(linha, coluna, tabuleiro[linhaOrigem][colunaOrigem].getPeca());
                    tabuleiro[linhaOrigem][colunaOrigem].setOcupada(false);
                } catch(Exception e){
                    System.out.println("Erro ao atualizar o tabuleiro");
                }
	}

	/**
	 * Imprime todas as posicoes do tabuleiro na tela
	 */
	public void printTabuleiro() {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			System.out.printf("%d   ", i+1);
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

        
        /**
         * 
         * @param linhaDestino recebe a linha destino
         * @param colunaDestino recebe a coluna destino
         * @return true se estiver dentro dos limites do tabuleiro, false caso não
         */
	public boolean checaLimitesDoTabuleiro(int linhaDestino, int colunaDestino) {
		if (linhaDestino >= 0 && linhaDestino <= 7 && colunaDestino >= 0 && colunaDestino <= 7) {
			return true;
		}
		return false;
	}
        
        /**
         * 
         * @param linha linha da peça
         * @param coluna coluna da peça
         * @param p a peça em si
         */
	public void setPosicao(int linha, int coluna, Peca p) {
            try{
		tabuleiro[linha][coluna].setPeca(p);
                tabuleiro[linha][coluna].setLinha(linha);
                tabuleiro[linha][coluna].setColuna(coluna);
            }catch(Exception e){ }
	}
        
        
        /**
         * 
         * @param linhaOrigem
         * @param colunaOrigem
         * @param linhaDestino
         * @param colunaDestino
         * @return se há ou não peças no caminho considerando a direção diagonal
         */
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

        /**
         * 
         * @param linhaOrigem
         * @param colunaOrigem
         * @param linhaDestino
         * @param colunaDestino
         * @return se há ou não peças considerando a direção reta
         */
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
        
        /**
         * 
         * @param linhaOrigem
         * @param colunaOrigem
         * @param linhaDestino
         * @param colunaDestino
         * @return se há ou não peças na coordenada destino
         */
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
        
        /**
         * 
         * @param linhaOrigem
         * @param colunaOrigem
         * @param linhaDestino
         * @param colunaDestino
         * @return 
         */
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

        /**
         * 
         * @param cor do rei
         * @return  Se o rei está em xeque, olhando se há alguma peça que pode atacá-lo
         */
        public boolean reiEmXeque(String cor) {
		int reiLinha = 0;
		int reiColuna = 0;
		for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
			if (tabuleiro[i][j].getOcupada()) {
                            if (tabuleiro[i][j].getPeca() instanceof Rei) {
                                if(tabuleiro[i][j].getCor().equals(cor)){
                                    reiLinha = tabuleiro[i][j].getLinha();
                                    reiColuna = tabuleiro[i][j].getColuna();
                                    break;
                                }
                            }
                        }
                    }
		}

		for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
			if (tabuleiro[i][j].getOcupada() && tabuleiro[i][j].getPeca().getCor() != cor) {
                            if (tabuleiro[i][j].getPeca().checaMovimento(i, j, reiLinha, reiColuna)) {
				return true;
                            }
			}
                    }
		}
		return false;

	}

        
        /**
         * 
         * @param cor do Rei
         * @return  se o rei está em xeque mate, simulando jogadas das outras peças para tentar defendê-lo, se não adiantar, rei está em mate
         */
	public boolean reiEmXequeMate(String cor){
		boolean flag = true;
		if(!reiEmXeque(cor)) return false;
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
                            if(tabuleiro[i][j].getCor().equals(cor) && tabuleiro[i][j].getOcupada()){
				for(int a = 0; a < 8; a++){
                                    for(int b = 0; b < 8; b++){
                                        try{
                                            if(checaJogadaValida(tabuleiro[a][b].getPeca(), i, j, a, b)){
						atualizaTabuleiro(i, j, a, b);
                                                setPosicao(a, b, tabuleiro[a][b].getPeca());
						if(!reiEmXeque(cor)) flag = false;
						atualizaTabuleiro(a, b, i, j);
                                                setPosicao(i, j, tabuleiro[a][b].getPeca());
                                                if(!flag) return flag;
                                            }
					} catch(Exception e){}	
                                    }
				}
                            }
			}	
		}
		return flag;
	}	
        
        /**
         * 
         * @param linha recebe a linha
         * @param coluna recebe a coluna
         * @return posição do tabuleiro
         */
	public Posicao getPosicao(int linha, int coluna) {
                try{
		return tabuleiro[linha][coluna];
                } catch(Exception e){
                    return null;
                }      
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
                } catch (Exception e) {
                    return null;
		}           
	}

        /**
         * 
         * @param p recebe a Peça
         * @param linha recebe a linha origem
         * @param coluna recebe a coluna origem
         * @param linhaDestino recebe a linha de destino
         * @param colunaDestino recebe a coluna de destino  
         * @return se há alguma peça no caminho da peça p que impossibilite o movimento da mesma
         * 
         */
        
        public boolean checaPecasNoCaminho(Peca p, int linha, int coluna, int linhaDestino, int colunaDestino){
            boolean flag = false;
            if(p instanceof Rei){
                if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, linhaDestino, colunaDestino) && this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino)) {
                    flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
                }

            } else if(p instanceof Bispo){
               if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna,linhaDestino, colunaDestino)) {
                   flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
               }
                
            } else if(p instanceof Dama){
                if (this.naoTemPecaNoCaminhoDiagonal(linha, coluna, linhaDestino, colunaDestino) 
                    && (this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino))) {
                        flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
                    }

            } else if(p instanceof Cavalo){
                if (this.naoTemPecaNoCaminhoPosicaoDestino(linha, coluna, linhaDestino, colunaDestino)) {
                    flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
                }

            } else if(p instanceof Peao){
				if (this.naoTemPecaNoCaminhoPeao(linha, coluna, linhaDestino, colunaDestino)) {
					flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
				}
                
            } else if(p instanceof Torre){
                if (this.naoTemPecaNoCaminhoReta(linha, coluna, linhaDestino, colunaDestino)) {
                    flag = p.checaMovimento(linha, coluna, linhaDestino, colunaDestino);
                }
            }
            return flag;
        }
        
        /**
         * 
         * @param p peça
         * @param linha linha origen
         * @param coluna coluna origem
         * @param linhaDestino  linha destino
         * @param colunaDestino coluna destino  
         * @return se a jogada é válida ou não
         */       
	public boolean checaJogadaValida(Peca p, int linha, int coluna, int linhaDestino, int colunaDestino) {
		boolean flag = false;

		if (this.checaLimitesDoTabuleiro(linhaDestino, colunaDestino)) {
                    
                 flag = checaPecasNoCaminho( p,  linha,  coluna, linhaDestino, colunaDestino);
                 

            
            if (flag) {
                Posicao posicaoComPecaAdversaria = this.getPosicao(linhaDestino, colunaDestino);

                if (posicaoComPecaAdversaria.getOcupada()) {
                    posicaoComPecaAdversaria.getPeca().captura();
                }
    
                this.atualizaTabuleiro(linha, coluna,linhaDestino, colunaDestino);
                return true;
            } 
        } else {
            System.out.println("Coordenada fora dos limites do tabuleiro");
        }

		return flag;
	}
        
        
        /**
         * 
         * @param p peça do tabuleior
         * @param linha linha de origem
         * @param coluna  coluna de origem
         * @return se há algum movimento válido a ser feito pela peça
         */
        public boolean pecaCercada(Peca p, int linha, int coluna){
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(!(i == linha && j == coluna) && checaPecasNoCaminho(p, linha, coluna, i, j)) return false;
                }
            }
            return true;
        }
        

}