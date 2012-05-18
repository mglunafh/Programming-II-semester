/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixsort;

/**
 *
 * @author Fedor Uvarychev
 */
public class MatrixSort {

    /**
     * Compares two columns in matrix in lexicographical order.
     *
     * @param matrix
     * @param firstInd
     * @param secInd
     * @return true, if column 'firstInd' less than 'secInd', and false
     * otherwise.
     */
    public static boolean less(int[][] matrix, int firstInd, int secInd) {

        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][firstInd] < matrix[i][secInd]) {
                return true;
            } 
            if (matrix[i][firstInd] > matrix[i][secInd]) {
                return false;
            }
        }
        return false;
    }

    /**
     * Swaps two arrays. Sizes of array must equal.
     *
     * @param secInd
     */
    public static void swap(int[][] matrix, int firstInd, int secInd) {
        for (int i = 0; i < matrix.length; ++i) {
            int temp = matrix[i][firstInd];
            matrix[i][firstInd] = matrix[i][secInd];
            matrix[i][secInd] = temp;
        }


    }

    public static void sort(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; ++i) {
            int minIndex = i;
            for (int j = i; j < matrix[0].length; ++j) {
                if (MatrixSort.less(matrix, j, minIndex)) {
                    minIndex = j;
                }
            }
            MatrixSort.swap(matrix, i, minIndex);
        }
    }

    public static String print(int[][] matrix) {
        String result = "";
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                result += matrix[i][j] + " ";
            }
            result += '\n';
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] m = {{6, 5, 4, 3}, {1, 2, 3, 4}, {2, 1, 0, 1}};
        String res = MatrixSort.print(m);
        System.out.println(res);

        MatrixSort.sort(m);
        res = MatrixSort.print(m);
        System.out.println(res);
        System.out.println(MatrixSort.less(m, 0, 1));
    }
}
