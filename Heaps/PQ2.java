package Heaps;

import java.util.PriorityQueue;

public class PQ2 {

    static class Student implements Comparable<Student> { // overriding

        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("ABC", 3));
        pq.add(new Student("PQR", 5));
        pq.add(new Student("MNO", 10));
        pq.add(new Student("TRS", 1));
        pq.add(new Student("XYZ", 7));
        while (!pq.isEmpty()) {
            System.out.print(pq.peek().name + "->" + pq.peek().rank);
            pq.remove();
            System.out.println();
        }
    }
}

/*
 | Concept                          | Why it's used                                                            |
| -------------------------------- | ------------------------------------------------------------------------ |
| `implements Comparable<Student>` | So Java knows how to compare `Student` objects                           |
| `@Override`                      | Tells the compiler you're overriding the `compareTo()` method            |
| `compareTo(Student s2)`          | Defines how to sort students (by rank)                                   |
| `static class Student`           | Allows the inner class to be used without an instance of the outer class |

 */
