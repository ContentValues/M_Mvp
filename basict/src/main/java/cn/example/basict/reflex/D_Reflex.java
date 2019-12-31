package cn.example.basict.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Author：created by SugarT
 * Time：2019/12/4 20
 */
public class D_Reflex {


    public static void main(String args[]) {

        try {
            Constructor<Student> constructor = Student.class.getDeclaredConstructor(String.class, String.class);
            constructor.setAccessible(true);
            Student student = constructor.newInstance("小仙女我想做爱", "14");
//            student.printAge();

            Field field = Student.class.getDeclaredField("name");
            field.setAccessible(true);
            String name = (String) field.get(student);

            System.out.println(name);

//            for (Field declaredField : Student.class.getDeclaredFields()) {
//                declaredField.setAccessible(true);
//                System.out.println(declaredField.get(student));
//            }

            Method method = Student.class.getDeclaredMethod("print",String.class);
            method.setAccessible(true);
            method.invoke(student,"我喜欢肛交");


            Method method1= Student.class.getDeclaredMethod("printName");
            method1.setAccessible(true);
            method1.invoke(student);

            for (Method declaredMethod : Student.class.getDeclaredMethods()) {
                declaredMethod.setAccessible(true);
                if(!declaredMethod.getName().equals("print")){
                    declaredMethod.invoke(student);
                }else {
                    declaredMethod.invoke(student,"干你屁眼");
                }

            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


    }


}
