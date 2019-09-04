package com.change.projects.book.controller;

import com.change.projects.book.common.Common;
import com.change.projects.book.model.Books;
import com.change.projects.book.model.Cart;
import com.change.projects.book.model.User;
import com.change.projects.book.service.BookService;
import com.change.projects.book.service.CartService;
import com.change.projects.book.service.UserServiceImpl;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.hibernate.resource.beans.container.internal.CdiBeanContainerImmediateAccessImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@RestController
public class Cont {

    public static final String MID = "<your key here>";
    public static final String INDUSTRY_TYPE_ID = "Retail";
    public static final String CHANNEL_ID = "WEB";
    public static final String WEBSITE = "WEBSTAGING";
    public static final String CALLBACK_URL = "http://localhost:8080/transaction/pgresponse";
    public static final String WALLET_CALLBACK_URL = "http://localhost:8080/transaction/wallet/pgresponse";
    public static final String MERCHANT_KEY = "<your key here>";
    public static final String CS = Common.generateCheckSum();

    @Autowired
    BookService service;

    @Autowired
    UserServiceImpl userService;
    @Autowired
    CartService cartService;

    @RequestMapping("/")
    public ModelAndView getBooks(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        List<Books> books = service.getAllBooks();
        System.out.println(books);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());
       if (Common.currentUser != null){
           model.addAttribute("user", Common.currentUser);
       }

        model.addAttribute("books", books);


        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping("/admin/new")
    public ModelAndView newNook(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Books books = new Books();
        model.addAttribute("book", books);
        modelAndView.setViewName("newBook");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/save", method = RequestMethod.POST)
    public ModelAndView saveBook(@ModelAttribute("book") Books books) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveBook(books);
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping("/admin/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchBookList(@RequestParam(value = "search", required = false) String term, Model model) {
        List<Books> searchList = null;
        ModelAndView modelAndView = new ModelAndView();

        try {

            searchList = service.findBooksByName(term);


        } catch (Exception e) {
            // e.printStackTrace();

        }
        System.out.println(searchList);

        model.addAttribute("search", searchList);
        modelAndView.setViewName("searchres");
        return modelAndView;

    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    ModelAndView home(Model model) {
        ModelAndView modelAndView = new ModelAndView();

        //model.addAttribute()
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        model.addAttribute("user", user);
        System.out.println("This is User " + user);
        Common.currentUser = user;
        System.out.println(Common.currentUser.getUsername());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUsername(auth.getName());
        if (Common.currentUser != null){
            model.addAttribute("user", user);
            modelAndView.setViewName("redirect:/home");
        }
        else {


            System.out.println("This is User " + user);
            modelAndView.setViewName("login");
        }
        return modelAndView;

    }


//
//    @RequestMapping()
//    public ModelAndView home(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByUsername(auth.getName());
//        System.out.println("This is user"+ user);
////        modelAndView.addObject("userName", "Welcome " + user.getUsername());
////        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//        modelAndView.setViewName("home");
//        return modelAndView;
    //   }

    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        for (Cookie cookie : request.getCookies()) {
            cookie.setMaxAge(0);
        }

        return "logout";
    }

    @RequestMapping("/access-denied")
    public ModelAndView accesDesnied() {
        ModelAndView md = new ModelAndView();
        md.setViewName("404");
        return md;
    }

    @RequestMapping("/details/{id}")
    ModelAndView getDetails(@PathVariable(name = "id") int id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());

        Books book = service.getBook(id);
        Common.currentBook = book;
        System.out.println(Common.currentBook.getName());
        model.addAttribute("user", Common.currentUser);
        modelAndView.addObject("book", book);

        modelAndView.setViewName("details");
        return modelAndView;

    }

    @RequestMapping(value = "/buildCart", method = RequestMethod.POST)
    ModelAndView buildcart(@RequestParam("qty") int qty,  Model model) {
        ModelAndView modelAndView = new ModelAndView();
        Cart cart = new Cart();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());

        cart.setUsername(Common.currentUser.getUsername());
        cart.setProductname(Common.currentBook.getName());
        cart.setProductid(Common.currentBook.getId());
        cart.setPrice(Common.currentBook.getPrice());

        cart.setImage(Common.currentBook.getImage());

        if (cartService.ifExists(Common.currentUser.getUsername(), Common.currentBook.getId()) == 1) {
            cartService.update(Common.currentUser.getUsername(), Common.currentBook.getId(), qty);
        } else {
            cart.setQty(qty);
            cartService.save(cart);
        }



        System.out.println(Common.currentUser.getUsername() + "         " + Common.currentBook.getName());


        model.addAttribute("message", "Success");
        model.addAttribute("alertClass", "alert-success");
        modelAndView.addObject("added","true");

        modelAndView.setViewName("redirect:/details/" + Common.currentBook.getId());

        return modelAndView;


    }

    @RequestMapping(value = "/home/cart", method = RequestMethod.GET)
    ModelAndView showCart(Model model,@RequestParam(value = "em", required = false) String em) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());
        List<Cart> cart = cartService.getCart(Common.currentUser.getUsername());
        model.addAttribute("cartSize" ,cart.size());
        model.addAttribute("user", Common.currentUser);



      if (cart.size() != 0 ){
          model.addAttribute("cart", cart);



          float total = (float) cartService.getTotal(Common.currentUser.getUsername());
          int cartCount = cartService.getCartCount(Common.currentUser.getUsername());



          model.addAttribute("cnt",cartCount);

          model.addAttribute("total", total);
          model.addAttribute("rt",CS);


          model.addAttribute("errorMsg",em);
      }
      else{
          System.out.println("cart is empty");



      }


        modelAndView.setViewName("cart");


        return modelAndView;
    }

//    @RequestMapping("/error")
//    ModelAndView showwhiteerror() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("404");
//        return modelAndView;
//
//    }

//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }

    @RequestMapping(value = "/home/cart/checkout/process", method = RequestMethod.POST)
    public ModelAndView processPayment(HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
        TreeMap<String, String> paytmParams = new TreeMap<>();
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());

        String orderId = String.valueOf(System.currentTimeMillis());
        String cs = "";
        StringBuilder sb = null;

        float total = (float) cartService.getTotal(Common.currentUser.getUsername());
        paytmParams.put("CALLBACK_URL",CALLBACK_URL);
        paytmParams.put("CHANNEL_ID",CHANNEL_ID);
        paytmParams.put("CUST_ID",Common.currentUser.getId().toString());
        paytmParams.put("EMAIL","testt@gmail.com");
        paytmParams.put("INDUSTRY_TYPE_ID",INDUSTRY_TYPE_ID);
        paytmParams.put("MID",MID);
        paytmParams.put("MOBILE_NO","4558852");
        paytmParams.put("ORDER_ID",orderId);
        paytmParams.put("TXN_AMOUNT",String.valueOf(total));
        paytmParams.put("WEBSITE",WEBSITE);


        String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, paytmParams);


        model.addAttribute("CALLBACK_URL",CALLBACK_URL);
        model.addAttribute("CHANNEL_ID",CHANNEL_ID);
        model.addAttribute("CUST_ID",String.valueOf(Common.currentUser.getId()));
        model.addAttribute("EMAIL","testt@gmail.com");
        model.addAttribute("INDUSTRY_TYPE_ID",INDUSTRY_TYPE_ID);
        model.addAttribute("MID",MID);
        model.addAttribute("MOBILE_NO",4558852);
        model.addAttribute("ORDER_ID", orderId);
        model.addAttribute("TXN_AMOUNT",String.valueOf(total));
        model.addAttribute("WEBSITE",WEBSITE);
        model.addAttribute("CHECKSUMHASH",checkSum);
        // model.addAllAttributes(paytmParams);


        modelAndView.setViewName("processPayment");
        return modelAndView;


    }




    @RequestMapping(value = "/home/wallet/checkout/process", method = RequestMethod.POST)
    public ModelAndView processWalletPayment(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("inputWalletBal") double amout) throws Exception {
        TreeMap<String, String> paytmParams = new TreeMap<>();
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());

        String orderId = String.valueOf(System.currentTimeMillis());
        String cs = "";
        StringBuilder sb = null;

//        float total = (float) cartService.getTotal(Common.currentUser.getUsername());
        paytmParams.put("CALLBACK_URL",WALLET_CALLBACK_URL);
        paytmParams.put("CHANNEL_ID",CHANNEL_ID);
        paytmParams.put("CUST_ID",Common.currentUser.getId().toString());
        paytmParams.put("EMAIL","testt@gmail.com");
        paytmParams.put("INDUSTRY_TYPE_ID",INDUSTRY_TYPE_ID);
        paytmParams.put("MID",MID);
        paytmParams.put("MOBILE_NO","4558852");
        paytmParams.put("ORDER_ID",orderId);
        paytmParams.put("TXN_AMOUNT",String.valueOf(amout));
        paytmParams.put("WEBSITE",WEBSITE);


        String checkSum =  CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, paytmParams);


        model.addAttribute("CALLBACK_URL",WALLET_CALLBACK_URL);
        model.addAttribute("CHANNEL_ID",CHANNEL_ID);
        model.addAttribute("CUST_ID",String.valueOf(Common.currentUser.getId()));
        model.addAttribute("EMAIL","testt@gmail.com");
        model.addAttribute("INDUSTRY_TYPE_ID",INDUSTRY_TYPE_ID);
        model.addAttribute("MID",MID);
        model.addAttribute("MOBILE_NO",4558852);
        model.addAttribute("ORDER_ID", orderId);
        model.addAttribute("TXN_AMOUNT",String.valueOf(amout));
        model.addAttribute("WEBSITE",WEBSITE);
        model.addAttribute("CHECKSUMHASH",checkSum);
        // model.addAllAttributes(paytmParams);


        modelAndView.setViewName("processPayment");
        return modelAndView;


    }

    public boolean isValidCheckSum() {
        boolean isValideChecksum = false;

        String paytmChecksum = "";

        Map<String, String> mapData = new  TreeMap<String,String>();
       // mapData.put("CHECKSUMHASH",generateCheckSum());

        TreeMap<String, String> paytmParams = new  TreeMap<String,String>();

        for (Map.Entry<String, String> entry : mapData.entrySet())
        {
            if(entry.getKey().equals("CHECKSUMHASH")){
                paytmChecksum = entry.getKey();
            }else{
                paytmParams.put(entry.getKey(), entry.getValue());
            }
        }



        try{

            isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(MERCHANT_KEY, paytmParams, paytmChecksum);

            System.out.println("This is paytm checksum"+ paytmChecksum);

            System.out.println(isValideChecksum);


            // if checksum is validated Kindly verify the amount and status
            // if transaction is successful
            // kindly call Paytm Transaction Status API and verify the transaction amount and status.
            // If everything is fine then mark that transaction as successful into your DB.


        }catch(Exception e){
            e.printStackTrace();
        }

        return isValideChecksum;

    }


    @ResponseBody
    @RequestMapping(value = "transaction/pgresponse")
    public ModelAndView getResponseRedirect(HttpServletRequest request, Model model) {
        Enumeration<String> paramNames = request.getParameterNames();
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());
        if (Common.currentUser != null){
            model.addAttribute("user",Common.currentUser);
        }

        Map<String, String[]> mapData = request.getParameterMap();
        TreeMap<String,String> parameters = new TreeMap<String,String>();
        String paytmChecksum =  "";
        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            if(paramName.equals("CHECKSUMHASH")){
                paytmChecksum = mapData.get(paramName)[0];
            }else{
                parameters.put(paramName,mapData.get(paramName)[0]);
            }
        }
        boolean isValideChecksum = false;
        String outputHTML="";
        try{
            isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(MERCHANT_KEY,parameters,paytmChecksum);
            if(isValideChecksum && parameters.containsKey("RESPCODE")){
                if(parameters.get("RESPCODE").equals("01")){
                    outputHTML = parameters.toString();
                }else{
                    outputHTML="<b>Payment Failed.</b>";
                }
            }else{
                outputHTML="<b>Checksum mismatched.</b>";
            }
        }catch(Exception e){
            outputHTML=e.toString();

        }
        System.out.println(outputHTML);
        model.addAttribute("errorMsg","true");

        String respMsg = parameters.get("STATUS");
        String orderId = parameters.get("ORDERID");
        String amount = parameters.get("TXNAMOUNT");
        String date = parameters.get("TXNDATE");
        String finalDate = date.substring(0,11);
        if (respMsg.equalsIgnoreCase("TXN_SUCCESS")){
            model.addAttribute("orderid", orderId);
            model.addAttribute("amt", amount);
            model.addAttribute("date", finalDate);
            cartService.clearCart(Common.currentUser.getUsername());

            modelAndView.setViewName("orderConfirmationPage");
        }
        else {
            modelAndView.addObject("em","true");

            modelAndView.setViewName("redirect:/home/cart");

        }







        return modelAndView;
    }





    @ResponseBody
    @RequestMapping(value = "transaction/wallet/pgresponse")
    public ModelAndView getWALLETResponseRedirect(HttpServletRequest request, Model model) {
        Enumeration<String> paramNames = request.getParameterNames();
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Common.currentUser = userService.findByUsername(auth.getName());
        if (Common.currentUser != null){
            model.addAttribute("user",Common.currentUser);
        }

        Map<String, String[]> mapData = request.getParameterMap();
        TreeMap<String,String> parameters = new TreeMap<String,String>();
        String paytmChecksum =  "";
        while(paramNames.hasMoreElements()) {
            String paramName = (String)paramNames.nextElement();
            if(paramName.equals("CHECKSUMHASH")){
                paytmChecksum = mapData.get(paramName)[0];
            }else{
                parameters.put(paramName,mapData.get(paramName)[0]);
            }
        }
        boolean isValideChecksum = false;
        String outputHTML="";
        try{
            isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(MERCHANT_KEY,parameters,paytmChecksum);
            if(isValideChecksum && parameters.containsKey("RESPCODE")){
                if(parameters.get("RESPCODE").equals("01")){
                    outputHTML = parameters.toString();
                }else{
                    outputHTML="<b>Payment Failed.</b>";
                }
            }else{
                outputHTML="<b>Checksum mismatched.</b>";
            }
        }catch(Exception e){
            outputHTML=e.toString();

        }
        System.out.println(outputHTML);
        model.addAttribute("errorMsg","true");

        String respMsg = parameters.get("STATUS");
        String orderId = parameters.get("ORDERID");
        String amount = parameters.get("TXNAMOUNT");
        String date = parameters.get("TXNDATE");
        double amt = Double.parseDouble(amount) + Double.parseDouble(Common.currentUser.getWallet());
        String finalDate = date.substring(0,11);
        if (respMsg.equalsIgnoreCase("TXN_SUCCESS")){
            model.addAttribute("orderid", orderId);
            model.addAttribute("amt", amount);
            model.addAttribute("date", finalDate);
           userService.updateWallet(String.valueOf(amt),Common.currentUser.getUsername());

            modelAndView.setViewName("redirect:/home");
        }
        else {
            modelAndView.addObject("em","true");

            modelAndView.setViewName("redirect:/home");

        }







        return modelAndView;
    }





}
