package singleton;

/** Singleton pattern practice;
 * A chocolate factory's boiler -> change into singleton pattern
 * This pattern  ensures only one instance of the class can be created.
 * Do not support multi-thread
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    private static ChocolateBoiler chocolateBoiler;

    private ChocolateBoiler() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoiler getInstance() {
        if (chocolateBoiler == null) {
            chocolateBoiler = new ChocolateBoiler();
        }
        return chocolateBoiler;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public boolean isEmpty() {
        return empty;
    }
}
