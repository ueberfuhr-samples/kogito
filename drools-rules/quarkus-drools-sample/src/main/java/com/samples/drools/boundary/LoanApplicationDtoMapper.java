package com.samples.drools.boundary;

import com.samples.drools.boundary.model.LoanApplicationDto;
import com.samples.drools.rules.model.LoanApplication;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface LoanApplicationDtoMapper {

  LoanApplication map(LoanApplicationDto loanApplicationDto);

  LoanApplicationDto map(LoanApplication loanApplication);

}
