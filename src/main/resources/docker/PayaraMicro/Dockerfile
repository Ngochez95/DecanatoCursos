FROM payara/micro:4.181
COPY postgresql-42.2.2.jar $PAYARA_PATH/
COPY asadmin.txt $PAYARA_PATH/
COPY CursoUes-1.0-SNAPSHOT.war $PAYARA_PATH/
ENTRYPOINT ["java", "-jar", "payara-micro.jar", "--addLibs", "postgresql-42.2.2.jar", "--postbootcommandfile", "asadmin.txt","--deploy", "CursoUes-1.0-SNAPSHOT.war"]
