package class4;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsBeforeClass {

    @BeforeClass
    public void hello(){
        System.out.println("I am before class.");
    }

    @Test
    public void testB(){
        System.out.println("I am testB");
    }
}
