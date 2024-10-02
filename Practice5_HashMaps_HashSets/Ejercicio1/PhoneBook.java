import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;
public class PhoneBook{ //Class declaration
    //atributes
    private String name;
    private int number;

    //Object Constructor    
    HashMap<String, Integer> PhoneBook = new HashMap<>();

    //methods
    //Inserts a new contact to the collection with Key name , Value number
    public void addEntry(String name , int number){
        PhoneBook.put(name, number);
    }
    //Given a name, allows to change the phone number with an input
    public void changePhone(String name){
        System.out.println("Ingrese el nuevo numero de "+ name);
        Scanner input = new Scanner(System.in);
        int newNumber = input.nextInt();
        PhoneBook.put(name, newNumber);
    }
    //dado un nombre remueve el contacto de la agenda
    public void delContact(String name){
        PhoneBook.remove(name);
    }

    //Con un iterador sobre el hashmap PhoneBook muestra todos los contactos y almacena los nombre en un HashSet de tipo String

    public HashSet getAllContacts(){
        //Iterar sobre un hashmap, es decir, sobre pares <key , valor>
        //for(Element Type element : collection) donde nuestro Element Type es una Map.Entry<K , V>
        //Y nuestra collection es un HashMap
        HashSet<String> contactSet = new HashSet<>();
        System.out.println("Los contactos insertados el en Set son:");
        for (Map.Entry<String, Integer> Entry : PhoneBook.entrySet()) {
            System.out.println(Entry.getKey()+"=>"+Entry.getValue());
            contactSet.add(Entry.getKey());
            
        }
        System.out.println("Hay "+ contactSet.size()+" contactos en la agenda");
        return contactSet;
    }


    //Given a name, shows the associated name
    public int showNumberOf(String name){
        return PhoneBook.get(name);//Returns the value of the associated key
    }

    public boolean containsKey(String name){
        return PhoneBook.containsKey(name);
    }
}   