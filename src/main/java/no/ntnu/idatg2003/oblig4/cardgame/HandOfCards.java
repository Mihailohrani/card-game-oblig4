package no.ntnu.idatg2003.oblig4.cardgame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Represents a hand of playing cards dealt from a deck.
 * Provides analysis methods for the hand.
 *
 * @author Mihailo Hranisavljevic
 * @version 2025-03-10
 */
public class HandOfCards {

  private final List<PlayingCard> cards;

  /**
   * Constructs a HandOfCards with the given stream of cards.
   *
   * @param cardsStream the stream of cards dealt from the deck.
   */
  public HandOfCards(Stream<PlayingCard> cardsStream) {
    this.cards = cardsStream.toList();

    if (this.cards.isEmpty()) {
      throw new IllegalArgumentException("A hand of cards cannot be empty or null");
    }
  }

  /**
   * Calculates the sum of face values of the cards in the hand.
   * Ace counts as 1.
   *
   * @return the sum of the card faces.
   */
  public int getSumOfFaces() {
    return cards.stream()
        .mapToInt(PlayingCard::getFace)
        .sum();
  }

  /**
   * Returns a formatted string containing all heart cards ("H").
   *
   * @return formatted string of heart cards or "No Hearts" if none.
   */
  public String getHeartsAsString() {
    String hearts = cards.stream()
        .filter(card -> card.getSuit() == 'H')
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(" "));

    return hearts.isEmpty() ? "No Hearts" : hearts;
  }

  /**
   * Checks if the hand contains the Queen of Spades.
   *
   * @return true if Queen of Spades is present, false otherwise.
   */
  public boolean hasQueenOfSpades() {
    return cards.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  /**
   * Checks if the hand is a flush (all cards have the same suit).
   *
   * @return true if the hand is a flush, false otherwise.
   */
  public boolean isFlush() {
    return cards.size() == 5 && cards.stream()
        .map(PlayingCard::getSuit)
        .distinct()
        .count() == 1;
  }


  /**
   * Returns cards in the hand as a readable string.
   *
   * @return formatted string of all cards.
   */
  public String getHandAsString() {
    return cards.stream()
        .map(PlayingCard::getAsString)
        .collect(Collectors.joining(" "));
  }
}
