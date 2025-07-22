# backend
backend


curl -X POST http://localhost:8081/auth/create \
-H "Content-Type: application/json" \
-d '{"username": "john_doe", "password": "password123", "email": "john@example.com"}'


curl -X POST http://localhost:8081/auth/login \
-H "Content-Type: application/json" \
-d '{"username": "john_doe", "password": "password123"}'

curl -X POST http://localhost:8081/loan/submit/john_doe \
-H "Content-Type: application/json" \
-d '{
"loanType": "Home Loan",
"loanAmountRequested": 500000,
"employmentStatus": "Employed",
"monthlyIncome": 60000,
"existingEMIsMonthly": 5000,
"propertyOwnershipStatus": "Owned",
"residentialAddress": "123 Main St, City",
"applicantAge": 35,
"gender": "Male",
"numberOfDependents": 2,
"loanStatus": "Pending",
"assetTypeValuation": 800000,
"loanLimit": 600000,
"debtToIncomeRatio": 0.25,
"interestRateOffered": 6.7,
"applicationId": "APP1001",
"customerId": "CUST2001",
"applicationDate": "2025-07-10"
}'

curl -X PUT http://localhost:8081/loan/update/john_doe/1 \
-H "Content-Type: application/json" \
-d '{"loanStatus":"Approved", "loanLimit":650000}'


curl http://localhost:8081/loan/user/john_doe

curl http://localhost:8081/loan/user/id/1


curl -X POST http://localhost:8081/vertexai/score \
-H "Content-Type: application/json" \
-d '{
"loanType": "Home Loan",
"loanAmountRequested": 500000,
"employmentStatus": "Employed",
"monthlyIncome": 60000,
"existingEMIsMonthly": 5000,
"propertyOwnershipStatus": "Owned",
"residentialAddress": "123 Main St, City",
"applicantAge": 35,
"gender": "Male",
"numberOfDependents": 2,
"assetTypeValuation": 800000
}'

curl -X POST http://localhost:8081/vertexai/score \
-H "Content-Type: application/json" \
-d '{
"loanType": "Home Loan",
"loanAmountRequested": 500000,
"employmentStatus": "Employed",
"monthlyIncome": 60000,
"existingEMIsMonthly": 5000,
"propertyOwnershipStatus": "Owned",
"residentialAddress": "123 Main St, City",
"applicantAge": 35,
"gender": "Male",
"numberOfDependents": 2,
"assetTypeValuation": 800000,
"apiKey": "YOUR_API_KEY_OR_OAUTH_TOKEN"
}'