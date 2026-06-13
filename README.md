# KaneAssignment

# 1. Visa Processing Assignment

## Description

Reads visa applicant data from a text file, validates records, categorizes applicants as Kid or Adult, and writes the results to a CSV file.

## Validation Rules

- Email must be valid.
- Applicant must reside in India.
- Address must not be empty.

## Categorization

- Age > 18 -> Adult
- Age <= 18 -> Kid

## Assumptions

- First column is Name.
- Second column is Age.
- Last column is Email.
- All columns between Age and Email are considered Address.

## Input

input.txt

## Output

output.csv

# 2. SQL QUESTION

Problem Statement:

A company maintains the data of its employees in their EMPLOYEE
table. Write a query to print all pairs of employee names where the salary
of the first employee is less than the salary of the second employee.
Sort the output by the increasing order of first employee's ID and second
employee's salary.
Each row in the output must contain:
1. The name of the first employee
2. The name of the second employee, whose salary is more than the
salary of the first employee
