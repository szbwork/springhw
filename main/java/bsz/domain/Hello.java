package bsz.domain;

/**
 * @author Barna_Szoke
 */
public class Hello {

    public Hello(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println("Your Message : " + message);
    }
    private String message;

}
