import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import implementations.VendingMachine;
import interfaces.VendingMachineInterface;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> items= new ArrayList<>();
        items.add("Coffe latte");
        items.add("Tuna Sandwich");
        items.add("Lays Chips");
        items.add("Snicker");
        items.add("Turkey Sandwich");
        items.add("Peanuts");

        List<Double> itemsPrice= new ArrayList<>();
        itemsPrice.add(0.85);
        itemsPrice.add(1.5);
        itemsPrice.add(0.6);
        itemsPrice.add(0.5);
        itemsPrice.add(1.3);
        itemsPrice.add(0.7);

        VendingMachineInterface vm = new VendingMachine(items,itemsPrice);


        while (true) {
            vm.start();
            Scanner sc = new Scanner(System.in);
            String userInput = sc.next();
        
            vm.handleUserInput(userInput);
        }
    }
}
