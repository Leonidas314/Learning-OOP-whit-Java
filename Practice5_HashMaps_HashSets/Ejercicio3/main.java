import java.util.HashMap;

public class main {

    public static void main(String[] args){
        HashMap<Integer, Lot> unSLots;
        //Crear una nueva subasta:

        Auction auction1 = new Auction();

        //Crear nuevas personas
        Person  person1 = new Person("Elon") ;
        Person  person2 = new Person("Davis");
        Person  person3 = new Person("Alvin"); 

        //Crear nuevos lotes

        Lot lot1 = new Lot("White");
        Lot lot2 = new Lot("Black");
        Lot lot3 = new Lot("Green");
        Lot lot4 = new Lot("Red");
        //Agregar los lotes en la subasta

        auction1.enterLot("White");
        auction1.enterLot("Black");
        auction1.enterLot("Green");
        auction1.enterLot("Red");

        //Hacer Ofertas con las personas creadas

        auction1.makeABid(4, person1, 15000);
        auction1.makeABid(1,person2,8000);
        auction1.makeABid(4,person3,12000);
        auction1.makeABid(1,person1,7500);
        auction1.makeABid(4,person3,16000);

        
        //Probar metodos:

        auction1.getLot(1);

        auction1.showLots();

        auction1.getHighestBid(4);

        unSLots = auction1.getUnsold();

        auction1.removeLot(3);

        auction1.showLots();

        auction1.close();
    }
}