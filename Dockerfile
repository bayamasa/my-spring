# JDK 21の公式イメージをベースとする
FROM openjdk:21-slim-bullseye AS build

# 必要なツールをインストール
RUN apt-get update && apt-get install -y findutils

# 作業ディレクトリを設定
WORKDIR /app

# ホストのソースコードをDockerイメージ内にコピー
COPY . .

# Gradleを使ってビルドを実行
RUN ./gradlew build --no-daemon

# アプリケーションの実行コマンドを指定
ENTRYPOINT ["java", "-jar", "/app/build/libs/my-spring-0.0.1-SNAPSHOT.jar"]
