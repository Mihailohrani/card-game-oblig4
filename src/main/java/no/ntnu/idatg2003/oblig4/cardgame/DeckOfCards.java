package no.ntnu.idatg2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;


/**
 * Represents a complete deck of playing cards (52 cards).
 * Provides functionality to deal a hand of cards randomly.
 *
 * @author Mihailo Hranisavljevic
 * @version 2025-03-10
 */
public class DeckOfCards {

  private final List<PlayingCard> deck = new ArrayList<>();

  /**
   * Constructs a full deck containing 52 playing cards (13 faces x 4 suits).
   */
  public DeckOfCards() {
    char[] suits = {'S', 'H', 'D', 'C'};
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Deals a random hand of playing cards from the deck.
   *
   * @param n the number of cards to deal (must be between 1 and 52)
   * @return a list containing the dealt playing cards
   */
  public Stream<PlayingCard> dealHand(int n) {
    if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("Number of cards must be between 1 and the remaining deck size.");
    }
    Collections.shuffle(deck);
    return deck.stream().limit(n);
  }



}