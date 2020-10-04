package addBookCollectionUC6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AddressBookMain {
	  public static String get_book_name()
	  {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the name of the address book");
	    String bookName = sc.nextLine();
	    return bookName;
	  }

	  public static Contacts Console_Input()
	  {
	     Scanner sc = new Scanner(System.in);
	     System.out.println("Enter First Name");
	     String fname = sc.nextLine();
	     System.out.println("Enter Last Name");
	     String lname = sc.nextLine();
	     System.out.println("Enter Address");
	     String address = sc.nextLine();
	     System.out.println("Enter State");
	     String state = sc.nextLine();
	     System.out.println("Enter Zip");
	     String zip = sc.nextLine();
	     System.out.println("Enter Phone Number");
	     String phno = sc.nextLine();
	     System.out.println("Enter Email");
	     String email = sc.nextLine();

	     Contacts c = new Contacts(fname, lname, address, state, zip, phno, email);
	     return c;
	  } 
	public static void main(String args[])
	{  
      HashMap<String, AddressBook> addressBook = new  HashMap<String, AddressBook>();
      AddressBook ab;
      ArrayList<Contacts> cl;
      Scanner sc = new Scanner(System.in);
      int option,count;
      String fname, bookName="";
      boolean check;
      while(true)
       {
       	System.out.println("Choose : ");
       	System.out.println("1. Create a AddressBook\n2. Add Contact\n3. Edit Contact \n4. Delete Contact"
       			+ "\n5. Print AddressBook\n6. Exit");
       	option = Integer.parseInt(sc.nextLine());
        if(option == 1)
        {  
          bookName = get_book_name();
          addressBook.put(bookName,new AddressBook());
          System.out.println("A new AddressBook with name "+bookName+" is created succesfully");
        }

       	else if(option == 2)
       	{
          bookName = get_book_name();
          if(addressBook.containsKey(bookName)){
            ab = (AddressBook) addressBook.get(bookName);
            ab.addcont(Console_Input());
            System.out.println("Contact added succesfully to the AddressBook "+bookName);
          }
          else
          {
            System.out.println("No AddressBook exists with the name "+bookName);
          }
          
       	}

       	else if(option == 3)
       	{

          bookName = get_book_name();
          if(addressBook.containsKey(bookName)){
            ab = (AddressBook) addressBook.get(bookName);
            System.out.println("Enter the First Name of the Contact to be edited");
            fname = sc.nextLine();
            check = ab.check_if_contact_exists(fname);
            if(check)
           {
             ab.editcont(Console_Input());
             addressBook.replace(bookName,ab);
             System.out.println("Details Edited Succesfully");
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

       	else if(option == 4)
       	{
          bookName = get_book_name();
          if(addressBook.containsKey(bookName)){
            ab = (AddressBook) addressBook.get(bookName);
            System.out.println("Enter the First Name of the Contact to be edited");
            fname = sc.nextLine();
            check = ab.check_if_contact_exists(fname);
            if(check)
           {
             ab.delcont(fname);
             addressBook.replace(bookName,ab);
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
           System.out.println("Enter the name of the address book");
           bookName = sc.nextLine(); 
           if(addressBook.containsKey(bookName)){
            ab = (AddressBook) addressBook.get(bookName); 
            cl = ab.getAddressBook();
            System.out.println("The contacts in the address book "+bookName+" are :");
            for(Contacts c : cl)
            {
               ab.printcont(c.getFirstName());
            }
         }
         else
         {
          System.out.println("No AddressBook exists with the name "+bookName);
         }
       	}

       	else if(option == 6)
       	{
       		break;
       	}

       }
	   	 
	}



}


