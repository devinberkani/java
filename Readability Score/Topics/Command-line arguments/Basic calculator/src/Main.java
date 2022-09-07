class Problem {
    public static void main(String[] args) {
        String operatorChoices = "[-+*]";

        String operator = args[0];
        int numOne = Integer.parseInt(args[1]);
        int numTwo = Integer.parseInt(args[2]);

        switch(operator) {
            case "-":
                System.out.println(numOne - numTwo);
                break;
            case "+":
                System.out.println(numOne + numTwo);
                break;
            case "*":
                System.out.println(numOne * numTwo);
                break;
            default:
                System.out.println("Unknown operator");
                break;

        }
    }
}