package com.bayamasa.myspring.domain.fee;

public interface Fee {
  // interfaceのフィールドは暗黙的にpublic static finalである
  int DEFAULT_FEE = 0;
  int yen();
}
