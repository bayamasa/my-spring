package com.bayamasa.myspring.domain.fee;

public record ChildFee(int yen) implements Fee {
  public ChildFee() {
    this(500);
  }
}
