public class updateUser {

    public static void main(String[] args) {

//Update the user and any of their fields except for email
        User user = new User();

        user.setFirstName("John");
        user.setLastName("Smith");
        user.setUsername("jsmith");
        user.setPassword("123456");

//Update the user in the database
        UserDAO.updateUser(user);
    }
}