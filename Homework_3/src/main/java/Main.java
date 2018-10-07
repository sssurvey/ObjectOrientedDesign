import tableLamp.bulb.Lightbulb;
import tableLamp.control.Button;

public class Main {

    public static void main(String[] args) {

        Lightbulb lightbulb1 = new Lightbulb();
        Button buttonToLightbulb1 = new Button(lightbulb1);

        //turn bulb
        buttonToLightbulb1.flipTheSwitch(); //switch to ON
        System.out.println("lightbulb1's current Status ---> " + lightbulb1.getStatus());
        System.out.println("button1's current Status ---> " + buttonToLightbulb1.getStatus());

        buttonToLightbulb1.flipTheSwitch(); //switch to OFF
        System.out.println("lightbulb1's current Status ---> " + lightbulb1.getStatus());
        System.out.println("button1's current Status ---> " + buttonToLightbulb1.getStatus());
    }

}