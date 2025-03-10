package no.ntnu.idatg2003.oblig4.cardgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  private DeckOfCards deck;

  @BeforeEach
  void setUp() {
    deck = new DeckOfCards();
  }

  @Test
  void deckShouldContain52UniqueCards() {
    List<PlayingCard> cards = deck.dealHand(52);
    assertEquals(52, cards.size());
    assertEquals(52, new HashSet<>(cards).size()); // Ensures all cards are unique
  }

  @Test
  void dealingHandShouldReturnCorrectNumberOfCards() {
    List<PlayingCard> hand = deck.dealHand(5);
    assertEquals(5, hand.size());
  }
  @Test
  void dealingZeroOrNegativeCardsShouldThrowException() {
    Exception exception1 = assertThrows(IllegalArgumentException.class, () -> deck.dealHand(0));
    assertEquals("Number of cards must be between 1 and the remaining deck size.", exception1.getMessage());

    Exception exception2 = assertThrows(IllegalArgumentException.class, () -> deck.dealHand(-5));
    assertEquals("Number of cards must be between 1 and the remaining deck size.", exception2.getMessage());
  }



}
