
to point to different properties:

java -jar tonyas-cli.jar --spring.config.location=file:/path/to/props

For example, if you've a prompt at the root of this project:

java -jar target/tonyas-cli-0.0.1-SNAPSHOT.jar --spring.config.location=file:demo.app.properties

Without supplying the "spring.config.location" arg, the included application.properties are used.


Notes:

* You may need to add @ImportResource to TonyasCliApplication to include your other spring context file(s)/classes.
* Also all the other dependencies should be added to pom.xml, natch


Without spring-boot
=============================

This is the answer you probably had in mind.  

Set up your PropertyConfigurator to search for system properties.  This is how you'd do it in XML:
    
<bean id="configurer"
          class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
        <property name="searchSystemEnvironment" value="true"/>
        <property name="ignoreResourceNotFound" value="true"/>
        <property name="systemPropertiesModeName" value="SYSTEM_PROPERTIES_MODE_OVERRIDE"/>
        <property name="locations">
            <list>
                <value>file:/${path.to.config}</value>
            </list>
        </property>
    </bean>


The "path.to.config" in the above stanza is _not_ a reference to a spring property.  Rather, its a reference
to a system property.  It will be up to you to populate it via System.setProperty("path.to.config", propertyPath), 
_before_ you start the spring context.
 
The "propertyPath" is the path to your properties file (presumably gleaned from parsing a cli arg).

Basically this describes what spring boot is doing via various conventions & defaults.

 
 