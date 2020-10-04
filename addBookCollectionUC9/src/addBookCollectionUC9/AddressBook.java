package addBookCollectionUC9;
import java.util.*;

public class AddressBook {

	 ArrayList<Contact> contact ;



	public AddressBook()
	{
      contact = new ArrayList<Contact>();
	}

 public void setAddressBook(ArrayList<Contact> contact)
 {
     this.contact = contact;
 }

 public ArrayList<Contact> getAddressBook()
 {
   return contact;
 }

	public void addContact(Contact c1)
	{
		contact.add(c1);
	}

 public boolean check_if_contact_exists(String firstName, String lastName)
 {
   if(!contact.isEmpty())
   {
   for(Contact x : contact)
   {
	   if(firstName.equals(x.getFirstName()) && lastName.equals(x.getLastName()))
     {
       return true;
     }
   }
 }
 return false;
}



	public void editContact(Contact c)
   {
   	Iterator iter = contact.iterator();
		  int i=0;
     while (iter.hasNext()) {
       
     	 Contact c1 = (Contact) iter.next();
        if(c.getFirstName().equals(c1.getFirstName()))
        {
        	contact.set(i,c);    	
        	break;
        }
        i+=1;
        
     }
     
   }

   public void delContact(String firstName, String lastName)
   {
	   for(Contact x: contact) {  
	         if(firstName.equals(x.getFirstName()) && lastName.equals(x.getLastName()))
	         {
	         	contact.remove(x);
	         	break;
	         }  
	      }

   }

public void printContact(String firstName)
 {
   
   for(Contact s : contact)
   {
     if(firstName.equals(s.getFirstName()))
     {
       System.out.println("First Name : "+s.getFirstName());
       System.out.println("Last Name : "+s.getLastName());
       System.out.println("Address : "+s.getAddress());
       System.out.println("State: "+s.getState());
       System.out.println("Zip : "+s.getZip());
       System.out.println("Phone Number : "+s.getPhoneNumber());
       System.out.println("Email : "+s.getEmail());
       System.out.println(" ");
     }
   }
 }
}
