package com.samples.drools.boundary;

import com.samples.drools.boundary.model.LoanApplicationDto;
import com.samples.drools.boundary.model.LoanApplicationsInputDto;
import com.samples.drools.rules.LoanApplicationService;
import com.samples.drools.rules.model.LoanApplication;
import io.quarkus.arc.properties.IfBuildProperty;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.stream.Stream;

@IfBuildProperty(
  name = "kogito.generate.rest.rules",
  stringValue = "false"
)
@Path("applications")
public class LoanApplicationResource {

  @Inject
  LoanApplicationDtoMapper mapper;
  @Inject
  LoanApplicationService service;

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Stream<LoanApplicationDto> evaluateCredit(LoanApplicationsInputDto input) {
    var applications = Stream.of(input.applications())
      .map(mapper::map)
      .toArray(LoanApplication[]::new);
    return service
      .evaluate(applications)
      .map(mapper::map);
  }
}
