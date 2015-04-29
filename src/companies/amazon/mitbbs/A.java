package companies.amazon.mitbbs;

/**
 * @aythor: zhang
 * @since: Aug 14, 2010 9:55:40 PM
 */
public class A {

    public void printIt() {
        System.out.println("This is super class");
    }

    public void printIt(boolean yes) {
        if (yes) {
            System.out.println("This is super class II");
        } else {
            this.printIt();
        }
    }
}
