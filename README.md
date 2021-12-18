# CakeManager
Cake Manager:
- Is a microservice
- Is a spring boot application
- Provides REST Endpoints for CakeManager client microservice https://github.com/Mohammedmurshadhaque/CakeManagerClient,
  by implementing server api interfaces, which are generatede by https://github.com/Mohammedmurshadhaque/CakeManagerApi
- Also act as a resource server and authorization server (Oauth2).
- For getting the access token, please use the follwoings
  Token endpoint: http://localhost:8080/oauth/token
  clientId: client
  secret: secret
  grant_type=password
  username=waracle
  password=password
  This access token will used used by https://github.com/Mohammedmurshadhaque/CakeManagerClient, the client sets a Header called "Authorization" and value is the access token.
