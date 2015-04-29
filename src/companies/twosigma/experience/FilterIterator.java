package companies.twosigma.experience;

import java.util.*;

/**
 * @author: mizhang
 * @time: 3/24/15 2:46 PM
 */
public class FilterIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    int currentValue = 1;

    public FilterIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        while (this.iterator.hasNext() && (currentValue = this.iterator.next()) % 5 != 0);
    }

    @Override
    public boolean hasNext() {
        return currentValue % 5 == 0;
    }

    @Override
    public Integer next() {
        int returnValue = currentValue;
        while (this.iterator.hasNext() && (currentValue = this.iterator.next()) % 5 != 0);
        return returnValue;
    }

    @Override
    public void remove() {

    }

    public static boolean test(Integer[] data) {
        List<Integer> tmpList = new ArrayList<Integer>();
        for(Integer i : data) {
            if (i % 5 == 0) {
                tmpList.add(i);
            }
        }

        Iterator<Integer> expected = tmpList.iterator();
        FilterIterator iterator = new FilterIterator(Arrays.asList(data).iterator());

        while (expected.hasNext()) {
            if (!iterator.hasNext()) {
                return false;
            }
            int count = new Random().nextInt(100);
            for (int i = 0; i < count; i++) {
                if (iterator.hasNext() != expected.hasNext()) {
                    return false;
                }
            }

            if (!expected.next().equals(iterator.next())) {
                return false;
            }
        }

        return true;
    }
}
