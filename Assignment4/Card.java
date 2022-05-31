package Assignment4;

/**
 * This Class is calculate the number of total card
 * and low card high card
 *
 * @ author : PATEL RIDHAM PRAKASHCHANDRA, 000831171
 */
public class Card {
    /**
     * to store value of rank
     */
    private int rank;
    /**
     * to store value of suit
     */

    private int suit;
    /**
     * shuffle rank and set default value
     */

    private int shuffleRank = 1;

    /**
     * shuffle suit and set default value
     */
    private int shuffleSuit = 1;


    /**
     * this is constructor of class
     *
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * setter method to get value from main class
     *
     * @param shuffleRank
     * @param shuffleSuit
     */
    public void setShuffleCard(int shuffleRank, int shuffleSuit) {
        this.shuffleRank = shuffleRank;
        this.shuffleSuit = shuffleSuit;
    }

    /**
     * return total number  of card
     *
     * @return
     */
    public int getTotalCard() {
        return rank * suit;
    }

    /**
     * toString method to print
     *
     * @return
     */
    @Override
    public String toString() {
        return "Deck of " +
                getTotalCard() + " cards : low = " + Math.min(1, 2) + ", high =  " + Math.max(1, rank) + ", card { " + "suit = " +
                shuffleSuit + ", rank = " + shuffleRank + " }";
    }
}

