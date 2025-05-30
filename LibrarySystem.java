package project;


import java.util.ArrayList;
import java.util.List;
import java.util.*;



class Library{
  private List<User> usersList = new ArrayList<>();
  private List<Book> booksList = new ArrayList<>();
 
  
  public Library(){
   // System.out.println("Here is the library");
  }
  
  
  public void addNewBook(Book book){
    if(!booksList.contains(book)){
      booksList.add(book);
    }else{
      System.out.println("The book already found\n");
    }
  }
  
  
  public void delBook(Book book){
    if(booksList.contains(book)){
      booksList.remove(book);
   //   System.out.println("Deleted\n");
    }else{
      System.out.println("Book not found\n");
    }
  }
  
  
  public void printAvailableBooks(){
  if(booksList != null && !booksList.isEmpty()){
    System.out.println("Available books : \n");
     int count = 1;
    for(Book book : booksList){
        System.out.println("Book ["+count+"] ->");
        book.printBookInfo();
        System.out.println();
        count++; 
    }
    }else{
      System.out.println("The list is empty\n");
    }
  }
  
  
  public Book searchBook(Book book){
    for(Book search : booksList){
      if(search.equals(book)){
        return search ;
      }
    }
    System.out.println("Book not found\n");
    return null ;
  }
  
  
  public void addNewUser(User user){
    if(!usersList.contains(user)){
      usersList.add(user);
    }else{
      System.out.println("User already found");
    }
  }
  
  
  
}







 class Book extends Library { 
  private String title , author ;
  private int isbn;
  private boolean isAvailable;
   
  public Book(){
  //  isAvailable = true;
  }
  
  
  
  public Book(String title , String author , int isbn ){
    this.title = title; 
    this.author = author; 
    this.isbn = isbn;
    this.isAvailable = true;
  }
  
 
  public void printBookInfo(){ 
    System.out.println("\tTitle : "+title);
    System.out.println("\tAuthor : "+author);
    System.out.println("\tBook Id : "+isbn);
  }
  
  
  public void setTitle(String title){
    this.title = title; 
  }
  
  
  public String getTitle(){
    return title; 
  }
  
  
  public void setAuthor(String author){
    this.author = author; 
  }
  
  
  public String getAuthor(){
    return author; 
  }
  
  
  public void setIsbn(int isbn){
    this.isbn = isbn;
  }
  
  
  public int getIsbn(){
    return isbn;
  }
  
  
  public void setIsAvailable( boolean isAvailable){
    this.isAvailable = isAvailable;
  }
  
  
  public boolean getIsAvailable(){
    return isAvailable;
  }
}








class User extends Library{
  private String name;
  private int userId;
  private List<Book> borrowedBooks = new ArrayList<>();
  //private Library book = new Book();
  
  
  public User(){
    //System.out.println("user's constructor");
  }
  
  
  public User(String name , int userId ){
    this.name = name;
    this.userId = userId;
  }
  
  
  public void BorrowABook(Book book){
  
    if(book.getIsAvailable()){
    
       borrowedBooks.add(book); 
       book.setIsAvailable(false);
       System.out.println("The book has been added\n");
    }else{
      System.out.println("OOPS! Book not available\n");
    }
  }
  
  
  public void ReturnABook(Book book){
    if(borrowedBooks.contains(book)){
       borrowedBooks.remove(book);
       book.setIsAvailable(true);
       System.out.println("The book has been returned\n");
       }else{
         System.out.println("You didn't borrow this book\n");
       }
       
  }
  
  
  public void printBorrowedBooks(){
  if(borrowedBooks != null && !borrowedBooks.isEmpty()){
  System.out.println("Borrowed Books : \n");
    int count = 1;
    for(Book book : borrowedBooks){
      System.out.println("Book ["+count+"] ->");
      book.printBookInfo();
      System.out.println();
      count++; 
    }
    }else{
      System.out.println("The list is empty\n");
    }
  }
  
  
  public void setName(String name){
    this.name = name;
  }
 
  
  public String getName(){
    return name;
  }
  
  
  public void setUserId(int userId){
    this.userId = userId;
  }
 
  
  public int getUserId(){
    return userId;
  }
  
  
}



public class Main {
    public static void main(String[] args) {
   List <Library> libraryMenu = new ArrayList<>();  
     
     User Anees = new User("Anees",1);
     User user = new User();
     Library library = new Library();
     library.addNewUser(Anees);
     
     Book B1 = new Book("The Wretched","Vector Hugo",1);
     library.addNewBook(B1);
     library.delBook(B1);
     
     library.printAvailableBooks();
     
     
     library.searchBook(B1);
     user.BorrowABook(B1);
     
     user.printBorrowedBooks();
     
     library.searchBook(B1);
     user.ReturnABook(B1);
     
     return ;
    }
}
