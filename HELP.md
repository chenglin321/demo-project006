# Getting Started

### Reference Documentation
run env:
 zulu jdk17 with CRaC

build:
  mvn package
run:
java -Dspring.context.checkpoint=onRefresh -XX:CRaCCheckpointTo=./tmp_checkpoint -jar target/demo-project006-0.0.1-SNAPSHOT.jar