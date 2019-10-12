import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private Deck deck;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;
    private Card card5;

    @Before
    public void before() {
        game = new Game("Blackjack");
        player1 = new Player("Joe");
        player2 = new Player("Sandy");
        player3 = new Player("Berty");
        deck = new Deck();
        card1 = new Card(SuitType.HEARTS, RankType.JACK);
        card2 = new Card(SuitType.CLUBS, RankType.EIGHT);
        card3 = new Card(SuitType.DIAMONDS, RankType.KING);
        card4 = new Card(SuitType.SPADES, RankType.FIVE);
        card5 = new Card(SuitType.SPADES, RankType.TEN);

        game.addPlayer(player1);
        game.addPlayer(player2);
        player1.assignDealer();
        game.setDealer();

        deck.addCardToCardDeck(card1);
        deck.addCardToCardDeck(card2);
        deck.addCardToCardDeck(card3);
        deck.addCardToCardDeck(card4);
        deck.addCardToCardDeck(card5);

        player1.takeCard(card1); // 10
        player2.takeCard(card2); // 8
        player1.takeCard(card3); // 10 = 20
        player2.takeCard(card4); // 5
        player2.takeCard(card5); // 10 = 25 (bust)
    }

    @Test
    public void canGetGameName() {
        assertEquals("Blackjack", game.getName());
    }

    @Test
    public void canAddPlayersToPlayerArray() {
        assertEquals(2, game.countPlayers());
    }

    @Test
    public void canAddDealerToPlayerArray() {
        game.addDealer(player3);
        assertEquals(3, game.countPlayers());
        assertEquals(true, player3.checkIfDealer());
    }


    @Test
    public void canGetDealer() {
        assertEquals(player1, game.getDealer());
        assertNotEquals(player2, game.getDealer());
    }

    @Test
    public void canGetWinner() {
        assertEquals(player1, game.getWinner());
    }

}

