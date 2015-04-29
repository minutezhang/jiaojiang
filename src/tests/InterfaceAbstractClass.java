package tests;

/**
 * @author: mizhang
 * @time: 2/24/15 3:57 PM
 */
public class InterfaceAbstractClass {

    private static interface interfaceExample {
        public int field = 10; //this field must be initialized
        public static int staticField = 10; //this field must be initialized
        public final static int finalStaticField = 10; //this field must be initialized
        public void hello(); //default is public and no protected or private
    }

    private static abstract class abstractClassExample {
        private int field;
        public int publicField;
        public static int publicStaticField;
        public final static int publicFinalStaticField = 10;
        public final int publicFinalField = 10;
    }

    private static class classExample {
        private int field;
        public int publicField;
        public static int publicStaticField;
        public final static int publicFinalStaticField = 10;
        public final int publicFinalField = 10;
    }
}
