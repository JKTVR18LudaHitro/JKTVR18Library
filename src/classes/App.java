/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author melnikov
 */
public class App {
    List<Book> listBooks = new ArrayList<>();
    List<Reader> listReaders = new ArrayList<>();
    SaverToFile saverToFile = new SaverToFile();
    List<History> listHistories = new ArrayList<>();
    
    public App() {
        listBooks.addAll(saverToFile.loadListBooks());
        listReaders.addAll(saverToFile.loadListReaders());
        listHistories.addAll(saverToFile.loadListHistories());
    }
    
    public void run(){

        Scanner scanner = new Scanner(System.in);
        String operation = "0";
        boolean badOperation;
        
       
        
        HistoryProvider historyProvider = new HistoryProvider();
        
        do{
            do{
                System.out.println("Выберите операцию:");
                System.out.println("0. Выход");
                System.out.println("1. Добавить книгу");
                System.out.println("2. Добавить читателя");
                System.out.println("3. Выдать книгу");
                System.out.println("4. Вернуть книгу");
                System.out.println("5. Список книг");
                System.out.println("6. Список читателей");
                
                badOperation = false;
                operation = scanner.next();
                switch (operation) {
                    case "0":
                        badOperation = false;
                        break;
                    case "1":
                        BookProvider bookProvider = new BookProvider();
                        Book book = bookProvider.createBook();
                        if(book == null){
                            System.out.println("Книгу создать не удалось.");
                        }else{
                            listBooks.add(book);
                            saverToFile.saveBooks(listBooks);
                            System.out.println("Добавлена новая книга.");
                        }
                        break;
                    case "2":
                        ReaderProvider readerProvider = new ReaderProvider();
                        Reader reader = readerProvider.createReader();
                        if(reader == null){
                            System.out.println("Читателя добавить не удалось.");
                        }else{
                            listReaders.add(reader);
                            saverToFile.saveReaders(listReaders);
                            System.out.println("Добавлен новый читатель.");
                        }
                        break;
                    case "3":
                        
                        History history = historyProvider.createHistory(listBooks, listReaders);
                        if(history == null){
                            System.out.println("Не удалось выдать книгу.");
                        }else{
                            listHistories.add(history);
                            saverToFile.saveHistories(listHistories);
                            System.out.println("Книга выдана читателю.");
                        }
                        break; 
                    case "4":
                        historyProvider.returnBook(listHistories);
                         listHistories.add(history);
                         saverToFile.saveHistories(listHistories);
                        System.out.println("Книга возвращена в библиотеку");
                        break;
                    case "5":
                        System.out.println("---- Список книг ----");
                        for(Book b : listBooks){
                            System.out.println(b.toString());
                        }
                        break;
                    case "6":
                        System.out.println("---- Список читателей ----");
                        for(Reader r : listReaders){
                            System.out.println(r.toString());
                        }
                        break;
                    default:
                        System.out.println("Неправильная операция!");
                        System.out.println("Выберите правильную операцию");
                        badOperation = true;
                }
            }while(badOperation);
            if(operation.equals("0"))break;
            
        }while(true);
        
//        Book book = new Book();
//        book.setId(1L);
//        book.setTitle("Voina i mir");
//        book.setAuthor("L.Tolstoy");
//        book.setYear(2010);
//        System.out.println(book.getId());
//        System.out.println(book.getTitle());
//        System.out.println(book.getAuthor());
//        System.out.println(book.getYear());
//        System.out.println("Вывод метода toString(): ");
//        System.out.println(book.toString());
//        
//        Book book2 = new Book(2L, "Otsi i deti", "I.Turgenev", 2011);
//        System.out.println(book2.toString());
//        
//        book.setYear(2012);
//        System.out.println(book.toString());
//        
//        Reader reader = new Reader(1L, "Ivan", "Ivanov", 10, 10, 2000);
//        System.out.println(reader.toString());
//                
//        System.out.println("Выдача книги:");
//        History history = new History();
//        history.setId(1L);
//        history.setBook(book);
//        history.setReader(reader);
//        history.setTakeOnDate(new Date());
//        System.out.println(history.toString());
//        System.out.println("Возврат книги:");
//        history.setReturnDate(new Date());
//        System.out.println(history.toString());

    }
}
