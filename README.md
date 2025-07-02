# QuizCanvasApp

# 🌐 Full Stack Web Application - Spring Boot 3 & React 18

This is a **full stack web application** built using:

- ⚙️ **Spring Boot 3** (Backend)
- 🌐 **React 18** (Frontend)
- 🛡️ **OAuth2 authentication** with Google & GitHub
- 🗄️ **MySQL** for persistent storage
- ☁️ **Docker-based deployment** on AWS EC2
- 🔒 **SSL encryption** with Let's Encrypt

This project is designed for hands-on learning and professional-grade development. You'll integrate secure login, process flows, database, and frontend/backend connectivity, then deploy and secure it in the cloud.

---

## 🚀 Local Development Setup

### 1. Update Backend Configuration

Edit the following file:

backend/src/main/resources/application-local.yml

yaml
Copy
Edit

Add:

- Google OAuth2 credentials  
- GitHub OAuth2 credentials  
- JWT secret key  
- Admin email  

---

### 2. Start the MySQL Database

```bash
cd database/
docker compose up
This will start the database required by the backend.

3. Run the Spring Boot Backend
bash
Copy
Edit
cd backend/
mvn spring-boot:run -Dspring-boot.run.profiles=local
4. Run the React Frontend
bash
Copy
Edit
cd frontend/
npm ci         # Run this only the first time to install dependencies
npm start
The frontend app will be available at:

arduino
Copy
Edit
http://localhost:3000
☁️ AWS Cloud Deployment
1. Install Docker on AWS EC2 Instance
bash
Copy
Edit
ssh -i <path-to-key.pem> <user>@<ec2-host>
curl -fsSL https://get.docker.com -o get-docker.sh && sh get-docker.sh
sudo usermod -aG docker $USER
newgrp docker
2. Upload Config Files to EC2
bash
Copy
Edit
scp -i <path-to-key.pem> aws/docker-compose.yml <user>@<ec2-host>:docker-compose.yml
ssh -i <path-to-key.pem> <user>@<ec2-host> "mkdir -p nginx/conf"
scp -i <path-to-key.pem> aws/nginx.http.conf <user>@<ec2-host>:nginx/conf/nginx.http.conf
📌 Use nginx.http.conf before generating an SSL certificate.

3. Start Services and Generate SSL Certificate
bash
Copy
Edit
ssh -i <path-to-key.pem> <user>@<ec2-host>

docker compose up -d

docker compose run certbot certonly \
  --webroot --webroot-path /var/www/certbot/ \
  -d <your-domain.com>

# Confirm the certificate exists:
sudo ls -al certbot/conf/live/<your-domain.com>/
4. Upload HTTPS NGINX Config
bash
Copy
Edit
scp -i <path-to-key.pem> aws/nginx.https.conf <user>@<ec2-host>:nginx/conf/nginx.https.conf
5. Restart Docker Compose
bash
Copy
Edit
ssh -i <path-to-key.pem> <user>@<ec2-host>
docker compose restart
Your application will now be live over HTTPS at:
https://<your-domain.com>
