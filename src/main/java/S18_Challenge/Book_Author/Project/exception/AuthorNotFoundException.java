package S18_Challenge.Book_Author.Project.exception;

public class AuthorNotFoundException  extends  RuntimeException{
    public AuthorNotFoundException(String message){
        super(message);
    }
}
