package ra.run;

import ra.bussinessImp.Book;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookManagement  {
    public static List<Book> listBook  = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát");
            System.out.println("Mời nhập các chức năng từ 1-7");
             choice = Integer.parseInt(scanner.nextLine());
             switch (choice){
                 case 1:
                     System.out.println("Mời nhập số lượng sách : ");
                     int quantity = Integer.parseInt(scanner.nextLine());
                     for (int i = 0; i < quantity; i++) {
                         System.out.println("Sách phần tử thứ " + (i+1) + "là :");
                         Book book = new Book();
                         book.inputData();
                         listBook.add(book);
                     }
                     break;
                 case 2:
                     System.out.println("Hiển thị thông tin sách : ");
                     listBook.forEach(Book::displayData);
                     break;
                 case 3:
                     System.out.println("Sắp xếp sách theo lợi nhuận giảm dần ");
                     listBook.sort(Comparator.comparing(Book::getInterest).reversed());
                     break;
                 case 4:
                     System.out.println("Mời nhập mã cần xóa");
                     int idBook = Integer.parseInt(scanner.nextLine());
                     List<Book> deleteBook = listBook.stream().filter(a->a.getBookId()==idBook).toList();
                     listBook.remove(deleteBook.get(0));
                     break;
                 case 5:
                     System.out.println("Mời nhập tên sách : ");
                     String nameBook = scanner.nextLine();
                     listBook.stream().filter(a->a.getBookName().equals(nameBook)).forEach(Book::displayData);
                     break;
                 case 6:
                     System.out.println("Mời nhập mã sách : ");
                     int idBook1 = Integer.parseInt(scanner.nextLine());
                     listBook.stream().filter(a->a.getBookId()==idBook1).forEach(a->a.setBookStatus(!a.getBookStatus()));
                     break;
                 case 7:
                     scanner.close();
                     System.exit(0);
                     break;
                 default:
                     System.err.println("Nhập không đúng, vui lòng nhập từ 1-7");
             }

        }while (choice != 7);
    }

}
