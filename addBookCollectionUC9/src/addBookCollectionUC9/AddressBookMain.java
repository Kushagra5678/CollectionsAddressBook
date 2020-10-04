package addBookCollectionUC9;
import java.util.*;
public class AddressBookMain {
	public static String get_book_name()
	  {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the name of address book");
	    String bookName = sc.nextLine();
	    return bookName;
	  }

	  public static Contact Enter_Details()
	  {
	     Scanner sc = new Scanner(System.in);
	     System.out.println("Enter First Name: ");
	     String fname = sc.nextLine();
	     System.out.println("Enter Last Name: ");
	     String lname = sc.nextLine();
	     System.out.println("Enter the Address: ");
	     String address = sc.nextLine();
	     System.out.println("Enter the State: ");
	     String state = sc.nextLine();
	     System.out.println("Enter Zip code: ");
	     String zip = sc.nextLine();
	     System.out.println("Enter the Phone Number");
	     String phno = sc.nextLine();
	     System.out.println("Enter Email address: ");
	     String email = sc.nextLine();

	     Contact c = new Contact(fname, lname, address, state, zip, phno, email);
	     return c;
	  }
	public static void main(String args[])
	{  
	  Scanner sc = new Scanner(System.in);
      HashMap<String, AddressBook> AddressBookDirectory = new  HashMap<String, AddressBook>();
      HashMap<String, ArrayList<String>> statemap = new HashMap<String,ArrayList<String>>();
      AddressBook ab;
      ArrayList<Contact> cl;      
      ArrayList<String> al;
      int option,count;
      String fname,state,bookName="";
      boolean check;
      Contact c;
      while(true)
       {
       	System.out.println("Menu: ");
       	System.out.println("1. Create new AddressBook\n2. Add contact\n3. Edit contact\n4.Delete Contact"
       			+ "\n5. Search contact based on state\n6. View Contact Based on state\n 7.Print a AddressBook"
       			+ "\n8. Exit");

       	option = Integer.parseInt(sc.nextLine());

        if(option == 1)
        {  
          bookName = get_book_name();
          AddressBookDirectory.put(bookName,new AddressBook());
          System.out.println("AddressBook with name "+bookName+" is created succesfully!!!");
        }

       	else if(option == 2)
       	{
          bookName = get_book_name();
          if(AddressBookDirectory.containsKey(bookName))
          {
        	  ab = (AddressBook) AddressBookDirectory.get(bookName);
              c = Enter_Details();
              check = ab.check_if_contact_exists(c.getFirstName(), c.getLastName());
              if(check)
            	  System.out.println("A person already exists with the same Name, Duplicate entry is not allowed!");
              else
              {
            	 if(!statemap.isEmpty())
            	 {
            		if(statemap.containsKey(c.getState()))
            		{
            			al = statemap.get(c.getState());
            			al.add(c.getFirstName());
            			statemap.replace(c.getState(),al);
            		}
            		else
            		{
            			ArrayList<String> ll = new ArrayList<String>();
            			ll.add(c.getFirstName());
            			statemap.put(c.getState(),ll);
            		}
            	}
            	else
            	{
            		ArrayList<String> ll = new ArrayList<String>();
            		ll.add(c.getFirstName());
            		statemap.put(c.getState(),ll);
            	}
            	ab.addContact(c);
            	System.out.println("Contact added succesfully to the AddressBook "+bookName);
            }
          }
          else
          	System.out.println("AddressBook does not exists with the name "+bookName);
          
       }

       	else if(option == 3)
       	{

          bookName = get_book_name();
          if(AddressBookDirectory.containsKey(bookName))
          {
        	  ab = (AddressBook) AddressBookDirectory.get(bookName);
        	  System.out.println("Enter the Name of the Person whose contact is to be edited");
        	  fname = sc.nextLine();
        	  String[] x = fname.split(" ");
        	  check = ab.check_if_contact_exists(x[0], x[1]);
        	  if(check)
        	  {
        		  ab.editContact(Enter_Details());
        		  AddressBookDirectory.replace(bookName,ab);
        		  System.out.println("Details Edited Succesfully");
        	  }

        	  else
        		  System.out.println("No Contact Exists with that First Name");
          }
          else
          	  System.out.println("No AddressBook exists with the name "+bookName);
       	}

       	else if(option == 4)
       	{
          bookName = get_book_name();
          if(AddressBookDirectory.containsKey(bookName)){
            ab = (AddressBook) AddressBookDirectory.get(bookName);
            System.out.println("Enter the Name of the Person whose contact is to be deleted:");
            fname = sc.nextLine();
            String[] x = fname.split(" ");
            check = ab.check_if_contact_exists(x[0], x[1]);
            if(check)
           {
             ab.delContact(x[0], x[1]);
             AddressBookDirectory.replace(bookName,ab);
             System.out.println("Contact Deleted Succesfully");
           }

           else
           {
               System.out.println("No Contact Exists with that First Name");
           }
          }
          else
          {
            System.out.println("No AddressBook exists with the name "+bookName);
          }

       	}

       	
        else if(option == 5)
        {
          if(!AddressBookDirectory.isEmpty())
          {
          System.out.println("Enter the name of the state");
          state = sc.nextLine(); 
          System.out.println("The list of people in the state "+state+" :");
          for(HashMap.Entry<String, AddressBook> entry : AddressBookDirectory.entrySet()) {
          AddressBook value = entry.getValue();
          cl = value.getAddressBook();  
          for(Contact cc : cl)
          {
               if(cc.getState().equals(state))
               {
                System.out.println(cc.getFirstName());
               }
          }
        }
      }
      else
      {
        System.out.println("No AddressBooks are added yet.");
      }
      }
        else if(option == 6)
        {
          System.out.println("Enter the name of the state");
          state = sc.nextLine(); 
          if(!statemap.isEmpty())
          {
          for(HashMap.Entry<String, ArrayList<String>> entry : statemap.entrySet()) {
            if(state.equals((String)entry.getKey()))
            {              
            ArrayList<String> value = entry.getValue();
            for(String str : value)
            {
              System.out.println(str);
            }
            }
        }
      }
          else
          {
           System.out.println("No person is from the given state");
          }
        }

       	else if(option == 7)
       	{
           System.out.println("Enter the name of the address book");
           bookName = sc.nextLine(); 
           if(AddressBookDirectory.containsKey(bookName)){
        	   ab = (AddressBook) AddressBookDirectory.get(bookName); 
        	   cl = ab.getAddressBook();
        	   System.out.println("The contacts in the address book "+bookName+" are :");
        	   for(Contact cc : cl)
        	   {
        		   ab.printContact(cc.getFirstName());
        	   }
            }
            else
            	System.out.println("No AddressBook exists with the name "+bookName);
       	 }

       	 else if(option == 8)
       		break;
       } 	 
	}

  
}
