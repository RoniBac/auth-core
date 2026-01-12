# AuthCore

**AuthCore** is a modular Java authentication library supporting local and Google OAuth authentication. It is designed to be reusable, decoupled, and fully tested with JUnit.

## Features
- Modular architecture using providers
- Unit-tested functionality
- `UserIdentity` model for user data
- Ready for integration with Java backends (Spring Boot, Micronaut, etc.)
- Supports local auth and Google OAuth

## Project Structure
auth-core/
├─ src/main/java/com/auth/core/
│ ├─ AuthService.java
│ ├─ model/
│ │ ├─ AuthRequest.java
│ │ ├─ AuthResult.java
│ │ └─ UserIdentity.java
│ └─ providers/
│ ├─ AuthProvider.java
│ ├─ LocalAuthProvider.java
│ └─ GoogleAuthProvider.java
├─ src/test/java/com/auth/core/AuthServiceTest.java
├─ pom.xml
└─ README.md

## Usage

Add as a Maven dependency (local repo):
 
<dependency>
  <groupId>com.auth</groupId>
  <artifactId>auth-core</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>

## Initialize AuthService with providers:


Map<AuthType, AuthProvider> providers = Map.of(
    AuthType.LOCAL, new LocalAuthProvider(),
    AuthType.GOOGLE, new GoogleAuthProvider()
);
AuthService authService = new AuthService(providers);
AuthRequest request = new AuthRequest(AuthType.GOOGLE, "google-token", "user@gmail.com");
AuthResult result = authService.authenticate(request);
System.out.println("Authenticated: " + result.isAuthenticated());
System.out.println("User email: " + result.getUser().getEmail());
## Testing
### Tests in AuthServiceTest.java validate:

-Local auth works

-Google auth works

-Empty credentials fail

## Run tests:

mvn test

### Notes
- Integrate with web backends and expose REST endpoints

- Use JWT or sessions for real apps

- Replace the simulated Google token with real OAuth tokens for production

## License
MIT – free to use and modify.

📄 Licencia
MIT License – libre para usar y modificar.
