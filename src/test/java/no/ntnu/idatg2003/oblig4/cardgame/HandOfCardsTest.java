package no.ntnu.idatg2003.oblig4.cardgame;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class HandOfCardsTest {

  @Test
  void getSumOfFacesShouldReturnCorrectSum() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 5),
        new PlayingCard('D', 10),
        new PlayingCard('S', 3)
    ));
    assertEquals(18, hand.getSumOfFaces());
  }

  @Test
  void getHeartsAsStringShouldReturnCorrectString() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 4),
        new PlayingCard('H', 12),
        new PlayingCard('C', 9)
    ));
    assertEquals("H4 H12", hand.getHeartsAsString());
  }

  @Test
  void getHeartsAsStringShouldReturnNoHeartsIfNone() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('C', 2),
        new PlayingCard('D', 6),
        new PlayingCard('S', 7)
    ));
    assertEquals("No Hearts", hand.getHeartsAsString());
  }

  @Test
  void hasQueenOfSpadesShouldReturnTrueIfPresent() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 3),
        new PlayingCard('S', 12),
        new PlayingCard('D', 9)
    ));
    assertTrue(hand.hasQueenOfSpades());
  }

  @Test
  void hasQueenOfSpadesShouldReturnFalseIfAbsent() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 3),
        new PlayingCard('S', 11),
        new PlayingCard('D', 9)
    ));
    assertFalse(hand.hasQueenOfSpades());
  }

  @Test
  void isFlushShouldReturnTrueForFlushHand() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('H', 5),
        new PlayingCard('H', 9),
        new PlayingCard('H', 11),
        new PlayingCard('H', 13)
    ));
    assertTrue(hand.isFlush());
  }

  @Test
  void isFlushShouldReturnFalseForNonFlushHand() {
    HandOfCards hand = new HandOfCards(List.of(
        new PlayingCard('H', 2),
        new PlayingCard('D', 5),
        new PlayingCard('H', 9),
        new PlayingCard('S', 11),
        new PlayingCard('H', 13)
    ));
    assertFalse(hand.isFlush());
  }
}
