Keiths Wall Of Text
=======================================

This is using spring boot, just because its easier than trying to explain how to do it manually.  You should be able
to copy dependencies from your existing pom.xml & Main.main() code to here (or vice versa).  

Just as-is, once your call maven package, you'll have target/tonyas-cli.jar.  
  
To point to a different configuration file, run like so:

<pre>
java -jar path/to/tonyas-cli.jar --spring.config.location=file:/path/to/props
</pre>
For example, if you've a console open at the root of this project:

<pre>
java -jar target/tonyas-cli-0.0.1-SNAPSHOT.jar --spring.config.location=file:demo.app.properties
</pre>
Without supplying the "spring.config.location" arg, the included application.properties are used.


Notes:

* You may need to add @ImportResource to TonyasCliApplication to include your other spring context file(s)/classes.
* Although spring-boot has its own hibernate/JPA mechanisms, they aren't included here.  Further, I don't _think_
any of those mechanisms will interfere with your own hibernate/db setup.  I could be wrong though.
* Let me know when we can add a REST interface for this puppy or a GUI.


Without spring-boot
=============================

This is the answer you probably had in mind.  

Set up your PropertyConfigurator to search for system properties.  This is how you'd do it in XML:
    
<pre>
&lt;bean id="configurer"
          class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer"&gt;
        &lt;property name="searchSystemEnvironment" value="true"/&gt;
        &lt;property name="ignoreResourceNotFound" value="true"/&gt;
        &lt;property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/&gt;
        &lt;property name="locations"&gt;
            &lt;list&gt;
                &lt;value&gt;${file.url.of.config.file}&lt;/value&gt;
            &lt;/list&gt;
        &lt;/property&gt;
    &lt;/bean&gt;
</pre>

The "file.url.of.config.file" in the above stanza is _not_ a reference to a spring property.  Rather, its a reference
to a system property.  It will be up to you to populate it via System.setProperty("file.url.of.config.file", propertyFileUrl), 
_before_ you start the spring context.
 
The "propertyFileUrl" is the file url to your properties file (presumably gleaned from parsing a cli arg).  Note 
it should be a file URL, i.e. "file:///home/tonya/your.properties".

Basically this describes what spring boot is doing via various conventions & defaults.

 
