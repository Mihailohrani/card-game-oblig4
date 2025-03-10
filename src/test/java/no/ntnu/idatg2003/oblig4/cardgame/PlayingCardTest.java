package no.ntnu.idatg2003.oblig4.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayingCardTest {

  @Test
  void validPlayingCardShouldBeCreated() {
    PlayingCard card = new PlayingCard('H', 12);
    assertEquals('H', card.getSuit());
    assertEquals(12, card.getFace());
  }

  @Test
  void invalidSuitShouldThrowException() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 5));
    assertEquals("Parameter suit must be one of H, D, C or S", exception.getMessage());
  }

  @Test
  void invalidFaceShouldThrowException() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 14));
    assertEquals("Parameter face must be a number between 1 to 13", exception.getMessage());
  }

  @Test
  void getAsStringShouldReturnCorrectFormat() {
    PlayingCard card = new PlayingCard('S', 10);
    assertEquals("S10", card.getAsString());
  }

  @Test
  void equalsMethodShouldWorkCorrectly() {
    PlayingCard card1 = new PlayingCard('C', 7);
    PlayingCard card2 = new PlayingCard('C', 7);
    PlayingCard card3 = new PlayingCard('D', 7);

    assertEquals(card1, card2);
    assertNotEquals(card1, card3);
  }

  @Test
  void hashCodeShouldBeConsistent() {
    PlayingCard card1 = new PlayingCard('H', 5);
    PlayingCard card2 = new PlayingCard('H', 5);

    assertEquals(card1.hashCode(), card2.hashCode());
  }
}
