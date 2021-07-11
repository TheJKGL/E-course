import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingAndThrows {
    //При переопределении (overriding) список исключений потомка не обязан совпадать с таковым у предка.
    //Но он должен быть «не сильнее» списка предка:
    public class Parent {
        // предок пугает IOException и InterruptedException
        public void f() throws IOException, InterruptedException {
        }
    }

    class Child extends Parent {
        // а потомок пугает только потомком IOException
        @Override
        public void f() throws FileNotFoundException {
        }
    }

    //==================================================================================================================
    //Однако тут мы попытались «расширить тип» бросаемых исключений
    class ChildB extends Parent {
        //@Override
        //public void f() throws Exception {}
    }
    //>> COMPILATION ERROR: overridden method does not throw 'java.lang.Exception'


}
