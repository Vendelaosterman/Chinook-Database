package a2.database.access.model;

public class CustomerGenre {
    private int customerId;
    private int genreId;
    private String genreName;
    private int genreCount;

    public CustomerGenre(int customerId, int genreId, String genreName, int genreCount){
        this.customerId = customerId;
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreCount = genreCount;
    }

    public int getCustomerId(){
        return customerId;
    }

    public int getGenreId(){
        return genreId;
    }

    public String getGenreName(){
        return genreName;
    }

    public int getGenreCount(){
        return genreCount;
    }
}
