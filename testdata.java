import java.util.ArrayList;

public class testdata{
    public Movie movie1;
    public Movie movie2;
    public Movie movie3;
    public Movie movie4;
    public Movie movie5;
    public Movie movie6;
    public Movie movie7;
    public Movie movie8;
    public Movie movie9;
    public Movie movie10;
    public Movie movie11;
    public Movie movie12;
    public Movie movie13;
    public Movie movie14;
    public ArrayList <Movie> movielist;
    public ArrayList <Movie> favorites = new ArrayList<>();
    String TheaterA = "Maadi Theater";
    String TheaterB = "October Theater";
    String TheaterC = "Zayed Theater";
    public ArrayList<String> timings1 = new ArrayList<>();
    public ArrayList<String> timings2 = new ArrayList<>();
    public ArrayList<String> timings3 = new ArrayList<>();
    public screen screen1 = new screen(TheaterA, 20);
    public screen screen2 = new screen(TheaterB, 30);
    public screen screen3 = new screen(TheaterC, 40);
    public testdata(){
        timings1.add("9:00 PM");
        timings1.add("3:00 PM");
        timings1.add("4:00 PM");
        timings2.add("11:00 AM");
        timings2.add("3:00 PM");
        timings2.add("7:00 PM");
        timings3.add("5:00 PM");
        timings3.add("8:00 AM");
        timings3.add("4:00 PM");
        ArrayList <String> cast1, cast2, cast3, cast4, cast5, cast6, cast7, cast8, cast9, cast10, cast11, cast12, cast13, cast14; // An array list which will contain the cast of movies
        cast1 = new ArrayList<>();
        cast2 = new ArrayList<>();
        cast3 = new ArrayList<>();
        cast4 = new ArrayList<>();
        cast5 = new ArrayList<>();
        cast6 = new ArrayList<>();
        cast7 = new ArrayList<>();
        cast8 = new ArrayList<>();
        cast9 = new ArrayList<>();
        cast10 = new ArrayList<>();
        cast11 = new ArrayList<>();
        cast12 = new ArrayList<>();
        cast13 = new ArrayList<>();
        cast14 = new ArrayList<>();
        cast1.add("Tom Holland");
        cast1.add("Toby Maguire");
        cast1.add("Andrew Garfield");
        movie1 = new Movie("Spiderman: No Way Home", 2022, "Action", cast1, "Spider-Man: No Way Home is a superhero film released in 2021. The movie follows Peter Parker (played by Tom Holland) as he seeks the help of Doctor Strange to erase the knowledge of his secret identity from the world after it is revealed by Mysterio. However, a spell goes wrong, causing a multiverse to collide and bringing villains from other dimensions into Peter's world.", timings1, screen1, "Jon Watts");
        cast2.add("Leonardo Di Caprio");
        cast2.add("Joseph Gordon-Levitt");
        cast2.add("Ellen Page");
        movie2 = new Movie("Inception", 2010, "Sci-fi", cast2, "Inception is a 2010 science fiction thriller directed by Christopher Nolan. The film revolves around the concept of shared dreaming and follows a skilled thief named Dom Cobb (played by Leonardo DiCaprio) who specializes in a form of corporate espionage that involves entering the dreams of others to steal their secrets.", timings1, screen2, "Christopher Nolan");
        cast3.add("Tom Hanks");
        cast3.add("Robin Wright");
        cast3.add("Gary Sinise");
        movie3 = new Movie("Forrest Gump", 1994, "Drama", cast3, "Forrest Gump is a 1994 film directed by Robert Zemeckis. The story is narrated by Forrest Gump (played by Tom Hanks), a man with low intelligence but a kind heart, as he recounts his extraordinary life experiences.", timings1, screen3, "Robert Zemeckis");
        cast4.add("Harrison Ford");
        cast4.add("Karen Allen");
        cast4.add("Paul Freeman");
        movie4 = new Movie("Raiders of The Lost Ark", 1981, "Action", cast4,"Raiders of the Lost Ark is a 1981 action-adventure film directed by Steven Spielberg and produced by George Lucas. The movie follows the iconic archaeologist and adventurer, Dr. Indiana Jones (played by Harrison Ford), in his quest to find the Ark of the Covenant, an ancient biblical artifact believed to possess extraordinary power.", timings1, screen1,"Steven Spielberg" );
        cast5.add("Christian Bale");
        cast5.add("Heath Ledger");
        cast5.add("Aaron Eckhart");
        movie5 = new Movie("The Dark Knight", 2008, "Action", cast5, "The Dark Knight is a 2008 superhero film directed by Christopher Nolan and is the second installment of Nolan's Batman trilogy. The film follows the journey of Gotham City's vigilante, Batman, as he faces one of his most formidable adversaries, the Joker.", timings2, screen2, "Christopher Nolan");
        cast6.add("Tim Robbins");
        cast6.add("Morgan Freeman");
        cast6.add("Bob Gunto");
        movie6 = new Movie("Shawshank Redemption", 1994, "Drama", cast6, "The Shawshank Redemption is a 1994 drama film directed by Frank Darabont, based on a novella by Stephen King. The story revolves around Andy Dufresne, a banker who is wrongfully convicted of the murder of his wife and her lover and is sentenced to life in Shawshank State Penitentiary.", timings2, screen1, "Frank Darabont");
        cast7.add("Elijah Wood");
        cast7.add("Viggo Mortensen");
        cast7.add("Ian McKellen");
        movie7 = new Movie("The Lord of the Rings: The Return of the King", 2003, "Fantasy", cast7,"The Lord of the Rings: The Return of the King is the third and final installment of Peter Jackson's film adaptation of J.R.R. Tolkien's epic fantasy novel, \"The Lord of the Rings.\" The film, released in 2003, continues the journey of Frodo Baggins, a hobbit, and his companions in their quest to destroy the One Ring and bring an end to the Dark Lord Sauron's reign of terror.", timings1, screen2, "Peter Jackson");
        cast8.add("John Travolta");
        cast8.add("Uma Thurman");
        cast8.add("Samuel Jackson");
        movie8 = new Movie("Pulp Fiction", 1994, "Action", cast8, "Pulp Fiction is a 1994 neo-noir crime film directed by Quentin Tarantino. The story is told in a non-linear narrative style and follows various interconnected characters through a series of interlocking crime stories in Los Angeles.", timings3, screen2, "Quentin Tarantino");
        cast9.add("Jonah Hill");
        cast9.add("Micheal Cera");
        cast9.add("Christopher Mintz-Plasse");
        movie9 = new Movie("Superbad", 2007 , "Comedy", cast9, "Superbad follows two high school friends, Seth and Evan, who embark on a quest to obtain alcohol for a party to impress their crushes. Along the way, they encounter various hilarious misadventures and learn important lessons about friendship and growing up.", timings1, screen1, "Greg Mottola");
        cast10.add("Ralph Fiennes");
        cast10.add("Tony Revolori");
        cast10.add("Adrien Brody");
        movie10 = new Movie("The Grand Budapest Hotel", 2014 , "Comedy", cast10, "The Grand Budapest Hotel is a quirky comedy that takes place in the fictional European hotel between the wars. The film revolves around the misadventures of Gustave H., the hotel's legendary concierge, and Zero Moustafa, a young lobby boy, as they become embroiled in a plot involving theft, murder, and a valuable painting.", timings3, screen2, "Wes Anderson");
        cast11.add("Kristen Wiig");
        cast11.add("Maya Rudolph");
        cast11.add("Melissa McCarthy");
        movie11 = new Movie("Bridesmaids", 2011 , "Comedy", cast11, "Bridesmaids follows Annie, a down-on-her-luck woman, who is asked to be the maid of honor for her best friend's wedding. As she navigates the challenges of wedding planning and her own personal struggles, hilarity ensues with a cast of colorful characters.", timings3, screen3, "Paul Feig");
        cast12.add("Jack Nicholson");
        cast12.add("Shelly Duvall");
        cast12.add("Danny Lloyd");
        movie12 = new Movie("The Shining", 1980 , "Horror", cast12, "The Shining follows Jack Torrance, a writer and recovering alcoholic, who takes a job as the winter caretaker of the historic Overlook Hotel. As winter sets in, the isolation and supernatural forces within the hotel begin to take a toll on Jack's sanity, leading to terrifying and deadly consequences for his family.", timings2, screen2, "Stanley Kubrick");
        cast13.add("Daniel Kaluuya");
        cast13.add("Allison Williams");
        cast13.add("Catherine Keener");
        movie13 = new Movie("Get Out", 2017 , "Horror", cast13, "Get Out is a psychological horror film that explores racial tensions. When Chris, an African American man, visits his white girlfriend's family estate, he uncovers a series of disturbing secrets about the family and their sinister motives. The film delves into social commentary and psychological terror", timings2, screen1, "Jordan Peele");
        cast14.add("Toni Collette");
        cast14.add("Alex Wolff");
        cast14.add("Milly Shapiro");
        movie14 = new Movie("Hereditary", 2018, "Horror", cast14, "Hereditary centers on the Graham family, who are haunted by sinister and increasingly terrifying occurrences following the death of their secretive grandmother. As the family unravels the dark and mysterious history of their ancestry, they confront unimaginable horrors", timings2, screen3, "Ari Aster");
        movielist = new ArrayList<>();
        movielist.add(movie1);
        movielist.add(movie2);
        movielist.add(movie3);
        movielist.add(movie4);
        movielist.add(movie5);
        movielist.add(movie6);
        movielist.add(movie7);
        movielist.add(movie8);
        movielist.add(movie9);
        movielist.add(movie10);
        movielist.add(movie11);
        movielist.add(movie12);
        movielist.add(movie13);
        movielist.add(movie14);
    }
    public ArrayList<Movie> getlistofMovies(){
        return movielist;
    }

    static void searchtitle(Movie movie, String name){
        if(movie.getTitle() == name){
            System.out.println("Movie Found");
        }else{
            System.out.println("Movie not Found");
        }
    }
    void printgenremovies(String userchoice){
        ArrayList<String> usergenre = new ArrayList<>();
        for (Movie movie : movielist) {
            if (movie.getGenre().equals(userchoice)) {
                usergenre.add(movie.getTitle());
            }
        }
        for(int i = 0; i < usergenre.size(); i++){
            System.out.println(usergenre.get(i));
        }

    }
    void printyearmovies(int userchoice){
        ArrayList<String> useryear = new ArrayList<>();
        ArrayList <Integer> releaseyear = new ArrayList<>();
        for (Movie movie : movielist) {
            if (movie.getYear() >= userchoice) {
                useryear.add(movie.getTitle());
                releaseyear.add(movie.getYear());
            }
        }
        System.out.println("Here are the list of Movies released during and after " + userchoice + " until 2023");
        for(int i = 0; i < useryear.size(); i++){
            System.out.println("(" + useryear.get(i) + ")" + " was released in " + releaseyear.get(i));
        }

    }
    void printMovieInfo(){
        for (Movie movie : movielist) {
            System.out.println("Movie Name: " + movie.getTitle());
            System.out.println("Movie Year: " + movie.getYear());
            System.out.println("Movie Genre: " + movie.getGenre());
            System.out.println("Cast: " + movie.getCast());
            System.out.println("Director: " + movie.getcrew());
            System.out.println();
        }
    }
    void printTitles(){
        ArrayList <String> titles = new ArrayList<>();
        for(Movie movie : movielist){
            titles.add(movie.getTitle());
        }
        for(int i = 0; i < titles.size(); i++){
            System.out.println(i+1 + " " + titles.get(i));
        }
    }
    void extrainfo(int userchoice){
        System.out.println("This is the plot of " + movielist.get(userchoice).getTitle() + ": " + movielist.get(userchoice).getPlot());
        System.out.println("The cast of " + movielist.get(userchoice).getTitle() + ": " + movielist.get(userchoice).getCast());
        System.out.println("Directed by: " + movielist.get(userchoice).getcrew());
    }
    void addMovie(String title, int year, String genre, ArrayList<String> cast, String plot, ArrayList<String> timings, String director){
        Movie newmovie = new Movie(title, year, genre, cast, plot, timings, screen1, director);
        movielist.add(newmovie);
    }
    void updateMovie(int choice, String title, int year, String genre, ArrayList<String> cast, String plot, ArrayList<String> timings, String director){
        Movie newmovie = new Movie(title, year, genre, cast, plot, timings, screen1, director);
        movielist.set(choice, newmovie);
    }
    void removeMovie(int choice){
        System.out.println(movielist.get(choice).getTitle() + " Successully Removed");
        movielist.remove(choice);
    }
    void printCast(int choice){
        int number = 1;
        for (int i = 0; i < movielist.get(choice).getCast().size(); i++){
            System.out.println("Cast Member " + number + ": "+ movielist.get(choice).getCast().get(i));
            number++;
        }
    }
    void removeCastMember(int choice, int choice2){
        movielist.get(choice).getCast().remove(choice2);
    }
    void removeCrewMember(int choice){
        System.out.println("Director: " + movielist.get(choice).getcrew() + " from " + movielist.get(choice).getTitle() + " has been removed");
        movielist.get(choice).setcrew("(Director Removed)");
    }
    int sizeofcastarray(int choice){
        return movielist.get(choice).getCast().size();
    }

    void printmovieshowtimes(int choice){
        System.out.println(movielist.get(choice).getTitle() + " is being shown at " + movielist.get(choice).getScreenName() + " during these times " + movielist.get(choice).getTimings());
        System.out.println("Seats Available: " + movielist.get(choice).getScreenCapacity());
    }
    void addCastMember(int choice, String actor){
        movielist.get(choice).getCast().add(actor);
    }
    void purchaseTicket(int numberOfTickets, int choice){
        int newCapacity  = movielist.get(choice).getScreenCapacity() - numberOfTickets;
        movielist.get(choice).setScreenCapacity(newCapacity);
        movielist.get(choice).screenings.setNumberOfTickets(numberOfTickets);
    }
    void ManageTheaterSchedule(int i, int choice, String time){
        movielist.get(choice).timings.set(i, time);
    }
    void SeatsSold(int choice){
        System.out.println("Seats bought for " + movielist.get(choice).getTitle() + " is " + movielist.get(choice).screenings.getNumberOfTickets());
    }
}