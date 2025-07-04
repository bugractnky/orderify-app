# Temel imaj olarak OpenJDK 17 kullan
FROM openjdk:17-jdk-slim

# JAR dosyasını konteyner içine kopyala
COPY target/order-service-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-it.sh /wait-for-it.sh

# Uygulamayı çalıştır
ENTRYPOINT ["/wait-for-it.sh", "order-db:5432", "--", "java", "-jar", "/app.jar"]

