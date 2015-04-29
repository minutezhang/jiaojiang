package companies.dropbox.mitbbs;

import utils.Utils;

import java.util.Random;
import java.util.Date;

/**
 * @author: zhang
 * @since: Oct 8, 2013 10:12:37 PM
 */
/*
Write a counter function, which return the number of function call hit() in past 5 minutes (or 30 seconds for test purpose)

Two functions:
void hit()
long getHits() // counter function
 */
public class HitCounter {

    private final static int timeRange = 20;
    private int[] circularBuffer = new int[timeRange];
    private long lastUpdateTime = 0;

    //circular buffer
    public void hit() {
        long time = System.currentTimeMillis()/1000;
        if (lastUpdateTime != time && lastUpdateTime != 0) {
            for (long l = lastUpdateTime + 1; l < time; l++) {
                circularBuffer[(int)(l % timeRange)] = 0;
            }
            circularBuffer[(int)(time % timeRange)] = 1;
        } else {
            circularBuffer[(int)(time % timeRange)]++;
        }
        lastUpdateTime = time;
    }

    public long getHits() {
        long time = System.currentTimeMillis()/1000;
        long hits = 0;
        for (long l = time - timeRange + 1; l <= lastUpdateTime; l++) {
            hits += circularBuffer[(int)(l % timeRange)];
        }

        return hits;
    }

    public static void test(long timeRange) throws InterruptedException {
        int totalTime = 0;
        HitCounter hc = new HitCounter();
        long count = 0;
        Random r = new Random();
        while (totalTime < timeRange) {
            int t = r.nextInt(5000);
            System.out.println("Sleep " + t + " milliseconds");
            Thread.sleep(t);
            totalTime += t;
            System.out.println("Time elapsed: " + totalTime + " milliseconds");
            hc.hit();
            count++;
            System.out.println("Hits: " + count);
            Utils.printArrayln(hc.circularBuffer);
            System.out.println();
        }

        System.out.println("hit counter: " + hc.getHits() + ", total count: " + count);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date() + "\n");
        test(3 * timeRange * 1000);
        System.out.println("\n" + new Date());
    }
}