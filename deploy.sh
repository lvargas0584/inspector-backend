git pull
sh mvnw clean package
docker stop inspector-backend
docker run -d --rm -i -p 8080:8080   --name inspector-backend  quarkus/inspector-backend
