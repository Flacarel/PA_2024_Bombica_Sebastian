public class bonus {
    void bonus(int n) {
        if (n < 4) {
            System.out.println("Graful trebuie sa contina minim 4 noduri");
            return;
        }
        int[][] adjacencyMatrix = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            adjacencyMatrix[i][i + 1] = 1;
            adjacencyMatrix[i + 1][i] = 1;
        }
        adjacencyMatrix[0][n - 2] = 1;
        adjacencyMatrix[n - 2][0] = 1;
        for (int i = 0; i < n - 1; i++) {
            adjacencyMatrix[i][n - 1] = 1;
            adjacencyMatrix[n - 1][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        int cycleNumber = 0;
        for (int i = 3; i <= n; i++) {
            System.out.println("Cicluri cu " + i + " noduri:");
            if (i == n - 1) {
                StringBuilder cycle = new StringBuilder();
                for (int j = 0; j <= n - 2; j++) {
                    cycle.append(j);
                    cycle.append(" ");
                }
                cycle.append(0);
                System.out.println(cycle);
                cycleNumber++;
            }
            for (int j = 0; j < n - 1; j++) {
                cycleNumber++;
                StringBuilder cycle = new StringBuilder();
                cycle.append(n - 1);
                cycle.append(" ");
                cycle.append(j);
                cycle.append(" ");
                for (int l = 1; l < i - 1; l++) {
                    cycle.append((j + l) % (n - 1));
                    cycle.append(" ");
                }
                cycle.append(n - 1);
                System.out.println(cycle);
            }
        }
        if (cycleNumber == n * n - 3 * n + 3) {
            System.out.println("Numarul de cicluri: " + cycleNumber);
        }
    }

    public static void main(String[] args) {
        bonus x = new bonus();
        x.bonus(5);
    }
}

