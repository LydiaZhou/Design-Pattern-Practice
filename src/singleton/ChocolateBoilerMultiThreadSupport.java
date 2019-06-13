package singleton;

/** Singleton pattern practice;
 * A chocolate factory's boiler -> change into singleton pattern
 * This pattern  ensures only one instance of the class can be created.
 * Implementation to support multi-thread using double-check lock
 */
public class ChocolateBoilerMultiThreadSupport {
    private boolean empty;
    private boolean boiled;

    private static volatile ChocolateBoilerMultiThreadSupport chocolateBoiler;

    private ChocolateBoilerMultiThreadSupport() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerMultiThreadSupport getInstance() {
        if (chocolateBoiler == null) {
            synchronized (chocolateBoiler) {
                if (chocolateBoiler == null) {
                    chocolateBoiler = new ChocolateBoilerMultiThreadSupport();
                }
            }
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
