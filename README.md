# Java OOP - LAB211 FPT

This repository contains 5 labs with a total of ~800 LOC.  
Each lab is in a separate branch named by the last two numbers of its lab code (e.g., `21`, `22`, `23`, `72`, `25`).

---

## J1.L.P0021 – Student Management (OOP + ArrayList)

### Overview
A **Java console program** to manage student information (ID, Name, Semester, Course – limited to Java, .Net, C/C++).
It supports creating, finding/sorting, updating/deleting, and reporting students with the total number of courses they have taken.

### Main Features
1️⃣ **Create Students**
- Create at least 10 students initially.
- Allow adding more students interactively.

2️⃣ **Find / Sort**
- Search students by name (or partial name).
- Display matched results and sort them by name.

3️⃣ **Update / Delete**
- Find students by ID, then update or delete as needed.

4️⃣ **Report**
- Display each student with their courses and the total number of courses taken.

### Technical Requirements
- Use **Object-Oriented Programming (OOP)**.
- Use `ArrayList` and `Collections.sort()` with `Comparator`.
- Only core Java libraries are allowed.

---

## J1.S.P0072 – Login Function with MD5 Encryption

### Overview
A **Java console program** to manage user accounts and provide a secure login function.
Each account includes Username, Password, Name, Phone, Email, Address, and DOB.

### Main Features
1️⃣ **Add Account**
- Prompt user for account details.
- Validate input (username unique, valid phone/email/DOB).
- Encrypt password with MD5 before storing.

2️⃣ **Login**
- Ask for username and password.
- Verify credentials and display success or failure message.

3️⃣ **Exit**
- Quit the program.

### Technical Requirements
- Implement `addAccount()` (returns account ID or throws exceptions).
- Implement `login()` (returns login status).
- Use only core Java libraries.
- Validate input properly and apply MD5 encryption for password storage.

---

## J1.L.P0022 – Candidate Management System (OOP + Inheritance)

### Overview
A **Java console program** to manage company candidates.
Each candidate has shared attributes (ID, Name, Birth Date, Address, Phone, Email, Type) and belongs to one of three types: Experience, Fresher, or Intern.

### Main Features
1️⃣ **Create Candidate**
- Create Experience, Fresher, or Intern candidates.
- Validate inputs: DOB = 4-digit year, Phone ≥ 10 digits, Email format, ExpYears 0–100, Graduation Rank ∈ {Excellence, Good, Fair, Poor}.
- Allow multiple entries until user stops, then display all candidates.

2️⃣ **Search Candidate**
- Search by name (first or last) and candidate type.
- Display matched candidates with all details.

3️⃣ **Exit**
- Quit the program.

### Technical Requirements
- Use **OOP with inheritance** (`Candidate` superclass, `Experience`, `Fresher`, `Intern` subclasses).
- Store candidates in an `ArrayList`.
- Only use core Java functions and classes.

---

## J1.L.P0023 – Fruit Shop Management

### Overview
A **Java console application** to manage a fruit shop.
It allows shop owners to create fruits, view orders, and customers to buy fruits easily.

### Main Features
1️⃣ **Create Fruit**
- Add new fruits with attributes: Fruit ID, Name, Price, Quantity, Origin.
- Validate data (price > 0, quantity > 0).
- Allow multiple entries until the user stops, then display all created fruits.

2️⃣ **Shopping**
- Display all fruits for customers.
- Customers select fruits by item number, input quantity, confirm order, and enter their name to save the order.

3️⃣ **View Orders**
- Display all customer orders with details: Product, Quantity, Price, Amount, and Total.

4️⃣ **Exit**
- Quit the program.

### Technical Requirements
- Use **OOP**.
- Use `ArrayList` for fruits and purchased items.
- Use `HashTable` to store orders by customer name.
- Only core Java functions and classes.

---

## J1.S.P0025 – Text Normalization

### Overview
A **Java console application** that reads text from `input.txt`, normalizes it, and writes the result to `output.txt`.
It ensures proper spaces, punctuation, capitalization, and sentence structure.

### Main Features
1️⃣ **Read Input File**
- Read text from `input.txt` using `BufferedReader`.
- Handle file reading exceptions.

2️⃣ **Normalize Text**
- Only one space between words.
- One space after `,`, `.`, `:` and no spaces before them.
- Capitalize first letter after a period and first word of file, make others lowercase.
- Remove spaces before/after quoted phrases.
- Remove blank lines.
- Add a `.` at the end of the text if missing.

3️⃣ **Write Output File**
- Write normalized text to `output.txt`.
- Handle file writing exceptions.

### Technical Requirements
- Use **OOP**.
- Use `BufferedReader`, `StringBuffer`, and core Java classes.
- Implement exception handling for file operations.
