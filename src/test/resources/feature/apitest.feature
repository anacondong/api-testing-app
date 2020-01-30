Feature: Testing different requests on the apitest application

@SMOKE
Scenario: Check if the apitest application can be accessed by users
When User sends a GET request to the list endpoint,they must get back a valid status code 200


  Scenario Outline: Create a new apitest & verify if the apitest is added
     When I create a new apitest by providing the information firstName <firstName> lastName <lastName> email <email> programme <programme> courses <courses>
    Then I verify that the apitest with <email> is created

    Examples: 
      | firstName | lastName | email                                    | programme        | courses |
      | Declan    | Smith    | nnon.ante.bibendum@risusDonecegestas.edu | Computer Science | Java    |
      | Mark    | Taylor    | nnon2.ante.bibendum@risusDonecegestas.edu | Computer Science | Java    |