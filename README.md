# SpringBoot_UserManagement

The given code uses 
  - Java
	- Springboot
	- JPA
	- MySQL
	- Maven
technologies to create RestAPI for registration and login of a user. It also checks for user's authenticity at the time of login and if user is already registered then it won't add user in database. It also stores the login history of the user.
The below screenshot shows the Login history of user:
![Capture](https://user-images.githubusercontent.com/50027521/109393446-ae5e8100-7947-11eb-852b-f428f3722110.PNG)

Following Screenshots shows the execution of API using PostMan.
![LoginHistory](https://user-images.githubusercontent.com/50027521/109393498-1319db80-7948-11eb-96c7-cf9ecf648150.PNG)
![user](https://user-images.githubusercontent.com/50027521/109393501-14e39f00-7948-11eb-8179-535d58254390.PNG)

If user is not in database and attempts to login it gives error message as user does not exists.


