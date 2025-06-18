public class SortHelpers {

    // Devuelve true si x debe ir antes que y
    public static boolean goesBefore(int x, int y) {
        return x <= y;
    }

    // Intercambia elementos en un array
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Devuelve true si el subarray a[0..length] está ordenado
    public static boolean arrayIsSorted(int[] a, int length) {
        for (int i = 1; i <= length; i++) {
            if (!goesBefore(a[i - 1], a[i])) {
                return false;
            }
        }
        return true;
    }

    // Inserta el elemento en posición i en su lugar correcto
    private static void insert(int[] a, int i) {
        /*Need implementation */
        throw new UnsupportedOperationException("Not implemented");
    }

    // Ordena el array usando ordenamiento por inserción
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            assert arrayIsSorted(a, i - 1) : "Array not sorted before insertion at index " + i;
            insert(a, i);
        }
    }
}

