---
page_type: sample
languages:
- java
products:
- azure
description: "This is a sample application to showcase the use of Spring Cloud Function on top of Azure Functions."
urlFragment: hello-spring-function-azure
---

# Example "Hello, world" Spring Boot application that runs on Azure Functions

This is a sample application to showcase the use of Spring Cloud Function on top of Azure Functions.
This sample application is taken from https://github.com/azure-samples/hello-spring-function-azure/tree/master/ and
adopted to provide a sample model for checking some input data structure and return the check result. The check is only
mocked.

## Features

This is just a "Hello, world", but it uses domain objects TestInput, TestResult and so on, so it's easy to extend to do
something more complex.

## Getting Started

### Prerequisites

This project uses the Maven Wrapper, so all you need is Java installed.

### Installation

- Clone the project: `git clone https://github.com/WayneSchlegel/hello-spring-function-azure.git`
- Configure the project to use your own resource group and your own application name (it should be unique across Azure)
  - Open the `pom.xml` file
  - Customize the `functionResourceGroup` and `functionAppName` properties
- Build the project: `./mvnw clean package`

### Quickstart

Once the application is built, you can run it locally using the Azure Function Maven plug-in:

`./mvnw azure-functions:run -DenableDebug`

In IntelliJ this is best done from a terminal window, otherwise you might not be able to terminate the process
afterwards (
ref. https://stackoverflow.com/questions/54183387/how-to-stop-an-azure-function-running-locally-my-windows-10-environment).

And you can test it using a cURL command:

`curl http://localhost:7071/api/check -d '{"someParameter": "Azure"}'`

## Deploying to Azure Functions

Deploy the application on Azure Functions with the Azure Function Maven plug-in:

`./mvnw azure-functions:deploy`

You can then test the running application, by running a POST request:

```
curl https://<YOUR_SPRING_FUNCTION_NAME>.azurewebsites.net/api/check -d '{"someParameter": "Azure"}'
```

Or a GET request:

```
curl https://<YOUR_SPRING_FUNCTION_NAME>.azurewebsites.net/api/check?someParameter=Azure
```

Replace the `<YOUR_SPRING_FUNCTION_NAME>` part by the name of your Spring Function.
