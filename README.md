
#E-Diary Webapplication

E-Diary is a web application designed to keep track of tasks.
As a E-Diary user, user will have option to add todo's and each todo is a category where user can add items in specified todo.
User can view the todo list as he logsin  and also add delete and update item in the selected todo
Database Specification : Its Mysql database and has ToDo table, To_Do_Items ,User, role,Users_roles,Tables
Below is the ER diagram for the tables
ClassDiagram



Features:
Adding ToDo's and adding todo items to associated ToDo.
Performing CRUD on ToDoItems



## Documentation

It has ToDo Controller ,main controller ,ToDoItem Service and UserToDoService 

ToDo controller has rest api's for the TODO feature
Main Controller has rest api's fro login module and user page

Implemented two services for reading data, saving data ,deleting and updating data

writtten Junit tests for  ToDoItem to verify if the items are saved in repository and fetched correctly.

This application has Login view page main view page, TodoItems view page and create ToDo view page
