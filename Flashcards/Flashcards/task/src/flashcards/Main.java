package flashcards;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();

        // get the number of cards from the user
        menu.getNumberOfCards();
        int deckSize = menu.getDeckSize();

        // create a new deck of flashcards
        Deck deck = new Deck();

        // fill the deck
        menu.fillDeck(deck);

        // go through deck
        menu.goThroughDeck(deck);

    }
}