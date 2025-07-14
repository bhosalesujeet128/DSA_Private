# Dsa
### OOP

**Classes and object**
A class is basically a blueprint or template for creating objects. It defines the structure—like what properties (variables) and behaviors (methods) an object of that type will have.  
An object is an actual instance of that class  
**constructor**
A constructor in Java is a special block of code that gets called automatically when you create an object using the new keyword. Its main job is to initialize the object—either by setting default values or accepting values from the user.  
Unlike regular methods, constructors:  
- Have the same name as the class
- Don’t have a return type, not even void

**Access Modifier**
|Access Modifier | within class |within package |outside package by subclass only | outside package |
| --- | --- | --- | --- |--- |
|Private | Y |N |N | N |
|Default | Y |Y |N | N |
|Protected | Y |Y |Y | N |
|Public | Y |Y |Y | Y |

### String  
In Java, a String is a sequence of characters used to represent textual data. It is a class in the java.lang package and is immutable, meaning once a String object is created, its value cannot be changed.  
  
A String is a class, but Java allows us to use it like a data type.  

String literals(sequence of characters enclosed in double quotes) are stored in a special memory area called the String pool to optimize memory usage.  

Reusing literals saves memory, while using `new String()` creates a new object in the heap.  

Java provides many built-in methods to manipulate strings like   
- `length()`: Returns the length of the string.
- `charAt(index)`: Returns the character at the specified index.
- `substring(beginIndex, endIndex)`: Returns a new string that is a substring of this string.
- `equalsIgnoreCase(anotherString)`: Compares this string to another string, ignoring case considerations.
- `str1.compareTo(str2)` : if = 0 ->(str1=str2), if < 0 -> (str1 < str2), if > 0 -> (str1 > str2)
- `str.toUpperCase()` : convert the given string in upper case.
- `str.toLowerCase()` : convert the given string in lower case.
- `Character.toUpperCase()` : convet the given character in upper case.
- `.append()` : is a method used with StringBuilder or StringBuffer to add text at the end of the existing content.

### Arrays
