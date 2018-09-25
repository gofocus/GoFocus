import java.io.*;

/**
 * Created by guojia on 2017/6/7.
 */

class Student implements Serializable {
    private int age;
    private String name;

    Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


public class Serialize_test {

    public static void main(String[] args) throws FileNotFoundException {
        Student student = new Student("guojia", 22);

        File file = new File("D:\\test.txt");
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(student);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Student s = (Student) ois.readObject();
            System.out.printf(s.getName()+"\n");
            System.out.printf(String.valueOf(s.getAge()));
            ois.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
