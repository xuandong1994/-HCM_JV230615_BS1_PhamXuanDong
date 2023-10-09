package ra.bussinessImp;

import ra.bussiness.IBook;

import java.util.Scanner;

public class Book implements IBook,Comparable<Book> {
    public static Scanner scanner =new Scanner(System.in);
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private Boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, float importPrice, float exportPrice, float interest, Boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public Boolean getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Mời nhập mã sách : ");
        this.bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mời nhập tên sách : ");
        this.bookName = scanner.nextLine();
        System.out.println("Mời nhập tiêu đề sách : ");
        this.title = scanner.nextLine();
        System.out.println("Mời nhập số trang sách : ");
        this.numberOfPages = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Mời nhập giá nhập : ");
        this.importPrice = scanner.nextFloat();
        scanner.nextLine();
        System.out.println("Mời nhập giá xuất : ");
        this.exportPrice = scanner.nextFloat();
        this.interest = this.exportPrice-this.importPrice;
        System.out.println("Lợi nhuận của sách là : " +getInterest());
        scanner.nextLine();
        System.out.println("Mời nhập trạng thái sách : ");
        this.bookStatus = scanner.nextBoolean();
    }



    @Override
    public void displayData() {
        System.out.println(
                "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", importPrice=" + importPrice +
                ", exportPrice=" + exportPrice +
                ", interest=" + interest +
                ", bookStatus=" +( bookStatus? "còn sách":"hết sách" )+
                '}');
    }

    @Override
    public int compareTo(Book o) {
        return (int)(this.interest - o.interest);
    }
}
