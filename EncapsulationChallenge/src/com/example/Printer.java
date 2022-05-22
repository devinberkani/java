package com.example;

public class Printer {
    private int tonerLevel = 82;
    private int numOfPagesPrinted = 0;
    private boolean doubleSided = false;
    private int remainingPaper = 5;

    public int getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(int tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public void increaseTonerLevel(int toner) {
        if((getTonerLevel() + toner) > 100) {
            System.out.println("Max toner level is 100, toner level is currently " + getTonerLevel());
        } else {
            setTonerLevel((getTonerLevel() + toner));
            System.out.println("Toner level was " + (getTonerLevel() - toner) + ", now toner level is " + getTonerLevel());
        }
    }

    public int getRemainingPaper() {
        return remainingPaper;
    }

    public void setRemainingPaper(int remainingPaper) {
        this.remainingPaper = remainingPaper;
    }

    public void addPaper(int paper) {
        setRemainingPaper(getRemainingPaper() + paper);
        System.out.println(paper + " pieces of paper have been added. You now have " + getRemainingPaper() + " pieces of paper available.");
    }

    public int getNumOfPagesPrinted() {
        return numOfPagesPrinted;
    }

    public void setNumOfPagesPrinted(int numOfPagesPrinted) {
        this.numOfPagesPrinted = numOfPagesPrinted;
    }

    public void printPage(int numOfPages) {
        int paperNeeded = numOfPages;
        if(doubleSided) {
            double doublePaperNeeded = Math.ceil((double) numOfPages / 2);
            paperNeeded = (int) doublePaperNeeded;
        }
        if ((getRemainingPaper() - paperNeeded) <= 0) {
            System.out.println("Not enough paper. This job requires " + (paperNeeded) + " pieces of paper and you only have " + getRemainingPaper() + " available");
        } else {
            setNumOfPagesPrinted(getNumOfPagesPrinted() + numOfPages);
            setRemainingPaper(getRemainingPaper() - paperNeeded);
            System.out.println(numOfPages + " pages have been printed. You have " + getRemainingPaper() + " pieces of paper available.");
        }
    }

    public boolean isDoubleSided() {
        return doubleSided;
    }

    public void setDoubleSided(boolean doubleSided) {
        this.doubleSided = doubleSided;
    }

    public void toggleDoubleSided() {
        setDoubleSided(!doubleSided);
        if(doubleSided) {
            System.out.println("DOUBLE SIDED IS ON");
        } else {
            System.out.println("DOUBLE SIDED IS OFF");
        }
    }
}
