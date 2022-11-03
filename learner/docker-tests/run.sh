#!bin/sh

# export JAVA_TOOL_OPTIONS="-Dserver.port=8080 -agentlib:jdwp=transport=dt_socket,address=*:8082,server=y,suspend=n"

# full jar
exec java -jar /app.jar

# unpacked jar
#exec java -cp app:app/lib/* com.sub.learner.LearnerApplication

# spring boot layers/JarLauncher
#exec java org.springframework.boot.loader.JarLauncher