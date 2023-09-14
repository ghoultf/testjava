import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

public class TestReflect {

    /**
     * The interface My annotation.
     *
     * @author ghoul
     * @date 2023 /09/14
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyAnnotation {
        String name();
    }

    @MyAnnotation(name = "abc")
    public void m1() {}

    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestReflect> clazz = TestReflect.class;
        Method m1 = clazz.getMethod("m1");
        MyAnnotation annotation = m1.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            System.out.println(annotation.name());
        }
        // for (Annotation m1Annotation : m1.getAnnotations()) {
        // System.out.println(m1Annotation.annotationType());
        // if (m1Annotation.annotationType() == MyAnnotation.class) {
        // System.out.println(m1Annotation instanceof MyAnnotation);
        // System.out.println(((MyAnnotation)m1Annotation).name());
        // }
        // }
    }
}
