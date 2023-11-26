package Controller;
import Controller.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Testdata {
    public ArrayList<Movie> movielist = new ArrayList<>();
    public ArrayList<Screen> screens = new ArrayList<>();
    

    public Testdata() {
        screens.add(new Screen("Maadi Theater", 20));
        screens.add(new Screen("October Theater", 30));
        screens.add(new Screen("Zayed Theater", 40));

        loadMoviesFromCSV("Model\\movies.csv");
    }

    private void loadMoviesFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            // Skip the header line
            String header = br.readLine();
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(",", -1); // Split by comma, include empty values
                String title = movieData[0];
                
                // Check if the year is a valid integer
                int year = 0; // Default value in case of parsing failure
                try {
                    year = Integer.parseInt(movieData[1].trim());
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Handle the parsing error or invalid data as needed
                    e.printStackTrace();
                }
    
                String genre = movieData[2];
                String[] castArray = movieData[3].split(";");
                ArrayList<String> cast = new ArrayList<>();
                for (String actor : castArray) {
                    cast.add(actor.trim());
                }
                String description = movieData[4];
                String[] timingsArray = movieData[5].split(";");
                ArrayList<String> timings = new ArrayList<>();
                for (String timing : timingsArray) {
                    timings.add(timing.trim());
                }
                String director = movieData[6];
    
                // Assuming the last field in CSV refers to screen index
                int screenIndex = 0; // Default value
                try {
                    screenIndex = Integer.parseInt(movieData[7].trim());
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    // Handle the parsing error or invalid data as needed
                    e.printStackTrace();
                }
    
                // Check if the screenIndex is valid before using it
                if (screenIndex >= 0 && screenIndex < screens.size()) {
                    Screen screen = screens.get(screenIndex);
                    Movie movie = new Movie(title, year, genre, cast, description, timings, screens, director);
                    movielist.add(movie);
                } else {
                    // Handle the invalid screen index
                    System.err.println("Invalid screen index: " + screenIndex);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMovie(Movie movie, String filename) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
        String title = movie.getTitle();
        int year = movie.getYear();
        String genre = movie.getGenre();
        String cast = String.join(";", movie.getCast());
        String description = movie.getPlot();
        String timings = String.join(";", movie.getTimings());
        String director = movie.getcrew();

        String movieData = String.format("%s,%d,%s,%s,%s,%s,%s,%d\n",
                title, year, genre, cast, description, timings, director, 1);

        bw.write(movieData);
        bw.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public ArrayList<Movie> getlistofmovies(){
        return movielist;
    }
    public int getnumberofmovies(){
        return movielist.size();
    }
    public Movie getMovieByTitle(String title) {
        for (Movie movie : movielist) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }
    public ArrayList<String> getScreenNames(){
        ArrayList<String> ScreenNames = new ArrayList<>();
        for(Screen screen: screens){
            ScreenNames.add(screen.getName());
        }
        return ScreenNames;
    }
    void removeMovie(Movie movie){
        movielist.remove(movie);
    }
}