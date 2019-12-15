package ro.jademy.librarymgmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintBooks
{

    public static void printBookTable(ArrayList<Book> bookList)
    {

        for (int i = 0; i < bookList.size(); i++)
        {

            System.out.printf("| " + (i + 1) + "." + "|" +
                    bookList.get(i).getAuthor() + "%" +
                    (30 - bookList.get(i).getAuthor().length()) + "s" +
                    bookList.get(i).getTitle() + "%" +
                    (50 - bookList.get(i).getTitle().length()) +
                    "s" + bookList.get(i).getGenre() + "%" +
                    (20 - bookList.get(i).getGenre().length()) +
                    "s" + bookList.get(i).getPublisher() + "%" +
                    (30 - bookList.get(i).getPublisher().length()) + "s" +
                    bookList.get(i).getIsbn() + "%" +
                    (15 - bookList.get(i).getIsbn().length()) + "s", "|", "|", "|", "|", "|\n");


        }
    }

    public static void printBookTable(ArrayList<Book> bookList, HashMap<String,String> stockList)
    {

        int author = 0;
        int title = 0;
        int genre = 0;
        int publisher = 0;
        int isbn = 0;
        int stock = 3; //stockList.get(0).getStock().length();

        for (Book book : bookList)
        {
            if (book.getAuthor().length() > author)
            {
                author = book.getAuthor().length();
            }
            if (book.getTitle().length() > title)
            {
                title = book.getTitle().length();
            }
            if (book.getGenre().length() > genre)
            {
                genre = book.getGenre().length();
            }
            if (book.getPublisher().length() > publisher)
            {
                publisher = book.getPublisher().length();
            }
            if (book.getIsbn().length() > isbn)
            {
                isbn = book.getIsbn().length();
            }
        }

        int lengthLine = 3 + 3 + author + 3 + title + 3 + genre + 3 + publisher + 3 + isbn + 3 + stock + 3 + 12;

        printDashes(lengthLine);
        System.out.println(String.format("%-3s %-3s %-" + author + "s %-3s %-" + title + "s %-3s %-" + genre + "s %-3s %-" + publisher + "s %-3s %-" + isbn + "s %" + stock + "s %-1s",
                "No", "|", "Author", "|", "Book name", "|", "Genre", "|", "Publisher", "|", "ISBN", "|", "Stock", "|"));
        printDashes(lengthLine);

        int i=0;
        for (int j = 0; j < bookList.size(); j++)
        {
            for (Map.Entry element : stockList.entrySet())
            {


                if (bookList.get(j).getIsbn().equals(element.getKey()))
                {

                    System.out.println(String.format("%-3s %-3s %-" + author + "s %-3s %-" + title + "s %-3s %-" + genre + "s %-3s %-" + publisher + "s %-3s %-" + isbn + "s %" + stock + "s %-1s", i + 1,
                            "|", bookList.get(j).getAuthor(), "|", bookList.get(j).getTitle(), "|", bookList.get(j).getGenre(),
                            "|", bookList.get(j).getPublisher(), "|", element.getKey(), "|", element.getValue(), "|"));
                    break;
                }



            }
            i++;
        }
        printDashes(lengthLine);
        System.out.println(String.format("%-3s %-3s %-" + author + "s %-3s %-" + title + "s %-3s %-" + genre + "s %-3s %-" + publisher + "s %-3s %-" + isbn + "s %" + stock + "s %-1s",
                "No", "|", "Author", "|", "Book name", "|", "Genre", "|", "Publisher", "|", "ISBN", "|", "Stock", "|"));
        printDashes(lengthLine);


    }

    public static void printDashes(int number)
    {

        String dash = "";

        for (int i = 0; i < number; i++)
        {
            dash = dash + "-";
        }
        System.out.println(dash);

    }


}
