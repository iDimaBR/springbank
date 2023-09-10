package com.github.idimabr.springbank.dtos;

import org.jetbrains.annotations.NotNull;
import java.math.BigDecimal;

public record UserDTO(@NotNull String firstName, @NotNull String lastName, @NotNull String document, @NotNull BigDecimal balance, @NotNull String email, @NotNull String password){
}
