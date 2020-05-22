package Lab1;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int matrix[][] = optional(args);
        bonus(matrix);
    }

    public static int[][] optional(String args[]) {
        long nanoStart = System.nanoTime();

        if (args.length < 3) {
            System.out.println("You need a number, number, and latters");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
        int m = args.length - 2;
        char alphabet[] = new char[m];

        for (int i = 0; i < m; i++) {
            alphabet[i] = args[i + 2].charAt(0);
        }

        String words[] = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < k; j++) {
                int r = (int) (Math.random() * m);

                sb.append(alphabet[r]);
            }

            words[i] = sb.toString();


        }

        int matrix[][] = new int[n][n];
        int neighbours[] = new int[n];
        int maxNeighbours = 0;
        int minNeighbours = n;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Boolean> hm = new HashMap<Character, Boolean>();
            int count = 0;

            for (int x = 0; x < k; x++) {
                hm.put(words[i].charAt(x), true);
            }

            for (int j = i + 1; j < n; j++) {
                for (int x = 0; x < k; x++) {
                    if (hm.containsKey(words[j].charAt(x)) == true) {
                        matrix[i][j] = 1;
                        matrix[j][i] = 1;
                        break;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) count++;
                if (n <= 30_000) System.out.print(matrix[i][j] == 1 ? 1 : 0);
            }
            System.out.println();

            neighbours[i] = count;

            if (count > maxNeighbours) maxNeighbours = count;
            if (count < minNeighbours) minNeighbours = count;
        }



        if (n > 30_000) {
            long nanoEnd = System.nanoTime();

            System.out.println("Running time: " + (nanoEnd - nanoStart) + " nanoseconds");
        }

        return matrix;
    }

    public static void dfs(int node, int matrix[][], boolean visited[]) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i] && matrix[i][node] == 1) {
                dfs(i, matrix, visited);
            }
        }
    }

    public static void bonus(int matrix[][]) {
        int n = matrix.length;
        boolean visited[] = new boolean[n];
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                components++;


                dfs(i, matrix, visited);
                System.out.println();
            }
        }

        if( components == 1)
            System.out.println("It is connected");
        else System.out.println("It is not connected");
    }
}
