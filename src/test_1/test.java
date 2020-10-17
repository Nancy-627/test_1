package test_1;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class test {

    public static void main(String[] args) {
            MyList<String> list = null;
            list = new MyList<String>();
            list.add( "Hello");
            list.add( "MyList");
            list.add( "ready to delete");
            list.add( "ready to set");
            list.remove(2);
            list.get(1);
            list.indexOf("Hell0");
            list.set(2, "yes");
            list.isEmpty();
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                    System.out.print(iterator.next() + "、"); //输出内容
            }
            Collection<String> collection = (Collection<String>) new MyList<String>();






    }


}
