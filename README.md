# 실행

# MacOS
`javac -cp ".:lib/tomcat-embed-core.jar" Launcher.java; java -cp ".:lib/tomcat-embed-core.jar:lib/annotations-api.jar:lib/tomcat-embed-jasper.jar" Launcher`

# Windows
```javac -cp ".;lib/tomcat-embed-core.jar" Launcher.java
java -cp ".;lib/tomcat-embed-core.jar;lib/annotations-api.jar;lib/tomcat-embed-jasper.jar" Launcher```

# 접속 
http://localhost:8011/app