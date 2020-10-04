package com.practice.addBookCollectionUC8;
import java.util.*;
import java.util.stream.Collectors;
public class AddressBookMain {

	  public static String get_book_name()
	  {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the name of the address book");
	    String bookName = sc.nextLine();
	    return bookName;
	  }

	  public static Contact Console_Input()
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

	     Contact c = new Contact(fname,lname,address,state,zip,phno,email);
	     return c;
	  }
	public static void main(String args[])
	{  
      HashMap<String, AddressBook> AddressBookList = new  HashMap<String, AddressBook>();
      AddressBook ab;
      ArrayList<Contact> cl;
      Scanner sc = new Scanner(System.in);
      int option,count;
      String fname,lname,address,state,email,bookName="";
      long zip,phno;
      boolean check;
      Contact c;
      while(true)
       {
       	System.out.println("Choose : ");
       	System.out.println("1. Create a AddressBook\n 2. Add contact \n3. Edit contact \n4. Delete Contact"
       			+ "\n5. Seach contacts based on state \n6. Print AddressBook \n7. Exit");

       	option = Integer.parseInt(sc.nextLine());

        if(option == 1)
        {  
          bookName = get_book_name();
          AddressBookList.put(bookName,new AddressBook());
          System.out.println("A new AddressBook with name "+bookName+" is created succesfully");
        }

       	else if(option == 2)
       	{
          bookName = get_book_name();
          if(AddressBookList.containsKey(bookName)){
            ab = (AddressBook) AddressBookList.get(bookName);
            c = Console_Input();
            check = ab.check_if_contact_exists(c.getFirstName());
            if(check)
            {
              System.out.println("A person already exists with the same FirstName,Duplicate entry not allowed!");
            }
            else
            {
            ab.addContact(c);
            System.out.println("Contact added succesfully to the AddressBook "+bookName);
            }
          }
          else
          {
            System.out.println("No AddressBook exists with the name "+bookName);
          }
          
       	}

       	else if(option == 3)
       	{

          bookName = get_book_name();
          if(AddressBookList.containsKey(bookName)){
            ab = (AddressBook) AddressBookList.get(bookName);
            System.out.println("Enter the First Name of the Contact to be edited");
            fname = sc.nextLine();
            check = ab.check_if_contact_exists(fname);
            if(check)
           {
             ab.editContact(Console_Input());
             AddressBookList.replace(bookName,ab);
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
          if(AddressBookList.containsKey(bookName)){
            ab = (AddressBook) AddressBookList.get(bookName);
            System.out.println("Enter the First Name of the Contact to be edited");
            fname = sc.nextLine();
            check = ab.check_if_contact_exists(fname);
            if(check)
           {
             ab.delContact(fname);
             AddressBookList.replace(bookName,ab);
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
          if(!AddressBookList.isEmpty())
          {
          System.out.println("Enter the name of the state");
          state = sc.nextLine(); 
          for(HashMap.Entry<String, AddressBook> entry : AddressBookList.entrySet()) {
          AddressBook value = entry.getValue();
          cl = value.getAddressBook();
          System.out.println("The list of people in the state "+state+" :");
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
           System.out.println("Enter the name of the address book");
           bookName = sc.nextLine(); 
           if(AddressBookList.containsKey(bookName)){
            ab = (AddressBook) AddressBookList.get(bookName); 
            cl = ab.getAddressBook();
            System.out.println("The contacts in the address book "+bookName+" are :");
            for(Contact cc : cl)
            {
               ab.printContact(cc.getFirstName());
            }
         }
         else
         {
          System.out.println("No AddressBook exists with the name "+bookName);
         }
       	}

       	else if(option == 7)
       	{
       		break;
       	}

       }
	   	 
	}
}
