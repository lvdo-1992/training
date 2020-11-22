From openjdk:8
copy ./target/product-0.0.1-SNAPSHOT.jar product-0.0.1-SNAPSHOT.jar
CMD ["java","-jar", "-Dspring.profiles.active=prod", "product-0.0.1-SNAPSHOT.jar"]
