import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class main {
    public static void main(String[] args) {
        boolean flag = false;
        boolean flag1 = false;
        testdata database = new testdata(); 
        database.getlistofMovies(); //creates database
        users user1 = new users("user1", ""); //creates users and passwords
        users user2 = new users("user2", "");
        users user3 = new users("user3", "");
        admin admin = new admin("admin", "");
        ArrayList<users> listofusers = new ArrayList<>();
        listofusers.add(user1); //adds them to an array list of users
        listofusers.add(user2);
        listofusers.add(user3);
        listofusers.add(admin);
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;
        while (!exitProgram) {
            // Ask for username and password
            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            // Authenticate user
            users activeUser = null;
            for (users user : listofusers) {
                if (user.authenticate(username, password)) {
                    activeUser = user;
                    break;
                }
            }

            if (activeUser != null) {
                boolean loggedIn = true;

                while (loggedIn) {
                    if (activeUser instanceof admin) {
                        // Display admin menu
                        ((admin) activeUser).displayMenu();
                    } else {
                        // Display user menu
                        activeUser.displayMenu();
                    }

                    // Simulate user interaction with the menu
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    switch (choice) {
                        case 1: //adding a movie database
                            if (activeUser instanceof admin) {
                        System.out.println("Enter name of Movie: ");
                        String title = scanner.nextLine();
                        System.out.println("Year of Release: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Genre (Only add Comedy, Sci-Fi, Horror and Action): ");
                        String genre = scanner.nextLine();
                        genre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
                        flag1 = false;
                        while(flag1 == false){
                            if((genre.equals("Action")) || (genre.equals("Sci-fi")) || (genre.equals("Drama")) || (genre.equals("Horror")) || (genre.equals("Comedy"))){
                                flag1 = true;
                            }else{
                                System.out.println("Not a Genre");
                                System.out.println("The Genres are Action, Sci-fi, Drama, Horror or Comedy: ");
                                genre = scanner.nextLine();
                                genre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
                            }
                        }
                        ArrayList <String> cast = new ArrayList<>();
                        ArrayList <String> timings = new ArrayList<>();
                        String castmember;
                        String timingschose;
                        for(int i = 1; i < 4; i++){
                            System.out.println("Cast Member " + i);
                            castmember = scanner.nextLine();
                            cast.add(castmember);
                        }
                        System.out.println("Plot: ");
                        String plot = scanner.nextLine();
                        for(int i = 1; i < 4; i++){
                            System.out.println("Timings " + i);
                            timingschose = scanner.nextLine();
                            timings.add(timingschose);
                        }
                        System.out.println("Director: ");
                        String director = scanner.nextLine();
                        database.addMovie(title, year, genre, cast, plot, timings, director);
                    }else{ // gives users info about movies
                        database.printMovieInfo();
                    }
                            break;
                        case 2:
                            if(activeUser instanceof admin){ //admin can update the movies in the database
                        database.printTitles();
                        System.out.println("Pick which Movie you want to change: ");
                        int choice1;
                        Scanner sc = new Scanner(System.in);
                        choice1 = sc.nextInt();
                        choice1 = choice1 - 1;
                        flag = false;
                        while(flag == false){
                            if((choice1 >= 0) && (choice1 < database.getlistofMovies().size())){
                                flag = true;
                            }else{
                                System.out.println("Re-Enter your choice from the list: ");
                                choice1 = sc.nextInt();
                                choice1 = choice1 - 1;
                            }
                        }
                        System.out.println("Enter name of Movie: ");
                        String title = scanner.nextLine();
                        System.out.println("Year of Release: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Genre (Only add Comedy, Sci-Fi, Horror and Action): ");
                        String genre = scanner.nextLine();
                        genre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
                        flag1 = false;
                        while(flag1 == false){
                            if((genre.equals("Action")) || (genre.equals("Sci-fi")) || (genre.equals("Drama")) || (genre.equals("Horror")) || (genre.equals("Comedy"))){
                                flag1 = true;
                            }else{
                                System.out.println("Not a Genre");
                                System.out.println("The Genres are Action, Sci-fi, Drama, Horror or Comedy: ");
                                genre = scanner.nextLine();
                                genre = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
                            }
                        }
                        ArrayList <String> cast = new ArrayList<>();
                        ArrayList <String> timings = new ArrayList<>();
                        String castmember;
                        String timingschose;
                        for(int i = 0; i < 3; i++){
                            System.out.println("Cast Member " + i+1);
                            castmember = scanner.nextLine();
                            cast.add(castmember);
                        }
                        System.out.println("Plot: ");
                        String plot = scanner.nextLine();
                        for(int i = 0; i < 3; i++){
                            System.out.println("Timings " + i+1);
                            timingschose = scanner.nextLine();
                            timings.add(timingschose);
                        }
                        System.out.println("Director: ");
                        String director = scanner.nextLine();
                        database.updateMovie(choice1, title, year, genre, cast, plot, timings, director);

                            }else{ //Users can search by Genre
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
                                    genrechoice = genrechoice.substring(0, 1).toUpperCase() + genrechoice.substring(1).toLowerCase();
                                }
                            }
                            }
                            break;
                        case 3: //Admins can search by Genre
                            if(activeUser instanceof admin){
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
                                    genrechoice = genrechoice.substring(0, 1).toUpperCase() + genrechoice.substring(1).toLowerCase();
                                }
                            }
                            }else{ //Users can see movies until today
                                flag = false;
                                System.out.println("Pick a year to see movies up until 2023");
                                Scanner useryear = new Scanner(System.in);
                                int year = useryear.nextInt();
                                while(flag == false){
                                    if((year < 2024) && (year > 1950)){
                                        flag = true;
                                        database.printyearmovies(year);
                                    }else{
                                        System.out.println("The Year cannot be less than 1950 and 2023 try again: ");
                                        year = useryear.nextInt();
                                    }
                                }
                            }
                            break;
                        case 4:
                            if(activeUser instanceof admin){ //Admins Deleting a movie from database
                                database.printTitles();
                                System.out.println("Pick Movie to remove: ");
                                Scanner userchoice = new Scanner(System.in);
                                int choice1 = userchoice.nextInt();
                                choice1 = choice1 - 1;
                                flag = false;
                                while(flag == false){
                                    if((choice1 >= 0) && (choice1 < database.getlistofMovies().size())){
                                        flag = true;
                                        database.removeMovie(choice1);
                                    }else{
                                        System.out.println("Must be from the List: ");
                                        choice1 = userchoice.nextInt();
                                        choice1 = choice1 - 1;
                                    }
                                }
                            }else{ //Users Getting more info about the movie
                                flag = false;
                                database.printTitles();
                                System.out.println("Pick which movie you want to know its info: ");
                                Scanner extra = new Scanner(System.in);
                                int extrachoice = extra.nextInt();
                                extrachoice = extrachoice - 1;
                                while(flag == false){
                                    if((extrachoice >= 0) && (extrachoice < database.getlistofMovies().size())){
                                        flag = true;
                                        database.extrainfo(extrachoice);
                                    } else{
                                        System.out.println("Invalid Choice pick again: ");
                                        extrachoice = extra.nextInt();
                                        extrachoice = extrachoice - 1;
                                    }
                                }
                            }
                            break;
                        case 5:
                        if(activeUser instanceof admin){ //Admins Remove Cast Member
                            flag = false;
                            boolean flag2 = false;
                            database.printTitles();
                            System.out.println("Pick Movie: ");
                            Scanner pick = new Scanner(System.in);
                            int pickchoice = pick.nextInt();
                            pickchoice = pickchoice - 1;
                            while(flag == false){
                                if((pickchoice >= 0) && (pickchoice < database.getlistofMovies().size())){
                                    flag = true;
                                    database.printCast(pickchoice);
                                }else{
                                    System.out.println("Incorrect please pick from the list: ");
                                }
                            }
                            System.out.println("Pick number next to cast member name to remove him: ");
                            int castchoice = pick.nextInt();
                            castchoice = castchoice - 1;
                            while(flag2 == false){
                                if((castchoice >= 0) && (castchoice < database.sizeofcastarray(castchoice))){
                                    flag2 = true;
                                    database.removeCastMember(pickchoice, castchoice);
                                }else{
                                    System.out.println("Incorrect, please pick from the numbers next to the names of the actor: ");
                                    pickchoice = pick.nextInt();
                                    pickchoice = pickchoice - 1;
                                }
                            }
                        }else{ // Users knowing the timings of films
                            flag = false;
                            database.printTitles();
                            System.out.println("Pick which movie you want to know its timings: ");
                            Scanner extra = new Scanner(System.in);
                            int extrachoice = extra.nextInt();
                            extrachoice = extrachoice - 1;
                            while(flag == false){
                                if((extrachoice >= 0) && (extrachoice < database.getlistofMovies().size())){
                                    flag = true;
                                    database.printmovieshowtimes(extrachoice);
                                } else{
                                    System.out.println("Invalid Choice pick again: ");
                                    extrachoice = extra.nextInt();
                                    extrachoice = extrachoice - 1;
                                }
                            }
                        }
                        break;
                        case 6:
                        if(activeUser instanceof admin){ //admins adding a cast member
                            flag = false;
                            database.printTitles();
                            System.out.println("Pick Movie to add a cast member: ");
                            Scanner pick = new Scanner(System.in);
                            int pickchoice = pick.nextInt();
                            pickchoice = pickchoice - 1;
                            while(flag == false){
                                if((pickchoice >= 0) && (pickchoice < database.getlistofMovies().size())){
                                    flag = true;
                                }else{
                                    System.out.println("Incorrect, please pick from the list: ");
                                }
                            }
                            System.out.println("Who do you want to add, Please type his name: ");
                            Scanner adminactor = new Scanner(System.in);
                            String actor = adminactor.nextLine();
                            database.addCastMember(pickchoice, actor);
                        }else{ //Users adding to favorites
                            flag = false;
                            database.printTitles();
                            System.out.println("Pick which movie you want to add to your favorites, just put the number next to it: ");
                            Scanner extra = new Scanner(System.in);
                            int extrachoice = extra.nextInt();
                            extrachoice = extrachoice - 1;
                            while(flag == false){
                                if((extrachoice >= 0) && (extrachoice < database.getlistofMovies().size())){
                                    flag = true;
                                    activeUser.addfav(extrachoice);
                                } else{
                                    System.out.println("Invalid Choice pick again: ");
                                    extrachoice = extra.nextInt();
                                    extrachoice = extrachoice - 1;
                                }
                            }
                        }
                        break;
                        case 7:
                        if(activeUser instanceof admin){ //Admins removing Crew
                            database.printTitles();
                            flag = false;
                            System.out.println("Pick which movie you want to remove their crew member: ");
                            Scanner picker = new Scanner(System.in);
                            int pickchoice = picker.nextInt();
                            while(flag == false){
                                if((pickchoice >= 0) && (pickchoice < database.getlistofMovies().size())){
                                    database.removeCrewMember(pickchoice);
                                    flag = true;
                                }else{
                                    System.out.println("Incorrect, please pick from the list: ");
                                }
                            }
                        }else{ //Users viewing their favorites
                            activeUser.viewfav(); 
                        }
                        break;
                        case 8:
                        if(activeUser instanceof admin){ //Reports Generated for customer experience
                            System.out.println("Reviews left by: " + user1.getUsername());
                            user1.printReviewedTitles();
                            System.out.println("Reviews left by: " + user2.getUsername());
                            user2.printReviewedTitles();
                            System.out.println("Reviews left by: " + user3.getUsername());
                            user3.printReviewedTitles();
                        }else{ //Users removing favorites
                            flag = false;
                            if(activeUser.printFav() == false){
                                System.out.println("No movies are in favorites");
                                break;
                            }else{
                                System.out.println("Pick number of which movie you want to remove: ");
                                Scanner favremover = new Scanner(System.in);
                                int removefav = favremover.nextInt();
                                removefav = removefav - 1;
                                while(flag == false){
                                    if((removefav >= 0) && (removefav < activeUser.getfavsize())){
                                        activeUser.removefav(removefav);
                                        flag = true;
                                    }else{
                                        System.out.println("Invalid Please pick a number from the list");
                                        removefav = favremover.nextInt();
                                        removefav = removefav - 1;
                                    }
                                }
                            }
                        }
                        break;
                        case 9:
                        if(activeUser instanceof admin){ //Admins changing times
                            int number = 1;
                            database.printTitles();
                            System.out.println("Which Movie do you want to change it's timings? ");
                            String timing;
                            Scanner times = new Scanner(System.in);
                            Scanner picking = new Scanner(System.in);
                            int pick = picking.nextInt();
                            pick = pick - 1;
                            flag = false;
                            while(flag == false){
                                    if((pick >= 0) && (pick < database.getlistofMovies().size())){
                                        for(int i = 0; i < 3; i++){
                                            System.out.println("Timing " + number + ": ");
                                            timing = times.nextLine();
                                            database.ManageTheaterSchedule(i, pick, timing);
                                            number = number + 1;
                                        }
                                        flag = true;
                                    }else{
                                        System.out.println("Invalid Please pick a number from the list");
                                        pick = picking.nextInt();
                                        pick = pick - 1;
                                    }
                                }
                        }else{ //Users rating and reviewing a movie
                            database.printTitles();
                            System.out.println("Pick which movie you want to rate and leave review for: ");
                            Scanner picking = new Scanner(System.in);
                            Scanner reviewer = new Scanner(System.in);
                            int pick = picking.nextInt();
                            pick = pick - 1;
                            if(activeUser.validate(database.getlistofMovies().get(pick).getTitle()) == true){
                                System.out.println("You already left a review for "+ database.getlistofMovies().get(pick).getTitle());
                                break;
                            }
                            int rating;
                            flag = false;
                            boolean flag4 = false;
                            while(flag == false){
                                if((pick >= 0) && (pick < database.getlistofMovies().size())){
                                    System.out.println("Rating (1-5) for " + database.getlistofMovies().get(pick).getTitle() + ": ");
                                    rating = picking.nextInt();
                                    while(flag4 == false){
                                        if((rating > 0) && (rating < 6)){
                                            flag4 = true;
                                        }else{
                                            System.out.println("Only from 1 to 5 please");
                                            rating = picking.nextInt();
                                        }
                                    }
                                    System.out.println("Review for " + database.getlistofMovies().get(pick).getTitle() + ": ");
                                    String review = reviewer.nextLine();
                                    activeUser.useropinion(database.getlistofMovies().get(pick).getTitle(), rating, review);
                                    flag = true;
                                }else{
                                    System.out.println("Invalid Pick from the List: ");
                                    pick = picking.nextInt();
                                    pick = pick - 1;
                                }
                            }
                        }
                        break;
                        case 10: 
                        if(activeUser instanceof admin){ // Admins seeing how well a movie did
                            database.printTitles();
                            System.out.println("Which Movie would you like to see its showtimes and seats sold? ");
                            Scanner picking = new Scanner(System.in);
                            int pick = picking.nextInt();
                            pick = pick - 1;
                            flag = false;
                            while(flag == false){
                                if((pick >= 0) && pick < database.getlistofMovies().size()){
                                    database.SeatsSold(pick);
                                    System.out.println("Movie showtimes: " + database.getlistofMovies().get(choice).getTimings());
                                    flag = true;
                                }else{
                                    System.out.println("Pick from the list only: ");
                                    pick = picking.nextInt();
                                    pick = pick - 1;
                                }
                            }
                        }else{ //Users buying tickets
                            database.printTitles();
                            System.out.println("Which movie do you want to purchase tickets for");
                            Scanner picking = new Scanner(System.in);
                            int pick = picking.nextInt();
                            pick = pick - 1;
                            flag = false;
                            while(flag == false){
                                if((pick >= 0) && (pick < database.getlistofMovies().size())){
                                    System.out.println("There are " + database.getlistofMovies().get(pick).getScreenCapacity() + " of seats available for " + database.getlistofMovies().get(pick).getTitle() + " at " + database.getlistofMovies().get(pick).getScreenName());
                                    System.out.println("How many tickets would you like? ");
                                    int amountoftickets = picking.nextInt();
                                    if((amountoftickets > 0) && (amountoftickets < database.getlistofMovies().get(pick).getScreenCapacity())){
                                        database.purchaseTicket(amountoftickets, pick);
                                        flag = true;
                                    }else{
                                        System.out.println("Number of tickets must be more than 0 and less than: " + database.getlistofMovies().get(pick).getScreenCapacity());
                                        System.out.println("How many tickets would you like? ");
                                        amountoftickets = picking.nextInt();
                                    }
                                }else{
                                    System.out.println("Please pick from the list: ");
                                    pick = picking.nextInt();
                                    pick = pick - 1;
                                }
                            }
                        }
                        break;
                        case 11:
                        if(activeUser instanceof admin){ //Admins logging out
                            loggedIn = false;
                        }else{
                            activeUser.recomendations(); //User recommendations
                        }
                        break;
                        case 12:
                        if(activeUser instanceof admin){
                            exitProgram = true; //closes the program
                            loggedIn = false; //logs out
                        }else{
                            loggedIn = false;
                        }
                        break;
                        case 13:
                        if (activeUser instanceof users){
                            exitProgram = true; //closes the program
                            loggedIn = false; //logs out
                            break;
                        }else{

                        }
                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }
                }
            } else {
                System.out.println("Invalid username or password.");
            }
        }

        scanner.close();
    }
}
