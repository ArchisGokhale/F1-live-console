# 🏎️ F1 Live Console
### Real-Time Formula 1 Analytics Dashboard  
**Built with Maven • Java Swing • Spring Boot • MySQL**

---

## 🚀 Overview
F1 Live Console is a full-stack analytics platform for visualizing **live & historical Formula 1 telemetry**, driver statistics, race comparisons, and animated track maps.  
The desktop UI is a Java Swing application; the backend is a Spring Boot REST API backed by MySQL.

---

## ✨ Key Features
- Side-by-side **historical driver / race comparisons**  
- **Lap time & speed charts**, per-lap telemetry graphs  
- **Animated track map** with team color markers  
- MySQL storage for drivers, races, laps and telemetry  
- Spring Boot REST API for data retrieval (consumed by the Swing client)

---

## 📸 Screenshots
<img src="https://raw.githubusercontent.com/ArchisGokhale/F1-live-console/main/Screenshot%202025-11-14%20213325.png" width="900"/>

<img src="https://raw.githubusercontent.com/ArchisGokhale/F1-live-console/main/Screenshot%202025-11-14%20213341.png" width="900"/>

<img src="https://raw.githubusercontent.com/ArchisGokhale/F1-live-console/main/Screenshot%202025-11-14%20213409.png" width="900"/>

<img src="https://raw.githubusercontent.com/ArchisGokhale/F1-live-console/main/Screenshot%202025-11-14%20213445.png" width="900"/>

---

## 🏗️ Tech Stack
| Layer | Technology |
|---|---|
| Desktop | Java Swing (Maven), Graphics2D |
| Backend | Spring Boot (REST) |
| Database | MySQL |
| Build | Maven |
| Data | JSON over REST, JDBC / Spring Data JPA |

---

## ✅ Prerequisites
- Java JDK 17+ installed and on `PATH`  
- Maven 3.6+  
- MySQL 5.7+ (or compatible)  
- `git`

---

## ⚙️ FULL INSTALL & RUN (Backend + DB + Desktop)

### 1) Clone repository

git clone https://github.com/ArchisGokhale/F1-live-console.git
cd F1-live-console
2) Database (MySQL) — create DB & user
Start MySQL


3) Backend — configure and run Spring Boot
Open backend/src/main/resources/application.properties (or .yml) and set DB credentials:


🧩 Project Layout (recommended)
css
Copy code
F1-live-console/
├── backend/            # Spring Boot application
│   ├── src/main/java/...controllers
│   ├── src/main/java/...services
│   ├── src/main/java/...repositories
│   └── src/main/resources/application.properties
├── swing-client/       # Java Swing desktop app
│   ├── src/main/java/...ui
│   └── src/main/resources/ (images, config)
├── sql/                # schema.sql, seed data
└── README.md
💡 Tips & Config
Use spring.jpa.hibernate.ddl-auto=validate in production to avoid accidental schema changes.

For heavy telemetry data, consider indexing race_id, driver_id columns and batching inserts.

For packaged distribution, create a script that launches backend and desktop with proper env vars.

🧪 Development & Debugging
Backend logs appear on console; increase logging in application.properties for TRACE/DEBUG.

If the Swing client shows no data: verify http://localhost:8080/actuator/health (if actuator enabled) or simple /api/drivers.

Use Postman / curl to test APIs before running the desktop client.

👨‍💻 Author
Archis Gokhale

