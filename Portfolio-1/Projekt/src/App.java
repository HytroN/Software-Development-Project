import org.junit.Test;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello World " + sum(4, 5));
    }

    @Test
    public static int sum(int x, int y) {
        return x + y;
    }
}
