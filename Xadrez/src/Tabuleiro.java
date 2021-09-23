/**
 * Ainda não comecei a classe posição, bastante coisa daqui vai migrar pra lá.
 * 
 * Utilizei int para as colunas por facilitar o calculo das posições, mas provavelmente o input 
 * do usuario vai ser um char, a gente pode usar um enum para transformar o char em int.
 */
public class Tabuleiro {
    private String tabuleiro[][];
    
    Dama db = new Dama("branca");
    Dama dp = new Dama("preta");
    Rei rb = new Rei("branca");
    Rei rp = new Rei("preta");
    Cavalo cbe = new Cavalo("branca", "esquerda");
    Cavalo cpe = new Cavalo("preta", "esquerda");
    Cavalo cbd = new Cavalo("branca", "direita");
    Cavalo cpd = new Cavalo("preta", "direita");

    //Construtor
    public Tabuleiro() {
        tabuleiro = new String[64][64];
        inicializaTabuleiro();
    }

    public void atualizaTabuleiro() {

    }

    
    private void inicializaTabuleiro() {
        criaTabuleiro();

        posicionaPecasParaInicioDoJogo();
    }


    private void posicionaPecasParaInicioDoJogo() {
        //dama
        colocaPecaNoTabuleiro(db);
        colocaPecaNoTabuleiro(dp);
        //rei
        colocaPecaNoTabuleiro(rb);
        colocaPecaNoTabuleiro(rp);
        //cavalo
        colocaPecaNoTabuleiro(cpe);
        colocaPecaNoTabuleiro(cbe);
        colocaPecaNoTabuleiro(cpd);
        colocaPecaNoTabuleiro(cbd);
        /**
         * Adicionar outras peças aqui conforme for criando,
         * 1 chamadas para cada peça
         */
    }
    
    
    public void colocaPecaNoTabuleiro(Dama p) {
        if(p.isCapturada() == false) {
            tabuleiro[p.getLinha()][p.getColuna()] = p.desenha();
        }
    }
    public void colocaPecaNoTabuleiro(Rei p) {
        if(p.isCapturada() == false) {
            tabuleiro[p.getLinha()][p.getColuna()] = p.desenha();
        }
    }
    public void colocaPecaNoTabuleiro(Cavalo p) {
        if(p.isCapturada() == false) {
            tabuleiro[p.getLinha()][p.getColuna()] = p.desenha();
        }
    }
    

    private void criaTabuleiro() {
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tabuleiro[i][j] = defineCorDaCasa(i, j);
            }
        }
    }

    private String defineCorDaCasa(int i, int j) {
        if ((i % 2 == 0) && (j % 2 == 0)) { //se os dois forem pares
            return casaBranca();
        } else if ((i % 2 == 1) && (j % 2 == 1)) { //se os dois fore impares
            return casaBranca();
        } else { //se forem diferentes
            return casaPreta();
        }
    }

    
    public void printTabuleiro() {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(tabuleiro[i][j]);
                count++;
                if (count == 8) {
                    System.out.printf("\n");
                    count = 0;
                }
            }
        }
    }
    
    public String casaBranca() {
        return "⬜";
    }
    private String casaPreta() {
        return "⬛";
    }
}
