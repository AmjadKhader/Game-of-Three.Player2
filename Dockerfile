FROM openjdk:17-oracle

MAINTAINER Amjad Khader <amjad@amjadkhader.com>

COPY /target/player2-1.0.0.jar justeattakeawayplayer2challenge.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "justeattakeawayplayer2challenge.jar"]