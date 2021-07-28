# Car-Price-Calculator
 
 ## Software Architecture Assignment 1 (OSGi)
 
 ## Introduction
 
 The scenario will be implemented using the OSGI framework as an Eclipse Equinox plugin project. This collection of bundles implements a scenario of a car purchasing system. The Car Sale will be the consumer which the user can interact with. The car manufacturers (ToyotaPublisherService and HondaPublisherService), Government, FincanceCompany will be the producers of this scenario. The manufacturer services will publish the details of the car models available within each of them. Once a model is supplied, for valid models, the Manufacturer Services will return the price and the engine capacity. The government service will announce the tax and the tax rate once the manufacturer price and the engine capacity of a vehicle is given.
The car sale will get the manufacturer price and the engine capacity form a manufacturer servce and supply them to the government to get the tax and the tax rate. The Car sale will calculate the final price after the tax and (Car sale’s) profit margin is added. Then the car sale will consume the Finance company service to calculate the installments once the down payment is given.

![High level architecture diagram of the system](https://github.com/paradocx96/Car-Price-Calculator/blob/main/Diagram/Diagram.jpg "High level architecture diagram of the system")

## Group Members  

| Student ID | Student Name            | Github Username       |
|------------|-------------------------|-----------------------|
| IT19014128 | A.M.W.W.R.L. Wataketiya | RavinduLa             |
| IT19180526 | S.A.N.L.D. Chandrasiri  | paradocx96            |
| IT19240848 | H.G. Malwatta           | DeclanChirush         |
| IT19238722 | I.H.A.H. Karunathilaka  | AmarangiKarunathilaka |  

 ## Git Guide  
<details> 
  <summary>💻</summary>
  
 ### > First Time
 git init  
 git checkout -b StudentName  
 git add .  
 git commit -m "Initial commit"  
 git branch -M StudentName  
 git remote add origin https://github.com/paradocx96/Car-Price-Calculator.git  
 git push -u origin StudentName  
 
 ### > After Time  
 git add .  
 git commit -m "After commit"  
 git branch -M StudentName  
 git push -u origin StudentName  
</details> 
