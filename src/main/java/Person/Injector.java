package Person;

import Person.Annotaion.AutoInjectable;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;

public class Injector<Object> {


    public void inject(Object obj)
    {
        Class cl = obj.getClass();
        AnnotatedType[] anTypes = cl.getAnnotatedInterfaces();
        AnnotatedType[] anTypes1 = obj.getClass().getAnnotatedInterfaces();
        System.out.println( anTypes1.length);
    }
}
