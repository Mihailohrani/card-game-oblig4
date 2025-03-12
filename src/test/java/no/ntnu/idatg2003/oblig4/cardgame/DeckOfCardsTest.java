package no.ntnu.idatg2003.oblig4.cardgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {

  private DeckOfCards deck;

  @BeforeEach
  void setUp() {
    deck = new DeckOfCards();
  }

  @Test
  void deckShouldContain52UniqueCards() {
    List<PlayingCard> cards = deck.dealHand(52).toList();
    assertEquals(52, cards.size());
    assertEquals(52, new HashSet<>(cards).size());
  }

  @Test
  void dealingHandShouldReturnCorrectNumberOfCards() {
    List<PlayingCard> hand = deck.dealHand(5).toList();
    assertEquals(5, hand.size());
  }

  @Test
  void dealingInvalidNumberOfCardsShouldThrowException() {
    Stream.of(0, -5).forEach(n -> {
      IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> deck.dealHand(n).toList());
      assertEquals("Number of cards must be between 1 and the remaining deck size.", exception.getMessage());
    });
  }
}
