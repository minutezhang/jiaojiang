package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/**
 * @author: mizhang
 * @time: 1/27/15 8:53 PM
 */
public class TestMain {
    private static void test(String testPackageName, String packageName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(TestMain.class.getResourceAsStream("/test/" + packageName + ".data"), "UTF-8"));

        int count = 0;
        String line;
        while ((line = br.readLine()) != null) {
            if (!line.startsWith("#") && !line.startsWith("//")) {
                String[] contents = line.split("\\s");
                String className = contents[0];
                String methodName = contents[1];
                System.out.println("[" + (++count) + "] <" + className + "> - <" + methodName + ">");
                try {
                    Method method = Class.forName(testPackageName + "." + className).getMethod("test", String.class, String.class, String.class);
                    method.invoke(null, packageName, className, methodName);
                } catch (Exception e) {
                    System.err.println("No method " + methodName + " for class " + className);
                    e.printStackTrace();
                }
            }
            System.err.flush();
            System.out.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(TestMain.class.getResourceAsStream("/test/test.data"), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (!line.startsWith("#") && !line.startsWith("//")) {
                String packageName = line;
                System.out.println("================= " + packageName + " =================");
                String[] packageNames = packageName.split(":");
                test(packageNames[0], packageNames[1]);
            }
        }
    }
}
