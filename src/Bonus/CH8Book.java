package Bonus;
public class CH8Book {
    private final String author;
    private final String title;
    private final int pages;
    private String refNumber;
    private int borrowed;
    private final boolean courseText;
    public CH8Book(String bookAuthor, String bookTitle, int bookPages, boolean isTextbook){
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
        borrowed = 0;
        courseText = isTextbook;
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
    //Question 5, Modded for Q7 & Q9
    public void printDetails(){
        /* Question 5:
            System.out.println("Title: " + title + "\nAuthor: " + author + "\nPages: " + pages);
        */
        /* Question 7:
            String out = "Title: " + title + "\nAuthor: " + author + "\nPages: " + pages + "\nRef Number: ";
            if (refNumber.length() <= 0){
                out += refNumber;
            } else {
                out += "ZZZ";
            }
            System.out.println(out);
        */
        String out = "Title: " + title + "\nAuthor: " + author + "\nPages: " + pages + "\nRef Number: ";
        if (refNumber.length() <= 0) out += refNumber;
        else out += "ZZZ";
        System.out.println(out + "\nTimes Borrowed: " + borrowed);
    }
    //Question 6, Modded for Q8
    public void setRefNumber(String ref){
        /* Question 6
            refNumber = ref;
        */
        if (ref.length() >= 3) refNumber = ref;
        else System.out.println("Error! Reference Number is too short!");
    }
    public String getRefNumber(){
        return refNumber;
    }
    //Question 9
    public void borrow(){
        borrowed += 1;
    }
    public int getBorrwed(){
        return borrowed;
    }
    //Question 10
    public boolean isCourseText(){
        return courseText;
    }
}
