mvn clean install
docker network create product-mysql
docker container run --name mysqldb --network product-mysql -e MYSQL_ROOT_PASSWORD=123@Toor -e MYSQL_DATABASE=product -d mysql:8
docker image build -t product .
docker container run --network product-mysql --name product-container -p 8080:8080 -d product
