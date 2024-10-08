## API’leri Test Et! 📡
Postman ile API'lerimizi test etmek çok kolay! İşte birkaç örnek endpoint:

### 1. Yeni Yazar Oluştur ✍️
- **Method:** POST
- **Endpoint:** /author

**Body:**

```json
{
  "firstName": "Okyanus",
  "lastName": "Aydogan"
}
## API’leri Test Et! 📡
Postman ile API'lerimizi test etmek çok kolay! İşte birkaç örnek endpoint:

### 1. Yeni Yazar Oluştur ✍️
- **Method:** POST
- **Endpoint:** /author

Postman'de POST methodunu seçip, `http://localhost:8080/workintech/author` endpoint'ine aşağıdaki body'yi ekleyip gönder. 🎯

```json
{
  "firstName": "Okyanus",
  "lastName": "Aydogan"
}
### 2. Tüm Yazarları Getir 📚
- **Method:** GET
- **Endpoint:** /author

Postman’de sadece GET methodunu ve şu URL'yi kullanman yeterli: `http://localhost:8080/workintech/author`.

### 3. Yeni Kategori Oluştur 🏷️
- **Method:** POST
- **Endpoint:** /category

**Body:**

```json
{
  "name": "Fiction"
}
Yine Postman’de POST methodunu ve `http://localhost:8080/workintech/category` endpoint'ini kullanarak yukarıdaki body'yi gönder. Kategorin hazır!

### 4. Kitap Kaydet ve Yazara/Kategoriye Bağla 📖
- **Method:** POST
- **Endpoint:** /book/saveByAuthor

**Parametreler:**
- `categoryId`: Kategori ID'si
- `authorId`: Yazar ID'si

**Body:**

```json
{
  "name": "Java Programming"
}
Postman’de:
- **URL:** `http://localhost:8080/workintech/book/saveByAuthor?categoryId={categoryId}&authorId={authorId}`
- Body'de kitabını kaydet!

### Postman Kullanımı 🧪
Postman’de yeni istekler oluşturarak yukarıdaki API’leri test edebilirsin. API URL'lerini ekleyip, GET ya da POST gibi methodları seçerek ve gerekli body'yi ekleyerek hemen işe başlayabilirsin!

### Sonuç 🎯
Bu proje, kitaplar ve yazarlar arasında basit bir CRUD yönetimi sunuyor. Spring Boot ve PostgreSQL ile çalışırken Postman kullanarak rahatça test edebilirsin. Hadi, biraz kod yazmanın ve eğlenmenin tam zamanı! 😎
