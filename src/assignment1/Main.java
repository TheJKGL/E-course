package assignment1;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model,view);
        controller.processor();
        System.out.println(model.createSentences());
    }
}
