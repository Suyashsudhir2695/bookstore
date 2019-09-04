package com.change.projects.book.common;

import com.change.projects.book.model.Books;
import com.change.projects.book.model.User;
import com.paytm.pg.merchant.CheckSumServiceHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.TreeMap;

public class Common {

    public static final String MID = "<your key here>";
    public static final String INDUSTRY_TYPE_ID = "Retail";
    public static final String CHANNEL_ID = "WEB";
    public static final String WEBSITE = "WEBSTAGING";
    public static final String CALLBACK_URL = "http://localhost:8080/pgresponse";
    public static final String MERCHANT_KEY = "<your key here>";
    public static User currentUser;
    public static Books currentBook;
    public static String generateCheckSum() {
        String checkSum = null;
        String orderId = String.valueOf(System.currentTimeMillis());
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Common.currentUser = userService.findByUsername(auth.getName());

        TreeMap<String, String> paytmParams = new TreeMap<>();

        paytmParams.put("MID", MID);

        /* Find your WEBSITE in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
        paytmParams.put("WEBSITE", WEBSITE);

        /* Find your INDUSTRY_TYPE_ID in your Paytm Dashboard at https://dashboard.paytm.com/next/apikeys */
        paytmParams.put("INDUSTRY_TYPE_ID", INDUSTRY_TYPE_ID);

        /* WEB for website and WAP for Mobile-websites or App */
        paytmParams.put("CHANNEL_ID", CHANNEL_ID);

        /* Enter your unique order id */
        paytmParams.put("ORDER_ID", orderId);

        /* unique id that belongs to your customer */
        paytmParams.put("CUST_ID","test@ggg");


        paytmParams.put("TXN_AMOUNT", "100");

        /* on completion of transaction, we will send you the response on this URL */
        paytmParams.put("CALLBACK_URL", CALLBACK_URL);

        try {
            checkSum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(MERCHANT_KEY, paytmParams);
            paytmParams.put("CHECKSUMHASH", checkSum);
            //model.addAttribute("CHECKSUMHASH", checkSum);
            System.out.println(checkSum);

        } catch (Exception e) {

        }
        return checkSum;

    }


}
