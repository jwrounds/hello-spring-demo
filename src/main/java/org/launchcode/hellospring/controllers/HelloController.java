package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {


    public static String createMessage(String name, String language) {
        String greeting = switch (language) {
            case "french" -> "Bonjour, ";
            case "spanish" -> "Hola, ";
            case "german" -> "Hallo, ";
            case "italian" -> "Ciao, ";
            default -> "Hello, ";
        };
        return greeting + name + "!";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language) {
        return createMessage(name, language);
    }

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language' >" +
                "<option value='french'>French</option>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
