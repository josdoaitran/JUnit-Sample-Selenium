execute multiple JUnit test suite at a time

This looks indeed like integration tests and unit tests or a combination of both. For such purposes i would suggest to use the maven-failsafe-plugin to run the integration tests which should follow the naming schema:
```
<includes>
 <include>**/IT*.java</include>
 <include>**/*IT.java</include>
 <include>**/*ITCase.java</include>
</includes>
```
Furthermore the usual unit tests will be executed by the maven-surefire-plugin which should follow the following naming schema:
```
<includes>
 <include>**/*Test*.java</include>
 <include>**/*Test.java</include>
 <include>**/*TestCase.java</include>
</includes>
```
Furthermore you should avoid using test suites, cause based on the naming schema it can be distinguished if it's a unit- or integration tests.

After you changed to the above schema you can run the unit tests by
```
mvn test
```
running the integration tests by using:
```
mvn verify
```
