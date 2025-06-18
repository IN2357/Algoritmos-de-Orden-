import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {

    private static final int MAX_SIZE = 100000;

    public static void printHelp(String programName) {
        System.out.println("Usage: java " + programName + " <input file path>\n\n"
                + "Sort an array given in a file on disk.\n"
                + "\n"
                + "The input file must have the following format:\n"
                + " * The first line must contain only a positive integer, "
                + "which is the length of the array.\n"
                + " * The second line must contain the members of the array "
                + "separated by one or more spaces. Each member must be an integer.\n\n"
                + "In other words, the file format is:\n"
                + "<amount of array elements>\n"
                + "<array elem 1> <array elem 2> ... <array elem N>\n");
    }

    public static String parseFilePath(String[] args) {
        if (args.length < 1) {
            printHelp("Main");
            System.exit(1);
        }
        return args[0];
    }

    public static int[] arrayFromFile(String filepath) {
        int[] array = new int[MAX_SIZE];
        int length = 0;
        try (Scanner scanner = new Scanner(new File(filepath))) {
            if (scanner.hasNextInt()) {
                length = scanner.nextInt();
                for (int i = 0; i < length && scanner.hasNextInt(); i++) {
                    array[i] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filepath);
            System.exit(1);
        }
        return Arrays.copyOf(array, length);
    }

    public static void arrayCopy(int[] dest, int[] src) {
        System.arraycopy(src, 0, dest, 0, src.length);
    }


    public static void arrayDump(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(int[] original, int[] sorted) {
        int[] a = Arrays.copyOf(original, original.length);
        int[] b = Arrays.copyOf(sorted, sorted.length);
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        String filepath = parseFilePath(args);

        int[] array = arrayFromFile(filepath);

        int[] copy = Arrays.copyOf(array, array.length);

        /*Completar */ 

        arrayDump(array);

        /*Completar: Verificar que el arreglo esta ordenado*/

        /*Completar: Verificar que el arreglo ordenado es una permutacion del original */

        System.exit(0);
    }
}

