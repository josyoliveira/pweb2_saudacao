package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting/time")
    public Greeting greetingTime(@RequestParam(value = "hour", defaultValue = "0") int hour) {
        if (hour >= 12 && hour <= 18) {
            return new Greeting(counter.incrementAndGet(), "Boa Tarde");
        }else if (hour > 18 && hour <= 23) {
            return new Greeting(counter.incrementAndGet(), "Boa Noite");
        } else {
            return new Greeting(counter.incrementAndGet(), "Bom Dia");
        }
    }

    @RequestMapping("/greeting/{code}")
    public Greeting List(@PathVariable(value = "code") int code) {
        ArrayList<String> lista = new ArrayList<String>();

        lista.add("O importante não é vencer todos os dias, mas lutar sempre.");
        lista.add("Maior que a tristeza de não haver vencido é a vergonha de não ter lutado!");
        lista.add("É melhor conquistar a si mesmo do que vencer mil batalhas.");
        lista.add("Quem ousou conquistar e saiu pra lutar, chega mais longe!");
        lista.add("O medo de perder tira a vontade de ganhar.");

        return new Greeting(counter.incrementAndGet(), lista.get(code));
       

    //     if (hour >= 12 && hour <= 18) {
    //         return new Greeting(counter.incrementAndGet(), "Boa Tarde");
    //     }else if (hour > 18 && hour <= 23) {
    //         return new Greeting(counter.incrementAndGet(), "Boa Noite");
    //     } else {
    //         return new Greeting(counter.incrementAndGet(), "Bom Dia");
    //     }
    }
    
}