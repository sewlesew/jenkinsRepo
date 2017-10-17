
 Rest_Client which calls the rest_Server, HotelManagementRestService to get 
 HotelService Data, but uses local client DB  "gladiators" database to get access to other Data
 
  
 
  
 Has login 
 user name / password
 admin/admin
 guest/guest
 
 DB: gladiators
 
 Note: change the amqp configuration in amqp-order-app-context.xml
 <rabbit:connection-factory id="amqpConnectionFactory" host="localhost" username="sewlesew" password="123456"
  /> 
   
 
 //admin can create USER/ADMIN users using RBAC in the user management tab.
 
 
 follow the procedures to use services from our hotel management App.
   
   1. add Room in "Room Management" 
   2. reserve a room at "Room Reservation" by searching for available Rooms bn specified dates
     // first time users simply click on search to get available rooms
   3. then click "Book" on the corresponding Room  
   4. ADD the customer information,and bokk the room.
   
   5. Then customer will get an email message.
   
   6.  go to "Check in |Check out" Tab to search for the customer who has reserved a room
    (search by first  and last name)
    
    7. observer the specified customer's booking information to check in | out. and 
        if you check out, all customer billing and customer ingformation will be passed to
        RAbbit AMQP to deliver the message to in room management system.
        
        
   
    