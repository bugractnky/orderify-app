# Orderify Microservices Demo

Orderify, modern mikroservis mimarisiyle geliştirilmiş, **Spring Boot**, **Spring Cloud**, **Docker Compose** ve **PostgreSQL** tabanlı bir demo projedir.  
Gerçek dünyadaki kurumsal uygulamalara benzer şekilde; servis keşfi, API gateway, JWT authentication, merkezi veritabanı, örnek veri ve Swagger/OpenAPI dokümantasyonu içerir.

---

## İçindekiler

- [Mimari](#mimari)
- [Teknolojiler](#teknolojiler)
- [Kurulum](#kurulum)
- [Servisler ve Portlar](#servisler-ve-portlar)
- [Kullanım](#kullanım)
- [Örnek API İstekleri](#örnek-api-istekleri)
- [Geliştirici Notları](#geliştirici-notları)
- [Lisans](#lisans)

---

## Mimari

```mermaid
graph TD
    subgraph Discovery & Gateway
        A[discovery-service (Eureka)]
        B[gateway-service (Spring Cloud Gateway)]
    end
    subgraph Microservices
        C[order-service]
        D[payment-service]
        E[user-service]
    end
    subgraph Databases
        F[order-db (PostgreSQL)]
        G[payment-db (PostgreSQL)]
        H[user-db (PostgreSQL)]
    end

    B --> C
    B --> D
    B --> E
    C --> F
    D --> G
    E --> H
    C -->|Service Discovery| A
    D -->|Service Discovery| A
    E -->|Service Discovery| A
    B -->|Service Discovery| A
```

---

## Teknolojiler

- **Spring Boot 3.x**
- **Spring Cloud (Eureka, Gateway)**
- **Spring Security & JWT**
- **Spring Data JPA**
- **PostgreSQL**
- **Docker & Docker Compose**
- **Swagger/OpenAPI (springdoc)**
- **Maven**

---

## Kurulum

### 1. Gereksinimler

- Docker & Docker Compose
- Java 17 (lokal geliştirme için)
- Maven (lokal geliştirme için)

### 2. Projeyi Klonla

```bash
git clone https://github.com/bugractnky/orderify-app.git
cd orderify-app
```

### 3. Tüm Servisleri ve Veritabanlarını Başlat

```bash
docker-compose up --build -d
```

> Tüm servisler ve veritabanları otomatik olarak başlatılır.  
> İlk başlatmada örnek veriler otomatik olarak yüklenir.

---

## Servisler ve Portlar

| Servis              | Açıklama                | Port (Host) | Swagger UI                        |
|---------------------|-------------------------|-------------|-----------------------------------|
| discovery-service   | Eureka Service Discovery| 8761        | -                                 |
| gateway-service     | API Gateway             | 8080        | -                                 |
| order-service       | Sipariş Yönetimi        | 8081        | /swagger-ui/index.html            |
| payment-service     | Ödeme Yönetimi          | 8082        | /swagger-ui/index.html            |
| user-service        | Kullanıcı & Auth        | 8084        | /swagger-ui/index.html            |
| order-db            | PostgreSQL (order)      | 5433        | -                                 |
| payment-db          | PostgreSQL (payment)    | 5434        | -                                 |
| user-db             | PostgreSQL (user)       | 5435        | -                                 |

---

## Kullanım

### 1. **Swagger UI ile API Testi**

Her servisin Swagger arayüzüne aşağıdaki adreslerden ulaşabilirsin:

- Order:   [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)
- Payment: [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)
- User:    [http://localhost:8084/swagger-ui/index.html](http://localhost:8084/swagger-ui/index.html)

### 2. **Kullanıcı Kaydı ve Giriş (JWT)**

#### Register

```http
POST /api/auth/register
Content-Type: application/json

{
  "username": "testuser",
  "password": "123456"
}
```

#### Login

```http
POST /api/auth/login
Content-Type: application/json

{
  "username": "testuser",
  "password": "123456"
}
```

Yanıt:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### 3. **JWT ile Korunan Servisleri Kullanmak**

- Login sonrası dönen JWT token'ı, diğer servislerin korumalı endpoint'lerinde `Authorization: Bearer <token>` header'ı ile kullanabilirsin.

---

## Geliştirici Notları

- **Servisler arası iletişim**: Eureka ile servis isimleri üzerinden yapılır.
- **Veritabanı şeması ve örnek veri**: Her servis kendi veritabanı ile başlar ve örnek veri otomatik yüklenir.
- **API Gateway**: Tüm trafiği merkezi olarak yönetir, istenirse rate limiting, logging, JWT doğrulama gibi ek filtreler eklenebilir.
- **Güvenlik**: User-service ile JWT tabanlı authentication, diğer servislerde kolayca entegre edilebilir.
- **Geliştirme**: Her servisi bağımsız olarak geliştirebilir, test edebilir ve yeniden başlatabilirsin.

---

## Lisans

MIT License

---

> **Not:**  
> Proje, gerçek dünyadaki mikroservis mimarisi, Docker ile izole geliştirme ve modern authentication örnekleri için hazırlanmıştır.  
> Her türlü katkı ve PR'a açıktır!

---

**GitHub:** [github.com/bugractnky/orderify-app](https://github.com/bugractnky/orderify-app) 