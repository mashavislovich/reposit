import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Scanner {

    private ProductInfoContainer container;

    public Scanner(ProductInfoContainer container){
        this.container = container;
    }

    public void scan() throws IOException{
        // exit flag
        Boolean exit = false;

        System.out.println("List of allowed commands: exit, new, count types, count all, average price");
        System.out.println("How to pass command argument: %command_name : %command_argument");
        System.out.println("New command reference: New: %name | %type | %count | %itemPrice");

        while(!exit){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // Read command from command line
            System.out.println("Enter command: ");
            // read command
            String command =  br.readLine();

            String[] splittedCommand = command.split(Pattern.quote(":"));
            String cleanedCommand = splittedCommand[0].trim();

            switch(cleanedCommand){
                case "exit":
                    exit = true;
                    System.out.println("Bye bye!");
                    break;
                case "new":
                    if (splittedCommand.length < 2){
                        System.out.println("No data");
                        continue;
                    }
                    this.parseProductInfo(splittedCommand[1]);
                    break;
                case "count types":
                    System.out.println(String.format("Types count: %d", this.container.getTypesCount()));
                    break;
                case "count all":
                    System.out.println(String.format("All products count: %d", this.container.getCount()));
                    break;
                case "average price":
                    if(splittedCommand.length > 1){
                        String type = splittedCommand[1].trim();
                        System.out.println(String.format("Average price for type %s: %f", type, this.container.getAveragePriceForType(type)));
                    }else{
                        System.out.println(String.format("Average price: %f", this.container.getAveragePrice()));
                    }
                    break;
                default:
                    System.out.println("No such command");
                    break;
            }
        }
    }

    private void parseProductInfo(String productInfoString){
        String[] parts = productInfoString.split(Pattern.quote("|"));
        ProductInfo productInfo = new ProductInfo();
        if(parts.length < 4){
            System.out.println("Not enought info for product");
        }
        productInfo.name = parts[0].trim();
        productInfo.type = parts[1].trim();
        productInfo.count = Integer.parseInt(parts[2].trim());
        productInfo.itemPrice = Double.parseDouble(parts[3].trim());
        this.container.pushProductInfo(productInfo);

        System.out.println(String.format("New object: %s", productInfo.toString()));

    }

}
