package Person;

import Person.Annotaion.AutoInjectable;
import Sortings.Sort;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {

    public <T> T inject(T obj) throws IOException, IllegalAccessException, ClassNotFoundException {
        //Create Input Stream
        FileInputStream  fls = new FileInputStream("src/main/Resource/inject.properties");
        Properties property = new Properties();
        property.load(fls);

        Class<?> cl = obj.getClass();
        Field[] fields = cl.getFields();
        String s;
        Class<?> classSort;


        for(int i=0; i<fields.length; i++)
            if(fields[i].getAnnotation(AutoInjectable.class) != null) {
                s = property.getProperty(fields[i].getType().getCanonicalName());
                classSort= Class.forName(s);
                try {
                    fields[i].set(obj, classSort.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
            return obj;
    }


}
