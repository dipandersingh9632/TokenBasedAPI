Welcome to TokenBased API where ADMIN can only POST and other USER and ADMIN can see all Post \
To run this project

1. Run the TokenBasedApiApplication class
2. Create a User, create POST request on Postman \
    url: http://localhost:8080/api/v1/register \
    and in Body -> raw -> json \
   { \
     "name":"name", \
     "username":"username", \
     "password":"password" \
   }
3. Create a Admin, create POST request on Postman \
   url: http://localhost:8080/api/v1/register \
    in name write _admin to identify this is a admin \
   In Body -> raw -> json \
   { \
   "name":"name_admin", \
   "username":"username", \
   "password":"password" \
   }
4. To login, create POST request on Postman \
   url: http://localhost:8080/api/v1/login \
   In body -> raw -> json \
   { \
   "username":"username", \
   "password":"password" \
   } \
   you get a JSON token Save it
5. To Post Something, You must login with your ADMIN credentials \ 
   Create a POST request on Postman \
   url: http://localhost:8080/api/v1/admin/post \
   { \
   "description":"Post_description" \
   } \
6. To See all the Post, Create a GET request in Postman 
   Must be Logged In either as a ADMIN or USER
   url: http://localhost:8080/api/v1/getAllPost \
  
  