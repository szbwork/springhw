package bsz.service;

import org.springframework.stereotype.Service;

/**
 * Created by szb on 10/23/18.
 */
@Service("helloWorldService")
public class HelloWorldService {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String sayHello() {
        return "Hello! " + name;
    }
}