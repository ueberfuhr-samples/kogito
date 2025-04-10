# Kogito

[Kogito](https://kogito.kie.org/) is a cloud-native business automation technology for building cloud-ready business applications. Its name is derive from Latin "Cogito" ("I think"), whereas the "K" refers to Kubernetes and to the [Knowledge Is Everything (KIE) open source business automation project](https://www.kie.org/) from which Kogito originates.

It’s the modern evolution of two well-established projects, that are also part of KIE:

jBPM – for modeling and executing business processes (using BPMN)
Drools – a powerful rules engine (for decision logic using DRL or DMN)

Kogito lets us define business logic (like workflows or decisions), and then it generates a REST-based service around it.

For example:

We model a loan approval process (BPMN).
Kogito turns it into a Spring Boot or Quarkus microservice.
We can deploy this service with Kubernetes to any container environment. Kogito has a strong integration into OpenShift.
We can call that service from our applications to check loan eligibility.
