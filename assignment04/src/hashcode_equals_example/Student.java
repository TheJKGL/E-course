package hashcode_equals_example;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(obj instanceof Student){
            Student other = (Student) obj;
            return this.age == other.age && this.name.equals(other.name);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){
        /*int result = 17;
        result = 31 * result + (name == null ? 0 : name.hashCode());
        result = 31 * result + age;
        return result;*/
        return age * 31 + (name == null ? 0 : name.hashCode());
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Student student1 = new Student("Jenya",19);
        Student student2 = new Student("Jenya",19);
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());
        System.out.println(student1.equals(student2));
        System.out.println(student1);
    }
}
