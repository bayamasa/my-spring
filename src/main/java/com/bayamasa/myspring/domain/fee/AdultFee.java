package com.bayamasa.myspring.domain.fee;

public record AdultFee(int yen) implements Fee {
  public AdultFee() {
    this(1000);
  }
}

