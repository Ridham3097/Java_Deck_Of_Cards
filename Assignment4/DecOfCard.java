package Assignment4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DecOfCard {
    private int numCard;
    /**
     * to store number of card
     */
    private int numSuit;
    /**
     * to store number of suit
     */
    private int[] card;
    /**
     * array of card to store value
     */
    private int[] suit;
    /**
     * array of suit to store value
     */
    private int sfRank;
    /**
     * to set shuffle rank
     */
    private int sfSuit;   /** to set shuffle suit */

    /**
     * create object to get value randomly
     */
    Random r = new Random();



    /**
     * constructor of class
     *
     * @param numCard
     * @param numSuit
     */
    public DecOfCard(int numCard, int numSuit) {
        this.numCard = numCard;
        this.numSuit = numSuit;
    }

    /**
     * to set value in card array
     *
     * @param card
     * @param suit
     */
    public void setCard(int[] card, int[] suit) {
        this.card = card;
        this.suit = suit;
    }

    /**
     * shuffle method
     * to shuffle card
     */
    public void shuffle() {
        /**
         * for loop to shuffle card,  number of times
         */
        for (int i = 0; i <= 5; i++) {
            int index1 = (int) (Math.random() * numCard);
            int index2 = (int) (Math.random() * numCard);
            int index3 = (int) (Math.random() * numSuit);
            int index4 = (int) (Math.random() * numSuit);

            int temp = card[index1];
            card[index1] = card[index2];
            card[index2] = temp;

            int temp1 = suit[index3];
            suit[index3] = suit[index4];
            suit[index4] = temp1;

        }
        setSfRank(card[0]);
        setSfSuit(suit[0]);

    }

    /**
     * setter method fro shuffle rank
     *
     * @param sfRank
     */
    public void setSfRank(int sfRank) {
        this.sfRank = sfRank;
    }

    /**
     * setter method for shuffle suit
     *
     * @param sfSuit
     */
    public void setSfSuit(int sfSuit) {
        this.sfSuit = sfSuit;
    }

    /**
     * to get value of shuffled card
     *
     * @return
     */
    public int getSfRank() {
        return sfRank;
    }

    /**
     * to get value of shuffled suit
     *
     * @return
     */
    public int getSfSuit() {
        return sfSuit;
    }

    /**
     * deal method
     * to deal num of card
     *
     * @param numDeal
     */
    public void deal(int numDeal) {

        String[] total = new String[numDeal]; /** to store deal card */
        /**
         * for loop to deal card number of time
         */
        for (int i = 0; i < numDeal; i++) {
            total[i] = "card{suit= " + String.valueOf(r.nextInt(numSuit) + 1) + ", rank= " + String.valueOf(r.nextInt(numCard) + 1 + " }");
        }
        /**
         * to print first deal card
         */
        System.out.println("The hand dealt is : " + Arrays.toString(total));
    }

    /**
     * histogram method
     * to deal for 100000 times
     *
     * @param numOfDeal
     */
    public void histogram(int numOfDeal) {

        int[] histogram = new int[100000]; /** histogram array to store value*/
        int[] total = new int[numOfDeal];  /** total array to store value of deal card sum*/

        for (int q = 0; q < 100000; q++) {
            int y = 0;
            for (int k = 0; k < numOfDeal; k++) {
                for (int l = 0; l < numOfDeal; l++) {
                    int p = r.nextInt(numCard) + 1;
                    int u = r.nextInt(numSuit) + 1;
                    total[l] = p * u;
                }
                y = y + total[k];
            }
            histogram[y]++;
        }

        for (int i = 0; i < 100000; i++) {
            if (histogram[i] > 0) {
                System.out.print(" ");
                System.out.println(i + ": " + histogram[i]);
            } else {
                continue;
            }
        }
    }

    /**
     * main method
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * create scanner object to get user input
         */
        Scanner obj = new Scanner(System.in);
        /**
         * create object to get value randomly
         */
        Random r = new Random();

        /**
         * to get user input for num of rank
         */
        System.out.println("Enter how many rank");
        int a = obj.nextInt();

        /**
         * to get user input for num of suit
         */
        System.out.println("Enter no of suit");
        int b = obj.nextInt();

        /**
         * create a object of DecOfCard to run methods
         */
        DecOfCard obj2 = new DecOfCard(a, b);
        /**
         * Crad class object to use card class methos
         */
        Card c = new Card(a, b);
        System.out.println(c);

        /**
         * to create array of cards
         */
        int[] card = new int[a];
        int j = 1;
        for (int i = 0; i < card.length; i++) {
            card[i] = j;
            j++;
        }

        /**
         * to create array of suits
         */
        int q = 1;
        int[] suit = new int[b];
        for (int i = 0; i < suit.length; i++) {
            suit[i] = q;
            q++;
        }
        obj2.setCard(card, suit);

        while (true) {
            System.out.println("1 = Shuffle, 2= Deal 1 hand, 3=deal 100000 times, 4 = quit");
            System.out.println(" ");
            int d = obj.nextInt();

            if (d == 1) {
                obj2.shuffle();
                c.setShuffleCard(obj2.getSfRank(), obj2.getSfSuit());
                System.out.println(c);
            } else if (d == 2) {
                System.out.println("Number of cards to deal");
                int numDeal = obj.nextInt();
                obj2.deal(numDeal);
                System.out.println(c);

            } else if (d == 3) {
                System.out.println("Number of cards to deal");
                int numOfDeal = obj.nextInt();
                obj2.histogram(numOfDeal);
            } else if (d == 4) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Type correct option");
            }
        }
    }
}
