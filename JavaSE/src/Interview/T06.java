package Interview;


/**
 * @Author: gofocus
 * @Date: 9:20 2018/7/15 0015
 */
public class T06 {

    static class Student implements Comparable<Student> {
        private String name;        // 姓名
        private int age;            // 年龄

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", age=" + age + "]";
        }

        @Override
        public int compareTo(Student o) {
            return this.age - o.age; // 比较年龄(年龄的升序)
        }

    }

    public static void main(String[] args) {
        Student a = new Student("Hao LUO", 33);
        Student b = new Student("XJ WANG", 32);
        System.out.println(a.compareTo(b));

    }


}



