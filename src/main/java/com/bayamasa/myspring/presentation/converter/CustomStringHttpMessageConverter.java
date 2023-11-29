package com.bayamasa.myspring.presentation.converter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.lang.NonNull;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CustomStringHttpMessageConverter extends StringHttpMessageConverter {

  @Override
  protected void writeInternal(@NonNull String str, @NonNull HttpOutputMessage outputMessage) throws IOException {
    // https://www.kimullaa.com/posts/201702181214/
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

    String modifiedBody = str;
    // リクエストURIが /hello の場合、レスポンスボディを変更
    if (("/hello".equals(request.getRequestURI()))) {
      // レスポンスボディの変更
      modifiedBody = str + " world!!\n";
    }
    // レスポンスボディのバイト表現を取得
    byte[] bodyBytes = modifiedBody.getBytes(StandardCharsets.UTF_8);
    // Content-Length ヘッダを設定
    outputMessage.getHeaders().setContentLength(bodyBytes.length);
    // レスポンスボディを書き込み
    StreamUtils.copy(bodyBytes, outputMessage.getBody());

  }
}

