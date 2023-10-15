import java.util.ArrayList;

public class Movie{
        private String title;
        private int year;
        private String genre;
        private ArrayList<String> cast;
        public String plot;
        public String crew;
        public ArrayList<String> timings;
        public screen screenings;

        public Movie(String title, int year, String genre, ArrayList<String> cast, String plot, ArrayList<String> timings, screen screenings, String crew) {
            this.title = title;
            this.year = year;
            this.genre = genre;
            this.cast = cast;
            this.plot = plot;
            this.screenings = screenings;
            this.timings = timings;
            this.crew = crew;
        }

        public String getTitle() {
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
        public void setScreenings(screen screenings){
            this.screenings = screenings;
        }
        public ArrayList<String> getTimings(){
            return timings;
        }
        public String getScreenName(){
            return screenings.getScreenName();
        }
        public int getScreenCapacity(){
            return screenings.getCapacity();
        }
        public void setScreenCapacity(int capacity){
            screenings.setScreenCapacity(capacity);
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
        
}