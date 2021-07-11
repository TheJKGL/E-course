public class Catch {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");
        } catch (Exception e) { // catch по Exception ПЕРЕХВАТЫВАЕТ RuntimeException
            System.err.print(" 2");
        }
        System.err.println(" 3");
    }
    //>> 0 2 3


}

//===============================================================================================================
class Catch2 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (Exception e) {
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.println("Это RuntimeException на самом деле!!!");
            } else {
                System.err.println("В каком смысле не RuntimeException???");
            }
        }
    }
    //>>Это RuntimeException на самом деле!!!
}

//===============================================================================================================
class Catch3 {
    //Catch не может поймать предка.
    public static void main(String[] args) throws Exception { // пока игнорируйте 'throws'
        try {
            System.err.println("0");
            if (true) {
                throw new Exception();
            }
            System.err.println("1");
        } catch (RuntimeException e) {
            System.err.println("2");
        }
        System.err.println("3");
    }
    /*>> 0
      >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Exception*/
}

//===============================================================================================================
class Catch4 {
    /*catch по одному «брату» не может поймать другого «брата» (Error и Exception не находятся в отношении предок-потомок,
     они из параллельных веток наследования от Throwable)*/
    public static void main(String[] args) {
        try {
            System.err.println("0");
            if (true) {
                throw new Error();
            }
            System.err.println("1");
        } catch (Exception e) {
            System.err.println("2");
        }
        System.err.println("3");
    }
    /*>> 0
      >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error*/
}

//===============================================================================================================
class Catch5 {
    /*В таком случае выполнение метода тоже прерывается (не печатаем «3»).
      Новое исключение не имеет никакого отношения к try-catch*/
    public static void main(String[] args) {
        try {
            System.err.println("0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.println("1");
        } catch (RuntimeException e) {     // перехватили RuntimeException
            System.err.println("2");
            if (true) {
                throw new Error();
            } // но бросили Error
        }
        System.err.println("3");          // пропускаем - уже летит Error
    }
    /*>> 0 2
      >> RUNTIME EXCEPTION: Exception in thread "main" java.lang.Error*/
    //Мы можем даже кинуть тот объект, что у нас есть «на руках»
    //Но важный момент в том, что catch имеет отношение исключительно к try-секции, но не к другим catch-секциям.
}

//===============================================================================================================
class Catch6 {
    /*Как покажем ниже — можно строить вложенные конструкции, но вот пример, «исправляющий» эту ситуацию.*/
    /*Трюк с «if (true) {...}» требуется, так как иначе компилятор обнаруживает
     недостижимый код (последняя строка) и отказывается его компилировать*/
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(" 1");//ПРОПУСТИЛИ
        } catch (RuntimeException e) { // перехватили RuntimeException
            System.err.print(" 2.1");
            try {
                System.err.print(" 2.2");
                if (true) {
                    throw new Error();
                } // и бросили новый Error
                System.err.print(" 2.3");//ПРОПУСТИЛИ
            } catch (Throwable t) {            // перехватили Error
                System.err.print(" 2.4");
            }
            System.err.print(" 2.5");
        } catch (Error e) { // хотя есть cath по Error "ниже", но мы в него не попадаем
            System.err.print(" 3");//ПРОПУСТИЛИ
        }
        System.err.println(" 4");
    }
    //>> 0 2.1 2.2 2.4 2.5 4
}

//===============================================================================================================
class Catch7 {
    /*Но есть такое правило — нельзя ставить потомка после предка! (RuntimeException после Exception)*/
    public static void main(String[] args) {
        try {
        } catch (Exception e) {
        } /*catch (RuntimeException e) {
        }*/
    }
    //>> COMPILATION ERROR: Exception 'java.lang.RuntimeException' has alredy been caught
}

class CatchOrder {
    /*JVM идет сверху-вниз до тех пор,
    пока не найдет такой catch что в нем указано ваше исключение или его предок — туда и заходит. Ниже — не идет.

     Выбор catch осуществляется в runtime (а не в compile-time),
     значит учитывается не тип ССЫЛКИ (Throwable), а тип ССЫЛАЕМОГО (Exception)
     */
    public static void main(String[] args) {
        try {
            Throwable t = new Exception();
            throw t;
        } catch (RuntimeException e) {
            System.err.println("catch RuntimeException");
        } catch (Exception e) {
            System.err.println("catch Exception");
        } catch (Throwable e) {
            System.err.println("catch Throwable");
        }
        System.err.println("next statement");
    }
    /*>> catch Exception
      >> next statement*/
}











