import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void insertionSort(double[] A) {
        for (int j = 1; j < A.length; j++) {
            double key = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > key) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = key;
        }
    }

    public static void merge(double[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        double[] L = new double[n1];
        double[] R = new double[n2];
        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }
        int i = 0;
        int j = 0;
        int k = p;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(double[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void mergeSort(double[] A) {
        mergeSort(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        String fileName = "output.txt"; // Specify the file name or path

        try {
            // Create a FileWriter object with the file name
            FileWriter fileWriter = new FileWriter(fileName,true);

            // Create a BufferedWriter object using the FileWriter
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);





        int hugeSize = 500000;
        int smallSize = 30;
        double[] hugeTemplateTable = new double[hugeSize];
        double[] smallTemplateTable = new double[smallSize];




        //wypełnianie tablic-templatek
        Random random = new Random();
        for (int i = 0; i < hugeTemplateTable.length; i++) {
            double n = random.nextDouble() * 1000;
            n = Math.round(n);
            hugeTemplateTable[i] = n;
        }
        double[] hugePartiallySortedTemplateTable = hugeTemplateTable.clone();

        for (int i = 0; i < smallTemplateTable.length; i++) {
            double n = random.nextDouble() * 1000;
            n = Math.round(n);
            smallTemplateTable[i] = n;
        }
        double[] smallPartiallySortedTemplateTable = smallTemplateTable.clone();


        //tworzenie częściowo posortowanych tablic templatek
        Arrays.sort(hugePartiallySortedTemplateTable, 0, hugeSize/2);
        Arrays.sort(smallPartiallySortedTemplateTable, 0, smallSize/2);


        double[] hugeInsertionSortTable = hugeTemplateTable.clone();
        double[] smallInsertionSortTable = smallTemplateTable.clone();
        double[] hugeMergeSortTable = hugeTemplateTable.clone();
        double[] smallMergeSortTable = smallTemplateTable.clone();

        double[] hugePartiallySortedInsertionSortTable = hugePartiallySortedTemplateTable.clone();
        double[] smallPartiallySortedInsertionSortTable = smallPartiallySortedTemplateTable.clone();
        double[] hugePartiallySortedMergeSortTable = hugePartiallySortedTemplateTable.clone();
        double[] smallPartiallySortedMergeSortTable = smallPartiallySortedTemplateTable.clone();


//        System.out.println("przed sortowaniem");
//        System.out.println(Arrays.toString(smallTemplateTable));
//        System.out.println("czesciow posortowane: ");
//        System.out.println(Arrays.toString(smallPartiallySortedTemplateTable));

//        System.out.println("Przed insertion sortem dla dużej tablicy:");
//        System.out.println(Arrays.toString(hugeInsertionSortTable));
        long startTime = System.nanoTime();
        insertionSort(hugeInsertionSortTable);
        long endTime = System.nanoTime();
        System.out.println("Po insertion sorcie dla dużej nieposortowanej tablicy:");
            bufferedWriter.append("--------------------------NOWA PRÓBA--------------------------");
            bufferedWriter.newLine();
            bufferedWriter.append("Po insertion sorcie dla dużej nieposortowanej tablicy:");
            bufferedWriter.newLine(); // Write a new line
//        System.out.println(Arrays.toString(hugeInsertionSortTable));
        long timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.newLine();

        startTime = System.nanoTime();
        insertionSort(hugePartiallySortedInsertionSortTable);
        endTime = System.nanoTime();
        System.out.println("Po insertion sorcie dla dużej czesciowo posortowanej tablicy:");
            bufferedWriter.append("Po insertion sorcie dla dużej czesciowo posortowanej tablicy:");
            bufferedWriter.newLine();
        //System.out.println(Arrays.toString(hugeInsertionSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.newLine();


//        System.out.println("Przed insertion sortem dla małej tablicy:");
//        System.out.println(Arrays.toString(smallInsertionSortTable));
        startTime = System.nanoTime();
        insertionSort(smallInsertionSortTable);
        endTime = System.nanoTime();
        System.out.println("Po insertion sorcie dla małej nieposortowanej tablicy:");
            bufferedWriter.append("Po insertion sorcie dla małej nieposortowanej tablicy:");
            bufferedWriter.newLine();
//        System.out.println(Arrays.toString(smallInsertionSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.write("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");


        startTime = System.nanoTime();
        insertionSort(smallPartiallySortedInsertionSortTable);
        endTime = System.nanoTime();
        System.out.println("Po insertion sorcie dla małej częściowo posortowanej tablicy:");

            bufferedWriter.newLine();
        bufferedWriter.append("Po insertion sorcie dla małej częściowo posortowanej tablicy:");
        bufferedWriter.newLine();
//        System.out.println(Arrays.toString(smallPartiallyInsertionSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.newLine();


//        System.out.println("Przed merge sortem dla małej tablicy:");
        //System.out.println(Arrays.toString(smallMergeSortTable));
        startTime = System.nanoTime();
        mergeSort(smallMergeSortTable);
        endTime = System.nanoTime();
        System.out.println("Po merge sorcie dla małej nieposortowanej tablicy:");
        bufferedWriter.append("Po merge sorcie dla małej nieposortowanej tablicy:");
        bufferedWriter.newLine();
        //System.out.println(Arrays.toString(smallMergeSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.newLine();

//        System.out.println("Przed merge sortem dla dużej tablicy:");
        //System.out.println(Arrays.toString(hugeMergeSortTable));
        startTime = System.nanoTime();
        mergeSort(hugeMergeSortTable);
        endTime = System.nanoTime();
        System.out.println("Po merge sort dla dużej nieposortowanej tablicy:");
        bufferedWriter.append("Po merge sort dla dużej nieposortowanej tablicy:");
            bufferedWriter.newLine();
        //System.out.println(Arrays.toString(hugeMergeSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.newLine();

        startTime = System.nanoTime();
        mergeSort(smallPartiallySortedMergeSortTable);
        endTime = System.nanoTime();
        System.out.println("Po merge sorcie dla małej częściowo posortowanej tablicy:");
        bufferedWriter.append("Po merge sorcie dla małej częściowo posortowanej tablicy:");
            bufferedWriter.newLine();
        //System.out.println(Arrays.toString(smallMergeSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
            bufferedWriter.newLine();

        startTime = System.nanoTime();
        mergeSort(hugePartiallySortedMergeSortTable);
        endTime = System.nanoTime();
        System.out.println("Po merge sorcie dla dużej częściowo posortowanej tablicy:");
        bufferedWriter.append("Po merge sorcie dla dużej częściowo posortowanej tablicy:");
            bufferedWriter.newLine();
        //System.out.println(Arrays.toString(smallMergeSortTable));
        timeElapsed = endTime - startTime;
        System.out.println("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("Czas operacji: " + timeElapsed + " nanosekund = "+ timeElapsed/1000000 + " milisekund\n");
        bufferedWriter.append("-------------------------KONIEC PRÓBY-------------------------");
            bufferedWriter.newLine();
        bufferedWriter.append("--------------------------------------------------------------");
            bufferedWriter.newLine();
        bufferedWriter.append("--------------------------------------------------------------");
            bufferedWriter.newLine();
            bufferedWriter.close();

            System.out.println("Data has been written to the file.");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
