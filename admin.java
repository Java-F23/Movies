public class admin extends users {

    public admin(String username, String password) {
        super(username, password);

    }
    public void displayMenu() {
        System.out.println("--- Admin Menu for " + getUsername() + " ---");
        System.out.println("1. Add Movie to Database");
        System.out.println("2. Edit and Update Movie");
        System.out.println("3. Browse By Genre");
        System.out.println("4. Delete Movie from Database");
        System.out.println("5. Remove Cast Memebers");
        System.out.println("6. Add Cast Memeber");
        System.out.println("7. Remove Crew Memeber");
        System.out.println("8. Generate Reports");
        System.out.println("9. Manage Theater Schedules and Seating");
        System.out.println("10. Historical Showtimes and Theater Preformance");
        System.out.println("11. Log Out");
        System.out.println("12 or 13. Exit Program");
        System.out.println("-----------------");
    }
    
}
