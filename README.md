# librarymanagement📚 Library Management System in Java A simple Library Management System built using Java that supports user login/registration, book management, and basic library operations. This console-based application uses OOP principles and is structured using packages for better modularity.

✨ Features 👤 User Authentication

User registration and login

Session management

📘 Book Management

Add new books

View available books

Search books by title/author

Issue and return books

🔒 Access Control

Separate functionalities for Admin and Users

🗃 Data Handling

Book and user data stored in memory (can be extended to use files or databases)

📂 Project Structure pgsql Copy Edit LibraryManagementSystem/ ├── Main_1.java ├── Model/ │ ├── Book.java │ └── User.java ├── Manager/ │ ├── LibraryManager.java │ └── LoginManager.java ⚙ Technologies Used Java SE

Java Collections (List, Map)

Object-Oriented Programming (OOP)

🏁 Getting Started Prerequisites JDK 8 or above

IDE (like IntelliJ IDEA, Eclipse) or terminal

Running the Application Clone the repository:

bash Copy Edit git clone https://github.com/your-username/library-management-java.git cd library-management-java Compile and run:

bash Copy Edit javac Main_1.java java Main_1 Follow the on-screen menu to:

Login/Register

Add/View/Search books

Issue or return books

🧾 Sample Users Admin:

Username: admin

Password: admin123

You can register new users via the application.

🛠 Future Improvements File or database integration for persistent storage

GUI using JavaFX or Swing

Advanced search and filtering

Fine tracking and due dates

🤝 Contributing Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
