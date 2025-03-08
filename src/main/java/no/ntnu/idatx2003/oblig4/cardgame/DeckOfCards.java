package no.ntnu.idatx2003.oblig4.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a complete deck of playing cards (52 cards).
 * Provides functionality to deal a hand of cards randomly.
 *
 * @author Mihailo Hranisavljevic
 * @version 2025-03-08
 */
public class DeckOfCards {

  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final List<PlayingCard> deck = new ArrayList<>();

  /**
   * Constructs a full deck containing 52 playing cards (13 faces x 4 suits).
   */
  public DeckOfCards() {
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
  public List<PlayingCard> dealHand(int n) {
    Collections.shuffle(deck);
    return deck.stream().limit(n).toList();
  }
}