package com.dxy.lenny.sample.boot;

import javax.servlet.annotation.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * Hello world!
 */

@SpringBootApplication
@ServletComponentScan
@WebServlet
public class SampleBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SampleBootApplication.class, args);
    }
}
