
to point to different properties:

java -jar tonyas-cli.jar --spring.config.location=file:/path/to/props

For example, if you've a prompt at the root of this project:

java -jar target/tonyas-cli-0.0.1-SNAPSHOT.jar --spring.config.location=file:demo.app.properties


* You may need to add @ImportResource to TonyasCliApplication to include your other spring context file(s)/classes
* Also all the other dependencies, natch

 
 