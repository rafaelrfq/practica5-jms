FROM adoptopenjdk/openjdk11:alpine-jre

LABEL maintainer="Rafael Felipe <20100748@ce.pucmm.edu.do>"

VOLUME /tmp

ENV OPTION=1 ID_DISP=1

EXPOSE 61616

COPY /build/libs/*.jar practica5-jms.jar

ENTRYPOINT java -jar practica5-jms.jar $OPTION $ID_DISP