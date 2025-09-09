package Hashing;

import java.util.*;

public class HashMapImplementation {

    static class HashMap<k, v> { // generic variables

        private class Node {

            k key;
            v value;

            public Node(k key, v value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n; // total entries
        private int N; // total buckets
        private LinkedList<Node>[] buckets;

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.n = 0;
            this.buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(k key) {
            return Math.abs(key.hashCode()) % N;
        }

        private int searchInLL(k key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key.equals(key)) {
                    return i;
                }
            }
            return -1;
        }

        public void put(k key, v value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            N = 2 * N;
            buckets = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                buckets[i] = new LinkedList<>();
            }
            n = 0; // reset and re-insert
            for (LinkedList<Node> ll : oldBuckets) {
                while (!ll.isEmpty()) {
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }
        }

        public v get(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].get(di);
                return node.value;
            }
            return null;
        }

        public v remove(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
            return null;
        }

        public boolean containskey(k key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public boolean isEmpty() {
            return n == 0;
        }

        public int size() {
            return n;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            for (LinkedList<Node> bucket : buckets) {
                for (Node node : bucket) {
                    sb.append(node.key).append("=").append(node.value).append(", ");
                }
            }
            if (sb.length() > 1) {
                sb.setLength(sb.length() - 2); // remove last comma

                        }sb.append("}");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Pakistan", -100);
        hm.put("America", 50);
        hm.put("America", 80); // update
        hm.put("Nepal", 10);
        hm.put("China", 30);
        hm.put("Japan", 60);

        // Print map
        System.out.println("Map: " + hm);

        // get
        System.out.println("India: " + hm.get("India"));       // 100
        System.out.println("China: " + hm.get("China"));       // 30
        System.out.println("Brazil: " + hm.get("Brazil"));     // null

        // containsKey
        System.out.println("Contains India? " + hm.containskey("India")); // true
        System.out.println("Contains UK? " + hm.containskey("UK"));       // false

        // remove
        System.out.println("Remove Pakistan: " + hm.remove("Pakistan")); // -100
        System.out.println("Remove UK: " + hm.remove("UK"));             // null

        // size
        System.out.println("Size: " + hm.size()); // Should reflect current size

        // isEmpty
        System.out.println("Is Empty? " + hm.isEmpty()); // false
    }
}
