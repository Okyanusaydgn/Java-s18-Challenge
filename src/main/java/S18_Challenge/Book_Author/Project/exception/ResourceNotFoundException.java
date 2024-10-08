package S18_Challenge.Book_Author.Project.exception;

// Kaynak bulunamadığında kullanılacak exception sınıfı
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);
    }

}
