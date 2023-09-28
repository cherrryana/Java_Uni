import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] m1 = {-8, -7, -6, -5, -4, -3};
        int[] m2 = {6, 7, 8, 9, 10};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}};

        System.out.println(firstTask("abababaqwertyuiopasdfghjkl"));
        System.out.println(Arrays.toString(secondTask(m1, m2)));
        System.out.println(thirdTask(m1));
        printMatrix(fourthTask(matrix));
        System.out.println(Arrays.toString(fifthTask(m1,-11)));
        System.out.println(sixthTask(matrix));
        System.out.println(Arrays.toString(seventhTask(matrix)));
        printMatrix(eighthTask(matrix));
    }

    public static String firstTask(String str) {
        System.out.println("Первая задача, итоговая строка: ");

        int maxLen = 0, maxI = 0, maxJ = 0;
        int [] symbolsFreq = new int [2000];     // массив частот появления символов

        while (maxJ < str.length()) {
            symbolsFreq[str.charAt(maxJ)]++;    // при встрече с символом ++ к его частоте

            while (symbolsFreq[str.charAt(maxJ)] > 1) {
                symbolsFreq[str.charAt(maxI)]--;    // смещаем, пока частота символа не будет = 1
                maxI++;
            }
            maxLen = Math.max(maxLen, maxJ - maxI + 1);
            maxJ++;
            }

        return(str.substring(maxI, maxJ));
    }

    public static int[] secondTask(int[] mas1, int[] mas2){
        System.out.println("\nВторая задача, итоговый массив: ");

        int[] resultMas = Arrays.copyOf(mas1, mas1.length + mas2.length);
        System.arraycopy(mas2, 0, resultMas, mas1.length, mas2.length);

        return resultMas;
    }

    public static int thirdTask(int[] m){
        System.out.println("\nТретья задача, максимальная сумма подмассива: ");

       int maxSum = Integer.MIN_VALUE;  // для возможности обрабатывать отрицательные числа
       int curMax = 0;

       for (int elem : m) {
           curMax = Math.max(curMax + elem, elem);  // переходим на другой подмассив,
           // если elem > curMax + elem
           maxSum = Math.max(maxSum, curMax);
       }

       return maxSum;
    }

    public static int[][] fourthTask(int[][] m){
        System.out.println("\nЧетвертая задача, итоговая матрица: ");
        int [][] resultMatrix = new int[m[0].length][m.length];

        for (int i = 0; i < resultMatrix.length; i++){
            for (int j = 0; j < resultMatrix[0].length; j++){
                resultMatrix[i][j] = m[j][i];
            }
        }

        return resultMatrix;
    }

    public static int[] fifthTask(int[] m, int target){
        System.out.println("\nПятая задача, итоговый массив: ");

        int[] result = new int[2];
        int flag = 0;

        for (int i = 0; i < m.length - 1; i++){
            if (m[i] + m[i + 1] == target){
                result[0] = m[i];
                result[1] = m[i + 1];
                flag++;
                break;
            }
        }

        if (flag == 0)
            return null;
        return result;
    }

    public static int sixthTask(int[][] m){
        System.out.println("\nШестая задача, итоговая сумма: ");
        int sum  = 0;

        for (int[] row : m){
            for (int elem : row)
                sum += elem;
            }
        return sum;
    }

    public static int[] seventhTask(int[][] m){
        System.out.println("\nСедьмая задача, итоговый массив: ");
        int[] maxElem = new int[m.length];

        for (int row = 0; row < m.length; row++){
            for (int col = 0; col < m[row].length - 1; col++)
                maxElem[row] = Math.max(m[row][col], m[row][col + 1]);
        }

        return maxElem;
    }

    public static int[][] eighthTask(int[][] m){
        System.out.println("\nВосьмая задача, итоговая матрица: ");
        int [][] resultMatrix = new int[m[0].length][m.length];

        for (int i = 0; i < resultMatrix.length; i++){
            for (int j = 0; j < resultMatrix[0].length; j++){
                resultMatrix[i][j] = m[j][resultMatrix.length - i - 1];
            }
        }

        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix){
        for (int[] row : matrix) {
            System.out.print("\n");
            for (int elem : row) {
                System.out.print(elem + " ");
            }
        }

        System.out.print("\n");
    }
}