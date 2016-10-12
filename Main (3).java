import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ProductInfoContainer container = new ProductInfoContainer();
        Scanner scanner = new Scanner(container);

        try{
            scanner.scan();
        } catch (IOException e){
            System.out.println("IOException. WTF?!");
        }
    }
}
