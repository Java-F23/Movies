public class screen {
        public String name;
        private int capacity;
        private int numberOfTickets = 0;
        public screen(String name, int capacity){
            this.name = name;
            this.capacity = capacity;
        }
        public String getScreenName(){
            return name;
        }
        public int getCapacity(){
            return capacity;
        }
        public void setScreenCapacity(int capacity){
            this.capacity = capacity;
        }

        public int getNumberOfTickets(){
            return numberOfTickets;
        }
        public void setNumberOfTickets(int numberOfTickets){
            this.numberOfTickets = this.numberOfTickets + numberOfTickets;
        }
}
