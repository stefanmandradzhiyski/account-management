package com.snmi.rest;

import com.snmi.dto.AccountDTO;
import com.snmi.dto.WholeAccountDTO;
import com.snmi.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/accounts")
@Api("Accounts API")
public class AccountResource {

    private final AccountService accountService;

    @ApiOperation(value = "Create new account")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Account has been created successfully", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Account's fields requirements aren't met", response = ResponseEntity.class),
            @ApiResponse(code = 409, message = "Account's email isn't unique", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Something wrong with our service", response = ResponseEntity.class)
    })
    @PostMapping
    public ResponseEntity<WholeAccountDTO> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.createAccount(accountDTO), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get a specific account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account has been retrieved successfully", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Account doesn't exist", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Something wrong with our service", response = ResponseEntity.class)
    })
    @GetMapping("/{accountId}")
    public ResponseEntity<WholeAccountDTO> getAccount(@PathVariable("accountId") Long accountId) {
        return new ResponseEntity<>(accountService.getAccount(accountId), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all accounts")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Accounts have been retrieved successfully", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Something wrong with our service", response = ResponseEntity.class)
    })
    @GetMapping()
    public ResponseEntity<List<WholeAccountDTO>> getAllAccounts() {
        return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update a specific account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Accounts has been updated successfully", response = ResponseEntity.class),
            @ApiResponse(code = 400, message = "Account's fields requirements aren't met", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Account doesn't exist", response = ResponseEntity.class),
            @ApiResponse(code = 409, message = "Account's email isn't unique", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Something wrong with our service", response = ResponseEntity.class)
    })
    @PutMapping("/{accountId}")
    public ResponseEntity<WholeAccountDTO> updateAccount(
            @PathVariable("accountId") @NotNull Long accountId,
            @Valid @RequestBody AccountDTO accountDTO
    ) {
        return new ResponseEntity<>(accountService.updateAccount(accountId, accountDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a specific account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Accounts has been deleted successfully", response = ResponseEntity.class),
            @ApiResponse(code = 404, message = "Account doesn't exist", response = ResponseEntity.class),
            @ApiResponse(code = 500, message = "Something wrong with our service", response = ResponseEntity.class)
    })
    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("accountId") @NotNull Long accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok().build();
    }
}
