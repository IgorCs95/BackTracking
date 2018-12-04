package BackTracking;

public class NRainhas {

	/*
	 * Programa Java para resolver N Queen Problem usando backtracking
	 */

	final int N = 8;

	/* Uma fun��o de utilidade para imprimir a solu��o */
	void printSolution(int tabuleiro[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + tabuleiro[i][j] + " ");
			System.out.println();
		}
	}

	/*
	 * Uma fun��o de utilidade para verificar se uma rainha pode ser colocada a
	 * bordo [linha] [col]. Note que esta fun��o � chamada quando rainhas "col" j�
	 * s�o colocadas em colunas de 0 a col -1. Ent�o, precisamos verificar apenas o
	 * lado esquerdo para atacar rainhas
	 */
	boolean isSafe(int tabuleiro[][], int linha, int coluna) {
		int i, j;

		/* Verifique esta linha no lado esquerdo */
		for (i = 0; i < coluna; i++)
			if (tabuleiro[linha][i] == 1)
				return false;

		/* Verifique a diagonal superior no lado esquerdo */
		for (i = linha, j = coluna; i >= 0 && j >= 0; i--, j--)
			if (tabuleiro[i][j] == 1)
				return false;

		/* Verifique a diagonal inferior no lado esquerdo */
		for (i = linha, j = coluna; j >= 0 && i < N; i++, j--)
			if (tabuleiro[i][j] == 1)
				return false;

		return true;
	}

	/*
	 * Uma fun��o de utilidade recursiva para resolver o problema N Queen
	 */
	boolean solveNQUtil(int tabuleiro[][], int colunas) {
		/*
		 * caso base: Se todas as rainhas forem colocadas, retorne true
		 */
		if (colunas >= N)
			return true;

		/*
		 * Considere esta coluna e tente colocar essa rainha em todas as linhas uma por
		 * uma
		 */
		for (int i = 0; i < N; i++) {
			/*
			 * Verifique se a rainha pode ser colocada a bordo [i] [col]
			 */
			if (isSafe(tabuleiro, i, colunas)) {
				/* Coloque essa rainha no quadro [i] [col] */
				tabuleiro[i][colunas] = 1;

				/* recorrer para colocar resto das rainhas */
				if (solveNQUtil(tabuleiro, colunas + 1) == true)
					return true;

				/*
				 * Se colocar a rainha no tabuleiro [i] [col] n�o levar a uma solu��o, remova a
				 * rainha do tabuleiro [i] [col]
				 */
				tabuleiro[i][colunas] = 0; // BACKTRACK
			}
		}

		/*
		 * Se a rainha n�o pode ser colocada em qualquer linha nesta coluna, ent�o
		 * retorne falso
		 */
		return false;
	}

	/*
	 * Esta fun��o resolve o problema N Queen usando Backtracking. Ele usa
	 * principalmente solveNQUtil () para resolver o problema. Ele retorna false se
	 * rainhas n�o puderem ser colocadas, caso contr�rio, retornar� true e imprime o
	 * posicionamento de rainhas na forma de 1s. Por favor, note que pode haver mais
	 * de uma solu��o, esta fun��o imprime uma das solu��es vi�veis.
	 */
	boolean solveNQ() {
		int tabuleiro[][] = { 
				
				{ 0, 0, 0, 0, 0, 0, 0, 0}, 
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				{ 0, 0, 0, 0, 0, 0, 0, 0},
				
		};

		if (solveNQUtil(tabuleiro, 0) == false) {
			System.out.print("Soluc��o nao existe");
			return false;
		}

		printSolution(tabuleiro);
		return true;
	}

	// programa de driver para testar a fun��o acima
	public static void main(String args[]) {
		NRainhas Queen = new NRainhas();
		Queen.solveNQ();
	}

	

}
