# Sleuth AOP - Custom Span and trace ID

Implementation of Spring Sleuth to print Corrolation ID (also known as traceId) in the log for the request and the sub functions (also known as spanId).

## Installation

Use the maven to install build the project after you clone it.

```bash
mvn install
```

## Usage

```curl
curl --location --request GET 'http://localhost:8080/same-span' \
--header 'activity_id: abc' 
```
you realise the header activity_id in the response, while if it does not exist in the request, a random id will be generated.
the spanId will be simply the function name. behavior can be changed based on your demand.
## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.


## License
[MIT](https://choosealicense.com/licenses/mit/)