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
public class Testes {
	public static void main(String[] args) {

		// Teste 1
		System.out.println("Teste 1");
		Rei rei = new Rei("branca");
		if (rei.desenha() == "r  ") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\\n");
		}

		// Teste 2
		System.out.println("Teste 2");
		if (rei.checaMovimento(0, 0, 1, 1) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 3
		System.out.println("Teste 3");
		if (rei.checaMovimento(7, 4, 0, 3) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 4
		System.out.println("Teste 4");
		Dama dama = new Dama("preta");
		if (dama.desenha() == "D  ") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 5
		System.out.println("Teste 5");
		if (dama.checaMovimento(0, 0, 3, 3) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 6
		System.out.println("Teste 6");
		if (dama.checaMovimento(0, 0, 3, 4) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 7
		System.out.println("Teste 7");
	    if (dama.checaMovimento(0, 0, 9, 9) == false) {
	    	System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 8
		System.out.println("Teste 8");
		Cavalo cavalo = new Cavalo("branca", "direita");
		if (cavalo.desenha() == "cd ") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 9
		System.out.println("Teste 9");
		if (cavalo.checaMovimento(0, 0, 2, 1) == true ) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 10
		System.out.println("Teste 10");
		if (cavalo.checaMovimento(0, 0, 2, -1) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 11
		System.out.println("Teste 11");
		if (cavalo.checaMovimento(0, 0, 0, 0) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 12
		System.out.println("Teste 12");
		if(cavalo.checaMovimento(0, 0, 4, 3) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 13
		System.out.println("Teste 13");
		Bispo bispo = new Bispo("preta", "direita");
		if (bispo.desenha() == "BD ") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 14
		System.out.println("Teste 14");
		if (bispo.checaMovimento(0, 0, 7, 7) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 15
		System.out.println("Teste 15");
		if (bispo.checaMovimento(0, 0, 0, 6) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 16
		System.out.println("Teste 16");
		if (bispo.checaMovimento(0, 0, 4, 7) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 17
		System.out.println("Teste 17");
		Peao peao = new Peao("branca", 4);
		if (peao.desenha().equals("p4 ")) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 18
		System.out.println("Teste 18");
		if (peao.checaMovimento(0, 0, 2, 0, true) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 19
		System.out.println("Teste 19");
		if (peao.checaMovimento(0, 0, 2, 0, false) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 20
		System.out.println("Teste 20");
		if (peao.checaMovimento(0, 0, 1, 0) == true ) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 21
		System.out.println("Teste 21");
		if (peao.checaMovimento(0, 0, 4, 0) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 22
		System.out.println("Teste 22");
		if (peao.checaMovimento(0, 0, 0, 1) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 23
		System.out.println("Teste 23");
		Torre torre = new Torre("preta", "esquerda");
		if (torre.desenha() == "TE ") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 24
		System.out.println("Teste 24");
		if (torre.checaMovimento(0, 0, 0, 1) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 25
		System.out.println("Teste 25");
		if (torre.checaMovimento(0, 0, 4, 0) == true) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 26
		System.out.println("Teste 26");
		if (torre.checaMovimento(0, 0, 4, 6) == false) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 27
		System.out.println("Teste 27");
		Jogador j1 = new Jogador("branca");
		j1.atualizarCorPecas();
		if (j1.rei.getCor() == "branca") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}
		

		// Teste 28
		System.out.println("Teste 28");
		Jogador j2 = new Jogador("preta");
		j2.atualizarCorPecas();
		if (j2.rei.getCor() == "preta") {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 29
		System.out.println("Teste 29");
		j1.definePosicaoInicial();
		if (j1.rei.getLinha() == 0 && j1.rei.getColuna() == 4) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}

		// Teste 30
		System.out.println("Teste 30");
		j2.definePosicaoInicial();
		if (j2.rei.getLinha() == 7 && j2.rei.getColuna() == 4) {
			System.out.println("Pass!\n");
		} else {
			System.out.println("Fail!!!!!\n");
		}


		// Teste 31
		System.out.println("Teste 31");
		Tabuleiro tabuleiro = new Tabuleiro(j1, j2);
		tabuleiro.printTabuleiro();

		// Teste 32
		System.out.println("Teste 32");
		tabuleiro.atualizaTabuleiro(0, 0);
		tabuleiro.atualizaTabuleiro(0, 3);
		tabuleiro.atualizaTabuleiro(0, 4);
		tabuleiro.atualizaTabuleiro(0, 7);
		tabuleiro.atualizaTabuleiro(1, 0);
		tabuleiro.atualizaTabuleiro(1, 2);
		tabuleiro.atualizaTabuleiro(1, 3);
		tabuleiro.atualizaTabuleiro(1, 7);
		tabuleiro.atualizaTabuleiro(7, 0);
		tabuleiro.atualizaTabuleiro(7, 5);
		tabuleiro.atualizaTabuleiro(7, 7);
		tabuleiro.atualizaTabuleiro(6, 3);
		tabuleiro.atualizaTabuleiro(6, 4);
		tabuleiro.atualizaTabuleiro(6, 6);
		tabuleiro.printTabuleiro();

		// Teste 33
		System.out.println("Teste 33");
		Rei outroRei = new Rei("branca");
		outroRei.definePosicaoInicial();
		System.out.printf("Rei branco - %d %d\n", outroRei.getLinha(), outroRei.getColuna());
		outroRei.setCor("preta");
		outroRei.definePosicaoInicial();
		System.out.printf("Rei Preto - %d %d\n", outroRei.getLinha(), outroRei.getColuna());

		// Teste 34
		System.out.println("Teste 34");
		Dama outraDama = new Dama("branca");
		outraDama.definePosicaoInicial();
		System.out.printf("Dama branca - %d %d\n", outraDama.getLinha(), outraDama.getColuna());
		outraDama.setCor("preta");
		outraDama.definePosicaoInicial();
		System.out.printf("Dama preta - %d %d\n", outraDama.getLinha(), outraDama.getColuna());

		// Teste 35
		System.out.println("Teste 35");
		Cavalo outroCavalo = new Cavalo("branca", "esquerda");
		outroCavalo.definePosicaoInicial();
		System.out.printf("Cavalo branco esquerdo - %d %d\n", outroCavalo.getLinha(), outroCavalo.getColuna());

		outroCavalo.setLado("direita");
		outroCavalo.definePosicaoInicial();
		System.out.printf("Cavalo branco direito - %d %d\n", outroCavalo.getLinha(), outroCavalo.getColuna());

		outroCavalo.setCor("preta");
		outroCavalo.definePosicaoInicial();
		System.out.printf("Cavalo preto direito - %d %d\n", outroCavalo.getLinha(), outroCavalo.getColuna());

		outroCavalo.setLado("esquerda");
		outroCavalo.definePosicaoInicial();
		System.out.printf("Cavalo preto esquerdo - %d %d\n", outroCavalo.getLinha(), outroCavalo.getColuna());

		// Teste 36
		System.out.println("Teste 36");
		Bispo outroBispo = new Bispo("branca", "esquerda");
		outroBispo.definePosicaoInicial();
		System.out.printf("Bispo branco esquerdo - %d %d\n", outroBispo.getLinha(), outroBispo.getColuna());

		outroBispo.setLado("direita");
		outroBispo.definePosicaoInicial();
		System.out.printf("Bispo branco direito - %d %d\n", outroBispo.getLinha(), outroBispo.getColuna());

		outroBispo.setCor("preta");
		outroBispo.definePosicaoInicial();
		System.out.printf("Bispo preto direito - %d %d\n", outroBispo.getLinha(), outroBispo.getColuna());

		outroBispo.setLado("esquerda");
		outroBispo.definePosicaoInicial();
		System.out.printf("Bispo preto esquerdo - %d %d\n", outroBispo.getLinha(), outroBispo.getColuna());

		// Teste 37
		System.out.println("Teste 37");
		Torre outraTorre = new Torre("branca", "esquerda");
		outraTorre.definePosicaoInicial();
		System.out.printf("Torre branca esquerda - %d %d\n", outraTorre.getLinha(), outraTorre.getColuna());

		outraTorre.setLado("direita");
		outraTorre.definePosicaoInicial();
		System.out.printf("Torre branca direita - %d %d\n", outraTorre.getLinha(), outraTorre.getColuna());

		outraTorre.setCor("preta");
		outraTorre.definePosicaoInicial();
		System.out.printf("Torre preta direita - %d %d\n", outraTorre.getLinha(), outraTorre.getColuna());

		outraTorre.setLado("esquerda");
		outraTorre.definePosicaoInicial();
		System.out.printf("Torre preta esquerda - %d %d\n", outraTorre.getLinha(), outraTorre.getColuna());

		// Teste 38
		System.out.println("Teste 38");
		Peao outroPeao = new Peao("branca", 5);
		outroPeao.definePosicaoInicial();
		System.out.printf("5º peao branco - %d %d\n", outroPeao.getLinha(), outroPeao.getColuna());
		outroPeao.setCor("preta");
		outroPeao.definePosicaoInicial();
		System.out.printf("5º peao Preto - %d %d\n", outroPeao.getLinha(), outroPeao.getColuna());

		Jogo jogo = new Jogo();
		jogo.iniciarJogo();

	}
}
