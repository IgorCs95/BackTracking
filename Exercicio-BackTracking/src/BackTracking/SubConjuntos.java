package BackTracking;

public class SubConjuntos {

	static void printSubsets(char set[]) {
		int n = set.length;

		// Run a loop for printing all 2^n subsets one by obe
		for (int i = 0; i < (1 << n); i++) {
			System.out.print(" ");

			// Imprimir subconjunto atual
			for (int j = 0; j < n; j++)

				// (1 << j) é um número com jth bit 1, então, quando nós 'e' eles com o número do subconjunto, obtemos quais números estão presentes no subconjunto e quais não estão
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
