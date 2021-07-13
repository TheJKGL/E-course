package immutable_example;

public final class ImmutableStudent {
    private final int age;
    private final Name name;

    public ImmutableStudent(int age, Name name) {
        this.age = age;
        Name clone = new Name();
        clone.setName(new StringBuilder(name.getStrName()));
        this.name = clone;
        //this.name = new Name(name.getStrName());
    }

    public int getAge() {
        return age;
    }

    public Name getName() {
        Name clone = new Name();
        clone.setName(new StringBuilder(name.getStrName()));
        return clone;
        //return new Name(this.name.getStrName());
    }

    public ImmutableStudent setName(Name name){
        return new ImmutableStudent(this.age,name);
    }

    public ImmutableStudent setAge(int age){
        return new ImmutableStudent(age,this.name);
    }
}
