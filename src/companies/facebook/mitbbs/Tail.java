package companies.facebook.mitbbs;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author: zhang
 * @since: Feb 4, 2014 9:56:55 PM
 */
public class Tail {
    /*
    implement tail -n
     */

    private static int DEFAULT_BUFFER_SIZE = 1024;
    String[] buffer;

    public Tail() {
        buffer = new String[DEFAULT_BUFFER_SIZE];
    }

    public Tail(int n) {
        buffer = new String[n];
    }

    public String tail(int n, String filename) {
        if (n > buffer.length) {
            buffer = new String[n];
        }

        InputStream is  = JumpGame.class.getResourceAsStream("/" + filename);
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(reader);

        int index = 0, count = 0;
        try {
            String line;
            for (index = 0, count = 0; (line = br.readLine()) != null; buffer[index] = line, index = (index + 1) % n, count++);
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < Math.min(n, count); i++) {
            ret.append(buffer[(index + i) % n]).append('\n');
        }

        return ret.toString();
    }

    public static void main(String[] args) {
        Tail util = new Tail();
        System.out.println(util.tail(21, "JumpGame.data"));
    }
}
