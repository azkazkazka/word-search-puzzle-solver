import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;


public class WordSearch{
    public static String getLetter(ArrayList<char[]> words, int row, int col){
        return Character.toString(words.get(row)[col]);
    }
    public static void printWords(ArrayList<char[]> words){
        for (int i = 0; i < words.size(); i++){
            System.out.println(words.get(i));
        }
    }
    public static void printMatrix(String[][] matrix, ArrayList<String> toPrint, int comparison){
        int matrixRow = matrix.length, matrixCol = matrix[0].length;
        for (int m = 0; m < matrixRow; m++){
            for (int n = 0; n < matrixCol; n++){
                String temp = String.valueOf(m) + "," + String.valueOf(n);
                if (toPrint.contains(temp)){
                    System.out.print(matrix[m][n]);
                }
                else{
                    System.out.print("-");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("Total Comparison: " + comparison);
        System.out.println();
    }

    public static void searchUp(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = matrixCol - 1; j >= 0; j--){
                for (int k = matrixRow - 1; k >= 0; k--){
                    comparison++;
                    if (matrix[k][j].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(k) + "," + String.valueOf(j);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[k][j].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(j) + "," + String.valueOf(k);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        j = -1;
                        k = -1;
                        toDelete.add(i);
                    }
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchDown(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = 0; j < matrixCol; j++){
                for (int k = 0; k < matrixRow; k++){
                    comparison++;
                    if (matrix[k][j].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(k) + "," + String.valueOf(j);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[k][j].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(k) + "," + String.valueOf(j);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        j = matrixCol;
                        k = matrixRow;
                        toDelete.add(i);
                    }
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchLeft(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = matrixRow - 1; j >= 0; j--){
                for (int k = matrixCol - 1; k >= 0; k--){
                    comparison++;
                    if (matrix[j][k].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(j) + "," + String.valueOf(k);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[j][k].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(j) + "," + String.valueOf(k);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        j = -1;
                        k = -1;
                        toDelete.add(i);
                    }
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchRight(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = 0; j < matrixRow; j++){
                for (int k = 0; k < matrixCol; k++){
                    comparison++;
                    if (matrix[j][k].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(j) + "," + String.valueOf(k);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[j][k].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(j) + "," + String.valueOf(k);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        j = matrixRow;
                        k = matrixCol;
                        toDelete.add(i);
                    }
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    
    public static void searchDiagUpLeft(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = 0; j < matrixCol; j++){
                int row = matrixRow - 1;
                int col = j;
                while (col >= 0 && row >= 0){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = matrixCol;
                        break;
                    }
                    row--;
                    col--;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
            for (int j = 0; j < matrixRow - 1; j++){
                int col = matrixCol - 1;
                int row = j;
                while (col >= 0 && row >= 0){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = matrixCol;
                        break;
                    }
                    row--;
                    col--;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchDiagUpRight(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = matrixCol - 1; j >= 0; j--){
                int row = matrixRow - 1;
                int col = j;
                while (col < matrixCol && row >= 0){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = -1;
                        break;
                    }
                    row--;
                    col++;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
            for (int j = matrixRow - 2; j >= 0; j--){
                int col = 0;
                int row = j;
                while (col < matrixCol && row >= 0){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = -1;
                        break;
                    }
                    row--;
                    col++;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchDiagDownLeft(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = matrixRow - 1; j >= 0; j--){
                int col = matrixCol - 1;
                int row = j;
                while (col >= 0 && row < matrixRow){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = -1;
                        break;
                    }
                    row++;
                    col--;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
            for (int j = matrixCol - 2; j >= 0; j--){
                int row = 0;
                int col = j;
                while (col >= 0 && row < matrixRow){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = -1;
                        break;
                    }
                    row++;
                    col--;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void searchDiagDownRight(String[][] matrix, ArrayList<char[]> words){
        ArrayList<Integer> toDelete = new ArrayList<>();
        ArrayList<String> toPrint = new ArrayList<String>();
        int matrixRow = matrix.length, matrixCol = matrix[0].length, comparison = 0;
        for (int i = 0; i < words.size(); i++){
            int wordCheck = 0;
            boolean diff = true;
            for (int j = matrixCol - 1; j >= 0; j--){
                int row = 0;
                int col = j;
                while (col < matrixCol && row < matrixRow){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = -1;
                        break;
                    }
                    row++;
                    col++;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
            for (int j = matrixRow - 1; j > 0; j--){
                int col = 0;
                int row = j;
                while (col < matrixCol && row < matrixRow){
                    comparison++;
                    if (matrix[row][col].equals(getLetter(words, i, wordCheck))){
                        if (diff == true){
                            diff = false;
                        }
                        String temp = String.valueOf(row) + "," + String.valueOf(col);
                        toPrint.add(temp);
                        wordCheck++;
                    }
                    else{
                        if (diff == false){
                            diff = true;
                            wordCheck = 0;
                            toPrint.clear();
                            comparison++;
                            if (matrix[row][col].equals(getLetter(words, i, 0))){
                                diff = false;
                                String temp = String.valueOf(row) + "," + String.valueOf(col);
                                toPrint.add(temp);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        printMatrix(matrix, toPrint, comparison);
                        toDelete.add(i);
                        j = 0;
                        break;
                    }
                    row++;
                    col++;
                }
                wordCheck = 0;
                diff = true;
                toPrint.clear();
            }
        }
        for (int i = toDelete.size() - 1; i >= 0; i--){
            words.remove((toDelete.get(i)).intValue());
        }
        return;
    }
    public static void main(String[] args){
        System.out.println("\n---------------------\nWORD SEARCH PUZZLE SOLVER\n---------------------");
        System.out.print("Enter Filename\n<filename>.txt: ");
        Scanner sc = new Scanner(System.in);
        String filename = "../test/" + sc.nextLine();
        sc.close();
        try{
            ArrayList<ArrayList<String>> tempMatrix = new ArrayList<ArrayList<String>>();
            ArrayList<char[]> words = new ArrayList<char[]>();
            boolean isWord = false;
            
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String rl = br.readLine();
            while (rl != null){
                if (rl.length() == 0){
                    isWord = true;
                }
                else{
                    String[] rls = rl.split(" ");
                    if (isWord == false){
                        ArrayList<String> temp = new ArrayList<String>();
                        for (String x : rls){
                            temp.add(x);
                        }
                        tempMatrix.add(temp);
                    }
                    else{
                        String all = "";
                        for (String x : rls){
                            all += x;
                        }
                        char[] ch = all.toCharArray();
                        words.add(ch);
                    }
                }
                rl = br.readLine();
            }
            br.close();
            String[][] matrix = tempMatrix.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
            int searchWords = words.size();
            long startTime = System.nanoTime();
            searchUp(matrix, words);
            searchDown(matrix, words);
            searchLeft(matrix, words);
            searchRight(matrix, words);
            searchDiagUpLeft(matrix, words);
            searchDiagUpRight(matrix, words);
            searchDiagDownLeft(matrix, words);
            searchDiagDownRight(matrix, words);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            double elapsedTimeInSecond = (double) totalTime / 1_000_000_000;
            System.out.println("Matrix size: " + matrix.length + " x " + matrix[0].length);
            System.out.println("Elapsed Time: " + elapsedTimeInSecond + " second(s)");
            if (words.size() == 0){
                System.out.println("\nWords left: 0/" + searchWords);
                System.out.println("All words were found during the process");
            }
            else{
                System.out.println("\nWords left: " + words.size() + "/" + searchWords);
                printWords(words);
            }
        }
        catch(Exception ie){
            System.out.println("gasabi");
        }
    }
}
