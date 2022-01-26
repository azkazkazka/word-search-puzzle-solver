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
    public static void updateProgress(ArrayList<String> toPrint, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison, 
                                    ArrayList<Integer> toDelete, int i, int comparison){
        ArrayList<String> temp = new ArrayList<>(toPrint);
        finalPrint.add(temp);
        finalComparison.add(comparison);
        toDelete.add(i);
    }
    public static void addCoordinate(ArrayList<String> toPrint, int x, int y){
        String temp = String.valueOf(x) + "," + String.valueOf(y);
        toPrint.add(temp);
    }
    public static void printMatrix(String[][] matrix, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
        int matrixRow = matrix.length, matrixCol = matrix[0].length;
        int i = 0, tot = 0;
        for (ArrayList<String> toPrint : finalPrint){
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
            System.out.println("Total Comparison: " + (finalComparison.get(i)).intValue());
            tot += (finalComparison.get(i)).intValue();
            System.out.println();
            i++;
        }
        System.out.println("Total Comparison of All Words: " + tot);
    }

    public static void searchUp(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, k, j);
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
                                addCoordinate(toPrint, k, j);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
                        j = -1;
                        k = -1;
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
    public static void searchDown(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, k, j);
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
                                addCoordinate(toPrint, k, j);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
                        j = matrixCol;
                        k = matrixRow;
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
    public static void searchLeft(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, j, k);
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
                                addCoordinate(toPrint, j, k);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
                        j = -1;
                        k = -1;
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
    public static void searchRight(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, j, k);
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
                                addCoordinate(toPrint, j, k);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
                        j = matrixRow;
                        k = matrixCol;
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
    
    public static void searchDiagUpLeft(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
    public static void searchDiagUpRight(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
    public static void searchDiagDownLeft(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
    public static void searchDiagDownRight(String[][] matrix, ArrayList<char[]> words, ArrayList<ArrayList<String>> finalPrint, ArrayList<Integer> finalComparison){
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
                        addCoordinate(toPrint, row, col);
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
                                addCoordinate(toPrint, row, col);
                                wordCheck++;
                            }
                        }
                    }
                    if (wordCheck == words.get(i).length){
                        updateProgress(toPrint, finalPrint, finalComparison, toDelete, i, comparison);
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
            ArrayList<ArrayList<String>> finalPrint = new ArrayList<ArrayList<String>>();
            ArrayList<Integer> finalComparison = new ArrayList<Integer>();
            int searchWords = words.size();
            long startTime = System.nanoTime();
            searchUp(matrix, words, finalPrint, finalComparison);
            searchDown(matrix, words, finalPrint, finalComparison);
            searchLeft(matrix, words, finalPrint, finalComparison);
            searchRight(matrix, words, finalPrint, finalComparison);
            searchDiagUpLeft(matrix, words, finalPrint, finalComparison);
            searchDiagUpRight(matrix, words, finalPrint, finalComparison);
            searchDiagDownLeft(matrix, words, finalPrint, finalComparison);
            searchDiagDownRight(matrix, words, finalPrint, finalComparison);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            double elapsedTimeInSecond = (double) totalTime / 1_000_000_000;
            printMatrix(matrix, finalPrint, finalComparison);
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
