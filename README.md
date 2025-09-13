# 🚀 Quote Generator Backend

Spring Boot REST API backend for the InspireFlow quote generator application. Provides random inspirational quotes with fallback support.

## 🌟 Features

- **RESTful API** endpoints for quote management
- **External API integration** with Quotable.io
- **Fallback system** with 50+ curated demo quotes
- **CORS configured** for React frontend integration
- **Health check** endpoint for monitoring
- **Error handling** and graceful degradation

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Web MVC**
- **RESTful APIs**
- **Maven** for dependency management

## 📡 API Endpoints

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/api/health` | GET | Service health check |
| `/api/quote` | GET | Get random quote (external API + fallback) |
| `/api/quotes/demo` | GET | Get demo quote only |
| `/api/quotes/category/{category}` | GET | Get quotes by category |
| `/api/quotes/random/{count}` | GET | Get multiple random quotes |

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Installation
```bash
# Clone the repository
git clone https://github.com/YOUR_USERNAME/quote-generator-backend.git
cd quote-generator-backend

# Build the project
mvn clean package

# Run the application
java -jar target/quote-generator-backend-0.0.1-SNAPSHOT.jar