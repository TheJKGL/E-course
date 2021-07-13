package immutable_example;

public class Name {
    private StringBuilder name;

    public Name(){
        name = null;
    }

    public Name(StringBuilder name) {
        this.name = name;
    }

    public StringBuilder getStrName() {
        return name;
    }

    public void setName(StringBuilder name) {
        this.name = name;
    }
}
