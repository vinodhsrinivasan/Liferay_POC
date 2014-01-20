Lccs-portal – base project
Lccs-portal-portltes – All portlet impls
Lccs-portal-service – All service class impls
Lccs-portal-uis – theme implementation


------------Mvn------------------------------------
----------mysql------------------------------------
mvn install:install-file -Dfile=mysql.jar -DgroupId=com.mysql -DartifactId=mysql -Dversion=1.0 -Dpackaging=jar
------------------------
mvn install:install-file -Dfile=C:\dev\sqljdbc_4.0\enu\sqljdbc4.jar -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4 -Dversion=3.0 -Dpackaging=jar
