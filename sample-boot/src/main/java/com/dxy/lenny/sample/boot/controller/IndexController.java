package com.dxy.lenny.sample.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * @author niele
 * @date 2018/7/6
 */
@Controller
public class IndexController {

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    public static final ThreadLocal<TemplateMode> TEMPLATE_MODE = new ThreadLocal<>();

    @GetMapping(value = "/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/index1")
    public String index1() {
        String content = "<!DOCTYPE html>\n" +
                "<html xmlns:th=\"http://www.thymeleaf.org\">\n" +
                "<head>\n" +
                "    <title>Home page</title>\n" +
                "    <meta charset=\"UTF-8\"/>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<p>\n" +
                "    <span th:text=\"'Today is: ' + ${#dates.format(#dates.createNow(), 'dd MMM yyyy HH:mm')}\"></span>\n" +
                "</p>\n" +
                "</body>\n" +
                "</html>";
        Context context = new Context();

        TEMPLATE_MODE.set(TemplateMode.HTML);
        String result = springTemplateEngine.process(content, context);
        TEMPLATE_MODE.remove();
        return result;
    }
}
