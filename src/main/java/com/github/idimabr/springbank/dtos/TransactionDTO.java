package com.github.idimabr.springbank.dtos;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

public record TransactionDTO(@NotNull BigDecimal amount, @NotNull Long senderID, @NotNull Long receiverID) {

}
