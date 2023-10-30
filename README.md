# CSC207-Group-Project
A lovely dating planner. <br>
This application will help the user to plan for their date. <br>
The user should be able to input a calendar date and specifications such as time (having lunch together) or preferences (crafty activities vs. athletic ones vs. educational ones etc.). <br>
This application will provide the following features: weather considerations, restaurant and activity suggestions, as well as maps/transit and estimated costs.

# TODO List
 - [ ] Location Entity


# APIs

Weather - https://open-meteo.com/en/docs#start_date=2023-12-01&end_date=2024-01-12&time_mode=time_interval <br>
Calendar - https://www.googleapis.com/calendar/v3/calendars/calendarId <br>
Restaurants- [link] <br>
Map - [link] <br>
TicketMaster - https://app.ticketmaster.com/discovery/v2/events <br>
Reviews - https://reviewapi.com/ <br>
Google Search - https://apilayer.com/marketplace/google_search-api

# API Documentation

Weather - https://api.open-meteo.com/v1/forecast?latitude=52.520001&longitude=13.41&hourly=temperature_2m,rain&timeformat=unixtime&start_date=2023-10-31&end_date=2023-11-01 <br>
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
1. getEvents -> get events from APIs by the user input
2. addEvents -> user chose which event to be added to their schedule
3. deleteEvents -> user chose which event to be removed from their schedul;e
4. generateReport -> generate the final report
