![image](https://github.com/user-attachments/assets/8a765942-007e-4661-b0da-0003f110a083)
# 📚 Kitap Yazar Projesi

Merhaba! Bu proje, Java Spring Boot ve PostgreSQL kullanarak geliştirdiğimiz bir **Kitap Yazar Yönetim Sistemi**. Burada yazar bilgilerini ekleyebilir, silebilir, güncelleyebilir ve listeleyebilirsin. Backend projesi tamamen Java ile yazıldı ve veritabanı olarak PostgreSQL kullandık.

## 📌 Projenin Özeti
Bu proje, yazarlar ve onların kitapları arasında yönetim sağlayan bir sistemdir. Kullanıcılar, yazar ekleme, silme, güncelleme ve listeleme işlemlerini gerçekleştirebilir. Ayrıca, kitap ekleme ve silme işlemleri de yapılabilmektedir. Projenin amacı, kullanıcıların kitap ve yazar bilgilerini kolayca yönetmelerine olanak tanımaktır.

## Neler Kullandık?
- **Java 17**: Ana dilimiz.
- **Spring Boot**: Backend kısmını hızlıca halletmek için.
- **PostgreSQL**: Veritabanı olarak seçtik, çünkü sağlam ve stabil.
- **pgAdmin**: PostgreSQL veritabanını yönetmek için kullandık.
- **Postman**: API’yi test etmek için, ayrıca sen de denemeler yapabilmen için Postman linkini aşağıda paylaşıyorum.
- **IntelliJ IDEA**: Kodları yazarken burayı tercih ettik.

## Nasıl Çalıştırırsın?
Öncelikle Docker kurmakla uğraşmana gerek yok. Direkt olarak PostgreSQL'i kendi sisteminde kurman yeterli. Şu adımları izleyerek projeyi hızlıca ayağa kaldırabilirsin:

1. PostgreSQL indir ve kur. Eğer PostgreSQL yüklü değilse, [buradan indir](https://www.postgresql.org/download/).
2. PostgreSQL kurduktan sonra, pgAdmin'i aç ve yeni bir veritabanı oluştur: **bookAuthorManagement**.
3. Şimdi projeyi klonla:

   ```
   [git clone https://github.com/kullanici_adi/book-author-project.git](https://github.com/Okyanusaydgn/Java-s18-Challenge.git)
   ```

 4. `application.properties dosyasını aç`, aşağıdaki veritabanı ayarlarını kendi bilgilerinle doldur:

    ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/bookAuthorManagement
    spring.datasource.username=postgres
    spring.datasource.password=senin_sifren
    spring.jpa.hibernate.ddl-auto=update
    ```
 5.  IntelliJ IDEA'da projeyi aç ve çalıştır. İşte bu kadar! Artık backend çalışıyor olacak.
    
## 📡 API Endpoint'leri
Aşağıda birkaç endpoint paylaşıyorum. Bu endpoint'ler üzerinden yazarları ve kitapları yönetebilirsin. Örneğin yazar ekleyebilir, mevcut yazarların bilgilerini güncelleyebilir, listeleyebilir veya silebilirsin.

| HTTP Metodu | URL                                | Ne Yapar                               |
|-------------|------------------------------------|----------------------------------------|
| GET         | /workintech/author                 | Tüm yazarları listeler                 |
| POST        | /workintech/author                 | Yeni yazar ekler                       |
| PUT         | /workintech/author/{id}            | Yazar bilgisini günceller              |
| DELETE      | /workintech/author/{id}            | Yazarı siler                           |
| GET         | /workintech/book                   | Tüm kitapları listeler                 |
| POST        | /workintech/book/saveByAuthor      | Yeni bir kitap ekler                   |
| DELETE      | /workintech/book/{id}              | Kitabı siler                           |


## 📄 Örnek İstekler:
### GET /workintech/author
Bu istek, veritabanındaki tüm yazarları listeleyecektir. Postman ile basit bir GET isteği yapabilirsin.
### POST /workintech/author
Yeni bir yazar eklemek için bu endpoint'i kullanabilirsin. Gövde (Body) kısmına aşağıdaki JSON verisini 
ekleyerek yeni bir yazar ekleyebilirsin:
```
{
    "firstName": "Okyanus",
    "lastName": "Aydogan"
}

```
### PUT /workintech/author/{id}
Mevcut bir yazarın bilgilerini güncellemek için bu endpoint'i kullanabilirsin. Örneğin, id değeri 1 olan bir yazarın bilgilerini güncellemek istiyorsan, şu formatta bir PUT isteği yapmalısın:

```

{
    "firstName": "Ali",
    "lastName": "Yılmaz"
}

```
### DELETE /workintech/author/{id}
Bir yazarı silmek için kullanabilirsin. Örneğin, id değeri 2 olan bir yazarı silmek için şu şekilde bir DELETE isteği gönderebilirsin:
```

DELETE /workintech/author/2

```
## 📖  Endpointler

### GET /workintech/book
Açıklama: Tüm kitapların listesini getirir.
Örnek Yanıt:
```
[
  {
    "id": 1,
    "name": "Okyanus",
    "authorId": 1,
    "categoryId": 1
  },
  {
    "id": 2,
    "name": "Fatma",
    "authorId": 2,
    "categoryId": 2
  }
]
```
### POST /workintech/book/saveByAuthor
Açıklama: Yeni bir kitap ekler.
Örnek İstek Gövdesi:
```
{
  "name": "Design Patterns",
  "authorId": 1,
  "categoryId": 1
}
```

### DELETE /workintech/book/{id}
Açıklama: Belirtilen ID'ye sahip kitabı siler.

```
DELETE /workintech/book/2
```

## 🤝 Katkıda Bulunma
Bu projeye katkıda bulunmak istersen, lütfen önce bir sorun açarak veya benimle iletişime geçerek fikirlerini paylaş! Her türlü katkı için açığım. Ayrıca, pull request’ler de memnuniyetle karşılanır.

## 📧 İletişim
Soruların veya önerilerin için benimle iletişime geçebilirsin:
- E-posta: okyanusaydgn@gmail.com
- GitHub: [Okyanusaydgn](https://github.com/Okyanusaydgn)
