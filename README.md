# Zakhar_Sytoi_Java_Test_Task

## Description

This repository contains a method designed to verify input JSON data, specifically formatted according to the AWS IAM Role Policy. The method is capable of processing JSON input retrieved from a file.

## Features

- Fat jar Packaging.
- Jackson for json parsing.
- 100% coverage.

## Usage

### To use library perform following steps:

  1. Download `JsonVerifier-1.0-SNAPSHOT.jar` from [here](https://drive.google.com/file/d/1y8PK_wynjT3wlyhcbB14i3dZE8b7YFuP/view?usp=sharing).

  2. Run `java -jar ./target/JsonVerifier-1.0-SNAPSHOT.jar` iside directory containing `JsonVerifier-1.0-SNAPSHOT.jar`.

## Build
If in any case you have problems with downloading .jar from [here](https://drive.google.com/file/d/1y8PK_wynjT3wlyhcbB14i3dZE8b7YFuP/view?usp=sharing)
You can obtain it performig following steps:
1. Clone this repository.
2. Execute the following command in project root directory (You need to have Maven installed):

   `$ mvn package`
3. Now You can find `JsonVerifier-1.0-SNAPSHOT.jar` in `target` directory.
4. Perform steps from [Usage](#usage).

## Tests
1. Clone this repository.
2. Execute the following command in project root directory (You need to have Maven installed):

   `$ mvn test`

## Contact

For questions or inquiries, please contact [Zakhar Sytoi](mailto:zakharsytoi@gmail.com).
