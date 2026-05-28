# Student Management System (Java)

A beginner-friendly Java console application for managing student records.

## Build

This is a **Java application** — not a web app. It runs as a console program on your local machine.

### Prerequisites

- Java JDK 11+ installed
- `javac` (Java compiler) available in PATH

### Compile & Run

```bash
cd "/Users/test/Desktop/APP DEV/Java application"
javac -cp .:gson-2.10.1.jar Student.java StudentManager.java FileHandler.java Menu.java Main.java
java -cp .:gson-2.10.1.jar Main
```

### Dependencies

- [Gson 2.10.1](https://github.com/google/gson) — JSON serialization/deserialization

## Features

- Add, view, search, update, and delete student records
- Data persisted to `students.json` (JSON file storage)
- Menu-driven console interface
- Duplicate ID validation
- Graceful error handling (missing files, corrupt data)

## Class Overview

| Class | Purpose |
|-------|---------|
| `Student` | Data class — holds student fields (id, name, email, phone, grade) |
| `StudentManager` | Business logic — ArrayList CRUD operations, delegates to FileHandler |
| `FileHandler` | Persistence — JSON save/load using Gson |
| `Menu` | Console UI — Scanner input, System.out display |
| `Main` | Entry point — wires all components, manages app lifecycle |

## Deployment

This repository includes GitHub Actions CI/CD for build verification.

Deploying a Java console app to a live environment requires a JVM-enabled platform. See the `render.yaml` for one-click deployment to [Render](https://render.com).

## License

MIT
