package companies.amazon.mitbbs;

/**
 * @author: zhang
 * @since: Aug 14, 2010 9:57:44 PM
 */
public class B extends A{
    public void printIt() {
        System.out.println("This is subclass");
    }

    public static void main(String[] argv) {
        A a = new B();
        a.printIt();
        a.printIt(true);
        a.printIt(false);

        A b = new A();
        b.printIt(false);
    }
}
