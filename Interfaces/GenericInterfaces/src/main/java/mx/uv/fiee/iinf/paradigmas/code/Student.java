package mx.uv.fiee.iinf.paradigmas.code;

public class Student implements Comparable<Student> {
    private final String name;
    private final int age;

    public Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString () {
        return "Student {" +
                "name='" + name + '\'' +
                ", age=" + age +
                " }";
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
