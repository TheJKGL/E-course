public class ReturnResult {

    public static void main(String[] args) {
        System.out.println(area(-10, 10));
    }

    public double sqr(double arg) { // надо double
        return arg * arg;           // double * double - это double
    }

    //==============================================================================
    public double sqr2(double arg) { // надо double
        int k = 1;                  // есть int
        return k;                   // можно неявно преобразовать int в double
    }

    //==============================================================================
    // на самом деле, компилятор сгенерирует байт-код для следующих исходников
    public double sqr3(double arg) { // надо double
        int k = 1;                  // есть int
        return (double) k;          // явное преобразование int в double
    }

    //==============================================================================
    //Из-забавного, можно ничего не возвращать, а «повесить метод»
    public static double sqr4(double arg) {
        while (true) ; // Удивительно, но КОМПИЛИРУЕТСЯ!
    }

    //==============================================================================
    public static double sqr5(double arg) {
        if (System.currentTimeMillis() % 2 == 0) {
            return arg * arg; // ну ладно, вот твой double
        } else {
            while (true) ;     // а тут "виснем" навсегда
        }
    }

    //==============================================================================
    //Но механизм исключений позволяет НИЧЕГО НЕ ВОЗВРАЩАТЬ!
    public static double sqr6(double arg) {
        throw new RuntimeException();
    }

    //==============================================================================
    //Итак, у нас есть ТРИ варианта для компилятора
    public static double sqr7(double arg) {// согласно объявлению метода ты должен вернуть double
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            return arg * arg;             // ок, вот твой double
        } else if (time % 2 == 1) {
            while (true) ;                 // не, я решил "повиснуть"

        } else {
            throw new RuntimeException(); // или бросить исключение
        }
    }

    //==============================================================================
    //TODO: Давайте рассмотрим некоторый пример из практики.
    //Задача: реализовать функцию, вычисляющую площадь прямоугольника

    /*Но «правильный путь» таков: если обнаружили возможное некорректное поведение, то
    1. Вычисления остановить, сгенерировать сообщение-поломку, которое трудно игнорировать,
    предоставить пользователю информацию о причине, предоставить пользователю возможность все починить
    (загрузить белье назад и повторно нажать кнопку старт)*/
    public static int area(int width, int height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
        }
        return width * height;
    }
}
