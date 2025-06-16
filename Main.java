import java.util.*;
import manager.*;
import model.*;

public class Main 
{
    private static int bookId;

    public static void main(String[] args)
    {
        try (Scanner sc = new Scanner(System.in)) {
            LibraryManager library=new LibraryManager() ;
            LoginManager l=new LoginManager();
            
            User currentUser=null;
            while(currentUser==null)
            {
                System.out.println("1.login");
                System.out.println("2.Register");
                System.out.println("3.Exit");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    System.out.println("Enter your username");
                    String username=sc.next();
                    System.out.println("Enter your password");
                    String password=sc.next();
                    currentUser=l.login(username,password,library.getAllUsers());
                    if(currentUser==null)
                    {
                        System.out.println("Invalid username or password,Try Again");
                    }
                }
                else if(choice==2)
                {
                    System.out.println("Enter your name");
                    String name=sc.next();
                    System.out.println("Enter your username");
                    String username=sc.next();
                    System.out.println("Enter your password");
                    String password=sc.next();
                    int userId=1000+new Random().nextInt(9000);
                    User newUser=new User(userId,name,username,password,false);
                    library.addUser(newUser);
                    System.out.println("User Registered Successfully, Please goto login page to access your account");
                }
                else if(choice==3)
                {
                    System.out.println("Goodbye!...");
                    return ;
                }
                else 
                {
                    System.out.println("Invalid choice,Try Again");
                }
            }
              System.out.println("Welcome:"+currentUser.getname());
            int choice;
            do
            {
                System.out.println("==========MENU=========");
                if(currentUser.getisAdmin())
             {
                System.out.println("1.Add Book");
                System.out.println("2.View Book");
                System.out.println("3.View User");
                System.out.println("4.Logout");
                
                
                choice=sc.nextInt();
                if(choice==1)
                {
                    System.out.println("Book Title:");
                     String title=sc.nextLine();
                    System.out.println("Book Author:");
                    String author=sc.nextLine();
                    System.out.println("Book Publisher:");
                    String publisher=sc.nextLine();
                    System.out.println("Book Year:");
                    int year=sc.nextInt();
                    System.out.println("Copies:");
                    int copies=sc.nextInt();
                    int bookId=1000+new  Random().nextInt(9000);
                    Book newBook=new Book(bookId,title,author,publisher,year,copies,0);
                    library.addBook(newBook);
                    System.out.println();
                    System.out.println("Book Added Successfully");
                }
                else if(choice==2)
                {
                    System.out.println("=====Book List=====");
                    library.viewAllBooks();
                }
                else if(choice==3)
                {
                    System.out.println("=====User List=====");
                    ArrayList<User> users=library.getAllUsers();
                    for(User u:users)
                    {
                     String role;
                        if(u.getisAdmin())
                        {
                            role="Admin";
                        }
                        else{
                            role="User";
                        }
                        System.out.println(u.getUserId()+":"+u.getname()+":"+"Role:"+role);
                    }
                }
                else if(choice==4)
                {
                    System.out.println("=====GoodBye!!=====");
                    break;
                }
               
                else
                {
                    System.out.println("Invalid Choice,Try Again");
                }

             } else{
                System.out.println("1.View book");
                System.out.println("2.Searh book");
                System.out.println("3.Borrow book"); 
                System.out.println("4.Return book");
                System.out.println("5.MyBorrow book");
                System.out.println("logout");
                choice=sc.nextInt();
                if(choice==1){
                    System.out.println("........Book list......");
                     library.viewAllBooks();
                   }else if(choice==2){
                     System.out.println("Keyword");
                     String keyword=sc.nextLine();
                     library.searchBookByTitle(keyword);
                   }else if(choice==3){
                     System.out.println("Book Id:");
                     library.borrowBook(bookId, currentUser.getUserId());
                   }else if(choice==4){
                     System.out.println("Book ID:");
                     int bookId=sc.nextInt();
                     library.returnBook(bookId, currentUser.getUserId());
                   }else if(choice==5){
                    currentUser.ShowBorrowedBooks();
                   }else if(choice==6){
                     System.out.println("......Loged out");
                   }else{
                    System.out.println("Invalid choice ,try again ");
                   }

            }
            }while(true);
            sc.close();
        }
        }

    }