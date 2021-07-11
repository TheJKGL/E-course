public class Finally {
    //finally-секция получает управление, если try-блок завершился успешно
    //finally-секция получает управление, даже если try-блок завершился исключением
    //finally-секция получает управление, даже если try-блок завершился директивой выхода из метода
    //finally-секция НЕ вызывается только если мы «прибили» JVM
    public static void main(String[] args) {
        try {
            System.err.println("try");
            //throw new RuntimeException();
            //return;
            //System.exit(42); //System.exit(42) и Runtime.getRuntime().exit(42) — это синонимы
            //Runtime.getRuntime().exit(42);
        } finally {
            System.err.println("finally");
        }
    }
}

//============================================================================================================
class Finally2 {
    /*Однако finally-секция не может «починить» try-блок завершившийся исключение
    (заметьте, «more» — не выводится в консоль)*/
    public static void main(String[] args) {
        try {
            System.err.println("try");
            if (true) {
                throw new RuntimeException();
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more");
    }
    /*>> try
      >> finally
      >> Exception in thread "main" java.lang.RuntimeException*/
}

//============================================================================================================
class Finally3 {
    //Однако finally-секция может «перебить» throw/return при помощи другого throw/return
    public static void main(String[] args) {
        System.err.println(f());
    }

    public static int f() {
        try {
            return 0;
        } finally {
            return 1;
        }
    }
    //>> 1
}

//============================================================================================================
class Finally4 {
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                // НИЧЕГО
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - нет исключения
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение в норме
        } catch (Exception e) {
            System.err.print(" 6");     // НЕ заходим - нет исключения
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
    //>> 0 1 2 4 5 7 8
}





