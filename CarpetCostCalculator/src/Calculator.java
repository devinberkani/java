public class Calculator {
    private Floor floor;
    private Carpet carpet;

    public Calculator(Floor floor, Carpet carpet) {
        this.floor = floor;
        this.carpet = carpet;
    }

    public double getTotalCost(){
        double area = floor.getArea();
        double cost = carpet.getCost();
        double totalPrice = area * cost;
//        System.out.println("This is the area: " + area);
//        System.out.println("This is the cost of the carpet: " + cost);
//        System.out.println("This is the total price: " + totalPrice);
        return totalPrice;
    }
}
