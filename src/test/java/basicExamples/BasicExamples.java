package basicExamples;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class BasicExamples {

    @Test
    public void testEquals(){
        String string1="Junit";
        String string2="junit";

        assertNotEquals(string1,string2);
    }

    @Test
    public void usingSpy(){
        List list = new LinkedList<>();
        List spy = spy(list);
        /*Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
        when(spy.get(0)).thenReturn("foo");*/

        //You have to use doReturn() for stubbing
        doReturn("foo").when(spy).get(0);
    }

}
