package Chapter8;
public class Book {
    private String author;
    private String title;
    private int pages;
    public Book(String bookAuthor, String bookTitle, int bookPages){
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
    }
    //Question 2
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }
    //Question 3
    public void printAuthor(){
        System.out.println(author);
    }
    public void printTitle(){
        System.out.println(title);
    }
    //Question 4
    public int getPages(){
        return pages;
    }
    //Question 5 -- NOT STARTED
}
