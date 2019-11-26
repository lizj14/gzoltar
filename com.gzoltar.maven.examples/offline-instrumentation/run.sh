mvn clean test-compile
mvn -P sufire gzoltar:instrument
mvn -P sufire test
cp -R target/gzoltar-backup-classes/* target/classes
mvn gzoltar:fl-report

