package utils;

import java.io.InputStream;
import java.io.IOException;

/**
 * @author: mizhang
 * @time: 2/27/15 4:49 PM
 */
public class Reader4 {

    protected InputStream inputStream;
    private byte[] byte4Buffer = new byte[4];

    public Reader4(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public int read4(char[] buf) {
        int bytesRead;
        try {
            bytesRead = inputStream.read(byte4Buffer);
            for (int i = 0; i < bytesRead; i++) {
                buf[i] = (char)byte4Buffer[i]; 
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
        return bytesRead;
    }
}
