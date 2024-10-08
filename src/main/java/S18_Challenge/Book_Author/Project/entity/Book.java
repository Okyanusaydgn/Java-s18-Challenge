package S18_Challenge.Book_Author.Project.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // sınıfın nesnesi oluşturulurken hiçbir parametre geçmeden bir nesne yaratılabilir.
@Entity
@Table(name = "book",schema = "fsweb")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;
    //author_id sütunu, Book tablosundaki category tablosuna referans verir. Yani, bir kitabın hangi kategoriye ait olduğunu gösterir.

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;
    //author_id sütunu, Book tablosundaki Author tablosuna referans verir. Yani, bir kitabın yazarını gösterir.

    // CascadeType.MERGE -- eğer bir kitap merge edilir ise yani güncellenir ise ilgili "author" ve "book" nesneleri de güncellenir.
    // CascadeType.PERSIST -- eğer bir kitap persist yani kaydedilir ise ilgili "author" ve "book" nesneleri de kaydedilir.
    // CascadeType.REFREST -- eğer bir kitap refresh yani veritabanında güncelleme alınırken ilgili "author" ve "book" nesneleri de güncellenir.
    // CascadeType.DETACH -- eğer bir kitap detach yani entitymanager/veritabanı ile bağlantısı kesilir ise ilgili "author" ve "book" nesnelerinin de veritabanından bağlantısı kesilir.

    // JoinColumn -- bir entity nin diğer entity ile ilişkisinde hangi sütunu kullanacağını belirtir.
}
