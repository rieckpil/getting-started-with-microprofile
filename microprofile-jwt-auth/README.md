# MicroProfile JWT Auth

* [GitHub](https://github.com/eclipse/microprofile-jwt-auth)
* [Spec](https://download.eclipse.org/microprofile/microprofile-jwt-auth-1.2/microprofile-jwt-auth-spec-1.2.html#release_notes_12)
* Current version: **1.2** in **MicroProfile 4.0**
* Detailed blog post about this specification: [#WHATIS?: MicroProfile JWT Auth](https://rieckpil.de/whatis-eclipse-microprofile-jwt-auth/)
* YouTube video about this specification: [Getting started with Eclipse MicroProfile 3.0 - MicroProfile JWT Auth 1.1](https://youtu.be/8O3D2tNx1uM)

##  Steps to run this project

1. Run `java -jar jwtenizr.jar`
2. Adjust the created `jwt-token.json` like the following:
```json
{
  "iss": "rieckpil",
  "jti": "42",
  "sub": "duke",
  "upn": "duke",
  "groups": [
    "chief",
    "hacker",
    "admin"
  ],
  "administrator_id": 42,
  "administrator_level": "HIGH"
}
```
3. Re-run `java -jar jwtenizr.jar`
4. Take the public key from the generated `microprofile-config.properties` file and paste it to `src/main/resources/META-INF/publicKey.pem` in the inner section, e.g.:
```shell script
-----BEGIN RSA PUBLIC KEY-----
MydoO3l7rOiRw5PMtlxHYRqK51eql2pVvp+lASalwIDAQAB
-----END RSA PUBLIC KEY-----
```
5. Start the application with `./buildAndRun.sh` or `buildAndRun.bat`
6. Use the cURL console output of the last run of `jwtenizr` and adjust the port and URL path, e.g.:
```shell script
curl -i -H'Authorization: Bearer eyXYZ' http://localhost:9080/resources/books
```
or use Postman and take the JWT from the generated `token.jwt` file
