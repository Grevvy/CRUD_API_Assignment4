# CRUD MVC App using JPA/Hibernate, MySQL, and Thymleaf
___

## Dependencies:

For this project to work correctly, you must have the following installed:
- [xampp](https://www.apachefriends.org/download.html)

Note: xampp can be a bit finicky due to permissions. If you have trouble quiting xampp you can make the following change.

#### Automatically run as Administrator each time
Xampp by default does not allow unauthenticated users to have write permissions due to a potential security vulnerability.
You could right-click and run as Administrator every time, but I find this annoying.
The following steps will ensure that  Xampp will automatically run as Administrator every time.

1. Locate your instillation for xampp. For me this is in `C:\xampp`
2. Within this directory locate `xampp-control.exe`, right click, and go to properties
3. Click on the Compatibility tab
4. Check the `Run this program as an administrator` option
5. Click apply

## Getting Started:
The following will walk you through the steps to get start the web application.

### Starting the database
The first thing that you should do is start the Xampp Control Panel. From here first start the Apache Web Server, then start
the MySQL Database. It is very important that you start them in this order. If everything is done correctly, you should be
able to access the admin panel [here](http://localhost/phpmyadmin/).

### Creating the database
Before you can run the web app, we need
a database to connect to. Access the admin panel and look for a list of databases
on the left hand side.
Click New to create a new database and name it animal. It is important that you give it this exact name for the next step.
In the database you need to create 4 rows named:
- animalId (Auto generated)
- name (nullable = false)
- scientific_name
- species (nullable = false)
- habitat (nullable = false)
- description


### Start the web app
Now that the database has been populated with sample data, we can start the web app. Locate the file `Assignment4Application.java`
in the project. If you are using IntelliJ, it is as simple as clicking the run button at the top right. This well start the web
app and connect it to the database.

### Access the web app
Everything is now setup! The last thing to do access the web app and start using it. Go [here](http://localhost:8080/animal)
or simply go to `http://localhost:8080/animal`, both of which will take you to the home page. 
