package jiaojiang.leetcode.practice3.onlinejudge;

import utils.Reader4;

import java.io.InputStream;
import java.io.IOException;

/**
 * @author: mizhang
 * @time: 2/27/15 4:47 PM
 */
public class ReadNCharactersGivenRead4 extends Reader4 {

    public ReadNCharactersGivenRead4(InputStream inputStream) {
        super(inputStream);
    }

    /*
        The API: int read4(char *buf) reads 4 characters at a time from a file.
        The return value is the actual number of characters read. For example, it returns 3 if there is only 3
        characters left in the file.
        By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

        Note:
        The read function will only be called once for each test case.
         */
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
    public int read(char[] buf, int n) {
        int bytesRead, totalBytesRead = 0;
        char[] buf4 = new char[4];
        while ((bytesRead = super.read4(buf4)) > 0 && totalBytesRead < n) {
            bytesRead = Math.min(n - totalBytesRead, bytesRead);
            System.arraycopy(buf4, 0, buf, totalBytesRead, bytesRead);
            totalBytesRead += bytesRead;
        }

        return totalBytesRead;
    }

    public static String read(String filename, int n) {
        InputStream is = ReadNCharactersGivenRead4.class.getResourceAsStream(filename);
        ReadNCharactersGivenRead4 readN = new ReadNCharactersGivenRead4(is);
        char[] buf = new char[n + 100];
        int bytesRead = readN.read(buf, n);
        return new String(buf, 0, bytesRead);
    }
}
