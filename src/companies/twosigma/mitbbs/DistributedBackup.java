package companies.twosigma.mitbbs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: mizhang
 * @time: 2/11/15 3:25 PM
 */
public class DistributedBackup {
    /*
    输入：第一行是一个0-999999之间的整数，代表数据中心（data center）的数量。接着的每一行分别是一个数据中心，每一行最先是一个0-299的整
    数代表该数据中心的数据组（data sets）. 然后就是以空格分开的数据。数据都是1-999999之间的整数。每一行最多999个字符长。

    输出：

    要求输出分布式备份的步骤，将数据在数据中心间互相拷贝，最后使得所有数据中心都有所有的数据。
    打印出的步骤的格式是： <data-set-id> <from> <to>

     <data-set-id> 就是所要拷贝的数据， <from> 是该数据所在数据中心的索引， <to>是即将拷贝过去的数据中心的索引

    当步骤结束后，打印“done”。

    能实现分布式备份的步骤往往不是唯一的，打印出任何正确地步骤均可。


    约束:

    输入必须来自stdin，输出必输到stdout。可以假设输入是有效的。

    例如：

    输入:
    3
    5 1 3 4 5 7
    2 1 3
    1 2


    一种正确地输出:
    2 3 2
    2 3 1
    1 1 3
    4 1 2
    5 1 3
    5 3 2
    4 2 3
    3 1 3
    7 1 2
    7 1 3
    done
     */
    public static void distributedBackup(BufferedReader br) throws IOException {
        String line = br.readLine();
        int numDataCenters = Integer.parseInt(line);
        Set<Integer>[] datacenters = new Set[numDataCenters];
        for (int i = 0; i < numDataCenters; i++) {
            datacenters[i] = new HashSet<Integer>();
            line = br.readLine();
            String[] datasets = line.split("\\W+");
            int numDataSets = Integer.parseInt(datasets[0]);

            if (numDataSets + 1 != datasets.length) {
                throw new IllegalArgumentException("Wrong size of data sets: " + line);
            }

            for (int j = 1; j <= numDataSets; j++) {
                datacenters[i].add(Integer.parseInt(datasets[j]));
            }
        }

        StringBuffer ret = new StringBuffer();

        for (int i = 0; i < datacenters.length; i++) {
            for (int j = i + 1; j < datacenters.length; j++) {
                for (Integer ds : datacenters[i]) {
                    if (!datacenters[j].contains(ds)) {
                        datacenters[j].add(ds);
                        ret.append(ds).append(' ').append(i + 1).append(' ').append(j + 1).append('\n');
                    }
                }

                for (Integer ds : datacenters[j]) {
                    if (!datacenters[i].contains(ds)) {
                        datacenters[i].add(ds);
                        ret.append(ds).append(' ').append(j + 1).append(' ').append(i + 1).append('\n');
                    }
                }
            }
        }

        ret.append("done");

        System.out.println(ret.toString());
    }

    public static void main(String[] args) throws IOException {
        distributedBackup(new BufferedReader(new InputStreamReader(System.in)));
    }
}
