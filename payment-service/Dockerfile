# OpenJDK 17 tabanlı hafif bir imaj kullan
FROM openjdk:17-jdk-slim

# JAR dosyasını konteyner içine kopyala
COPY target/payment-service-0.0.1-SNAPSHOT.jar app.jar

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "/app.jar"]

