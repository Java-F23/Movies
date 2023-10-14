import java.util.ArrayList;

public class users extends testdata{
    private String username;
    private String password;
    int rating;
    String review;
    ArrayList <String> favorites;
    
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
        favorites = new ArrayList<>();
        favorites.add(getlistofMovies().get(choice).getTitle());
    }
    void viewfav(){
        for(int i = 0; i < favorites.size(); i++){
            System.out.println(favorites.get(i));
        }
    }
    void rating(int rating, String review){
        this.rating = rating;
        this.review = review;
    }
}
