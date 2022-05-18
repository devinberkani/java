public class SimpleCalculator {
    private double firstNumber;
    private double secondNumber;

    //get first number
    public double getFirstNumber() {
        return this.firstNumber;
    }

    //get second number
    public double getSecondNumber() {
        return this.secondNumber;
    }

    //set first number
    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    //set second number
    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    //addition
    public double getAdditionResult() {
        return this.firstNumber + this.secondNumber;
    }

    //subtraction
    public double getSubtractionResult() {
        return this.firstNumber - this.secondNumber;
    }

    //multiplication
    public double getMultiplicationResult() {
        return this.firstNumber * this.secondNumber;
    }

    //division
    public double getDivisionResult() {
        if(secondNumber == 0) {
            return 0;
        } else {
            return this.firstNumber / this.secondNumber;
        }
    }

}
