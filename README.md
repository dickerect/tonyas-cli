Intro
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
* Also all the other dependencies should be added to pom.xml, natch


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
                &lt;value&gt;file:/${path.to.config}&lt;/value&gt;
            &lt;/list&gt;
        &lt;/property&gt;
    &lt;/bean&gt;
</pre>

The "path.to.config" in the above stanza is _not_ a reference to a spring property.  Rather, its a reference
to a system property.  It will be up to you to populate it via System.setProperty("path.to.config", propertyPath), 
_before_ you start the spring context.
 
The "propertyPath" is the path to your properties file (presumably gleaned from parsing a cli arg).

Basically this describes what spring boot is doing via various conventions & defaults.

 
 