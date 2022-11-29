
public class CreditCard {
    private String cardNumber;
    private String cardType;
    private String expirationDate;


    public CreditCard(String cardNumber, String cardType, String expirationDate) {

        this.cardNumber = cardNumber;

        this.cardType = cardType;

        this.expirationDate = expirationDate;

    }


    public String getCardNumber() {

        return cardNumber;

    }


    public void setCardNumber(String cardNumber) {

        this.cardNumber = cardNumber;

    }


    public String getCardType() {

        return cardType;

    }



    public void setCardType(String cardType) {

        this.cardType = cardType;

    }


    public String getExpirationDate() {

        return expirationDate;

    }



    public void setExpirationDate(String expirationDate) {

        this.expirationDate = expirationDate;

    }

}


public class User {


    private String userId;

    private String name;

    private List<CreditCard> creditCards;



    public User(String userId, String name) {

        this.userId = userId;

        this.name = name;

        creditCards = new ArrayList<CreditCard>();

    }



    public String getUserId() {

        return userId;

    }



    public void setUserId(String userId) {

        this.userId = userId;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public List<CreditCard> getCreditCards() {

        return creditCards;

    }



    public void setCreditCards(List<CreditCard> creditCards) {

        this.creditCards = creditCards;

    }



    public void addCreditCard(CreditCard creditCard) {

        creditCards.add(creditCard);

    }



}


public class BookStore {

    private Map<String, User> users;

    public BookStore() {

        users = new HashMap<String, User>();

    }


    public void addUser(User user) {

        users.put(user.getUserId(), user);

    }


    public User getUser(String userId) {

        return users.get(userId);

    }


    public List<CreditCard> getCreditCardsForUser(String userId) {

        return users.get(userId).getCreditCards();

    }
}



public class BookStoreTest {

    public static void main(String[] args) {

        BookStore store = new BookStore();

        User user1 = new User("user1", "John Smith");

        CreditCard card1 = new CreditCard("1234123412341234", "Visa", "01/20");

        user1.addCreditCard(card1);



        User user2 = new User("user2", "Jane Doe");

        CreditCard card2 = new CreditCard("2345234523452345", "MasterCard", "02/21");

        CreditCard card3 = new CreditCard("3456345634563456", "Visa", "03/22");

        user2.addCreditCard(card2);

        user2.addCreditCard(card3);



        store.addUser(user1);

        store.addUser(user2);


        List<CreditCard> cards = store.getCreditCardsForUser("user1");

        for (CreditCard card : cards) {

            System.out.println(card.getCardNumber() + " - " + card.getCardType() + " - " + card.getExpirationDate());

        }


        cards = store.getCreditCardsForUser("user2");

        for (CreditCard card : cards) {

            System.out.println(card.getCardNumber() + " - " + card.getCardType() + " - " + card.getExpirationDate());

        }

    }


}

