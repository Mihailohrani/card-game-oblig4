package no.ntnu.idatx2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;

/**
 * <p>The Main class represents the entry point for the JavaFX-based Card Game application.
 * This application allows users to deal a hand of cards and analyze the hand for
 * different properties.</p>
 *
 * @author Mihailo Hranisavljevic
 * @version 2025-03-09
 */
public class Main extends Application {

  private final DeckOfCards deck = new DeckOfCards();
  private HandOfCards currentHand;

  private final TextArea cardDisplay = new TextArea();
  private final TextField sumField = new TextField();
  private final TextField heartsField = new TextField();
  private final TextField flushField = new TextField();
  private final TextField queenOfSpadesField = new TextField();

  /**
   * Starts the JavaFX application and initializes the GUI components.
   *
   * @param stage The primary stage for this application.
   */
  @Override
  public void start(Stage stage) {
    // UI Components
    cardDisplay.setEditable(false);
    cardDisplay.setPrefSize(400, 200);

    Button dealHandButton = new Button("Deal hand");
    dealHandButton.setOnAction(e -> dealHand());

    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(e -> checkHand());

    // GridPane for results
    GridPane resultsPane = new GridPane();
    resultsPane.setVgap(5);
    resultsPane.setHgap(5);
    resultsPane.addRow(0, new Label("Sum of faces:"), sumField, new Label("Cards of hearts:"), heartsField);
    resultsPane.addRow(1, new Label("Flush:"), flushField, new Label("Queen of Spades:"), queenOfSpadesField);

    // Layout
    VBox root = new VBox(10, cardDisplay, new HBox(10, dealHandButton, checkHandButton), resultsPane);
    root.setPadding(new Insets(10));
    root.setAlignment(Pos.CENTER);

    // Set up the stage
    Scene scene = new Scene(root, 500, 350);
    stage.setScene(scene);
    stage.setTitle("Card Game");
    stage.show();
  }

  /**
   * Deals a new hand of 5 random cards from the deck and updates the display.
   */
  private void dealHand() {
    List<PlayingCard> cards = deck.dealHand(5);
    currentHand = new HandOfCards(cards);
    cardDisplay.setText(currentHand.getHandAsString());
  }

  /**
   * Analyzes the current hand and updates the corresponding GUI fields
   * with the computed values (sum of faces, hearts cards, flush status, queen of spades).
   */
  private void checkHand() {
    if (currentHand == null) {
      return;
    }

    sumField.setText(String.valueOf(currentHand.getSumOfFaces()));
    heartsField.setText(currentHand.getHeartsAsString());
    flushField.setText(currentHand.isFlush() ? "Yes" : "No");
    queenOfSpadesField.setText(currentHand.hasQueenOfSpades() ? "Yes" : "No");
  }

  /**
   * The main entry point for the JavaFX application.
   *
   * @param args Command-line arguments (not used in this application).
   */
  public static void main(String[] args) {
    launch(args);
  }
}
