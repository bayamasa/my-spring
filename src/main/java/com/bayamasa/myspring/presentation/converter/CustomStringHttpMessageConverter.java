package com.bayamasa.myspring.presentation.converter;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomStringHttpMessageConverter extends StringHttpMessageConverter {

  @Override
  protected void writeInternal(@NonNull String str, HttpOutputMessage outputMessage) throws IOException {
    // レスポンスボディの変更
    String modifiedBody = str + " additional content";

    // レスポンスボディのバイト表現を取得
    byte[] bodyBytes = modifiedBody.getBytes(StandardCharsets.UTF_8);

    // Content-Length ヘッダを設定
    outputMessage.getHeaders().setContentLength(bodyBytes.length);

    // レスポンスボディを書き込み
    StreamUtils.copy(bodyBytes, outputMessage.getBody());
  }
}

