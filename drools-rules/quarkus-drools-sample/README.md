# Quarkus Drools Sample

This project uses Kogito to integrate Drools into Quarkus.

We run the app with this command:

```bash
mvn quarkus:dev
```

It has an integrated [Swagger UI](http://localhost:8080/q/swagger-ui/).

we can send loan applications to the endpoint:

```bash
curl -X 'POST' \
  'http://localhost:8080/applications' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "applications": [
    {
      "person": {
        "name": "Tom",
        "age": 14
      },
      "conditions": {
        "creditScore": 10,
        "income": 50000,
        "debt": 0
      }
    },
    {
      "person": {
        "name": "Julia",
        "age": 18
      },
      "conditions": {
        "creditScore": 10,
        "income": 50000,
        "debt": 0
      }
    }
  ]
}' -i
```

## Use Custom API Endpoint

We run the app with the `custom-api` profile activated. This allows to specify the API manually instead of directly mapping the domain objects to the API.

```bash
mvn quarkus:dev -Dquarkus-profile=dev,custom-api
```

We can send the same request.

> [!CAUTION]
> The rule model is serialized and deserialized with Jackson during
> evaluation, so we should avoid Jackson annotations for direct mapping
> to the API, e.g. 
> `@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)`
> would lead to NullPointerExceptions.
