docker network create product-mysql
docker container run --name mysqldb --network product-mysql -e MYSQL_ROOT_PASSWORD=123@Toor -e MYSQL_DATABASE=product -d mysql:8
docker image build -t product .
echo "Waiting for 10 seconds for MYSQL Database is ready..."
sleep 10
docker container run --network product-mysql --name product-container -p 8080:8080 -d product
