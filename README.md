# All About JSON in Java: Converting Between JSON, Lists, and Strings

This repository contains a comprehensive class note for working with JSON in Java, including examples of converting JSON to lists, lists to JSON, strings to JSON, and JSON to strings. The code demonstrates practical usage of the `org.json` library and covers:

- Creating and manipulating `JSONArray` and `JSONObject`
- Converting between Java `List` and `JSONArray` (both single and nested/multi-dimensional)
- Parsing JSON from strings
- Serializing JSON to strings
- Handling nested arrays and objects

## Table of Contents
- [Requirements](#requirements)
- [Code Highlights](#code-highlights)
  - [Create a JSON Array](#create-a-json-array)
  - [Access Elements in JSON Array](#access-elements-in-json-array)
  - [Convert String to JSON Array](#convert-string-to-json-array)
  - [Convert JSON Array to String](#convert-json-array-to-string)
  - [Convert JSON Array to List](#convert-json-array-to-list)
  - [Convert List to JSON Array](#convert-list-to-json-array)
  - [Work with Nested/Multi-dimensional Arrays](#work-with-nestedmulti-dimensional-arrays)
  - [Convert Between Multi List and Multi Array](#convert-between-multi-list-and-multi-array)
  - [Using JSON Object (JSONObject)](#using-json-object-jsonobject)
  - [String to List Example](#string-to-list-example)
- [Full Example Code](#full-example-code)

---

## Requirements

- **Java JDK**
- **org.json library**  
  Download from [https://mvnrepository.com/artifact/org.json/json](https://mvnrepository.com/artifact/org.json/json)

```java
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
```

---

## Code Highlights

### Create a JSON Array

```java
JSONArray mahbub = new JSONArray();
mahbub.put("Value1");
mahbub.put("Value2");
System.out.println(mahbub.toString()); // ["Value1","Value2"]
```

### Access Elements in JSON Array

```java
System.out.println(mahbub.getString(0)); // Value1
```

### Convert String to JSON Array

```java
String str = "[\"Value5\", \"Value6\"]";
JSONArray from_string = new JSONArray(str);
System.out.println(from_string.toString()); // ["Value5","Value6"]
```

### Convert JSON Array to String

```java
String from_json = mahbub.toString();
System.out.println(from_json); // ["Value1","Value2"]
```

### Convert JSON Array to List

```java
List<String> normal2list = new ArrayList<>();
for(int i = 0; i < mahbub.length(); i++) {
    normal2list.add(mahbub.getString(i));
}
System.out.println(normal2list.toString()); // [Value1, Value2]
```

### Convert List to JSON Array

```java
JSONArray from_list_array = new JSONArray(normal2list);
System.out.println(from_list_array.toString()); // ["Value1","Value2"]
```

### Work with Nested/Multi-dimensional Arrays

```java
JSONArray multi_array = new JSONArray();
multi_array.put(mahbub);
multi_array.put(tanmay);
System.out.println(multi_array.toString()); // [["Value1","Value2"],["Value3","Value4"]]
```

### Convert Between Multi List and Multi Array

```java
List<List<String>> multi2list = new ArrayList<>();
for(int i = 0; i < multi_array.length(); i++) {
    List<String> templist = new ArrayList<>();
    for(int j = 0; j < multi_array.getJSONArray(i).length(); j++) {
        templist.add(multi_array.getJSONArray(i).getString(j));
    }
    multi2list.add(templist);
}
System.out.println(multi2list.toString()); // [[Value1, Value2], [Value3, Value4]]
```

Convert multi list to multi array:
```java
JSONArray from_multi_list = new JSONArray();
for (List<String> i : multi2list) {
    from_multi_list.put(new JSONArray(i));
}
System.out.println(from_multi_list.toString()); // [["Value1","Value2"],["Value3","Value4"]]
```

### Using JSON Object (JSONObject)

```java
JSONObject json_obj = new JSONObject();
json_obj.put("id 1", "value1");
json_obj.put("id 1", "value2"); // Overwrites previous value for "id 1"
json_obj.put("id 2", "value3");
json_obj.put("id 2", "value4"); // Overwrites previous value for "id 2"
System.out.println(json_obj); // {"id 2":"value4","id 1":"value2"}
```

### String to List Example

```java
String test = "[Value1, Value2],[Value1, Value2]";
List<String> list1 = new ArrayList<>();
list1.add(test);
System.out.println(list1);
```

---

## Full Example Code

```java
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) throws Exception {
        // ... (Full code as in your note)
    }
}
```

---

## References

- [org.json Documentation](https://stleary.github.io/JSON-java/index.html)
- [Java Collections Framework](https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html)

---

Feel free to use or modify the code in this repo for your class notes or learning purposes. Contributions and suggestions are welcome!
