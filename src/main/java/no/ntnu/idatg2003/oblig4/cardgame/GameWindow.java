package no.ntnu.idatg2003.oblig4.cardgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.List;

/**
 * The GameWindow class manages the JavaFX UI and game logic.
 *
 * @author Mihailo Hranisavljevic
 * @version 2025-03-10
 */
public class GameWindow extends Application {

  private final DeckOfCards deck = new DeckOfCards();
  private HandOfCards currentHand;

  private final TextArea cardDisplay = new TextArea();
  private final TextField sumField = new TextField();
  private final TextField heartsField = new TextField();
  private final TextField flushField = new TextField();
  private final TextField queenOfSpadesField = new TextField();

  /**
   * Starts the JavaFX application and sets up the UI.
   *
   * @param stage The primary stage for this application.
   */
  @Override
  public void start(Stage stage) {
    setupUI(stage);
  }

  /**
   * Sets up the UI components and layout.
   *
   * @param stage The primary JavaFX window.
   */
  private void setupUI(Stage stage) {
    cardDisplay.setEditable(false);
    cardDisplay.setPrefSize(400, 200);

    Button dealHandButton = new Button("Deal hand");
    dealHandButton.setOnAction(e -> dealHand());

    Button checkHandButton = new Button("Check hand");
    checkHandButton.setOnAction(e -> checkHand());

    GridPane resultsPane = new GridPane();
    resultsPane.setVgap(5);
    resultsPane.setHgap(5);
    resultsPane.addRow(0, new Label("Sum of faces:"), sumField, new Label("Cards of hearts:"), heartsField);
    resultsPane.addRow(1, new Label("Flush:"), flushField, new Label("Queen of Spades:"), queenOfSpadesField);

    VBox root = new VBox(10, cardDisplay, new HBox(10, dealHandButton, checkHandButton), resultsPane);
    root.setPadding(new Insets(10));
    root.setAlignment(Pos.CENTER);

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
   * Analyzes the current hand and updates the corresponding GUI fields.
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
   * Launches the JavaFX application.
   *
   * @param args Command-line arguments (not used).
   */
  public static void main(String[] args) {
    launch(args);
  }
}
