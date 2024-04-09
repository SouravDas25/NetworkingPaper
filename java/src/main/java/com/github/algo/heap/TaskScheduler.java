package com.github.algo.heap;

import com.github.algo.util.Pair;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Pair<Integer, Character>> available = new PriorityQueue<>(Comparator.reverseOrder());
        for (char task : map.keySet()) {
            available.add(new Pair<>(map.get(task), task));
        }
        Deque<Pair<Integer, Character>> deque = new LinkedList<>();
        List<Character> res = new LinkedList<>();
        int t = 0;
        while (!available.isEmpty() || !deque.isEmpty()) {

            if (!available.isEmpty()) {
                Pair<Integer, Character> popable = available.remove();
                int time = popable.getValue0();
                char task = popable.getValue1();
                res.add(task);
                map.put(task, map.get(task) - 1);
                if (map.get(task) > 0) {
                    deque.add(Pair.with(t + n, task));
                }
            } else {
                res.add(' ');
            }

            if (!deque.isEmpty() && deque.peek().getValue0() <= t) {
                Pair<Integer, Character> p = deque.removeFirst();
                char task = p.getValue1();
                available.add(Pair.with(map.get(task), task));
            }

            t++;
        }
        System.out.println(res);
        return t;
    }
}
