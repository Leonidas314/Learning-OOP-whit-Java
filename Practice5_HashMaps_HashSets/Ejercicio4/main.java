import java.util.HashMap;

public class main{
     public static void main(String[] args){

          StockManager stockMan1 = new StockManager();
          System.out.println("Hola");
          
          Product product1 = new Product(1,"cargador");
          Product product2 = new Product(2,"auriculares");
          Product product3 = new Product(3,"mouse");
          Product product4 = new Product(4,"notebook");
          Product product5 = new Product(5,"notebook");
          Product product6 = new Product(6,"notebook");
          Product product7 = new Product(7,"notebook");   

          stockMan1.addProduct(product1);
          stockMan1.addProduct(product2);
          stockMan1.addProduct(product3);
          stockMan1.addProduct(product4);
          stockMan1.addProduct(product5);
          stockMan1.addProduct(product6);
          stockMan1.addProduct(product7);
          stockMan1.findProduct(3);//This works 
          stockMan1.printProductDetails();//This works
          stockMan1.delivery(6, 10);
          stockMan1.findProductByName("notebook");
          

     }

}