# leetcode
practicing the leetcode


# LeetCode Solutions in Java #
A collection of LeetCode novel solutions that is implemented in Java. It would support you to solve the problems from easy to hard by the simplest ways.

## Solutions LeeCode ##
| # | Problem | Difficulty | Source code | Solution |
|---| ------- | ---------- | ----------- | -------- |
| 1 | [Two Sum](https://leetcode.com/problems/two-sum/) | Medium | [Java](https://github.com/saodem74/LeetCode-Solutions-Java/blob/master/src/TwoSum.java) | 1. Hash O(n) and O(n) space.<br>2. Sort and search with two points O(n) and O(1) space. |
| 2 | [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/) | Medium | [Java](https://github.com/saodem74/LeetCode-Solutions-Java/blob/master/src/AddTwoNumber.java) | Take care of the carry from lower digit. |
|---| To-be-updated soon | ---------- | ----------- | -------- |

## Big O performance ##
Below are the Big O performance of common functions of different Java Collections.


List                 | Add  | Remove | Get  | Contains | Next | Data Structure
---------------------|------|--------|------|----------|------|---------------
ArrayList            | O(1) |  O(n)  | O(1) |   O(n)   | O(1) | Array
LinkedList           | O(1) |  O(1)  | O(n) |   O(n)   | O(1) | Linked List



Set                   |    Add   |  Remove  | Contains |   Next   | Size | Data Structure
----------------------|----------|----------|----------|----------|------|-------------------------
HashSet               | O(1)     | O(1)     | O(1)     | O(h/n)   | O(1) | Hash Table
LinkedHashSet         | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Hash Table + Linked List
EnumSet               | O(1)     | O(1)     | O(1)     | O(1)     | O(1) | Bit Vector
TreeSet               | O(log n) | O(log n) | O(log n) | O(log n) | O(1) | Red-black tree
ConcurrentSkipListSet | O(log n) | O(log n) | O(log n) | O(1)     | O(n) | Skip List

* Note: h is the table capacity


Queue                   |  Offer   | Peak |   Poll   | Remove | Size | Data Structure
------------------------|----------|------|----------|--------|------|---------------
PriorityQueue           | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedList              | O(1)     | O(1) | O(1)     |  O(1)  | O(1) | Array
ArrayDequeue            | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List
ConcurrentLinkedQueue   | O(1)     | O(1) | O(1)     |  O(n)  | O(n) | Linked List
ArrayBlockingQueue      | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Array
PriorirityBlockingQueue | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
SynchronousQueue        | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | None!
DelayQueue              | O(log n) | O(1) | O(log n) |  O(n)  | O(1) | Priority Heap
LinkedBlockingQueue     | O(1)     | O(1) | O(1)     |  O(n)  | O(1) | Linked List



Map                   |   Get    | ContainsKey |   Next   | Data Structure
----------------------|----------|-------------|----------|-------------------------
HashMap               | O(1)     |   O(1)      | O(h / n) | Hash Table
LinkedHashMap         | O(1)     |   O(1)      | O(1)     | Hash Table + Linked List
IdentityHashMap       | O(1)     |   O(1)      | O(h / n) | Array
WeakHashMap           | O(1)     |   O(1)      | O(h / n) | Hash Table
EnumMap               | O(1)     |   O(1)      | O(1)     | Array
TreeMap               | O(log n) |   O(log n)  | O(log n) | Red-black tree
ConcurrentHashMap     | O(1)     |   O(1)      | O(h / n) | Hash Tables
ConcurrentSkipListMap | O(log n) |   O(log n)  | O(1)     | Skip List
## https://github.com/Mickey0521/Codility
## https://github.com/ZRonchy/Codility    contains all explanantion
Codelity                   |   Link                                                                             | Remarks |
----------------------     |-----------------------------------------------------------------------------------------------------------                                                                          |-------------|
AbsDistinct                |       https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct   |Compute number of distinct absolute values of sorted array elements.|                                                      |                        
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |
|  |  |  