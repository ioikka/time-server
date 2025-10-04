# Time Server API

A simple Spring Boot application that provides a REST API to get the current server time.

## Features

- Get current server time in ISO-8601 format with timezone offset
- Get current timestamp in milliseconds since Unix epoch
- Lightweight and fast REST endpoint

## Prerequisites

- Java 21 or later
- Maven 3.6.3 or later

## Getting Started

### Building the Application

```bash
mvn clean package
```

### Running the Application

```bash
mvn spring-boot:run
```

The application will start on port 8080 by default.

## API Endpoints

### Get Current Time

Returns the current server time and timestamp.

- **URL**: `/time`
- **Method**: `GET`
- **Response**: 
  ```json
  {
    "serverTime": "2025-10-04T23:45:30+02:00",
    "timestamp": "1728085530000"
  }
  ```
  - `serverTime`: Current server time in ISO-8601 format with timezone offset
  - `timestamp`: Current timestamp in milliseconds since Unix epoch

## Technologies Used

- Java 21
- Spring Boot 3.5.6
- Maven

## Project Structure

```
src/
├── main/
│   └── java/io/ikka/demo/
│       ├── TimeApiApplication.java    # Main application class
│       └── TimeController.java        # REST controller with time endpoint
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.