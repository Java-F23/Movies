package Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Movie{
        private String title;
        private int year;
        private String genre;
        private ArrayList<String> cast;
        public String plot;
        public String crew;
        public ArrayList<String> timings;
        public ArrayList<Screen> screenings;
        public ArrayList<String> reviews = new ArrayList<>();
        public ArrayList<Integer> ratings = new ArrayList<>();
        public Movie(String title, int year, String genre, ArrayList<String> cast, String plot, ArrayList<String> timings, ArrayList<Screen> screen, String crew) {
            this.title = title;
            this.year = year;
            this.genre = genre;
            this.cast = cast;
            this.plot = plot;
            this.screenings = screen;
            this.timings = timings;
            this.crew = crew;
        }
        // public ArrayList<String> getScreens() {
        //     ArrayList<String> namescreens = new ArrayList<>();
        //     for (Screen screen : screenings) {
        //         namescreens.add(screen.getName());
        //     }
        //     return namescreens;
        // }

        public String getTitle() {
            return title;
        }
        public String movTitle(String selectedmovie){
            return title;
        }

        public int getYear() {
            return year;
        }

        public String getGenre() {
            return genre;
        }

        public ArrayList<String> getCast() {
            return cast;
        }

        public int getsizeofcast(){
            return cast.size();
        }

        public String getPlot() {
            return plot;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public void setCast(ArrayList<String> cast) {
            this.cast = cast;
        }

        public void setPlot(String plot) {
            this.plot = plot;
        }
        public void setTimings(ArrayList <String> timings){
            this.timings = timings;
        }
        public void setScreenings(ArrayList<Screen> screenings){
            this.screenings = screenings;
        }
        public ArrayList<String> getTimings(){
            return timings;
        }
        public void removeCastMember(int castMember) {
            cast.remove(castMember);
        }
        public String getcrew(){
            return crew;
        }
        public void setcrew(String crew){
            this.crew = crew;
        }

        public ArrayList<String> getreviews(){
            return reviews;
        }
        public ArrayList<Integer> getratings(){
            return ratings;
        }
        public double averageratings(){
            int sum = 0;
            for (Integer num : ratings) {
                sum += num;
            }
            return (double) sum/ratings.size();
        }
        public void addReview(String review) {
            reviews.add(review);
        }
    
        public void addRating(int rating) {
            ratings.add(rating);
        }
        public static Movie getMovieByTitle(String selectedTitle) {
            return null;
        }
        public ArrayList<Screen> getScreens() {
            return screenings;
        }
        public ArrayList<String> getScreenNames(){
            ArrayList<String> ScreenNames = new ArrayList<>();
            for(Screen screen: screenings){
                ScreenNames.add(screen.getName());
            }
            return ScreenNames;
        }
        public int getScreenIndex(String filename, String movieTitle) {
        int screenIndex = -1; // Default value if movie not found

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(",");
                String title = movieData[0];

                if (title.equals(movieTitle)) {
                    screenIndex = Integer.parseInt(movieData[7]);
                    break; // Movie found, exit loop
                }
            }
        } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return screenIndex;
    }
    public String toCSVString() {
        StringBuilder sb = new StringBuilder();
        sb.append(title).append(",");
        sb.append(year).append(",");
        sb.append(genre).append(",");
        sb.append(String.join(";", cast)).append(",");
        sb.append(plot).append(",");
        sb.append(String.join(";", timings)).append(",");
        sb.append(crew).append(",");
        return sb.toString();
    }
    /*Movie class */

        
}