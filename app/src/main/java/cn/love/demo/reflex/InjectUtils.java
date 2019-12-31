package cn.love.demo.reflex;

import android.support.v4.app.Fragment;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Author：created by SugarT
 * Time：2019/12/5 10
 */
public class InjectUtils {

    public static void inject(Fragment fragment) {

//        for (Field declaredField : fragment.getClass().getDeclaredFields()) {
//            Annotation annotation = declaredField.getAnnotation(FromValue.class);
//            if (annotation != null && annotation instanceof FromValue) {
//                declaredField.setAccessible(true);
//                View v = fragment.getActivity().findViewById(((FromValue) annotation).value());
//                try {
//                    declaredField.set(fragment,v);
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


        for (Field declaredField : fragment.getClass().getDeclaredFields()) {
            FromValue annotation = declaredField.getAnnotation(FromValue.class);
            if (annotation != null ) {
                declaredField.setAccessible(true);
                View v = fragment.getActivity().findViewById( annotation.value());
                try {
                    declaredField.set(fragment,v);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
