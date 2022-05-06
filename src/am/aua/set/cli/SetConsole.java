package am.aua.set.cli;
import am.aua.set.core.Card;
import am.aua.set.core.Deck;
import am.aua.set.core.Player;


import java.util.*;

public class SetConsole {
    public void play() {
        Scanner sc = new Scanner(System.in);
        Player playerClass = new Player();
        System.out.println("Enter your name.");
        playerClass.setPoints(0);
        int playerPoints = playerClass.getPoints();
        playerClass.setName(sc.nextLine());
        String playerName = playerClass.getName();
        Card cardClass = new Card();
        Deck deckClass = new Deck();
        ArrayList<Card> deck = deckClass.createDeck();
        ArrayList<Card> shuffledDeck = deckClass.shuffle(deck);
        ArrayList<Card> cardsOnBoard = deckClass.createCardsOnBoard(shuffledDeck);
        for (int i = 0; i <= shuffledDeck.size(); i++) {
            if (i != 12) {
                shuffledDeck.remove(i);
            } else {
                break;
            }
        }
        while(!(shuffledDeck.size() == 0 && !(cardClass.isSetPresent(cardsOnBoard)))) {
            System.out.println("Choose three cards.");
            int firstCard = sc.nextInt();
            int secondCard = sc.nextInt();
            int thirdCard = sc.nextInt();
            if(cardClass.isSet(cardsOnBoard.get(firstCard), cardsOnBoard.get(secondCard), cardsOnBoard.get(thirdCard))) {
                playerPoints++;
                cardsOnBoard.remove(firstCard);
                cardsOnBoard.remove(secondCard);
                cardsOnBoard.remove(thirdCard);
                for(int i = 0; i < shuffledDeck.size(); i++) {
                    if(i != 3) {
                        cardsOnBoard.add(shuffledDeck.get(i));
                        shuffledDeck.remove(i);
                    }else {
                        break;
                    }

                }
            }else{
                playerPoints--;
                System.out.println("Not a set. Try again.");
            }
        }
        System.out.println("Game over." + playerName + " got " + playerPoints + " points");
    }
}
