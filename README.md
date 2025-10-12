# Spring Boot SendGrid Email Service

A Spring Boot application that demonstrates email sending functionality using SendGrid API.

## Features

- Send emails via SendGrid API
- RESTful API endpoint for email sending
- Thymeleaf template support for web interface
- Lombok integration for cleaner code
- Spring Boot DevTools for development
- Configuration-based setup

## Technologies Used

- **Java 21**
- **Spring Boot 3.5.6**
    - Spring Boot Starter Web
    - Spring Boot Starter Thymeleaf
    - Spring Boot DevTools
    - Spring Boot Configuration Processor
- **SendGrid Java SDK 4.10.3**
- **Twilio SDK 11.0.0**
- **Lombok** - For reducing boilerplate code
- **Maven** - Build and dependency management

## Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed
- Maven 3.6+ installed
- A SendGrid account with an API key ([Sign up here](https://sendgrid.com/))
- Git (optional, for cloning the repository)

## Installation

1. Clone the repository:

```bash
git clone https://github.com/hendisantika/springboot-sendgrid.git
cd springboot-sendgrid
```

2. Update the SendGrid API key in `src/main/resources/application.properties`:

```properties
sendgrid.key=YOUR_SENDGRID_API_KEY_HERE
server.port=8888
```

3. Build the project:

```bash
mvn clean install
```

## Configuration

### Application Properties

Edit `src/main/resources/application.properties`:

```properties
# SendGrid API Key - Replace with your actual SendGrid API key
sendgrid.key=YOUR_SENDGRID_API_KEY_HERE
# Server port
server.port=8888
```

### Getting SendGrid API Key

1. Sign up for a SendGrid account at [https://sendgrid.com/](https://sendgrid.com/)
2. Navigate to Settings > API Keys
3. Create a new API key with "Full Access" or "Mail Send" permissions
4. Copy the API key and replace `YOUR_SENDGRID_API_KEY_HERE` in `application.properties`

## Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using Java

```bash
java -jar target/springboot-sendgrid-0.0.1-SNAPSHOT.jar
```

The application will start on port 8888. Access it at: `http://localhost:8888`

## API Endpoints

### Send Email

**Endpoint:** `POST /sendemail`

**Content-Type:** `application/json`

**Request Body:**

```json
{
  "to": "recipient@example.com",
  "subject": "Test Email",
  "body": "This is a test email sent from Spring Boot SendGrid application."
}
```

**Success Response:**

```
HTTP Status: 200 OK
Body: "send successfully"
```

**Error Response:**

```
HTTP Status: 404 NOT FOUND
Body: "failed to sent"
```

### Example using cURL

```bash
curl -X POST http://localhost:8888/sendemail \
  -H "Content-Type: application/json" \
  -d '{
    "to": "recipient@example.com",
    "subject": "Test Email",
    "body": "Hello from Spring Boot SendGrid!"
  }'
```

### Example using Postman

1. Set method to `POST`
2. URL: `http://localhost:8888/sendemail`
3. Headers: `Content-Type: application/json`
4. Body (raw JSON):

```json
{
  "to": "your-email@example.com",
  "subject": "Test from Postman",
  "body": "This is a test email sent via Postman"
}
```

## Project Structure

```
springboot-sendgrid/
├── src/
│   ├── main/
│   │   ├── java/com/hendisantika/
│   │   │   ├── SpringbootSendgridApplication.java    # Main application class
│   │   │   ├── config/
│   │   │   │   └── SendgridConfig.java               # SendGrid configuration
│   │   │   ├── controller/
│   │   │   │   └── EmailController.java              # REST controller
│   │   │   ├── dto/
│   │   │   │   └── EmailRequest.java                 # Email request DTO
│   │   │   └── service/
│   │   │       └── EmailService.java                 # Email service logic
│   │   └── resources/
│   │       ├── application.properties                # Application configuration
│   │       └── templates/
│   │           └── index.html                        # Thymeleaf template
│   └── test/
│       └── java/com/hendisantika/
│           └── SpringbootSendgridApplicationTests.java
├── pom.xml                                           # Maven configuration
└── README.md
```

## Key Components

### EmailController

Handles HTTP requests for sending emails. Exposes the `/sendemail` endpoint.

### EmailService

Contains the business logic for sending emails through SendGrid API. Configures email sender, recipient, subject, and
body.

### SendgridConfig

Spring configuration class that creates a SendGrid bean using the API key from application properties.

### EmailRequest

DTO (Data Transfer Object) for email request containing:

- `to`: Recipient email address
- `subject`: Email subject
- `body`: Email body content

## Testing

Run the tests with:

```bash
mvn test
```

## Building for Production

Create a production-ready JAR:

```bash
mvn clean package
```

The JAR file will be created in the `target` directory.

## Troubleshooting

### Lombok Issues

If you encounter compilation errors related to getter/setter methods, ensure:

1. Lombok is properly installed in your IDE
2. Annotation processing is enabled in your IDE
3. The Maven compiler plugin is configured correctly (already done in `pom.xml`)

### SendGrid API Errors

- Verify your API key is valid and has the correct permissions
- Check that your SendGrid account is active and verified
- Ensure the sender email is verified in your SendGrid account
- Check SendGrid's [API documentation](https://docs.sendgrid.com/) for specific error codes

## Notes

- The sender email is currently hardcoded as `hendisantika@yahoo.co.id` in `EmailService.java`. You may want to make
  this configurable.
- The application uses plain text emails. You can modify it to support HTML emails by changing the Content type.
- Make sure to keep your SendGrid API key secure and never commit it to version control.

## Author

**Hendi Santika**

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source and available for educational and commercial purposes.

## Contributing

Feel free to submit issues and enhancement requests!

## Resources

- [SendGrid Documentation](https://docs.sendgrid.com/)
- [Spring Boot Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [Lombok Documentation](https://projectlombok.org/)
