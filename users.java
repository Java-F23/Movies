import java.util.ArrayList;
import java.util.List;

public class users extends testdata{
    private String username;
    private String password;
    int rating;
    String review;
    ArrayList <Movie> favorites;
    ArrayList <Object> reviews = new ArrayList<>();
    
    public users(String username, String password) {
        this.username = username;
        this.password = password;
        favorites = new ArrayList<>();
    }
    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
    public String getUsername() {
        return username;
    }
    void addfav(int choice){
        if(favorites.contains(getlistofMovies().get(choice).getTitle())){
            System.out.println(getlistofMovies().get(choice).getTitle() + " is already included in your favorites folder");
        }else{
            favorites.add(getlistofMovies().get(choice));
            System.out.println(getlistofMovies().get(choice).getTitle() + " has been added");
        }
    }
    void viewfav(){
        for(int i = 0; i < favorites.size(); i++){
            System.out.println(favorites.get(i).getTitle());
        }
        System.out.println("Size of favorite: " + favorites.size());
        if(favorites.size() == 0){
            System.out.println("No movie is in favorites");
        }
    }
    boolean printFav(){
        int number = 1;
        if(favorites.isEmpty()){
            return false;
        }else{
            for(int i = 0; i < favorites.size(); i++){
                System.out.println(number + " " + favorites.get(i).getTitle());
                number = number + 1;
            }
            return true;
        }
    }
    void rating(int rating, String review){
        this.rating = rating;
        this.review = review;
    }
    public int getfavsize(){
        return favorites.size();
    }
    void removefav(int choice){
        favorites.remove(choice);
    }
    boolean validate(String movie){
        if(reviews.contains(movie)){
            return true;
        }else{
            return false;
        }
    }
    void useropinion(String movie, int rating, String review){
        reviews.add(movie);
        reviews.add(rating);
        reviews.add(review);
    }    
        void recomendations(){
        int number = 1;
        if(favorites.size() > 0){
            System.out.println("Based on your favorites, you can watch these movies: ");
            for(int i = 0; i < getlistofMovies().size(); i++){
                for(int j = 0; j < favorites.size(); j++){
                    if(favorites.get(j).getGenre() == getlistofMovies().get(i).getGenre()){
                    System.out.println(number + " " + getlistofMovies().get(i).getTitle() + ", Genre: " + getlistofMovies().get(i).getGenre());
                    number = number + 1;
             }
            }
        }
        }else{
            System.out.println("No Movies in favorites list");
        }
    }
    public List<Object> getReviews(){
        return reviews;
    }

    void printReviewedTitles(){
        if(reviews.size() == 0){
            System.out.println("No reviews were left");
            System.out.println();
        }else{
            for (int i = 0; i < reviews.size(); i += 3) {
            String title = (String) reviews.get(i);
            int rating = (int) reviews.get(i + 1);
            String review = (String) reviews.get(i + 2);

            System.out.println("Title: " + title);
            System.out.println("Rating: " + rating);
            System.out.println("Review: " + review);
            System.out.println();
        }
        }
    }
    public void displayMenu(){
        System.out.println("--- User Menu for " + username + " ---");
        System.out.println("--Welcome to the Cinemax Cinemas User Experience--.");
        System.out.println("Pick any of the options below: ");
        System.out.println("1. View List of Available Movies");
        System.out.println("2. Search for movies by Genre");
        System.out.println("3. Search Movies by release date");
        System.out.println("4. View Information about a Movie");
        System.out.println("5. View Movie Showtimes");
        System.out.println("6. Mark Favorite Movies");
        System.out.println("7. View Favorites");
        System.out.println("8. Remove Movie from Favorites");
        System.out.println("9. Rate A Movie");
        System.out.println("10. Purchase Tickets");
        System.out.println("11. Recommendations");
        System.out.println("12. Logout");
        System.out.println("13. Exit");
        System.out.println("-----------------");
    }
}
