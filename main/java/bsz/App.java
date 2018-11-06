package bsz;

import bsz.domain.User;
import bsz.service.UserServiceImp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloBean");
//        helloWorld.printHello();

       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml");

//        UserDao userDao = (UserDao) context
//                .getBean("userDao");


        UserServiceImp userService;
        userService = (UserServiceImp) context.getBean("userService");

        User user3 = userService.createNewUser("f3", "l3", "e3" );
        userService.save(user3);
        List<User> userList = new ArrayList<>(userService.getAll());
        System.out.println(userList.get(2).getFirstName() + " " + userList.get(2).getLastName());


//        mainMenu.start();

        context.close();

    }
}
