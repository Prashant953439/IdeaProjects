package dev.prashant.myfirstspringproject20thfeb;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyfirstAPI {


    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello Prashant";
    }
    @RequestMapping("/hello/{nameOfPerson}")
    public String sayHelloToAPerson(@PathVariable("nameOfPerson")String nameOfPerson)
    {
        return "Hello " + nameOfPerson;
    }
}


// http://url-of-my-server/hello/rohan