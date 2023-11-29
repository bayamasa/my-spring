package com.bayamasa.myspring.presentation;


import com.bayamasa.myspring.domain.fee.FeeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeController {

  @GetMapping("/fee")
  public String fee(@RequestParam String type) {
    return FeeType.safeValueOf(type).yen() + "円";
  }
}
