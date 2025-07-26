# Git Dashboard - A Java-Based Terminal Companion

A lightweight, zero-dependency command-line tool built in Java that provides a quick, at-a-glance summary of the current Git repository's status.

It's designed to be a practical, developer-friendly utility that saves you from typing multiple commands to get your bearings in a project.

## Final Output

<img width="750" height="437" alt="image" src="https://github.com/user-attachments/assets/e0d2cfd3-50dc-4af0-b61f-3d8104b00183" />


## Features

- **Clean/Dirty Status:** Instantly see if you have uncommitted changes.
- **Status Summary:** Shows a count of modified, new, or untracked files.
- **Current Branch:** Displays the active branch name in color.
- **Recent Commits:** Lists the last 5 commits for quick context.
- **Remote Info:** Shows the fetch and push URLs for your `origin` remote.
- **Color-Coded UI:** Uses terminal colors to make information easy to read at a glance.
- **Safe:** It's a read-only tool. It never writes or changes anything in your repository.

## Installation & Usage

There are two ways to use the Git Dashboard:

### 1. Simple Usage (Runnable JAR)

**Prerequisites:**

- Java 11 or higher must be installed and available in your system's PATH.

**Steps:**

1.  Clone this repository:

    ```bash
    git clone [https://github.com/YOUR_USERNAME/GitDashboard.git](https://github.com/YOUR_USERNAME/GitDashboard.git)
    ```

2.  Navigate into the project directory:

    ```bash
    cd GitDashboard
    ```

3.  Compile the Java files:

    ```bash
    javac src/*.java -d out
    ```

4.  Create a runnable JAR file:

    ```bash
    jar cfe GitDashboard.jar GitDashboard -C out .
    ```

5.  You can now copy `GitDashboard.jar` to any other Git project on your system, `cd` into that project's directory, and run:
    ```bash
    java -jar /path/to/your/GitDashboard.jar
    ```

### 2. Professional Usage

Make the dashboard a native command (`git-dash`) that you can run from anywhere.

**Steps:**

1.  Place your `GitDashboard.jar` file in a stable location (e.g., `~/tools/` or `C:\Users\YourUser\tools\`).
2.  Create a shell script named `git-dash` (on macOS/Linux) or `git-dash.bat` (on Windows).

**On macOS/Linux (`git-dash`):**

```bash
#!/bin/bash
# Make sure to update the path to your JAR file
java -jar ~/tools/GitDashboard.jar
```

**On Windows (`git-dash.bat`):**

```batch
@echo off
:: Make sure to update the path to your JAR file
java -jar C:\Users\YourUser\tools\GitDashboard.jar
```

3. Make the script executable (on macOS/Linux):

```bash
chmod +x git-dash
```

4. Move the script to a directory that is in your system's `PATH` (e.g., `/usr/local/bin` or a custom scripts folder).

```bash
git-dash
```

---

### 3. The "Why I Built This" Section

As a developer, I found myself constantly running the same set of Git commands (`git status`, `git branch`, `git log`) to get a sense of where my project stood. I built this dashboard to consolidate that information into a single, fast command. It was also a great opportunity to work with core Java features like `ProcessBuilder` and I/O streams to interact with the underlying operating system.
