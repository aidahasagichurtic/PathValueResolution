### Documentation

The PathValueResolver provides two distinct methods to resolve values from JSON files, each catering to different types of JSON structures.
The choice of method to call depends on the structure of the JSON you're working with:

Use simpleJsonPathValueResolver for simple, non-array JSONs, and complexJsonPathValueResolver for JSONs that contain arrays.

1. simpleJsonPathValueResolver:
This method is designed for simple JSON files, where the structure, where the data structure consists of key-value pairs and does not involve arrays. 
ARGS: 
 - json - specify simple JSON string
 - path - specify a path (a dot-separated string) to retrieve a specific value from the JSON object. 
This method is ideal for straightforward JSON files with key-value pairs, where no nested arrays need to be handled.

2. complexJsonPathValueResolver:
This method is tailored for more complex JSON files that include arrays.
ARGS:
 - json - specify complex JSON string
 - path - specify a path (a dot-separated string) to retrieve a specific value from the JSON object.
You can specify a path (a dot-separated string) to retrieve a specific value from the JSON object.
It can handle JSON objects with arrays at various levels, ensuring that values from within these arrays are resolved correctly. 
This method will process the path and correctly navigate through arrays, providing the value even if it is contained within an array.

In the main class of the project, both methods are demonstrated with example usages showing how to:
- pass the JSON data and 
- pass the path to the value you wish to extract. 

By specifying the appropriate JSON data and path, you can leverage these resolvers to access values in both simple and complex JSON files efficiently. 








