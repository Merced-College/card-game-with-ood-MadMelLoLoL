[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=19814618)
# cardsWithOOD

// Madison Bazan
// 6/18/2025
// Card game with OOD


# new additions

    new Card class explained (code under explanation): 
    For the Java Card class, I defined three strings and one integer private variables for the suit of the cards, the rank of the card, the value of the card and the picture the card is associated with. 

    Then I created setter and getter functions as well as a default, parameterized and copy constructor for the class in order to connect the functions listed in CardGame.java to actual functions to make the code run correctly. I made sure to have the print function print all values regarding a card for maximum information given to the player drawing cards.

    Card.java class
        // Madison Bazan
        // 6/18/2025
        // Card game with OOD


        public class Card {
            private String suit;
            private String rank;
            private int value;
            private String picture;

            // Default constructor
            public Card() {
                this.suit = "";
                this.rank = "";
                this.value = 0;
                this.picture = "";
            }

            // Parameterized constructor
            public Card(String suit, String rank, int value, String picture) {
                this.suit = suit;
                this.rank = rank;
                this.value = value;
                this.picture = picture;
            }

            // Copy constructor
            public Card(Card other) {
                this.suit = other.suit;
                this.rank = other.rank;
                this.value = other.value;
                this.picture = other.picture;
            }

            // Accessors (getters)
            public String getSuit() {
                return suit;
            }

            public String getRank() {
                return rank;
            }
            public int getValue() {
                return value;
            }

            public String getPicture() {
                return picture;
            }

            // Mutators (setters)
            public void setSuit(String suit) {
                this.suit = suit;
            }

            public void setRank(String rank) {
                this.rank = rank;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            // toString method
            @Override
            public String toString() {
                return rank + " of " + suit + " (Value: " + value + ", Picture: " + picture + ")";
            }
        }
        //end of card.java 

    Additions to CardGame.java:
        -Switched shuffle function to use the collections java util, makes shuffling easier to code and more efficient 
            import java.util.Collections; //new addition for shuffling
            .
            .
            .
            public static void shuffle() {
                // Use Collections.shuffle to shuffle the deck better 
                //(before it only shuffled heart suit cards)
                Collections.shuffle(deckOfCards);
            }

        - Comments on default code and new code explaining what they do
        
