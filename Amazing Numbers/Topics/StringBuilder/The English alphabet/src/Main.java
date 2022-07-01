
class EnglishAlphabet {

    public static StringBuilder createEnglishAlphabet() {

        StringBuilder uppercaseAlphabet = new StringBuilder();
        for(char letter = 'A'; letter <='Z'; letter++ ) {
            uppercaseAlphabet.append(letter);
            if (letter != 'Z') {
                uppercaseAlphabet.append(" ");
            }
        }
        return uppercaseAlphabet;
    }
}