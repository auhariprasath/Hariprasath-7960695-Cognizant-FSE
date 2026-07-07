# REST - Country Web Service

## 1. What happens in the controller method?

When the client sends the request:

```http
GET /country
```

Spring invokes the controller method:

```java
getCountryIndia()
```

Inside the method:

```java
ApplicationContext context =
        new ClassPathXmlApplicationContext("country.xml");
```

This loads the XML configuration file.

Then:

```java
Country country =
        (Country) context.getBean("india");
```

retrieves the bean named **india** from the Spring container.

Finally, the method returns:

```java
return country;
```

Since the controller is annotated with:

```java
@RestController
```

Spring understands that the returned object must be sent directly in the HTTP response body.

---

## 2. How is the bean converted into a JSON response?

Spring Boot automatically uses the **Jackson** library for JSON conversion.

The returned object:

```java
Country country
```

contains getter methods:

```java
getCode()
getName()
```

Jackson serializes the object into JSON format:

```json
{
  "code": "IN",
  "name": "India"
}
```

This process is known as **Object Serialization**.

### Internal Flow

```text
Country Object
      ↓
Jackson ObjectMapper
      ↓
JSON
      ↓
HTTP Response Body
```

No additional code is required because Spring Boot includes Jackson by default.

---

## 3. HTTP Headers in Browser Network Tab

Open:

**Developer Tools → Network → country**

Typical response headers:

```http
HTTP/1.1 200 OK

Content-Type: application/json
Content-Length: 29
Date: Tue, 07 Jul 2026 05:30:10 GMT
Connection: keep-alive
```

Request headers may contain:

```http
Accept: application/json
Host: localhost:8083
User-Agent: Mozilla/5.0
Accept-Encoding: gzip
```

---

## 4. HTTP Headers in Postman

Open **Postman** and send the request:

```http
GET http://localhost:8083/country
```

Click the **Headers** tab to view the response headers.

Example response headers:

```http
Content-Type: application/json
Content-Length: 29
Date: Tue, 07 Jul 2026 05:30:10 GMT
Connection: keep-alive
```

Response status:

```http
200 OK
```
