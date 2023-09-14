package com.github.ghoultf.test.java.dp.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * 提供一个聚合类，隐藏内部的实现，
 *
 * 高内聚：迭代的方法 <br>
 * 低耦合：客户端和Aggregate依赖抽象的AbstractIterator，而非具体的实现
 *
 * @author ghoul
 * @date 2023/06/14
 */
public class TestIterator1 {

    // 抽AbstractAggregate
    static class Aggregate {
        private List<Integer> elementData = Arrays.asList(1, 2, 3);

        public MyIterator iterator() {
            return new MyIterator();
        }

        // 抽AbstractIterator
        public class MyIterator {
            private int cursor;

            public boolean hasNext() {
                return cursor < elementData.size();
            }

            public Integer next() {
                if (cursor > elementData.size() - 1) {
                    throw new IndexOutOfBoundsException();
                }
                Integer integer = elementData.get(cursor);
                cursor++;
                return integer;
            }
        }
    }

    public static void main(String[] args) {
        Aggregate aggregate = new Aggregate();
        Aggregate.MyIterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
