package com.change.projects.book.controller;

import com.change.projects.book.model.Books;
import com.change.projects.book.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class BooksController {
//    @Autowired
//    BookService service;
//    @Autowired
//    //SearchService serachService;
//
//    @RequestMapping("/")
//    public ModelAndView getBook(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        List<Books> books = service.getAllBooks();
//        System.out.println(books);
//
//
//
//        model.addAttribute("books", books);
//
//        modelAndView.setViewName("index");
//
//        return modelAndView;
//    }
//
//    @RequestMapping("/new")
//    public ModelAndView newNook(Model model) {
//        ModelAndView modelAndView = new ModelAndView();
//        Books books = new Books();
//        model.addAttribute("book", books);
//        modelAndView.setViewName("newBook");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/save", method = RequestMethod.POST)
//    public ModelAndView saveBook(@ModelAttribute("book") Books books) {
//        ModelAndView modelAndView = new ModelAndView();
//        service.saveBook(books);
//        modelAndView.setViewName("redirect:/");
//        return modelAndView;
//    }
//
//    @RequestMapping("/delete/{id}")
//    public ModelAndView deleteProduct(@PathVariable(name = "id") int id) {
//        service.delete(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/search", method = RequestMethod.GET)
//    public ModelAndView searchBookList(@RequestParam(value = "search", required = false) String term, Model model){
//        List<Books> searchList = null;
//        ModelAndView modelAndView = new ModelAndView();
//
//        try{
//
//            searchList = service.findBooksByName(term);
//
//
//        }
//
//        catch(Exception e){
//           // e.printStackTrace();
//
//        }
//        System.out.println(searchList);
//
//        model.addAttribute("search", searchList);
//        modelAndView.setViewName("searchres");
//        return modelAndView;
//
//    }
//
//    @Autowired
//
//
//    @RequestMapping("/home")
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("home");
//        return modelAndView;
//    }

}
