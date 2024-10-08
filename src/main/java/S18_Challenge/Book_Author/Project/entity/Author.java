package S18_Challenge.Book_Author.Project.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor // Özellikle Entity ve DTO katmanlarında kullanılır.
@Entity
@Table(name = "author",schema = "fsweb")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Bu strateji kullanıldığı zaman, her yeni satır eklenirken veritabanı benzersiz ve artan bir id oluşturur.
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    // CascadeType.All --> Tüm silme,güncelleme vs. işlemlerini yapar. Author silindiğinde veya güncellendiğinde onunla ilişkili tüm Book nesneleri de silinir veya güncellenir.
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL) // mappedby book sınıfında bir author alanı olmalıdır ve author sınıfında kitaplar (List<Book>) saklanır.
    private List<Book> books;

    // Aşağıdaki kod bir yazara yeni bir kitap eklemek yani "Book" nesnesi eklemek için kullanılır.
    public void addBook(Book book){
        if(books == null){
            books = new ArrayList<>(); // Eğer book nesnesi boşsa yani henüz yeni bir kitap eklenmediyse null olmasından kaynaklanacak hataları engellemsi için Arraylist oluşturulur.
        }
        books.add(book);
    }


}
