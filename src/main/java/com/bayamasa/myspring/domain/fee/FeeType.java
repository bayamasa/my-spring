package com.bayamasa.myspring.domain.fee;

public enum FeeType {
  adult(new AdultFee()),
  child(new ChildFee()),
  invalid(null);

  private final Fee fee;

  FeeType(Fee fee) {
    this.fee = fee;
  }

  public int yen() {
    return this.fee.yen();
  }

  /**
   * FeeType.valueOf()を安全に呼び出せるようにする
   * valueOfをつかった場合、存在しない値を渡すとIllegalArgumentExceptionが発生するが、これを防ぐ
   * 存在しない値を渡した場合はinvalidを返す
   *
   * @param name FeeTypeの名前
   * @return FeeType
   */
  public static FeeType safeValueOf(String name) {
    for (FeeType type : FeeType.values()) {
      if (type.name().equals(name)) {
        return type;
      }
    }
    return invalid;
  }
}
