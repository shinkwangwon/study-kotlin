package ex4_class;

public interface JavaInterface {

    String test = "hhhh";

    default public void println() {
        System.out.println(test);
    }
}
