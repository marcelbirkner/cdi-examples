[![Build Status](https://buildhive.cloudbees.com/job/marcelbirkner/job/cdi-examples/badge/icon)](https://buildhive.cloudbees.com/job/marcelbirkner/job/cdi-examples/)

This project is used in an Java Magazin article in March 2011

Requirements:
- Maven 3.0.1 (or greater)
- Java EE 6

@author Marcel Birkner

<h4> Description </h4>

 This project uses several features of CDI. These features 
 include typesafe dependency injection, Qualifiers, 
 Producer Methods, Producers Fields, Qualifier Members, ...

 Over time we will add more complex features to show how
 powerful CDI is.

<h4> Running the example</h4>

<code>
mvn -Drun
</code>

```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Weld Example :: Car Manufacturing 1.1.0.Final
[INFO] ------------------------------------------------------------------------

...

484 [org.jboss.weld.environment.se.StartMain.main()] INFO de.sample.MultiCarManufacturer - 

I am a Family Car and these are my features:  
- tires  :: regular tires
- body   :: regular body
- engine :: Engine Type :: diesel

484 [org.jboss.weld.environment.se.StartMain.main()] INFO de.sample.MultiCarManufacturer - 

I am a SportsCar and these are my features:  
- tires  :: race tires
- body   :: regular body
- engine :: Engine Type :: racefuel

...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```
