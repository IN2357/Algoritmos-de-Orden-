import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    static final int MAX_SIZE = 100000;

    public static void printHelp(String programName) {
        System.out.printf(
            "Usage: %s <input file path>\n\n" +
            "Sort an array given in a file in disk.\n\n" +
            "The input file must have the following format:\n" +
            " * The first line must contain only a positive integer," +
            " which is the length of the array.\n" +
            " * The second line must contain the members of the array" +
            " separated by one or more spaces. Each member must be an integer.\n\n" +
            "In other words, the file format is:\n" +
            "<amount of array elements>\n" +
            "<array elem 1> <array elem 2> ... <array elem N>\n\n",
            programName);
    }

    public static String parseFilepath(String[] args) {
        if (args.length < 1) {
            printHelp("java Main");
            System.exit(1);
        }
        return args[0];
    }

    public static int arrayFromFile(int[] array, int maxSize, String filepath) {
        try (Scanner sc = new Scanner(new File(filepath))) {
            if (!sc.hasNextInt()) {
                System.err.println("Invalid array.");
                System.exit(1);
            }
            int size = sc.nextInt();
            if (size > maxSize) {
                System.err.printf("Allowed size is %d.\n", maxSize);
                System.exit(1);
            }
            for (int i = 0; i < size; i++) {
                if (!sc.hasNextInt()) {
                    System.err.println("Invalid array.");
                    System.exit(1);
                }
                array[i] = sc.nextInt();
            }
            return size;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist.");
            System.exit(1);
        }
        return 0; // unreachable but needed
    }

    public static void arrayCopy(int[] dest, int[] src, int length) {
        System.arraycopy(src, 0, dest, 0, length);
    }

    public static void arrayDump(int[] array, int length) {
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]);
            if (i < length - 1) System.out.print(" ");
            else System.out.println();
        }
    }

    // Aquí deberías implementar o llamar a quick_sort, array_is_sorted y array_is_permutation_of

    public static void main(String[] args) {
        String filepath = parseFilepath(args);

        int[] array = new int[MAX_SIZE];
        int length = arrayFromFile(array, MAX_SIZE, filepath);

        int[] copy = new int[MAX_SIZE];
        arrayCopy(copy, array, length);

        quickSort(array, length);

        arrayDump(array, length);

        assert arrayIsSorted(array, length) : "Array is not sorted";
        assert arrayIsPermutationOf(copy, array, length) : "Array is not a permutation";

        System.exit(0);
    }

    // Métodos stub para que compiles:
    public static void quickSort(int[] a, int length) {
        throw new UnsupportedOperationException("Implement quickSort");
    }

    public static boolean arrayIsSorted(int[] a, int length) {
        throw new UnsupportedOperationException("Implement arrayIsSorted");
    }

    public static boolean arrayIsPermutationOf(int[] a, int[] b, int length) {
        throw new UnsupportedOperationException("Implement arrayIsPermutationOf");
    }
}
