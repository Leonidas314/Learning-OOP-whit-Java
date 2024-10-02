public class main{
    public static void main(String[] args){
        //code here your Java program
        PhoneBook contactos = new PhoneBook();

        contactos.addEntry("Leon", 155520020);
        contactos.addEntry("Matias", 15412323);
        contactos.addEntry("Marcos", 4523542);
        contactos.addEntry("Seba",154222111);
        System.out.println("El numero de Leon es "+contactos.showNumberOf("Leon"));
        contactos.getAllContacts();
        contactos.addEntry("Leon",2222222);
        contactos.addEntry("Luca",2222222);
        //contactos.changePhone("Leon");
        System.out.println("El numero de Leon ahora es :"+contactos.showNumberOf("Leon"));
        contactos.delContact("Seba");
        contactos.getAllContacts();
        System.out.println(contactos.containsKey("Leon"));
        System.out.println(contactos.containsKey("Seba"));
        
    }
}