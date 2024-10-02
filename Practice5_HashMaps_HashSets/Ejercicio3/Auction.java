import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/**
 * Clase que modela una subasta
 */
public class Auction
{   
    //Cambiar de ArrayList a un HashMap
   // private ArrayList<Lot> lots;
    private HashMap<Integer , Lot> lots;
    /**
     * @post Una subasta es creada. Que puedo almacenar en un HAsMap que sea conveniente para la subasta?
     */
    public Auction()
    {
        //lots = new ArrayList<>();
        lots = new HashMap<>();
    }

    /**
     * @post Un nuevo lote es agregado a la subasta.
     */
    public void enterLot(String description)
    {
        //lots.add(new Lot(lots.size()+1, description));
        lots.put(lots.size()+1,new Lot(description));
    }

    /**
     * @post Todos los lotes son mostrados.
     */
    public void showLots()
    {
        for (Map.Entry<Integer, Lot> lot : lots.entrySet())
            System.out.println(lot.getKey()+"=>"+lot.getValue());
    }
    
    /**
     * @pre 0 < lotNNumber <= lots.size()
     * @post Una oferta por el lote es realizada. 
     */
    public boolean makeABid(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = lots.get(lotNumber);
        Bid bid = new Bid(bidder, value);
        return selectedLot.bidFor(bid);
    }

    /**
     * @pre 0 < lotNumber <= lots.size()
     * @post El lote con el número deseado es devuelto.
     */

    public Lot getLot(int clave){
        return lots.get(clave);
    }
    /*
    //////////////METODO OBSOLETO AL REFACTORIZAR CON HASHMAP
    public Lot getLot(int lotNumber)
    {
        return lots.get(lotNumber-1);
    }
   
     * @post La subasta está cerrada y los lotes vendidos son mostrados por pantalla.
     */
    public void close() {
        //implementar este método
        for (Map.Entry<Integer,Lot> currentLot : lots.entrySet()){
            if((currentLot.getValue()).getHighestBid() != null){
                System.out.println("Lote número "+ currentLot.getKey() + " vendido.");
                System.out.println("Descripcion del lote: "+ (currentLot.getValue()).getDescription());
            }
                //lots.remove(currentLot);
        }
        lots.remove(this);
        System.out.println("Subasta terminada");
    }
    
    /**
     * @pre 0 < lotNumber <= lots.size()
     * @post La oferta ganadora para el lote 'lotNumber' es retornada.
     */
    public long getHighestBid(int lotNumber) {
        
        Lot currentLot  = lots.get(lotNumber);
        Bid currentBid = currentLot.getHighestBid();
        long currentValue= currentBid.getValue();
        return currentValue;
         //return null; //TODO: implementar este método
        }
    
    /**
     * @post Una lista con todos los lotes sin vender es devuelta.
     * //Debo refactorizar el ArrayList de lotes no vendidos en un HashMap
     */
    public HashMap<Integer , Lot> getUnsold() {
        HashMap unsoldLots = new HashMap<>();
        for(Map.Entry<Integer, Lot> currentLot : lots.entrySet()){
            if((currentLot.getValue()).getHighestBid()==null){
                unsoldLots.put(currentLot.getKey(),currentLot.getValue());
            }
        }
        printUnsoldLots(unsoldLots);
        return unsoldLots;
    }


    
    /**
     * @pre Number of unsold Lost > 0
     * @post Print unsold lots and details 
     */
    public void printUnsoldLots(HashMap<Integer,Lot> unlots){
        for(Map.Entry<Integer,Lot> lot : unlots.entrySet()){
            System.out.println("Lote numero " + lot.getKey() + " sin vender");
            System.out.println("Descripcion " + (lot.getValue()).getDescription());
        }
    }
    
    /**
     * @pre 0 < lotNumber <= lots.size()
     * @post El lote con el número 'lotNumber' ha sido eliminado, este lote es retornado.
     */
     /* 
    ///////METODO OBSOLETO , UTILIZAR REMOVE CON HASHMAP
    public Lot removeLot(int lotNumber) {
        if(lots.size() > 0 && lotNumber <= lots.size()){
            for (Lot currentLot : lots){
                if(currentLot.getNumber() == lotNumber){
                    lots.remove(currentLot);
                }
            }
        }
        return null;
    }
     */
    public void removeLot(int lotNumber){
        lots.remove(lotNumber);
    System.out.println("Lote numero "+lotNumber+" fuera de subasta.");
    }
}
