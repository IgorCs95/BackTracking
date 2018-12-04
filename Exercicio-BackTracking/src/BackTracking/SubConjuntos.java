package BackTracking;

public class SubConjuntos {

	static void printSubsets(char set[]) {
		int n = set.length;

		// Run a loop for printing all 2^n subsets one by obe
		for (int i = 0; i < (1 << n); i++) {
			System.out.print(" ");

			// Imprimir subconjunto atual
			for (int j = 0; j < n; j++)

				// (1 << j) � um n�mero com jth bit 1, ent�o, quando n�s 'e' eles com o n�mero do subconjunto, obtemos quais n�meros est�o presentes no subconjunto e quais n�o est�o
				if ((i & (1 << j)) > 0)
					System.out.print(set[j] + " ");

			System.out.println(" ");
		}
	}

	// Driver code
	public static void main(String[] args) {
		char set[] = { '1', '2', '3' };
		printSubsets(set);
	}

}
