package com.example.readnew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Author: cpzh
 * @Date: 2018/2/1 21:46
 * TODO:
 */
@Controller
@RequestMapping("/")
public class ReadingListController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AmazonProperties amazonProperties;

    @RequestMapping(method = RequestMethod.GET)
    public String readerBooks(Reader reader, Model model){
        List<Book> bookList = bookRepository.findByReader(reader.getUsername());
        if(bookList != null){
            model.addAttribute("books", bookList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "/readingList";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book){
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/";
    }
}
