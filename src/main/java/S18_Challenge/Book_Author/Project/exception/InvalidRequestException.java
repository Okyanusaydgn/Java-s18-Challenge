package S18_Challenge.Book_Author.Project.exception;

// geçersiz istekler için kullanılacak exception sınıfı
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message){
        super(message);
    }

}
