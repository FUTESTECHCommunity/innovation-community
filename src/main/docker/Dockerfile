# Version 0.0.1
FROM java:8

MAINTAINER zouyc "futestech@gmail.com"

# 环境变量
ENV WORK_PATH /home/project/futurer
ENV APP_NAME @project.build.finalName@.@project.packaging@
ENV APP_VERSION @project.version@

EXPOSE 8080
EXPOSE 54112

#USER
#USER user:group

#VOLUME
#VOLUME ["/home/project", "/tmp/data"]

VOLUME /tmp

#ADD

#COPY
COPY $APP_NAME $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

# CMD
#CMD ["-jar", "@project.build.finalName@.@project.packaging@"]
CMD ["-jar", "-Dspring.config.location=/etc/config/application-report.properties", "@project.build.finalName@.@project.packaging@"]