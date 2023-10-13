import java.util.ArrayList;

public class users extends testdata{
    ArrayList <String> favorites;
    void addfav(int choice){
        favorites = new ArrayList<>();
        favorites.add(getlistofMovies().get(choice).getTitle());
    }
    void viewfav(){
        for(int i = 0; i < favorites.size(); i++){
            System.out.println(favorites.get(i));
        }
    }
}
