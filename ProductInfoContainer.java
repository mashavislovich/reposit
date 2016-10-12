import java.util.LinkedList;
import java.util.HashSet;

public class ProductInfoContainer {
    // Motivation behind this class (and approach):
    // This class allow fast inserts and slow queries.
    // This is good scenario when you do more inserts than queries

    // Store ProductInfo objects
    private LinkedList<ProductInfo> productInfos;

    public ProductInfoContainer(){
        this.productInfos = new LinkedList<ProductInfo>();
    }

    public void pushProductInfo(ProductInfo productInfo){
        this.productInfos.add(productInfo);
    }

    public Integer getCount(){
        Integer count = 0;

        // Iterate over list of productInfos
        // and count items
        for(ProductInfo productInfo : this.productInfos) {
            count += productInfo.count;
        }
        return count;
    }

    public Double getAveragePrice(){
        Double priceSum = 0.0;
        Integer count = 0;

        // Iterate over list of productInfos
        // and count average price
        for(ProductInfo productInfo : this.productInfos) {
            count += productInfo.count;
            priceSum += productInfo.count * productInfo.itemPrice;
        }

        return priceSum / count;
    }

    public Double getAveragePriceForType(String type){
        Double priceSum = 0.0;
        Integer count = 0;

        // Iterate over list of productInfos
        // and count average price for type
        for(ProductInfo productInfo : this.productInfos) {
            if(!productInfo.type.equals(type) ){
                continue;
            }

            count += productInfo.count;
            priceSum += productInfo.count * productInfo.itemPrice;
        }

        return priceSum / count;
    }

    public Integer getTypesCount(){
        // set store only unique values
        HashSet<String> typesSet = new HashSet<String>();

        for(ProductInfo productInfo : this.productInfos) {
            typesSet.add(productInfo.type);
        }
        // So we simple get size of set
        return typesSet.size();
    }
}
