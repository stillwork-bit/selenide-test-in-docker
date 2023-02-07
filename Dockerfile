FROM maven:3.6.3-jdk-11
WORKDIR /app
COPY pom.xml .
COPY src ./src



#COPY start_test.sh .
#RUN apk update && apk add bash
#ENV StartRemote = yes

#ENTRYPOINT ["/bin/sh"]
#CMD ["start_test.sh"]

#RUN chmod +x /app/start_test.sh
#RUN sed -i -e 's/\r$//' /app/start_test.sh
#FROM maven:3.6.3-jdk-11
#WORKDIR /app
#COPY --from=build /root/.m2/ /root/.m2/
#COPY . /app
#RUN mvn clean package