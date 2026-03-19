# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is an Eclipse Java project targeting Java 8 (JavaSE-1.8). It is a learning/test repository with a single Java class.

## Structure

- `TestProject/src/` — Java source files
- `TestProject/bin/` — Compiled class files (Eclipse output directory, not committed)
- `TestProject/.classpath` / `TestProject/.project` — Eclipse project configuration

## Build & Run

This project uses Eclipse's built-in Java builder. To compile and run from the command line:

```bash
# Compile
javac -source 1.8 -target 1.8 -d TestProject/bin TestProject/src/HelloWorld.java

# Run (after compiling)
java -cp TestProject/bin HelloWorld
```

## Java Version

Compiler compliance is set to **Java 1.8**. Keep all source compatible with Java 8.
