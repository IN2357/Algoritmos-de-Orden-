public class Stack {
    private char[] data;
    private int top; // índice del último elemento apilado

    private static final int DEFAULT_CAPACITY = 100;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        data = new char[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        /*Completar */
    }

    public boolean isFull() {
        /*Completar */
    }

    public void push(char value) {
        /*Completar */
    }

    /*Devuelve el tope y lo elimina */
    public char pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: pila vacía");
        }
        return data[top--];
    }

    /*Devuelve el tope pero no lo elimina */
    public char peek() {
        /*Coompletar */
    }

    public int size() {
        /*Completar */
    }
}
