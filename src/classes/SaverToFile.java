/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.History;
import entity.Reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Melnikov
 */
public class SaverToFile {
    private FileOutputStream fos = null;//память не выделена, только название
    private ObjectOutputStream oos = null;//сохраняет обьект, обертка fos
    FileInputStream fileInputStream = null;
    ObjectInputStream objectInputStream = null;
    
    public void saveBooks(List<Book> listBooks){
        try {
            fos = new FileOutputStream("Books.txt");//aссоциируем с файлом
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listBooks);//передаем лист и выдаем возможные ошибки
            oos.flush();//запись
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);//обрабатываем ошибки
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        }finally {//выполняется в любом случае, предназначен для освобождения ресурсов, памяти
            try {
                oos.close();
                fos.close();//уничтожаем память, связь прекращаем
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
    }
    public void saveReaders(List<Reader> listReaders){
         try {
        fos = new FileOutputStream("Readers.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listReaders);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        }finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
    }
        
    
    public void saveHistories(List<History> listHistories){
         try {
            fos = new FileOutputStream("Histories.txt");//aссоциируем с файлом
            oos = new ObjectOutputStream(fos);
            oos.writeObject(listHistories);//передаем лист и выдаем возможные ошибки
            oos.flush();//запись
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: " + ex);//обрабатываем ошибки
        } catch (IOException ex) {
            System.out.println("Ошибка ввода/вывода. Ошибка: " + ex);
        }finally {//выполняется в любом случае, предназначен для освобождения ресурсов, памяти
            try {
                oos.close();
                fos.close();//уничтожаем память, связь прекращаем
            } catch (IOException ex) {
                System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
        
    }
    
    public List<Book> loadListBooks(){
        List<Book> listBooks = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("Books.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listBooks =(List<Book>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex);
        } catch (IOException ex) {
            System.out.println("Файл не прочитан. Ошибка: "+ ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс: "+ ex);
        } finally {
            try {
               if(fileInputStream != null){
                  fileInputStream.close();
               }
               if(objectInputStream !=null){
                  objectInputStream.close();
               }
            } catch (IOException ex) {
               System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
        return listBooks;
    }
    public List<Reader> loadListReaders(){//при запуске программы
        List<Reader> listReaders = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("Readers.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listReaders =(List<Reader>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex);
        } catch (IOException ex) {
            System.out.println("Файл не прочитан. Ошибка: "+ ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс: "+ ex);
        } finally {
            try {
               if(fileInputStream != null){
                  fileInputStream.close();
               }
               if(objectInputStream !=null){
                  objectInputStream.close();
               }
            } catch (IOException ex) {
               System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
        return listReaders;
    }
    public List<History> loadListHistories(){
        List<History> listHistories = new ArrayList<>();
        try {
            fileInputStream = new FileInputStream("Readers.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            listHistories =(List<History>) objectInputStream.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден. Ошибка: "+ ex);
        } catch (IOException ex) {
            System.out.println("Файл не прочитан. Ошибка: "+ ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Не найден класс: "+ ex);
        } finally {
            try {
               if(fileInputStream != null){
                  fileInputStream.close();
               }
               if(objectInputStream !=null){
                  objectInputStream.close();
               }
            } catch (IOException ex) {
               System.out.println("Ресурсы освободить не удалось: "+ex);
            }
        }
        return listHistories;
    }
}
