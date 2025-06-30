# Dsa

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