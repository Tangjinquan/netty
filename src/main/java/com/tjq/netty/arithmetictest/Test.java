/**
 * =============================================================
 * Copyright 2018 Lianjia Group All Rights Reserved
 * CompanyName: 上海链家有限公司
 * SystemName: 贝壳
 * ClassName: Test
 * version: 1.0.0
 * date: 2018/10/12
 * author: Tyson
 * =============================================================
 */
package com.tjq.netty.arithmetictest;

import io.sentry.Sentry;
import io.sentry.SentryClient;
import io.sentry.SentryClientFactory;
import io.sentry.context.Context;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.net.MalformedURLException;

/**
 * @author Tyson
 * @version V1.0
 * @Description: TODO
 * @date 2018/10/12下午4:13
 */
public class Test {


    private static SentryClient sentry;


    public static void main(String[] args) {
        Sentry.init();

        // You can also manually provide the DSN to the ``init`` method.
        String dsn = "http://5c74f224aaba43269e8e9970a3bd732c@10.241.0.150:9000/3";  //http://bca94fcaa8f64a22bb831200b46eef90:8a7442e0d4ce498ca1845a9150e7e19f@127.0.0.1:9000/4
        Sentry.init(dsn);

        /*
         It is possible to go around the static ``Sentry`` API, which means
         you are responsible for making the SentryClient instance available
         to your code.
         */
        sentry = SentryClientFactory.sentryClient();

        Test myClass = new Test();
        myClass.logWithStaticAPI();
        myClass.logWithInstanceAPI();


    }
    /**
     * An example method that throws an exception.
     */
    void unsafeMethod() {
        throw new UnsupportedOperationException("You shouldn't call this! second");
    }

    /**
     * Examples using the (recommended) static API.
     */
    void logWithStaticAPI() {
        // Note that all fields set on the context are optional. Context data is copied onto
        // all future events in the current context (until the context is cleared).

        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        Sentry.getContext().recordBreadcrumb(
                new BreadcrumbBuilder().setMessage("User made an action").build()
        );

        // Set the user in the current context.
        Sentry.getContext().setUser(
                new UserBuilder().setEmail("jinq.tang001@bkjk.com").build()
        );

        // Add extra data to future events in this context.
        Sentry.getContext().addExtra("extra", "thing");

        // Add an additional tag to future events in this context.
        Sentry.getContext().addTag("tagName", "tagValue");

        /*
         This sends a simple event to Sentry using the statically stored instance
         that was created in the ``main`` method.
         */
        Sentry.capture("This is a second test");

        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry using the statically stored instance
            // that was created in the ``main`` method.
            Sentry.capture(e);
        }
    }

    /**
     * Examples that use the SentryClient instance directly.
     */
    void logWithInstanceAPI() {
        // Retrieve the current context.
        Context context = sentry.getContext();

        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        context.recordBreadcrumb(new BreadcrumbBuilder().setMessage("User made an action").build());

        // Set the user in the current context.
        context.setUser(new UserBuilder().setEmail("jinq.tang001@bkjk.com").build());

        // This sends a simple event to Sentry.
        sentry.sendMessage("This is a second test");

        try {
            unsafeMethod();
        } catch (Exception e) {
            // This sends an exception event to Sentry.
            sentry.sendException(e);
        }
    }
}

//    public static void main(String[] args) {
//
////        int[] arr2=new int[3];
////        for ( int i = 0 ; i <=3 ; i++) {
////            arr2[i] = 0;
////            System.out.println("hello world");
////        }
//        try {
//            File file = new File("/Users/tangjinquan/Desktop/电子对账单.pdf");
//            String recipient = "jinq.tang001@bkjk.com";
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//
//            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
//            body.add("file", new UrlResource(file.toURI()));
//            body.add("subject", "发送单一附件接口");
//            body.add("recipients", recipient);
//            body.add("content", "一封含附件的测试邮件，谢谢查收");
//
//            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);
//            //String serverUrl = "https://email.test.bkjk-inc.com/v1/mails/attachment";
//            String serverUrl = "http://10.241.3.34:8080/v1/mails/attachment";
//            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<APIResult> response = restTemplate.postForEntity(serverUrl, requestEntity, APIResult.class);
//            System.out.println("Response code: " + response.getStatusCode());
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
