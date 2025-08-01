# OCR MRZ Reader

A Java application for reading and extracting data from Machine Readable Zone (MRZ) codes found in passports, ID cards, and other travel documents using OCR technology.

## Overview

This project provides a Java-based solution for processing passport and ID document images to extract structured data from their Machine Readable Zones. The application uses the NSOCR engine to perform optical character recognition on document images and parse the extracted text into structured data fields.

## Features

- OCR processing of passport and ID document images
- MRZ data extraction and parsing
- Structured data output including:
  - Country code
  - Document type
  - Name and surname
  - Document number
  - Nationality
  - Birth date
  - Expiration date
  - Gender
  - Personal number

## Requirements

- Java 8 or higher
- NSOCR library and dependencies
- Maven for building

## Project Structure

```
src/main/java/
├── NSOCR/           # NSOCR engine wrapper classes
└── uz/asbt/ocr/mrz/reader/
    ├── Main.java         # Main application entry point
    ├── Scanner.java      # OCR scanning functionality
    ├── MRZData.java      # Data model for MRZ information
    ├── ReadXML.java      # XML parsing utilities
    └── MRZReaderException.java # Custom exception handling
```

## Usage

The application processes image files containing MRZ codes and outputs the extracted data:

```java
try(Scanner scanner = new Scanner("path/to/image.jpg", "output.xml")) {
    scanner.scan();
    MRZData mrzData = scanner.getData();
    System.out.println(mrzData.toString());
}
```

## Building

Build the project using Maven:

```bash
mvn clean compile
```

## License

This project uses the NSOCR engine which requires a valid license key for operation.