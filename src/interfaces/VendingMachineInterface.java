package interfaces;

public interface VendingMachineInterface {
    
    public void start();

    public void insertMoney();

    public void selectItem();

    public void handleUserInput(String userInput);

    public double returnMoney();
}
