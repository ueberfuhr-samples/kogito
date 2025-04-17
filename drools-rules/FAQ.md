# Frequently Asked Questions (FAQ)

1. [How does Kogito refer to Drools?](#how-does-kogito-refer-to-drools)
2. [How do I use Drools in a Kogito project?](#how-do-i-use-drools-in-a-kogito-project)

## How does Kogito refer to Drools?

Kogito refers to Drools as its underlying rule engine – it doesn’t reinvent rule processing but rather builds on top of Drools to provide a modern, cloud-native way to define, deploy, and run business rules.

Kogito documentation often phrases it like:

> _Kogito uses the Drools rule engine for rule evaluation and decision logic._

It emphasizes:
- Cloud-native usage of Drools
- Seamless embedding of `drl` files
- Automatic generation of REST endpoints to invoke rules
- Support for Quarkus and Spring Boot runtimes

**Kogito doesn't replace Drools — it operationalizes it.** It brings Drools into the world of microservices, containers, and Kubernetes by wrapping it with tooling for fast, scalable, and cloud-friendly rule processing.

## How do I use Drools in a Kogito project?

In a Kogito project:
- We write `.drl` or `.dmn` files just like we would in Drools.
- Kogito’s build process will detect these and generate the necessary rule units and endpoints automatically.
- Alternatively, we could create custom endpoints for custom API definition.
