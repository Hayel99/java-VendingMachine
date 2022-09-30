package implementations;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import interfaces.VendingMachineInterface;

public class VendingMachine implements VendingMachineInterface {

    private List<String> items;
    private List<Double> itemsPrice;

    private double currentBalane = 0;

    public VendingMachine(List<String> items, List<Double> itemsPrice) {
        this.items = items;
        this.itemsPrice = itemsPrice;
    }

    @Override
    public void start() {
        System.out.println(
                "Press 'M' to insert money / 'I' to select an item ... your current credit is : " + currentBalane);

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + 1 + "-" + items.get(i) + "........... " + itemsPrice.get(i));
        }
    }

    @Override
    public void insertMoney() {
        System.out.println("Insert Money ... Allowed units : 100fils, Quarter JD, Half JD,1 JD, 5 JD, 10 JD");
        Scanner sc = new Scanner(System.in);
        String units = sc.nextLine();
        currentBalane += parseUnits(units);
        System.out.println(units + " is inserted ... your current balance is " + currentBalane + "JD");
    }

    @Override
    public void selectItem() {
        System.out.println("Insert Item number");
        Scanner sc = new Scanner(System.in);
        int itemNumber = sc.nextInt();
        double price = itemsPrice.get(itemNumber-1);
   
        if (price > currentBalane) {
            System.out.println("Sorry, not enough credit");
        } else {
            System.out.println(items.get(itemNumber-1) + "  is Dropped");
            System.out.println(currentBalane-price +"JD's returned" );
            currentBalane=0;
        }
    

    }

    @Override
    public double returnMoney() {
        return 0;
    }

    @Override
    public void handleUserInput(String userInput) {
        if (userInput.equals("M")) {
            insertMoney();
        } else if (userInput.equals("I")) {
            selectItem();
        } else {
            System.out.println("Invalid Input");
        }
    }

    private double parseUnits(String units) {
        if (units.equals("100fils")) {
            return 0.1;
        } else if (units.equals("Quarter JD")) {
            return 0.25;
        } else if (units.equals("Half JD")) {
            return 0.5;
        } else if (units.equals("1 JD")) {
            return 1;
        } else if (units.equals("5 JD")) {
            return 5;
        } else if (units.equals("10 JD")) {
            return 10;
        } else {
            return 0;
        }
    }

}
