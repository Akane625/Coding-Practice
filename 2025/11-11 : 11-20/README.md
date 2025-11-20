# 📅 November 11, 2025 to November 20, 2025

These prompts were made through DeepSeek. The goal of this is to furthur practice OOP as by the looks of it, the basic syntax is taken care of.

*Note: The exercises for this week has been cut to half due to a busy schedule. It wont happen in the future anymore (Edited: 11/20/25)*

## Legend
| Symbol | Meaning | Comment |
|--------|---------|---------|
| ✅ | Accomplished | Able to create a good code by myself |
| 🚧 | Accomplished But... | Created the code but can be further improved |
| ❌ | Not Completed | Not able to create a code within the deadline |

## 🐍 Python
1. **Intermediate: Bank Account System** ✅
- Create a BankAccount class with private attributes for account number, holder name, and balance. Implement methods for: deposit(amount), withdraw(amount) (should prevent overdrafts), get_balance() (returns formatted balance), transfer(amount, target_account). Add a class variable to track the total number of accounts created. Create multiple accounts and demonstrate deposits, withdrawals, and transfers between accounts.

## 🟣 Kotlin
3. **Intermediate: Smart Home System with Sealed Classes** ❌
- Create a sealed class SmartDevice with properties name and isEnabled. Create subclasses: Light (adds brightnessLevel), Thermostat (adds currentTemperature, targetTemperature), SecurityCamera (adds isRecording), Each subclass should have methods turnOn() and turnOff() that update the device state. Create a SmartHome class that manages a list of SmartDevice objects and can: Turn all devices on/off, Find devices by type, Get devices that are currently on

## 🗄️ MySQL
5. **Intermediate: University Database Design** ❌
- Design a database for a university with tables: students (student_id, name, enrollment_date), courses (course_id, title, credits), enrollments (enrollment_id, student_id, course_id, grade). Write queries to: Find all students enrolled in a specific course, Calculate the average grade for each course, Find students who are taking more than 3 courses, List all courses with the number of enrolled students

## 📊 Pandas + NumPy + Matplotlib
7. **Intermediate: Student Gradebook System** ❌ 
- Create a Gradebook class that uses Pandas DataFrames to manage student data. The class should: Initialize with columns: student_id, name, math, science, english. Have methods to: Add new students, Update grades for specific subjects, Calculate each student's average grade, Add a column for grade status (Pass/Fail based on average >= 60), Display students who are failing, Use NumPy to calculate class statistics (mean, median, std dev)

## 🧩 LeetCode
9. **[Two Sums](https://leetcode.com/problems/two-sum/description/)** ❌
- Using Python and Kotlin solve the problem
