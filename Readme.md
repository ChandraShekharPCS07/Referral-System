# Referral System API

A Spring Boot backend application providing a user referral system with configurable admin settings. It supports user registration with referral codes, tracks referral relationships, and allows admin configuration via REST APIs.

---

## 📦 Features

- User registration with optional referral codes
- Unique referral code generation and validation
- Referral tracking
- Admin-configurable key-value settings
- H2 in-memory database for easy local development
- Postman collection included for API testing

---

## 🚀 Technology Stack

- Java 17+
- Spring Boot 3
- Spring Data JPA (Hibernate)
- H2 Database
- Maven or Gradle
- Postman

---

## 📁 Project Structure
```
.  
├── src/  
│ └── main/java/...  
├── postman/  
│ └── ReferralApp.postman_collection.json  
├── README.md  
└── ...
```
---

## 🛠️ Getting Started

### Prerequisites

- Java 17 or newer
- Maven or Gradle installed
- (Optional) Postman for API testing

---

### Clone the Repository

```bash
git clone https://github.com/ChandraShekharPCS07/Referral-System.git
cd Referral-System
```
---

### Build and Run

**Using Maven:**

```bash
./mvnw spring-boot:run
```
**Using Gradle:**

```bash
./gradlew bootRun
```

The server will start at:
```
http://localhost:8080
```
---

### H2 Database Console

- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    
- **JDBC URL:** `jdbc:h2:mem:testdb`
    
- **Username:** `sa`
    
- **Password:** _(leave blank)_
    

Schema is auto-generated on startup.

---

## 🌐 API Endpoints

|Method|Endpoint|Description|
|---|---|---|
|POST|`/api/users/register`|Register a new user|
|GET|`/api/users/{id}`|Retrieve user details|
|GET|`/api/admin/config`|Get all admin configurations|
|POST|`/api/admin/config`|Create or update admin configuration|

---

## 📑 API Documentation

All API requests and sample payloads are included in the Postman collection in this repo.

---

## 📬 Postman Collection

A Postman collection is included for easy testing:

postman/ReferralApp.postman_collection.json

### How to use it:

1. Open Postman
    
2. Click **Import**
    
3. Choose **File** and select `ReferralApp.postman_collection.json`
    
4. Click **Import**
    

You can now test all endpoints directly.

---

## 📝 Environment Variables (Postman)

If using variables (e.g. referralCode):

- Make sure to **define them** in your Postman environment
    
- Replace placeholders like `{{referralCode}}` with actual values to avoid request errors
    

---

## ⚠️ Common Issues

- **Invalid Characters in URL**: Make sure you replace template variables (like `{{referralCode}}`) with real values before sending the request.

---

## 🤝 Contributing

Contributions are welcome! Please:

1. Fork the repository
    
2. Create your feature branch (`git checkout -b feature/YourFeature`)
    
3. Commit your changes (`git commit -am 'Add your feature'`)
    
4. Push to the branch (`git push origin feature/YourFeature`)
    
5. Create a new Pull Request
    

---

## 📜 License

This project is open-source and available under the MIT License.

---

## ❤️ Acknowledgements

- Spring Boot team for the framework
    
- H2 Database for easy local testing
    
- Postman for simplifying API testing
    

---
