import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayHelpers {

    public static void arrayCopy(int[] copy, int[] array, int length) {
        for (int i = 0; i < length; i++) {
            copy[i] = array[i];
        }
    }

    public static int arrayValueCount(int[] a, int length, int value) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] == value) {
                count++;
            }
        }
        return count;
    }

    public static void arrayDump(int[] a, int length) {
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(a[i]);
            if (i < length - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static boolean arrayIsPermutationOf(int[] a, int[] b, int length) {
        for (int i = 0; i < length; i++) {
            int aCount = arrayValueCount(a, length, a[i]);
            int bCount = arrayValueCount(b, length, a[i]);
            if (aCount != bCount) {
                return false;
            }
        }
        return true;
    }

    public static int[] arrayFromFile(String filepath, int maxSize) {
        int[] array = new int[maxSize];
        int size = 0;

        try (Scanner scanner = new Scanner(new File(filepath))) {
            if (scanner.hasNextInt()) {
                size = scanner.nextInt();
            } else {
                System.err.println("Invalid array.");
                System.exit(1);
            }

            if (size > maxSize) {
                System.err.println("Allowed size is " + maxSize + ".");
                System.exit(1);
            }

            for (int i = 0; i < size; i++) {
                if (scanner.hasNextInt()) {
                    array[i] = scanner.nextInt();
                } else {
                    System.err.println("Invalid array.");
                    System.exit(1);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
            System.exit(1);
        }

        // Return only the portion of the array that was read
        int[] trimmedArray = new int[size];
        System.arraycopy(array, 0, trimmedArray, 0, size);
        return trimmedArray;
    }
}

