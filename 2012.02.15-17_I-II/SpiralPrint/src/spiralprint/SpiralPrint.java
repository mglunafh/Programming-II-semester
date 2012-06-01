/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package spiralprint;

/**
 *
 * @author Fedor Uvarychev
 */
public class SpiralPrint {

    public static String spiralPrint(int[][] matrix) {
        int size = matrix.length;
        int currentColumn = size / 2;
        int currentLine = size / 2;
        String result = matrix[currentLine][currentColumn] + " ";

        for (int i = 1; i < size; i++) {
            int sign = ((i % 2) == 0) ? -1 : 1;
            for (int j = 1; j <= i; j++) {
                result += matrix[currentLine + sign * j][currentColumn] + " ";
            }
            currentLine += sign * i;
            for (int j = 1; j <= i; j++) {
                result += matrix[currentLine][currentColumn + sign * j] + " ";
            }
            currentColumn += sign * i;
        }
        for (int i = 1; i < size; i++) {
            result += matrix[i][0]+ " ";
        }

        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        };
        System.out.println(SpiralPrint.spiralPrint(matrix));
    }
}
