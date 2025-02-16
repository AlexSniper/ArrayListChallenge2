package alex.leaernprogramming;

import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact>myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts=new ArrayList<Contact>();//initializing array list
    }
    public  boolean addNewContact (Contact contact){
        if(findContact(contact.getName())>=0) {//if name already exist than it will be not added
            System.out.println("Contact is already on file ");
            return false;
        }
        myContacts.add(contact);
        return true;
    }
    public boolean updateContact ( Contact oldContact, Contact newContact){
        int foundPosition= findContact(oldContact);    //   if   contact wasn't found it will return message
                                                       // that contact wasn't found
        if (foundPosition<0){
            System.out.println(oldContact.getName()+" , was not found");
            return false;
        }else if (findContact(newContact.getName()) !=-1){
            System.out.println(" Contact with name  "+ newContact.getName()+ " already exist." +
                    " Update  was not successful");
            return false;
        }
        this.myContacts.set(foundPosition,newContact);// if contact was found it would replace with a new contact name
        System.out.println(oldContact.getName()+" , was replaced with "+ newContact.getName());
        return true;
    }

    public  boolean removeContact (Contact contact){
        int foundPosition= findContact(contact);
        if (foundPosition<0) {                                          //if  contact wasn't found i will write
                                                                        // 'contact wasn't found
            System.out.println(contact.getName() + " , was not found");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println( contact.getName()+" was deleted");
        return true;
    }
    private int findContact( Contact contact){
        return this.myContacts.indexOf(contact);
    }
    private int findContact(String contactName) {
        for (int i=0;i<this.myContacts.size();i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }
    public String queryContact(Contact contact){
        if (findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact (String name){
        int position = findContact(name);
        if (position>=0) {
            return this.myContacts.get(position);
        }
        return null;
    }
    public void printContacts(){
        System.out.println(" Contacts List ");
        for ( int i =0; i<this.myContacts.size();i++){
            System.out.println((i+1)+" . "+ this.myContacts.get(i).getName()+" ->"+
                    this.myContacts.get(i).getPhoneNumber());
        }
    }
}
