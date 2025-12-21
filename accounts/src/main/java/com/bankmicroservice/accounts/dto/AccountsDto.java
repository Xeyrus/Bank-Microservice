package com.bankmicroservice.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account details"
)
public class AccountsDto {

    @Schema(
            description = "Account Number of Bank Account",
            example = "1234567890"
    )
    @NotEmpty(message = "AccountNumber can not be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account Type of Bank Account",
            example = "Savings"
    )
    @NotEmpty(message = "AccountType can not be null or empty")
    private String accountType;

    @Schema(
            description = "Branch Address of Bank Account",
            example = "123 Main Street, New York"
    )
    @NotEmpty(message = "BranchAddress can not be null or empty")
    private String branchAddress;
}
