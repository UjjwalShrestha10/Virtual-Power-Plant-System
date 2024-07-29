# Virtual-Power-Plant-System
The API should have an endpoint that accepts - in the HTTP request body - a list
of batteries, each containing: name, postcode, and watt capacity. This data
should be persisted in a database (In-memory is acceptable).
The API should have an endpoint that receives a postcode range. The response
body will contain a list of names of batteries that fall within the range, sorted
alphabetically. Additionally, there should be some statistics included for the
returned batteries, such as: total and average watt capacity.
