package com.samples.drools.rules;

import com.samples.drools.rules.model.LoanApplication;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.rules.RuleUnitIds;
import org.kie.kogito.incubation.rules.services.RuleUnitService;

import java.util.Map;
import java.util.stream.Stream;

@ApplicationScoped
public class LoanApplicationService {

  @Inject
  AppRoot appRoot;
  @Inject
  RuleUnitService ruleUnitService;

  public Stream<LoanApplication> evaluate(LoanApplication... applications) {
    var queryId = appRoot
      .get(RuleUnitIds.class)
      .get(LoanApplicationUnit.class)
      .queries()
      .get("applications");
    var ctx = MapDataContext
      .of(
        Map.of("applications", applications)
      );
    return ruleUnitService
      .evaluate(queryId, ctx)
      .map(
        result -> result
          .as(MapDataContext.class)
          .get("$result", LoanApplication.class)
      );
  }

}
