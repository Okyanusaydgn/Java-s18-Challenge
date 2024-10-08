package S18_Challenge.Book_Author.Project.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message){
        super(message);
    }
}
