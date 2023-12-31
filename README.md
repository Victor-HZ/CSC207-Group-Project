# CSC207-Group-Project
A lovely dating planner. <br>
This application will help the user to plan for their date. <br>
The user should be able to input a calendar date and specifications such as time (having lunch together) or preferences (crafty activities vs. athletic ones vs. educational ones etc.). <br>
This application will provide the following features: weather considerations, restaurant and activity suggestions, as well as maps/transit and estimated costs.

# TODO List
 - [ ] Location Entity

Use Cases to Implement:
 - [ ] List 'Events' (in progress)
 - [ ] List 'Activites' (other than 'Event')
 - [ ] Add 'Activity'
 - [ ] Remove 'Activity'
 - (Add more as we come up with them!)


# APIs

Weather - http://api.weatherbit.io/v2.0/forecast/hourly <br>
Calendar - https://www.googleapis.com/calendar/v3/calendars/calendarId <br>
Restaurants- [link] <br>
Map - [link] <br>
TicketMaster - https://app.ticketmaster.com/discovery/v2/events <br>
Reviews - https://reviewapi.com/ <br>
Google Search - https://apilayer.com/marketplace/google_search-api

# API Documentation

Weather - https://www.weatherbit.io/api/weather-forecast-hourly <br>
Calendar - https://developers.google.com/calendar/api/guides/overview <br>
Restaurants - [link] <br>
Cinemas - [link] <br>
Map - [link] <br>
TicketMaster - https://developer.ticketmaster.com/products-and-docs/apis/discovery-api/v2/#search-events-v2 <br>
Reviews - https://reviewapi.com/ <br>
Google Search - https://apilayer.com/marketplace/google_search-api

# API results from Hoppscotch.io
TicketMaster
![CleanShot 2023-10-01 at 17 15 53@2x](https://github.com/Victor-HZ/CSC207-Group-Project/assets/144486877/8e5dd734-e40e-4745-8a31-42094337593b)

Weatherbit
![img.png](img.png)

# Technical Problems
None so far

# Use Case:
1. fetchActivity -> get events from APIs by the user input. victor
2. addActivity -> user chose which event to be added to their schedule
3. deleteActivity -> user chose which event to be removed from their schedule
4. createPlan -> create a new empty plan
5. deletePlan -> delete an unwanted plan. victor
6. loadPlan -> load a plan from the database
7. savePlan -> save the plan to external database
8. generateReport -> generate the final report

# possible use case
1. sendPlan -> share the plan via mail api
2. updateWeather -> update the weather data to the plan via api.


