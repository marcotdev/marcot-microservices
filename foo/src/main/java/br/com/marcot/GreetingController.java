package br.com.marcot;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

     @RequestMapping(value ="/greeting")
    public Greeting greeting(
            @RequestParam(value="name", defaultValue="World")
            String name) {
         return new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
}
