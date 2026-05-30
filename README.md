# Paradigmas II - Curso 2026

## Índice de proyectos
### AbstractClasses
1. AbstractClasses (`AbstractClasses\AbstractClasses`)
   - **1.1 Objective:** Java/Maven example that models Persona and Profesor as an abstract class with concrete subclasses to illustrate inheritance and polymorphism.

### Collections
2. ArrayDequeExample (`Collections\ArrayDequeExample`)
   - **2.1 Objective:** Java/Maven example using `ArrayDeque` as a double-ended queue with insertion, peek, and removal from both ends.
3. MapImplementations (`Collections\MapImplementations`)
   - **3.1 Objective:** Java/Maven example comparing `HashMap`, `LinkedHashMap`, and `TreeMap` behaviors and iteration order.
4. SetImplementations (`Collections\SetImplementations`)
   - **4.1 Objective:** Java/Maven example showing set uniqueness and ordering strategies with `TreeSet`, `Comparable`, and `Comparator`.

### Generics
5. BoundedByExample (`Generics\BoundedByExample`)
   - **5.1 Objective:** Java/Maven example illustrating bounded generics (`extends`) with class hierarchies and numeric operations.
6. GenericBasics (`Generics\GenericBasics`)
   - **6.1 Objective:** Java/Maven example comparing non-generic, Object-based, and generic lists to highlight type-safety benefits.
7. Genericity (`Generics\Genericity`)
   - **7.1 Objective:** Java/Maven example demonstrating generic classes and generic methods with a simple utility type.
8. GenericMethodBounded (`Generics\GenericMethodBounded`)
   - **8.1 Objective:** Java/Maven example demonstrating bounded generic methods to copy elements between typed collections safely.
9. SortVectorActivity (`Generics\SortVectorActivity`)
   - **9.1 Objective:** Java/Maven activity exploring generic collection processing with inheritance-based types.
10. WildCardsByExample (`Generics\WildCardsByExample`)
   - **10.1 Objective:** Java/Maven example introducing wildcard generics (`?`, `? extends`, `? super`) with a simple class hierarchy.
11. WildCardsUseCase (`Generics\WildCardsUseCase`)
   - **11.1 Objective:** Java/Maven example applying wildcard bounds in practical list insertion and copy scenarios.

### Interfaces
12. CouplingDecoupling (`Interfaces\CouplingDecoupling`)
   - **12.1 Objective:** Java/Maven example contrasting high coupling versus interface-based low coupling for database and notification services.
13. GenericInterfaces (`Interfaces\GenericInterfaces`)
   - **13.1 Objective:** Java/Maven example implementing generic interfaces to compute min/max across comparable types.
14. InterfaceBasics (`Interfaces\InterfaceBasics`)
   - **14.1 Objective:** Java/Maven example showing interface implementation and polymorphism with geometric shapes.
15. IteratorBasics (`Interfaces\IteratorBasics`)
   - **15.1 Objective:** Java/Maven example building a custom collection that implements `Iterable` and exposes its own iterator.
16. LambdaBasics (`Interfaces\LambdaBasics`)
   - **16.1 Objective:** Java/Maven example introducing functional interfaces, anonymous classes, and lambda expressions.
17. SerializationBasics (`Interfaces\SerializationBasics`)
   - **17.1 Objective:** Java/Maven example serializing and deserializing objects using `ObjectOutputStream` and `ObjectInputStream`.
18. UnitTesting (`Interfaces\UnitTesting`)
   - **18.1 Objective:** Java/Maven example combining dependency injection with unit tests and mocks for data-access abstractions.

### IO
19. FileTextReaderBasics (`IO\FileTextReaderBasics`)
   - **19.1 Objective:** Java/Maven example comparing multiple Java APIs to read text/CSV files from disk.
20. FileTextWriterBasics (`IO\FileTextWriterBasics`)
   - **20.1 Objective:** Java/Maven example generating CSV files with several `OutputStream`-based writing approaches.

### Networks
21. HttpPostExample (`Networks\HttpPostExample`)
   - **21.1 Objective:** Java/Maven example sending URL-encoded POST data from a desktop UI through a simple HTTP helper.
22. RMIInvocations (`Networks\RMIInvocations`)
   - **22.1 Objective:** Java/Maven example exposing a remote calculus service with Java RMI and separate client/server applications.
23. SerializedOverNetwork (`Networks\SerializedOverNetwork`)
   - **23.1 Objective:** Java/Maven example serializing `Persona` objects and streaming them over sockets between sender and receiver.
24. ClientSocketV1 (`Networks\Sockets\ClientSocketV1`)
   - **24.1 Objective:** Java/Maven example opening a basic client socket and sending a single UTF message to a server.
25. ClientSocketV2 (`Networks\Sockets\ClientSocketV2`)
   - **25.1 Objective:** Java/Maven example building an interactive socket client that exchanges messages and files with a server.
26. ServerSocketV1 (`Networks\Sockets\ServerSocketV1`)
   - **26.1 Objective:** Java/Maven example opening a basic server socket and receiving a single UTF message from a client.
27. ServerSocketV2 (`Networks\Sockets\ServerSocketV2`)
   - **27.1 Objective:** Java/Maven example building an interactive server socket that exchanges messages and files with one client.
28. UrlBasics (`Networks\UrlBasics`)
   - **28.1 Objective:** Java/Maven example exploring `URL`, `URLConnection`, Java `HttpClient`, and OkHttp to inspect and download web resources.

### Threads
29. ExecutorCallable (`Threads\ExecutorCallable`)
   - **29.1 Objective:** Java/Maven example submitting `Callable` tasks to an executor and retrieving asynchronous results with `Future`.
30. ExecutorsBasics (`Threads\ExecutorsBasics`)
   - **30.1 Objective:** Java/Maven example introducing executor services with fixed, single, and scheduled thread pools.
31. RecursiveActionDemo (`Threads\RecursiveActionDemo`)
   - **31.1 Objective:** Java/Maven example using `ForkJoinPool` and `RecursiveAction` to transform large arrays in parallel.
32. RecursiveTaskDemo (`Threads\RecursiveTaskDemo`)
   - **32.1 Objective:** Java/Maven example using `ForkJoinPool` and `RecursiveTask` to count array values in parallel.
33. SemaphoreDemo (`Threads\SemaphoreDemo`)
   - **33.1 Objective:** Java/Maven example coordinating shared-state access across threads with binary and counting semaphores.
34. SyncThreads (`Threads\SyncThreads`)
   - **34.1 Objective:** Java/Maven example synchronizing concurrent access to shared state with synchronized methods and blocks.
35. ThreadsBasics (`Threads\ThreadsBasics`)
   - **35.1 Objective:** Java/Maven example introducing `Runnable`, `Thread`, `start`, `sleep`, and `join` for basic multithreading.

### Web
36. AdventureWorksClient (`Web\AdventureWorksClient`)
   - **36.1 Objective:** Spring Boot/Maven example exposing product-related REST endpoints with controllers, DTOs, and a service layer.
