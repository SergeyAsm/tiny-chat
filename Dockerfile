FROM orienteer/orienteer:latest

RUN mkdir -p /usr/src/tiny-chat/
WORKDIR /usr/src/tiny-chat/
ADD . /usr/src/tiny-chat/
RUN mvn clean install

RUN mv target/tiny-chat.war /orienteer/
RUN cp orienteer.properties /orienteer/
RUN mvn clean
RUN rm -rf tiny-chat/

WORKDIR /orienteer/
RUN ln -s -f tiny-chat.war active.war
