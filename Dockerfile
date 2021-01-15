# 指定基础镜像
FROM openjdk:8-jre-alpine
# 构建参数
ARG JAR_FILE
ADD target/${JAR_FILE} app.jar
# 暴露的端口号
EXPOSE 8080
# 运行时执行的命令
# 打印了一句提示信息，然后等待 30s，等其他依赖的容器启动起来，最后再启动应用容器
CMD echo "The application will start in 30s" && \
 sleep 30 && \
 java -jar /app.jar
