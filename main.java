import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        users user1 = new users();        
        testdata database = new testdata();
        database.getlistofMovies(); //creates the movie database on run
        Scanner sc = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        boolean flag2 = false;
        System.out.println("Welcome to Cinemax Cinemas: ");
        System.out.println("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        int userchoice = 0;
        while(flag == false){ //to validate the users presses
            if((username.equals("user")) || (username.equals("admin") && (password.equals("")))){
                flag = true;
            }
            else{
                System.out.println("Invalid input please write the correct username and password");
                username = sc.nextLine();
                password = sc.nextLine();
            }
        }
        if(username.equals("user")){ // interface for the users
            while(true){
            System.out.println("--Welcome to the Cinemax Cinemas User Experience--.");
            System.out.println("Pick any of the options below: ");
            System.out.println("1. View List of Available Movies");
            System.out.println("2. Search for movies by Genre");
            System.out.println("3. Search Movies by release date");
            System.out.println("4. View Information about a Movie");
            System.out.println("5. View Movie Showtimes");
            System.out.println("6. Mark Favorite Movies");
            System.out.println("7. View Favorites");
            System.out.println("8. Rate A Movie");
            System.out.println("9. Purchase Tickets");
            System.out.println("10. Historical Movie Showtimes");
            System.out.println("11. Logout");
            System.out.println("12. Exit");
            userchoice = sc.nextInt(); // kind of a mouse for user
            while(flag2 == false){
                if((userchoice < 0) && (userchoice > 13)){
                    System.out.println("Number must be from the list");
                    userchoice = sc.nextInt();
                }else{
                    flag2 = true;
                }
            }
            
            if(userchoice == 1){
                database.printMovieInfo();
            }if (userchoice == 2) {
                System.out.println("Pick which Genre you want, we have Action, Sci-Fi, Drama, Horror and Comedy: ");
                Scanner scgenre = new Scanner(System.in);
                String genrechoice = scgenre.nextLine();
                genrechoice = genrechoice.substring(0, 1).toUpperCase() + genrechoice.substring(1).toLowerCase();
                flag = false;
                while(flag == false){
                    if((genrechoice.equals("Action")) || (genrechoice.equals("Sci-fi")) || (genrechoice.equals("Drama")) || (genrechoice.equals("Horror")) || (genrechoice.equals("Comedy"))){
                    database.printgenremovies(genrechoice);
                    flag = true;
                }else{
                    System.out.println("Genre Entered is incorrect, make sure of spelling and try again: ");
                    System.out.println("We have Action, Sci-Fi, Drama, Horror and Comedy: ");
                    genrechoice = scgenre.nextLine();
                    genrechoice = genrechoice.substring(0, 1).toUpperCase() + genrechoice.substring(1);
                }
                }
            }if(userchoice == 3){
                flag = false;
                System.out.println("From which year would like to see the movies? :");
                Scanner yearchoice = new Scanner(System.in);
                int useryear = yearchoice.nextInt();
                while(flag == false){
                    if  ((useryear < 2023) && (useryear > 1950)){
                        flag = true;
                        database.printyearmovies(useryear);
                    }else{
                        System.out.println("The Year cannot be less than 1950 and not more than 2023 try again: ");
                        useryear = yearchoice.nextInt();
                    }
                }
            }if(userchoice == 4){
                flag = false;
                database.printTitles();
                System.out.println("Pick the corrsponding number to the movie you want to know the plot and its cast: ");
                Scanner extra = new Scanner(System.in);
                int userextra = extra.nextInt();
                userextra = userextra - 1;
                while(flag == false){
                    if((userextra >= 0) && (userextra < database.movielist.size())){
                        database.extrainfo(userextra);
                        flag = true;
                    }else{
                        System.out.println("Pick from the numbered list only one");
                        userextra = extra.nextInt();
                        userextra = userextra - 1;
                    }
                }
            }if(userchoice == 5){
                ArrayList<String> spidermanShowtimes = database.getShowtimes("Spiderman: No Way Home");
        System.out.println("Showtimes for Spiderman: No Way Home:");
        for (String time : spidermanShowtimes) {
            System.out.println(time);
        }
            }if(userchoice == 6){
                flag = false;
                database.printTitles();
                System.out.println("Pick the corrsponding number to add to favorites: ");
                Scanner pickfav = new Scanner(System.in);
                int userfav = pickfav.nextInt();
                userfav = userfav - 1;
                while(flag == false){
                    if((userfav >= 0) && (userfav <=database.movielist.size())){
                    user1.addfav(userfav);
                    flag = true;
                    }else{
                        System.out.println("Pick from the numbered list only one: ");
                        userfav = pickfav.nextInt();
                        userfav = userfav - 1;
                    }
                }
            }if(userchoice == 7){
                user1.viewfav();
            }if(userchoice == 8){
                database.printTitles();
                System.out.println("Pick a movie to rate and leave a review");

                flag = false;
                int rating;
                String review;
                Scanner userrating = new Scanner(System.in);
                Scanner userreview = new Scanner(System.in);
                System.out.println("Rate from 1 to 5: ");
                rating = userrating.nextInt();
                while(flag == false){
                    if((rating > 0) || (rating < 6)){
                        flag = true;
                    }else{
                        System.out.println("Rating must be from 1 to 5: ");
                        rating = userrating.nextInt();
                    }
                }

            }
            System.out.print("\nPress Enter to continue to return to the main user menu...");
            scanner.nextLine(); // Wait for Enter key press
            System.out.println();
        }
    }
    
    }
}
