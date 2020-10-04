package addBookCollectionUC6;
import java.util.*;

public class AddressBook {




	 ArrayList<Contacts> contact ;



	public AddressBook()
	{
      contact = new ArrayList<Contacts>();
	}

 public void setAddressBook(ArrayList<Contacts> contact)
 {
     this.contact = contact;
 }

 public ArrayList<Contacts> getAddressBook()
 {
   return contact;
 }

	public void addcont(Contacts c1)
	{
		contact.add(c1);
	}

 public boolean check_if_contact_exists(String fname)
 {
   if(!contact.isEmpty())
   {
   for(Contacts s : contact)
   {
     if(fname.equals(s.getFirstName()))
     {
       return true;
     }
   }
 }

   return false;
 }


	public void editcont(Contacts c)
   {
   	Iterator iter = contact.iterator();
		  int i=0;
     while (iter.hasNext()) {
       
     	 Contacts c1 = (Contacts) iter.next();
        if(c.getFirstName().equals(c1.getFirstName()))
        {
        	contact.set(i,c);    	
        	break;
        }
        i+=1;
        
     }
     
   }

   public void delcont(String firstName)
   {
   	Iterator iter = contact.iterator();
		int i=0;
     while (iter.hasNext()) {
       
     	Contacts c = (Contacts) iter.next();
  
     	
        if(firstName.equals(c.getFirstName()))
        {
        	contact.remove(i);
        	break;
        }
        i+=1;
        
     }

   }

public void printcont(String firstName)
 {
   
   for(Contacts s : contact)
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
