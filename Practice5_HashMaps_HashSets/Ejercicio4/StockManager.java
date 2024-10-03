/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 */
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
public class StockManager
{
    private HashMap<Integer, Product> stockManag;
    /**
     * @post A StockManager is created.
     */
    public StockManager()
    {
        HashMap stockManag = new HashMap<>();
    }

    /**
     * @pre Id's of the product to add does'n must exist already in stockMAnager
     * @post item are added to stock.
     */
    public void addProduct(Product item)
    {   
        if (!stockManag.containsKey(item.getID())) {
            stockManag.put(item.getID() , item);            
        }

    }
    
    /**
     * @post Update the associated product's quantity with id adding the input amount 
     */
    public void delivery(int id, int amount)
    {
        Product productToModified;
        productToModified=stockManag.get(id);
        productToModified.increaseQuantity(amount);
        stockManag.put(id, productToModified);
    }
    
    /**
     * @post Return the associated product to input id
     */
    public Product findProduct(int id)
    {
        return stockManag.get(id);
    }
    
    /**
     *@post Return the quantity of products by id
     */
    public int numberInStock(int id)
    {
        return (stockManag.get(id)).getQuantity();
    }

    /**
     * @post Shows details of al productos in stock
     */
    public void printProductDetails()
    {
       for(Map.Entry<Integer,Product> currentProduct : stockManag.entrySet()){
            currentProduct.toString();
       }
    }

    /*
     * @pre passed value must be under of at leats one quantity of some product in the stock
     * @post Returns an arraylist of productos with less quantity than passed value
     */
    public  ArrayList stockBelowThan(int value){
        ArrayList arrayProduct= new ArrayList<>();
        for(Map.Entry<Integer, Product> currentEntry : stockManag.entrySet()){
            if((currentEntry.getValue().getQuantity()) < value){
                arrayProduct.add(currentEntry.getValue());
            }
        }
        return arrayProduct;
    }
}
