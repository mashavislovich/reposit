public class ProductInfo {
    // Simple data container
    public String  name;
    public String  type;
    public Integer count;
    public Double  itemPrice;

    public ProductInfo(String name, String type, Integer count, Double itemPrice){
        this.name = name;
        this.type = type;
        this.count = count;
        this.itemPrice = itemPrice;
    }

    public ProductInfo(){
        this.name = "";
        this.type = "";
        this.count = 0;
        this.itemPrice = 0.0;
    }

    public String toString(){
        return String.format("name: %s, type: %s, count: %d, price: %f",
                this.name, this.type, this.count, this.itemPrice);
    }

}
