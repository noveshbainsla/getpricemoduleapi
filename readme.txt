Setting Up -
1. since it is spring-boot app use command "mvn spring-boot:run" command
2. embedded H2 is being used , which will be set up automatically  and data populated from data.sql automatically


## API DEFINITION ( can also refer swagger documentation on "http://localhost:8181/swagger-ui.html" ) ##
1. http://localhost:8181/pricing/getCoursePrice
2. requestBody-
    {
      "countryCode": "USA",
      "courseId": 1,
      "stateCode": "string"
    }
    try with courseId 1/2/3 as these are maintained by seed
    try with countryCode USA/INDIA

Curl command -
curl -d "{\"courseId\":3,\"countryCode\":\"USA\"}" -H "Content-Type: application/json" http://localhost:8181/pricing/getCoursePrice

Assumptions and Logic-
1. Course entity has it's base price , and priceType ( one time / monthly / free ).
2. We can maintain any no. of Charges in CHARGE_DEFINITION_MST, use chargeCode "CV" for conversion charges.
2. rate based charge will be calculated on course price.
3. if not country code maintained on chargeDefinition then it is applicable on all countries, same is for state code.
4. for now I am assuming that base price is same for all countries however taxes/charges can be maintained country-wise.
