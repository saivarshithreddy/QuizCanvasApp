# QuizCanvasApp

A modern, full-stack web application for creating, managing, and playing quizzes. Built with **Spring Boot 3** (backend), **React 18** (frontend), **MySQL**, and secured with **OAuth2** authentication. Easily deployable with **Docker** on the cloud.

---

## ✨ Features

- User authentication with Google & GitHub (OAuth2)
- Create, edit, and play quizzes
- User management and admin roles
- Track quiz history and scores
- Responsive, modern UI (React 18)
- Secure REST API (Spring Boot 3)
- MySQL persistent storage
- Docker-based deployment (local & cloud)

---

## 🛠️ Tech Stack

- **Frontend:** React 18, TypeScript, CSS Modules
- **Backend:** Spring Boot 3, Java 17+
- **Database:** MySQL
- **Auth:** OAuth2 (Google, GitHub)
- **Deployment:** Docker, AWS EC2, NGINX, Let's Encrypt SSL

---

## 🚀 Getting Started (Local Development)

### 1. Backend Setup
- Configure `backend/src/main/resources/application-local.yml` with your:
  - Google/GitHub OAuth2 credentials
  - JWT secret key
  - Admin email
- Start MySQL database (see below)
- Run backend:
  ```bash
  cd backend/
  mvn spring-boot:run -Dspring-boot.run.profiles=local
  ```

### 2. Database Setup
```bash
cd database/
docker compose up
```

### 3. Frontend Setup
```bash
cd frontend/
npm ci   # Only needed the first time
npm start
```
The app will be available at [http://localhost:3000](http://localhost:3000)

---

## ☁️ Deployment

1. **Provision AWS EC2 Instance** (Ubuntu recommended)
2. **Install Docker**
3. **Upload config files** (`docker-compose.yml`, NGINX configs)
4. **Start services**
5. **Set up SSL with Let's Encrypt**
6. **Update DNS for your domain**

See detailed deployment steps in the original README or `/aws/` folder.

---

## 🤝 Contributing

Contributions are welcome! Please open issues or submit pull requests for new features, bug fixes, or improvements.

---

## 📄 License

This project is licensed under the MIT License.

---

## 📬 Contact

For questions, contact the maintainer via GitHub Issues.
