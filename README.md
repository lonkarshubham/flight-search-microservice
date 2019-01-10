# flight-search-microservice
It fetch data from two different services and provide search with pagination

1) Start discoveryservice first. It will run on port 8761
Use http://localhost:8761 to check the status of all API. whether they are started or failed.
2) Start configserver service. It will run on port 9089
configserver provide the configuration to start the flightservice1 & flightservice2 from Git repository
3) Start flightservice1 service. It will run on port 9093
User swagger to check enpoint by using http://localhost:9093/swagger-ui.html
4) Start flightservice2 service. It will run on port 9094
User swagger to check enpoint by using http://localhost:9094/swagger-ui.html
5) Start searchservice service. It will run on port 9095
User swagger to check enpoint by using http://localhost:9095/swagger-ui.html


After this hit url http://localhost:9095/search to search record
If you want custom pagination then http://localhost:9095/search?page=1&size=5


# Points to improve/add
1) Search by parameter
2) Cache implementation
3) Async HTTP calls
4) Sorting of result


