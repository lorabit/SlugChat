package main.java.kidschat.api.controller;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.inject.Inject;
import main.java.kidschat.api.annotations.TestAnnotation;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lorabit on 2017/10/1.
 */
@RestController
public class GreetingController{
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @Inject
    public String home(@TestAnnotation String res) throws ExecutionException, InterruptedException{
        return Futures.immediateFuture(res).get();
    }
}
