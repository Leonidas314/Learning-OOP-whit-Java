/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.ArrayList;
public class StockManager
{
    //atributo de la clase StockManager

    private HashMap<Integer,Product> stockMap;    
    //Constructor del Objeto Clase StockManager
    public StockManager(){
        stockMap = new HashMap<>();
    }
    /*
     * @pre Id's of the product to add does'n must exist already in stockMAnager
     * @post item are added to stock.
     */
    public void addProduct(Product item)
    {   
            stockMap.put(item.getID() , item);            
    }
    
    /**
     * @post Update the associated product's quantity with id adding the input amount 
     */
    public void delivery(int id, int amount)
    {
        Product productToModified;
        productToModified=stockMap.get(id);
        productToModified.increaseQuantity(amount);
        stockMap.put(id, productToModified);
    }
    
    /**
     * @post Return the associated product to input id
     */
    public Product findProduct(int id)
    {   
        System.out.println((stockMap.get(id)).getName());
        return stockMap.get(id);
    }
    
    /**
     *@post Return the quantity of products by id
     */
    public int numberInStock(int id)
    {
        return (stockMap.get(id)).getQuantity();
    }

    /*
     * @post Returns a HashSet of the finded products by name input
     */
    public HashSet findProductByName(String name){
        HashSet<Product> findedProducts = new HashSet<>();
        for(Map.Entry<Integer, Product> currentProduct: stockMap.entrySet()){
            if(name.equals((currentProduct.getValue()).getName())){
                findedProducts.add(currentProduct.getValue());
            }
        }
        if(findedProducts.size()>0){
            for(Product findedProd : findedProducts ){
                System.out.println(findedProd.toString()); 
            }
        }
        return findedProducts;

    }

    /**
     * @post Shows details of al productos in stock
     */
    public void printProductDetails()
    {
       for(Map.Entry<Integer,Product> currentProduct : stockMap.entrySet()){
            System.out.println(currentProduct.toString()); 
       }
    }

    /*
     * @pre passed value must be under of at leats one quantity of some product in the stock
     * @post Returns an arraylist of productos with less quantity than passed value
     */
    public  ArrayList stockBelowThan(int value){
        ArrayList arrayProduct= new ArrayList<>();
        for(Map.Entry<Integer, Product> currentEntry : stockMap.entrySet()){
            if((currentEntry.getValue().getQuantity()) < value){
                arrayProduct.add(currentEntry.getValue());
            }
        }
        return arrayProduct;
    }

}
