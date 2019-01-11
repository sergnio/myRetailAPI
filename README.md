# myRetailAPI
Application built for the hungry developers who need to consume API from a rapidly growing company in Richmond

# NOTES
DB insert query - db.productprice.insertMany( [
{ _id: 13860428, value: 100.03, currency_code: "USA" },
{ _id: 13860429, value: 90.43, currency_code: "USA" },
{ _id: 13860425, value: 50, currency_code: "EUR" },
{ _id: 13860424, value: 1350, currency_code: "EUR" },
{ _id: 13860421, value: 12.59, currency_code: "CNY" },
{ _id: 13860419, value: 66.66, currency_code: "CNY" }
] );

DB ids - 13860428 13860429 13860425 13860424 13860421 13860419

# Principles followed
DRY
KISS
DTO pattern
ServiceImpl pattern 
Why? 
These commented interfaces provide a specification of the application, a description of how it's intended to behave.
