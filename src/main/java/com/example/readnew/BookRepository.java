package com.example.readnew;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author: cpzh
 * @Date: 2018/2/1 21:39
 * TODO:
 */
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByReader(Reader reader);
    List<Book> findByReader(String reader);

}
