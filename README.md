"# 📚 Kitap Yazar Projesi Merhaba! 👋 Bu proje, yazarlar, kitaplar ve kategoriler arasında bir yönetim sistemi sunan basit bir **Spring Boot** uygulaması. **PostgreSQL** ile veritabanı işlemlerini hallediyoruz ve **Hibernate** ile ORM kullanıyoruz. Hadi birlikte bakalım nasıl çalışıyor! 🚀 ## İçindekiler - [Kurulum](#kurulum-🛠️) - [Projeyi Çalıştırma](#projeyi-çalıştırma-🏃‍♂️) - [API'leri Test Et!](#api'leri-test-et-📡) - [Sonuç](#sonuç-🎯) - [Lisans](#lisans) ## Kurulum 🛠️ ### Gereksinimler - **Java 17** ☕ - **Spring Boot 3.x** 🌱 - **PostgreSQL 15** 🐘 - **Postman** (API'leri test etmek için) 📬 ### Veritabanı Ayarları Projemiz, PostgreSQL'e bağlı ve ilgili ayarlar `application.properties` dosyasında. İşte önemli ayarlar:

```
properties
spring.application.name=Book-Author-Project
server.servlet.context-path=/workintech
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/projects
spring.datasource.username=postgres
spring.datasource.password=your_password_here
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.default_schema=fsweb
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

### Projeyi Çalıştırma 🏃‍♂️ Projeyi klonlayın: bash Kodu kopyala git clone https://github.com/kullanici_adiniz/kitap-yazar-projesi.git application.properties dosyasındaki PostgreSQL bilgilerinizi güncelleyin. Terminale gidip şu komutla projeyi çalıştırın: bash Kodu kopyala mvn spring-boot:run API'leri Test Et! 📡 Postman ile API'lerimizi test etmek çok kolay! İşte birkaç örnek endpoint: 1. Yeni Yazar Oluştur ✍️ Method: POST Endpoint: /author Body: json Kodu kopyala { "firstName": "Okyanus", "lastName": "Aydogan" } Postman'de POST methodunu seçip, http://localhost:8080/workintech/author endpoint'ine yukarıdaki body'yi ekleyip gönder. 🎯 2. Tüm Yazarları Getir 📚 Method: GET Endpoint: /author Postman'de sadece GET methodunu ve şu URL'yi kullanman yeterli: http://localhost:8080/workintech/author. 3. Yeni Kategori Oluştur 🏷️ Method: POST Endpoint: /category Body: json Kodu kopyala { "name": "Fiction" } Yine Postman'de POST methodunu ve http://localhost:8080/workintech/category endpoint'ini kullanarak yukarıdaki body'yi gönder. Kategorin hazır! 4. Kitap Kaydet ve Yazara/Kategoriye Bağla 📖 Method: POST Endpoint: /book/saveByAuthor Parametreler: categoryId: Kategori ID'si authorId: Yazar ID'si Body: json Kodu kopyala { "name": "Java Programming" } Postman'de: URL: http://localhost:8080/workintech/book/saveByAuthor?categoryId={categoryId}&authorId={authorId} Body'de kitabını kaydet! ### Sonuç 🎯 Bu proje, kitaplar ve yazarlar arasında basit bir CRUD yönetimi sunuyor. Spring Boot ve PostgreSQL ile çalışırken Postman kullanarak rahatça test edebilirsin. Hadi, biraz kod yazmanın ve eğlenmenin tam zamanı! 😎
