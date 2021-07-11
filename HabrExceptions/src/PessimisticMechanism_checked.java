import java.io.IOException;

public class PessimisticMechanism_checked {
    /*Я называю связь между проверяемыми исключениями и throws — «пессимистичной»,
     польку мы можем «напугать» о большем, чем может произойти на самом деле, но не наоборот*/

    //Мы не можем бросать, но не предупредить
    public static void main(String[] args) {
        //throw new Exception(); // тут ошибка компиляции
    }
    //>> COMPILATION ERROR: unhandled exception: java.lang.Exceptiona
}

//==========================================================================================================
//Мы не можем бросать, но предупредить о «меньшем»
class Example1 {
    public static void main(String[] args) throws IOException {
        //throw new Exception(); // тут ошибка компиляции
    }
    //>> COMPILATION ERROR: unhandled exception: java.lang.Exception
}

//==========================================================================================================
//Мы можем предупредить точно о том, что бросаем
class Example2 {
    public static void main(String[] args) throws Exception { // предупреждаем о Exception
        throw new Exception(); // и кидаем Exception
    }
}

//==========================================================================================================
//Мы можем предупредить о большем, чем мы бросаем
class Example3 {
    public static void main(String[] args) throws Throwable { // предупреждаем "целом" Throwable
        throw new Exception(); // а кидаем только Exception
    }
}

//==========================================================================================================
// Можем даже предупредить о том, чего вообще нет
class Example4 {
    public static void main(String[] args) throws Exception { // пугаем
        // но ничего не бросаем
    }
}

//==========================================================================================================
//Даже если предупреждаем о том, чего нет — все обязаны бояться
class Example5 {
    public static void main(String[] args) {
        //f(); // тут ошибка компиляции
    }

    public static void f() throws Exception {
    }
    //>> COMPILATION ERROR: unhandled exception: java.lang.Exception
}

//==========================================================================================================
//Хотя они (испугавшиеся) могут перепугать остальных еще больше
class Example6 {
    // они пугают целым Throwable
    public static void main(String[] args) throws Throwable {
        f();
    }

    // хотя мы пугали всего-лишь Exception
    public static void f() throws Exception {
    }
}
