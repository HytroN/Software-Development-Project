import org.junit.Test;

public class App {
    public static void main(String[] args) throws Exception {
        print("Hello World");
    }

    @Test
    public static void print(String text) {
        System.out.println(text);
    }
}
