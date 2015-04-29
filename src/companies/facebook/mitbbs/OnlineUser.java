package companies.facebook.mitbbs;

import utils.Utils;

import java.util.*;

/**
 * @author: mizhang
 * @since: Nov 11, 2013 10:48:38 AM
 */
public class OnlineUser {
    /*
    Given a log file of user login info, find out the total number of users logged in in a certain period of time. For
    example,
    Given:
        user1:
        login_time: 0
        logout_time: 1

        user2:
        login_time: 0
        logout_time: 2

        user3:
        login_time: 1
        logout_time: 3

    output:
    [0 - 2): 2
    [2 - 3): 1
    [3 - infinite): 0
     */
    private static class Log {
        long logginTime;
        long loggoutTime;

        public Log(long loggin, long logout) {
            logginTime = loggin;
            loggoutTime = logout;
        }
    }

    private static class UserCount {
        long start;
        long end;
        long userCount;

        public String toString() {
            return "[" + start + ", " + end + "]: " + userCount;
        }
    }

    public static List<UserCount> onlineUser(List<Log> logs) {
        List<UserCount> ret = new ArrayList<UserCount>();

        long[] start = new long[logs.size()];
        long[] end = new long[logs.size()];

        for (int i = 0; i < logs.size(); i++) {
            start[i] = logs.get(i).logginTime;
            end[i] = logs.get(i).loggoutTime;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        UserCount  uc = new UserCount();
        uc.start = start[0];
        uc.userCount = 0;
        int i = 0, j = 0, count = 0;
        while (i < start.length || j < end.length) {
            if (i < start.length && start[i] == end[j]) {
                i++;
                j++;
            } else if (i < start.length && start[i] < end[j]) {
                count++;
                if (i == 0 || start[i - 1] == start[i]) {
                    uc.userCount++;
                } else {
                    uc.end = start[i];
                    ret.add(uc);
                    uc = new UserCount();
                    uc.start = start[i];
                    uc.userCount = count;
                }
                i++;
            } else {
                count--;
                if (j == 0 || end[j - 1] == end[j]) {
                    uc.userCount--;
                } else {
                    uc.end = end[j];
                    ret.add(uc);
                    uc = new UserCount();
                    uc.start = end[j];
                    uc.userCount = count;
                }
                j++;
            }
        }

        uc = new UserCount();
        uc.start = end[end.length - 1];
        uc.end = Long.MAX_VALUE;
        uc.userCount = 0;
        ret.add(uc);

        return ret;
    }

    public static List<UserCount> onlineUser2(List<Log> logs) {
        List<UserCount> ret = new ArrayList<UserCount>();
        TreeMap<Long, Long> map = new TreeMap<Long, Long>();

        for (Log log : logs) {
            if (!map.containsKey(log.logginTime)) {
                map.put(log.logginTime, 1l);
            } else {
                map.put(log.logginTime, map.get(log.logginTime) + 1);
            }

            if (!map.containsKey(log.loggoutTime)) {
                map.put(log.loggoutTime, -1l);
            } else {
                map.put(log.loggoutTime, map.get(log.loggoutTime) - 1);
            }
        }

        long count = 0;
        UserCount uc = new UserCount();
        Iterator<Long> iter = map.keySet().iterator();
        long s = iter.next();
        uc.start = s;
        count += map.get(s);

        while (iter.hasNext()) {
            s = iter.next();
            long c = map.get(s);
            if (c != 0) {
                uc.end = s;
                uc.userCount = count;
                ret.add(uc);
                uc = new UserCount();
                uc.start = s;
                count += c;
            }
        }

        uc.end = Long.MAX_VALUE;
        uc.userCount = count;
        ret.add(uc);

        return ret;
    }

    private static void test() {
        Utils.printListln(onlineUser(Arrays.asList(new Log(0, 1), new Log(0, 2), new Log(1, 3))));
        Utils.printListln(onlineUser2(Arrays.asList(new Log(0, 1), new Log(0, 2), new Log(1, 3))));
    }

    public static void main(String[] args) {
        test();
    }
}
