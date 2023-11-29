package com.bayamasa.myspring.domain.fee;

public enum FeeType {
  adult(new AdultFee()),
  child(new ChildFee()),
  invalid(new Fee() {
    @Override
    public int yen() {
      return Fee.DEFAULT_FEE;
    }
  });

  private final Fee fee;

  FeeType(Fee fee) {
    this.fee = fee;
  }

  public int yen() {
    return fee.yen();
  }

  /**
   * FeeType.valueOf()を安全に呼び出せるようにする
   * valueOfをつかった場合、存在しない値を渡すとIllegalArgumentExceptionが発生するが、これが外にもれないようにする
   *
   * @param name FeeTypeの名前
   * @return FeeType
   */
  public static FeeType safeValueOf(String name) {
    try {
      return FeeType.valueOf(name);
    } catch (IllegalArgumentException e) {
      return invalid;
    }
  }
}
