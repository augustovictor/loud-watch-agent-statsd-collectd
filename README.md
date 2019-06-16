# cloud-watch-agent-statsd-collectd

## Packaging the application
```bash
./gradlew bootJar
```

## Running the application
```bash
java -jar build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar
```

## Make a request
```bash
curl -X POST -H 'Content-type: application/json' -i localhost:8080/v1/sales -d '{"items": ["Item 1", "Item 2", "Item 3"]}'
```

## Storage for our Jar file
Create a bucket on `S3` with a unique name

victor-creditas-custom-app-jar-files

Upload the `jar` file to the created bucket:
```bash
aws-vault --debug exec scd-stg -- aws s3api put-object --bucket victor-creditas-custom-app-jar-files --key build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar --body build/libs/cloud-watch-agent-statsd-collectd-0.0.1-SNAPSHOT.jar
```