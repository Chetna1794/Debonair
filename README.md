


## Debonair Restaurant - Maven Project
This appplication offers user driven interface for the customers so that they can choose from variety of options available in the restaurant.
This application has three major modules: Admin, Customer and User Interface. These are described in below section.
## User Interface
This is the main module and starting point of the application. This module provides following functionalities to the customer.
1. Showing menu to the customer
2. Taking order from the customer
3. Checking order status
4. Showing regular customer offers
5. Showing corporate customer offers

This module has following classes, interfaces and methods.

## Admin module

Admin module is provided to the owner of the application so that he can add or remove items from the list. It has following Classes and Methods.
 1. **Classes** 
	 - *Owner* - This is the main class which handles Owner's actions.
 2. **Methods** 
	 - *modifyMenu()* - This method helps the owner in modifying the restaurant menu.
 
## Customer module
This module deals with handling customer information. Whenever the customer adds or removes any informaton of iself. It is appended to the text file. If the customer is Regular customer it is appended to *"RegularCustomer.txt"*. Whereas, if the customer is Corporate customer it is appended to *"CorporateCustomer.txt"*.

		
