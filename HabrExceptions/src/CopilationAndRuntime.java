public class CopilationAndRuntime {

}

/*Необходимо понимать, что
— проверка на cheched исключения происходит в момент компиляции (compile-time checking)
— перехват исключений (catch) происходит в момент выполнения (runtime checking)*/

/*Java — язык со статической типизацией (т.е. отслеживание корректности использования типов
(наличие используемых полей, наличие вызываемых методов, проверка на checked исключения, ...) проводится компилятором),
 запрещает такое поведение. В некоторых языках (языки с динамической типизацией —
 отслеживание корректности использования типов проводится средой исполнения (оно разрешено, например в JavaScript).*/

class App {
    // пугаем Exception
    public static void main(String[] args) throws Exception {
        try {
            Throwable t = new Exception(); // и лететь будет Exception
            //throw t; // но тут ошибка компиляции
        } catch (Exception e) {
            System.out.println("Перехвачено!");
        }
    }
    //>> COMPILATION ERROR: unhandled exception: java.lang.Throwable
}

class App2 {
    // ТЕПЕРЬ пугаем Throwable
    public static void main(String[] args) throws Throwable {
        try {
            Throwable t = new Exception(); // а лететь будет Exception
            throw t;
        } catch (Exception e) { // и мы перехватим Exception
            System.out.println("Перехвачено!");
        }
    }
    //>> Перехвачено!
}

