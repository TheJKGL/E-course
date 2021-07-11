public class System_err_out {
    //System.out — buffered-поток вывода, а System.err — нет.
    public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }
    /*>> RUNTIME ERROR: Exception in thread "main" java.lang.Error
      >> sout*/


    /*public static void main(String[] args) {
        System.out.println("sout");
        throw new Error();
    }*/
    /*>> sout
      >> RUNTIME ERROR: Exception in thread "main" java.lang.Error*/
}
