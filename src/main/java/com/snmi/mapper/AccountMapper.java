package com.snmi.mapper;

import com.snmi.dto.AccountDTO;
import com.snmi.dto.WholeAccountDTO;
import com.snmi.domain.Account;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface AccountMapper {

    @Mappings({
            @Mapping(target = "id", source = "account.id"),
            @Mapping(target = "firstName", source = "account.firstName"),
            @Mapping(target = "lastName", source = "account.lastName"),
            @Mapping(target = "email", source = "account.email"),
            @Mapping(target = "dateOfBirth", source = "account.dateOfBirth")
    })
    WholeAccountDTO toWholeAccountDTO(Account account);

    @Mappings({
            @Mapping(target = "firstName", source = "accountDTO.firstName"),
            @Mapping(target = "lastName", source = "accountDTO.lastName"),
            @Mapping(target = "email", source = "accountDTO.email"),
            @Mapping(target = "dateOfBirth", source = "accountDTO.dateOfBirth")
    })
    @BeanMapping(ignoreByDefault = true)
    Account toAccount(AccountDTO accountDTO);

}
